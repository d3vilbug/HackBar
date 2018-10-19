package knife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import burp.BurpExtender;
import burp.IBurpExtenderCallbacks;
import burp.IContextMenuInvocation;
import burp.IExtensionHelpers;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;

public class UpdateCookieMenu extends JMenuItem {
	//JMenuItem vs. JMenu
    public UpdateCookieMenu(BurpExtender burp){
        this.setText("Hack Bar -- Update cookie");
        this.addActionListener(new UpdateCookie_Action(burp,burp.context));
    }
}

class UpdateCookie_Action implements ActionListener{
	private IContextMenuInvocation invocation;
	public IExtensionHelpers helpers;
	public PrintWriter stdout;
	public PrintWriter stderr;
	public IBurpExtenderCallbacks callbacks;
	
	public UpdateCookie_Action(BurpExtender burp,IContextMenuInvocation invocation) {
		this.invocation  = invocation;
        this.helpers = burp.helpers;
        this.callbacks = burp.callbacks;
        this.stderr = burp.stderr;
        this.stdout = burp.stdout;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		IHttpRequestResponse[] selectedItems = invocation.getSelectedMessages();
		byte selectedInvocationContext = invocation.getInvocationContext();
	
		byte[] selectedRequest = selectedItems[0].getRequest();
		
		
		String shorturl = selectedItems[0].getHttpService().toString();
		String latestCookie = getLatestCookieFromHistory(shorturl);
		
		if (latestCookie !=null) {
        	IRequestInfo analyzedRequest = helpers.analyzeRequest(selectedRequest);//only get the first
        	List<String> headers = analyzedRequest.getHeaders();
        	//callbacks.printOutput(headers.toString());
        	String cookie =null;
        	for(String header:headers) {
        		if(header.toLowerCase().startsWith("cookie:")) {
        			cookie = header;
        			break;
        		}
        	}
    		if(cookie !=null) {
    			int index = headers.indexOf(cookie);
    			headers.remove(index);
	        	headers.add(index,latestCookie);
    		}else {
    			headers.add(latestCookie);
    		}
    		//callbacks.printOutput(headers.toString());
        	
        	
        	byte[] body= Arrays.copyOfRange(selectedRequest, analyzedRequest.getBodyOffset(), selectedRequest.length);
        	//https://github.com/federicodotta/HandyCollaborator/blob/master/src/main/java/burp/BurpExtender.java
        	byte[] newRequestBytes = helpers.buildHttpMessage(headers, body);
			
			if(selectedInvocationContext == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST) {
				selectedItems[0].setRequest(newRequestBytes);
			}
		}
	}

	public IHttpRequestResponse[] Reverse(IHttpRequestResponse[] input){
	    for (int start = 0, end = input.length - 1; start < end; start++, end--) {
	    	IHttpRequestResponse temp = input[end];
	        input[end] = input[start];
	        input[start] = temp;
	    }
	    return input;
	}
	
	public String getLatestCookieFromHistory(String shortUrl){
		//as cf_hb suggested
		
		IHttpRequestResponse[]  historyMessages = Reverse(callbacks.getProxyHistory());
		//callbacks.printOutput("length of history: "+ historyMessages.length);
		String lastestCookie =null;
		for (IHttpRequestResponse historyMessage:historyMessages) {
			IRequestInfo hisAnalyzedRequest = helpers.analyzeRequest(historyMessage);
			//String hisShortUrl = hisUrl.substring(0, hisUrl.indexOf("/", 8));
			String hisShortUrl = historyMessage.getHttpService().toString();
			//callbacks.printOutput(hisShortUrl);
			
			if (hisShortUrl.equals(shortUrl)) {
				List<String> hisHeaders = hisAnalyzedRequest.getHeaders();
				for (String hisHeader:hisHeaders) {
					if (hisHeader.toLowerCase().startsWith("cookie:")) {
						lastestCookie = hisHeader;
	        			if(lastestCookie != null) {
	        				return lastestCookie;
	        			}
					}
				}
			}
		}
		return null;
	}
}
