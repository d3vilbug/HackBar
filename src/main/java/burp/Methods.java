/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 *
 * @author abdul.wahab
 */
public class Methods {
    
    public static JMenu add_MenuItem_and_listener(JMenu menu, String[] itemList, Object actionListener){
        for(int i = 0; i < itemList.length; i++){
            JMenuItem item = new JMenuItem(itemList[i]);
            item.addActionListener((ActionListener) actionListener);
            menu.add(item);
        }
        return menu;
    }
    
    public static JMenu Create_Main_Menu(JMenu MainMenu, String[] MainMenuItems, String[][] SubMenuItems, Object actionListener){
        for(int i=0; i < MainMenuItems.length; i++){
            JMenu menu = new JMenu(MainMenuItems[i]);
            menu = add_MenuItem_and_listener(menu, SubMenuItems[i], actionListener);
            if(MainMenuItems[i].equals("Basic Statements")){
                MainMenu.add(new JSeparator());
                MainMenu.add(menu);
                MainMenu.add(new JSeparator());
            }else{
                MainMenu.add(menu);
            }
        }
        return MainMenu;
    }
    
    
    public static String prompt_and_validate_input(String prompt, String str){
        String user_input = JOptionPane.showInputDialog(prompt, str);
        while(user_input.trim().equals("")){
            user_input = JOptionPane.showInputDialog(prompt, str);
        }
        return user_input.trim();
    }
    
    public static byte[] do_modify_request(byte[] request, int[] selectedIndex, String modifiedString){
        byte[] modString = modifiedString.getBytes();
        byte[] newRequest = new byte[request.length + modifiedString.length() - (selectedIndex[1]-selectedIndex[0])];
        System.arraycopy(request, 0, newRequest, 0, selectedIndex[0]);
        System.arraycopy(modString, 0, newRequest, selectedIndex[0], modString.length);
        System.arraycopy(request, selectedIndex[1], newRequest, selectedIndex[0]+modString.length, request.length-selectedIndex[1]);
        return newRequest;
    }
    
    public static void show_message(String str1, String str2){
        JOptionPane.showMessageDialog(null, str1, str2, 0);
    }
}
