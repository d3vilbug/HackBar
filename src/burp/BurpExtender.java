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

import knife.AddHostToScopeMenu;
import knife.UpdateCookieMenu;

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
        
        this.callbacks.setExtensionName(this.ExtensionName);
        this.callbacks.registerContextMenuFactory(this);
    }

    
    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
    	this.context = invocation;
        
        ArrayList<JMenuItem> menu_list = new ArrayList<JMenuItem>();
        
		byte context = invocation.getInvocationContext();
		if (context == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST) {
			menu_list.add(new UpdateCookieMenu(this));
		}
        
		menu_list.add(new AddHostToScopeMenu(this));
        
        JMenu Hack_Bar_Menu = new JMenu(this.MenuName);
        Hack_Bar_Menu.add(new SQL_Menu(this));
        Hack_Bar_Menu.add(new SQL_Error(this));
        Hack_Bar_Menu.add(new SQli_LoginBypass(this));
        Hack_Bar_Menu.add(new XSS_Menu(this));
        Hack_Bar_Menu.add(new LFI_Menu(this));//learn from this
        Hack_Bar_Menu.add(new XXE_Menu(this));
        Hack_Bar_Menu.add(new WebShell_Menu(this));
        Hack_Bar_Menu.add(new Reverse_Shell_Menu(this));
        //Hack_Bar_Menu.add(new Decoder_Encoder_Menu(this));
        
        menu_list.add(Hack_Bar_Menu);
        return menu_list;
    }
    
}
