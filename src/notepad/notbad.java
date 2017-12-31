//package notepad;
//
//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Menu;
//import java.awt.MenuBar;
//import java.awt.MenuItem;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JColorChooser;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPopupMenu;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.KeyStroke;
///**
// *
// * @author Sara Alasdody
// */
//
//
//
//public class notbad extends JFrame {
//       JTextArea textarea ;
//       MenuBar mb ;
//       Menu File,Edit,Format,Help;
//       MenuItem i1,itmopen,i3,i4,i5,a1,a2,a3,a4,a5,w1,w2,c1;
//       JPopupMenu popupmenu;
//       JFileChooser filechoose;
//       
//      
//     public notbad(){
//             filechoose=new JFileChooser("222");
//            textarea=new JTextArea();
//    getContentPane().add(textarea);
//    getContentPane().add(new JScrollPane(textarea),BorderLayout.CENTER);
//    setTitle(" Sara Alasdody-->NotePad");
//    setSize(800, 600);
//
//         
//         
//         mb =new MenuBar();
//         
//       // menu File
//         File= new Menu("File");
//          i1=new MenuItem("New");  
//          itmopen=new MenuItem("Open");  
//          i3=new MenuItem("Save");  
//          i4=new MenuItem("Save as");  
//          i5=new MenuItem("Exite");
//         File.add(i1);
//         File.add(itmopen);
//         File.add(i3);
//         File.add(i4);
//         File.add(i5);
//         mb.add(File);
//         setMenuBar(mb);
//         i1.addActionListener(new ActionListener() {
//             @Override
//              public void actionPerformed(ActionEvent e) {
//                textarea.setText("");
//             } 
//         });
//         itmopen.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                open();
//                       
//            } 
//           });
//            
//         i3.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                save();
//            }
//        });
//       //menu edit
//          Edit= new Menu("Edit");
//           a1=new MenuItem("cut");  
//           a2=new MenuItem("copy");  
//           a3=new MenuItem("past");  
//           a4=new MenuItem("Delet");  
//           a5=new MenuItem("Find");
//         Edit.add(a1);
//         Edit.add(a2);
//         Edit.add(a3);
//         Edit.add(a4);
//         Edit.add(a5);
//         mb.add(Edit);
//         ///
//         a1.addActionListener(new ActionListener() {
//
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                textarea.cut();
//                 }
//             });
//         a2.addActionListener(new ActionListener() {
//
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                textarea.copy();
//                 }
//             });
//         a3.addActionListener(new ActionListener() {
//
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                textarea.paste();
//                 }
//             });
//     
//         
//       //menu fromat
//        Format= new Menu("Format");
//           w1=new MenuItem("word warp");  
//           w2=new MenuItem("Font");      
//         Format.add(w1);
//         Format.add(w2);
//         mb.add(Format);
//       //menu Help
//         Help= new Menu("Help");
//            c1=new MenuItem("Sara Alasdody"); 
//         Help.add(c1);
//         mb.add(Help);
//        
//       //popupMenue
//         popupmenu=new JPopupMenu();
//         
//                            
//        
//         setMenuBar(mb);
//                   
//
//        
//       
//        
//        
//      
//        
//       
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//
//     }
//     public void save(){
//    if(JFileChooser.APPROVE_OPTION==filechoose.showSaveDialog(this)){
//        File fout=filechoose.getSelectedFile();
//        try {
//            FileWriter write=new FileWriter(fout);
//            write.write(textarea.getText());
//            write.close();
//            
//        } catch (Exception e) {
//            
//        }
//    }
//        
//}
//     public void open (){
//    if(JFileChooser.APPROVE_OPTION==filechoose.showOpenDialog(this)){///becase if prese save or cansel
//        File fin=filechoose.getSelectedFile();
//        try {
//             textarea.setText("");
//            FileReader read =new FileReader(fin);
//            int c;
//            while((c=read.read())!=-1){
//                String s=Character.toString((char)c);
//                textarea.setText(textarea.getText()+s);
//            }
//            read.close();
//        } catch (Exception e) {
//        }
//    
//    }
//    
//}
//        
// public static void main (String [] args) {
//     notbad giu = new notbad();
//     
//     
// }   
//}


import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
/**
 *
 * @author Sara Alasdody
 */



