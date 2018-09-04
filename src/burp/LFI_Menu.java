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
public class LFI_Menu extends JMenu {
    public BurpExtender myburp;
    
    LFI_Menu(BurpExtender burp){
        this.setText("LFI");
        this.myburp = burp;
        this.Create_LFI_Menu();
    }
    
    public void Create_LFI_Menu(){}
}
