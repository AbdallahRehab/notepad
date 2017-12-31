/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Abdo Rehab
 */
public class register extends JPanel implements ActionListener{
    JLabel userl=new JLabel("choose username : ");
    JTextField userTF=new JTextField();
    JLabel passl=new JLabel("Password : ");
    JPasswordField passTF=new JPasswordField();
    JLabel passlc=new JLabel("confrime Password : ");
    JPasswordField passLC=new JPasswordField();
    JButton register=new JButton("Register");
    JButton back=new JButton("BAck");

    public register() {
        JPanel loginp=new JPanel();
        loginp.setLayout(new GridLayout(4, 2));
        loginp.add(userl);
        loginp.add(userTF);
        loginp.add(passl);
        loginp.add(passTF);
        loginp.add(passlc);
        loginp.add(passLC);
        loginp.add(register);
        loginp.add(back);
        register.addActionListener(this);
        back.addActionListener(this);
        add(loginp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==register && passTF.getPassword().length>0&&userTF.getText().length()>0){
           String pass=new String(passTF.getPassword());
           String confrim=new String(passLC.getPassword());
           if(pass.equals(confrim)){
               try {
                   BufferedReader input=new BufferedReader(new FileReader("passwords.txt"));
                   String line=input.readLine();
                   while(line!=null){
                       StringTokenizer st=new StringTokenizer(line);
                       if(userTF.getText().equals(st.nextToken())){
                           System.out.println("user ready exsit");
                           break;
                       }
                       line=input.readLine();
                   }
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

       }
        if(e.getSource()==back){
            login login= (login) getParent();
            login.c1.show(login, "login");
            
        }
        
    }
    
}
