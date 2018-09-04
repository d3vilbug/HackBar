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
public class Reverse_Shell_Menu extends JMenu {
    public BurpExtender myburp;
    
    Reverse_Shell_Menu(BurpExtender burp){
        this.setText("Reverse Shell");
        this.myburp = burp;
        this.Create_Reverse_Shell_Menu();
    }
    
    public void Create_Reverse_Shell_Menu(){}
}
