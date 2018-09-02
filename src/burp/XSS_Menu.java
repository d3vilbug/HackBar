/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author abdul.wahab
 */
public class XSS_Menu extends JMenu{
    public BurpExtender myburp;
    
    XSS_Menu(BurpExtender burp){
        this.setText("XSS");
        this.myburp = burp;
        this.Create_XSS_Menu();
    }
    
    public void Create_XSS_Menu(){
        JMenuItem xss_alert = new JMenuItem("alert");
        
        this.add(xss_alert);
    }
}
