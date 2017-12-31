/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author like
 */
public class note extends JFrame{
    
    JTextArea mainArea;
    JMenuBar mbar;
    JMenu Flie,Edit, format, Help,font,About,color,counter;
    JMenuItem mNew,mOpen,mSave,mExit,mBold,mTRUETYPE_FONT,mCENTER_BASELINE
            ,mItailc,mItailc_Bold,mBackground,mfontcolor,mAmany,mAge,memail,mFact,mundo
            ,mcut,mcopy,mpaste,mdelete,mselect,mthank_you;
    String filename;
    JFileChooser filechoose;
    String temp;
    static boolean checkcut;
    int count=0;
    String [] undolist;
    
    
    public note() {
        initcomponent();
        /////Action
        mSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        mOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        mNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainArea.setText("");
            }
        });
        mExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mcut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                temp=mainArea.getSelectedText();
//                mainArea.replaceRange("", mainArea.getSelectionStart(), mainArea.getSelectionEnd());
//                checkcut=true;
                mainArea.cut();
            }
        });
        mcopy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                    temp=mainArea.getSelectedText();
//                    checkcut=false;
                mainArea.copy();

            }
        });
        mpaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                mainArea.replaceRange(temp, mainArea.getSelectionStart(), mainArea.getSelectionEnd());
//                if(checkcut){
//                    temp="";
//                }
                   mainArea.paste();
                           
            }
        });
        mselect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainArea.selectAll();
            }
        });
        mdelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            mainArea.replaceRange("", mainArea.getSelectionStart(), mainArea.getSelectionEnd());
           
            }
        });
        mundo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(count==0){
                    
                }
            }
        });
        mBold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
               String x= JOptionPane.showInputDialog(null,"enter font size");
            mainArea.setFont(new Font("Bold",Font.BOLD,Integer.parseInt(x)));
            }
        });
        mItailc_Bold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            String x= JOptionPane.showInputDialog(null,"enter font size");
            mainArea.setFont(new Font("itailc_Bold",Font.BOLD+Font.ITALIC,Integer.parseInt(x)));
            }
        });
        mItailc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x= JOptionPane.showInputDialog(null,"enter font size");
                mainArea.setFont(new Font("italic",Font.ITALIC,Integer.parseInt(x)));
            }
        });
        mCENTER_BASELINE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 String x= JOptionPane.showInputDialog(null,"enter font size");
                mainArea.setFont(new Font("CENTER_BASELINE",Font.CENTER_BASELINE,Integer.parseInt(x)));           
            }
        });
        mTRUETYPE_FONT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             String x= JOptionPane.showInputDialog(null,"enter font size");
                mainArea.setFont(new Font("TRUETYPE_FONT",Font.TRUETYPE_FONT,Integer.parseInt(x)));
            }
        });
        mfontcolor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             Color c= Color.BLUE;
             Color color2= JColorChooser.showDialog(mfontcolor, "Color the color",c);
             mainArea.setForeground(color2);
            
            }
        });
        mBackground.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             Color c2= Color.BLUE;
             Color color2= JColorChooser.showDialog(mBackground, "Color the color",c2);
             mainArea.setBackground(color2);
            
            }
        });
        
        

    
    }
    
private void initcomponent(){
    filechoose=new JFileChooser(".");
    mainArea=new JTextArea();
    getContentPane().add(mainArea);
    getContentPane().add(new JScrollPane(mainArea),BorderLayout.CENTER);
    setTitle("Amany Zalat -->NotePad");
    setSize(800, 600);
    //////menu bar
    mbar=new JMenuBar();
    ////menu
    Flie=new JMenu("Flie");
    Edit=new JMenu("Edit");
    format=new JMenu("Format");
    font=new JMenu("Font");
    Help=new JMenu("Help");
    About=new JMenu("About");
    color=new JMenu("Color");
    counter=new JMenu("Counter");
    
    
    
    //////////itmmnue
    
        mNew = new JMenuItem("New");
        mOpen = new JMenuItem("Open");
        mSave = new JMenuItem("Save");
        //mprint=new JMenuItem("Print");
        mExit = new JMenuItem("Exit");
        mundo = new JMenuItem("Undo");
        mcut = new JMenuItem("Cut");
        mcopy = new JMenuItem("Copy");
        mpaste = new JMenuItem("Paste");
        mdelete = new JMenuItem("Delete");
        
        mselect = new JMenuItem("Select All");
        
    //itmffont=new JMenuItem("Ffont",newIcon3);
        //itmAbout=new JMenuItem("About",newIcon4);
        mAmany = new JMenuItem("Amany Zalat");
        mAge = new JMenuItem("20 sana");
        memail = new JMenuItem("amanyzalat3010@gmail.com");
        mFact = new JMenuItem("FCI");
        mthank_you = new JMenuItem("Thank_you");
    
    
   color.add(mBackground=new JMenuItem("Background"));
    color.add(mfontcolor=new JMenuItem("fontcolor"));
   Flie.add(mNew);
    Flie.add(mOpen);
    Flie.add(mSave);
    Flie.insertSeparator(3);//line
    Flie.add(mExit);
    Edit.add(mundo);
    Edit.insertSeparator(1);
    Edit.add(mcut);
    Edit.add(mcopy);
    Edit.add(mpaste);
    Edit.add(mdelete);
    Edit.insertSeparator(6);
    Edit.add(mselect);
    format.add(font);
    //mnuFormat.add(itmffont);
    format.add(color);
    
   
    ButtonGroup line=new ButtonGroup();
    font.add(mBold=new JRadioButtonMenuItem("BOld"));
    line.add(mBold);
    font.add(mItailc=new JRadioButtonMenuItem("Itailc"));
    line.add(mItailc);
    font.add(mItailc_Bold=new JRadioButtonMenuItem("Itailc_Bold"));
    line.add(mItailc_Bold);
    font.add(mCENTER_BASELINE=new JRadioButtonMenuItem("CENTER_BASELINE"));
    line.add(mCENTER_BASELINE);
    font.add(mTRUETYPE_FONT=new JRadioButtonMenuItem("DIALOG"));
    line.add(mTRUETYPE_FONT);
    
    
    Help.add(About);
    About.add(mAmany);
    About.add(mAge);
    About.add(memail);
    About.add(mFact);
    Help.insertSeparator(2);
    Help.add(mthank_you);
    
    ///add menu item to menu bar
    mbar.add(Flie);
    mbar.add(Edit);
    mbar.add(format);
    mbar.add(Help);
    ///add menu bar to frame
    setJMenuBar(mbar);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
}

public void save(){
    if(JFileChooser.APPROVE_OPTION==filechoose.showSaveDialog(mSave)){///becase if prese save or cansel
        File fout=filechoose.getSelectedFile();
        try {
            FileWriter write=new FileWriter(fout);
            write.write(mainArea.getText());
            write.close();
            
        } catch (Exception e) {
            
        }
    }
        
}
public void open (){
    if(JFileChooser.APPROVE_OPTION==filechoose.showOpenDialog(mSave)){///becase if prese save or cansel
        File fin=filechoose.getSelectedFile();
        try {
            FileReader read =new FileReader(fin);
            int c;
            while((c=read.read())!=-1){
                String s=Character.toString((char)c);
                mainArea.setText(mainArea.getText()+s);
            }
            read.close();
        } catch (Exception e) {
        }
    
    }
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    note n=new note();
    }
    
}


