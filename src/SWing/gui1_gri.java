/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Abdo Rehab
 */
public class gui1_gri extends JFrame{
 public gui1_gri(){
        Container con= getContentPane(); 
        con.setLayout(new GridLayout(4,3,5,5));
        for(int i=0;i<=10;i++){
            con.add(new JButton("component "+i));
        }
//        con.add(new JLabel("frist name"));
//        con.add(new JTextField(8));
//        con.add(new JLabel("ML"));
//        con.add(new JTextField(1));
//        
    }
    public static void main(String[] args) {
        gui1_gri s=new gui1_gri();
        
        s.setTitle("abdo");
        s.setSize(300, 300);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
