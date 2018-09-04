/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import burp.BurpExtender;
import javax.swing.JMenu;

/**
 *
 * @author abdul.wahab
 */
public class Decoder_Encoder_Menu extends JMenu {
    public BurpExtender myburp;
    
    Decoder_Encoder_Menu(BurpExtender burp){
        this.setText("Decoder/Encoder");
        this.myburp = burp;
        this.Create_Reverse_Shell_Menu();
    }
    
    public void Create_Reverse_Shell_Menu(){}
}
