/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Abdo Rehab
 */
public class login extends JPanel implements ActionListener{
    JLabel userl=new JLabel("Username : ");//word after inbox 
    JTextField userTF=new JTextField();//text 
    JLabel passl=new JLabel("Password : ");//word after inbox 
    JPasswordField passTF=new JPasswordField();//text 
    JPanel loginp=new JPanel(new GridLayout(3, 2));
    JPanel panel =new JPanel();
    JButton login=new JButton("Login");
    JButton register=new JButton("Register");
    CardLayout c1;

    public login() {
        setLayout(new CardLayout());
        loginp.add(userl);
        loginp.add(userTF);
        loginp.add(passl);
        loginp.add(passTF);
        login.addActionListener(this);//buttom
        register.addActionListener(this);//buttom
        loginp.add(login);
        loginp.add(register);
        panel.add(loginp);
        add(panel,"Login");
        c1 = (CardLayout) getLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        add(new register(),"register");
        c1.show(this, "register");
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("text edtior");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setSize(500, 500);
        login login =new login();
        frame.add(login);
        frame.setVisible(true);
    }
    
}
