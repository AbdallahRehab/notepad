/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Abdo Rehab
 */
public class Main {

    public Main() {
        JFrame frame=new JFrame();
        JButton button =new JButton("eye");
        button.setBounds(140, 120, 200,80);
        frame.add(button);
        frame.setSize(600,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
}
