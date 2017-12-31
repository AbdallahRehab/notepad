/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Abdo Rehab
 */
public class gui extends JFrame{
    public gui(){
        Container con= getContentPane(); 
        con.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        for(int i=0;i<=20;i++){
            con.add(new JButton("component "+i));
        }
        con.add(new JLabel("frist name"));
        con.add(new JTextField(8));
        con.add(new JLabel("ML"));
        con.add(new JTextField(1));
        
    }
    public static void main(String[] args) {
        gui s=new gui();
        
        s.setTitle("abdo");
        s.setSize(300, 300);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
