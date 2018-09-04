/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import javax.swing.JMenu;

/**
 *
 * @author abdul.wahab
 */
public class WebShell_Menu extends JMenu {
    public BurpExtender myburp;
    
    WebShell_Menu(BurpExtender burp){
        this.setText("Web Shells");
        this.myburp = burp;
        this.Create_WebShell_Menu();
    }
    
    public void Create_WebShell_Menu(){}
}
