/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author abdul.wahab
 */
public class BurpExtender implements IBurpExtender, IContextMenuFactory {
    
    public String ExtensionName =  "Hack Bar";
    public String MenuName = "Hack Bar";
    
    public IBurpExtenderCallbacks callbacks;
    public IExtensionHelpers helpers;
    public PrintWriter stdout;
    public PrintWriter stderr;
    public IContextMenuInvocation context;
    public ArrayList menu_list;
    public JMenu Hack_Bar_Menu;
    
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
        this.menu_list = new ArrayList();
        this.Hack_Bar_Menu = new JMenu(this.MenuName);
        this.Hack_Bar_Menu.add(new SQL_Menu(this));
        this.Hack_Bar_Menu.add(new SQL_Error(this));
        this.Hack_Bar_Menu.add(new SQli_LoginBypass(this));
        this.Hack_Bar_Menu.add(new XSS_Menu(this));
        this.Hack_Bar_Menu.add(new LFI_Menu(this));
        this.Hack_Bar_Menu.add(new XXE_Menu(this));
        this.Hack_Bar_Menu.add(new WebShell_Menu(this));
        this.Hack_Bar_Menu.add(new Reverse_Shell_Menu(this));
//        this.Hack_Bar_Menu.add(new Decoder_Encoder_Menu(this));
        
        
        this.callbacks.setExtensionName(this.ExtensionName);
        this.callbacks.registerContextMenuFactory(this);
    }

    
    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        this.context = invocation;

        menu_list.add(Hack_Bar_Menu);
        return menu_list;
    }
    
}