public class notbad extends JFrame {
       JTextArea textarea ;
       MenuBar mb ;
       Menu File,Edit,Format,Help;
       MenuItem i1,itmopen,i3,i4,i5,a1,a2,a3,a4,a5,w1,w2,w3,c1;
      // JPopupMenu popupmenu;
       JFileChooser filechoose;
       
      
     public notbad(){
             filechoose=new JFileChooser(".");
            textarea=new JTextArea();
    getContentPane().add(textarea);
    getContentPane().add(new JScrollPane(textarea),BorderLayout.CENTER);
    setTitle(" NotePad");
    setSize(800, 600);

         
         
         mb =new MenuBar();
         
       // menu File
         File= new Menu("File");
          i1=new MenuItem("New");  
          itmopen=new MenuItem("Open");  
          i3=new MenuItem("Save");  
          i4=new MenuItem("Save as");  
          i5=new MenuItem("Exite");
         File.add(i1);
         File.add(itmopen);
         File.add(i3);
         File.add(i4);
         File.add(i5);
         mb.add(File);
         setMenuBar(mb);
         i1.addActionListener(new ActionListener() {
             @Override
              public void actionPerformed(ActionEvent e) {
                textarea.setText("");
             } 
         });
         itmopen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                open();
                       
            } 
           });
            
         i3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
         i5.addActionListener(new ActionListener() {

                 @Override
                 public void actionPerformed(ActionEvent e) {
                  System.exit(0);
                 }
             });
         
       //menu edit
          Edit= new Menu("Edit");
           a1=new MenuItem("cut");  
           a2=new MenuItem("copy");  
           a3=new MenuItem("past");  
           a4=new MenuItem("Delet");  
           a5=new MenuItem("Select all");
         Edit.add(a1);
         Edit.add(a2);
         Edit.add(a3);
         Edit.add(a4);
         Edit.add(a5);
         mb.add(Edit);
         ///
         a1.addActionListener(new ActionListener() {

                 @Override
                 public void actionPerformed(ActionEvent e) {
                textarea.cut();
                 }
             });
         a2.addActionListener(new ActionListener() {

                 @Override
                 public void actionPerformed(ActionEvent e) {
                textarea.copy();
                 }
             });
         a3.addActionListener(new ActionListener() {

                 @Override
                 public void actionPerformed(ActionEvent e) {
                textarea.paste();
                 }
             });
         a4.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                  textarea.replaceRange("", textarea.getSelectionStart(), textarea.getSelectionEnd());

                 }
             });
         a5.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     textarea.selectAll();
                 }
             });
       //menu fromat
        Format= new Menu("Format");
           w1=new MenuItem("Color for Font");  
           w2=new MenuItem("Color for background"); 
           w3=new MenuItem("Font"); 
           
         Format.add( w1 );
         Format.add(w2);
         Format.add(w3);
         mb.add(Format);
          w1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             Color initialcolor=Color.RED;    
Color color=JColorChooser.showDialog(rootPane, " select acolor", initialcolor);


                textarea.setForeground(color);

            }
        });
          
           w2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             Color initialcolor1=Color.RED;    
             Color color=JColorChooser.showDialog(rootPane, " select acolor", initialcolor1);


             textarea.setBackground(color);


            }
        });
          
          
          
          
         
          
          
         
       //menu Help
         Help= new Menu("Help");
            c1=new MenuItem("Sara Alasdody"); 
         Help.add(c1);
         mb.add(Help);
        
       //popupMenue
//         popupmenu=new JPopupMenu();
         
                            
        
         setMenuBar(mb);
                   

        
       
        
        //action
        i1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
             textarea.setText("");
             }
         });
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

     }
     public void save(){
    if(JFileChooser.APPROVE_OPTION==filechoose.showSaveDialog(this)){
        File fout=filechoose.getSelectedFile();
        try {
            FileWriter write=new FileWriter(fout);
            write.write(textarea.getText());
            write.close();
            
        } catch (Exception e) {
            
        }
    }
        
}
     public void open (){
    if(JFileChooser.APPROVE_OPTION==filechoose.showOpenDialog(this)){///becase if prese save or cansel
        File fin=filechoose.getSelectedFile();
        try {
             textarea.setText("");
            FileReader read =new FileReader(fin);
            int c;
            while((c=read.read())!=-1){
                String s=Character.toString((char)c);
                textarea.setText(textarea.getText()+s);
            }
            read.close();
        } catch (Exception e) {
        }
    
    }
    
}
        
 public static void main (String [] args) {
     notbad giu = new notbad();
     
     
 }   
}