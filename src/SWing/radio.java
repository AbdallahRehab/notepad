/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWing;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author Abdo Rehab
 */
public class radio{
    JFrame frame;

    public radio() {
        frame =new JFrame();
        JRadioButton radiobutton1=new JRadioButton("1-Male");
        JRadioButton radiobutton2=new JRadioButton("2-Fmale");
        radiobutton1.setBounds(40,100, 90, 30);
        radiobutton2.setBounds(40, 140,130, 30);
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radiobutton1);
        buttonGroup.add(radiobutton2);
        
        frame.add(radiobutton1);
        frame.add(radiobutton2);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new radio();
    }
    
}
