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
public class RCE_Menu extends JMenu {
    public BurpExtender myburp;
    
    RCE_Menu(BurpExtender burp){
        this.setText("RCE");
        this.myburp = burp;
        this.Create_RCE_Menu();
    }
    
    public void Create_RCE_Menu(){}
}
