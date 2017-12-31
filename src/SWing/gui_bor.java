/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Abdo Rehab
 */
public class gui_bor extends JFrame{
    public gui_bor(){
        Container con= getContentPane(); 
        con.setLayout(new BorderLayout(5,10));
        
            con.add(new JButton("east"),BorderLayout.EAST);
            con.add(new JButton("center"),BorderLayout.CENTER);
             con.add(new JButton("west"),BorderLayout.WEST);  
        
//        con.add(new JLabel("frist name"));
//        con.add(new JTextField(8));
//        con.add(new JLabel("ML"));
//        con.add(new JTextField(1));
//        
    }
    public static void main(String[] args) {
        gui_bor s=new gui_bor();
        
        s.setTitle("abdo");
        s.setSize(300, 300);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
