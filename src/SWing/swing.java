/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Abdo Rehab
 */
public class swing {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JButton button=new JButton("click");
        button.setBounds(10, 40, 120, 60);
        frame.add(button);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        new abdo();
        
    }
    
}
