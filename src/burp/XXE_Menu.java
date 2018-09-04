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
public class XXE_Menu extends JMenu {
    public BurpExtender myburp;
    
    XXE_Menu(BurpExtender burp){
        this.setText("XXE");
        this.myburp = burp;
        this.Create_XXE_Menu();
    }
    
    public void Create_XXE_Menu(){}
}
