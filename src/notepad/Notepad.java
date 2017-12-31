/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Abdo Rehab
 */
public class Notepad extends JFrame {

    JTextArea mainArea;
    JMenuBar mbar;
    JMenu mnuFlie, mnuEdit, mnuFormat, mnuHelp, mnuFont, mnuAbout, mnuColor, counter;
    JMenuItem itmchar, itmline, itmNew, itmOpen, itmSave,itmprint,itmExit, itmBold, itmTRUETYPE_FONT
            , itmCENTER_BASELINE, itmItailc, itmItailc_Bold, itmBackground, itmfontcolor,itmAbdo
            ,itmgoto,itmreplace,itmfind,itmAge, itmemail, itmFact, itmundo, itmcut, itmcopy, itmpaste,itmdataandtime
            , itmdelete, itmselect, itmthank_you;
    JCheckBox itmwordwarp;
    String filename;
    JFileChooser filechoose;
    String temp;
    UndoManager undoManager = new UndoManager();
    JPopupMenu rightclick;
    JMenuItem r_undo,r_cut,r_copy,r_paste,r_select;
    
    
    
    
        ////add icon to menu item 
        ImageIcon newIcon = new ImageIcon(getClass().getResource("/img/if_tab_new_raised_2502.png"));
        ImageIcon newIcon1 = new ImageIcon(getClass().getResource("/img/if_folder-open-o_1608381.png"));
        ImageIcon newIcon2 = new ImageIcon(getClass().getResource("/img/if_save_2639912.png"));
        ImageIcon newIcon3 = new ImageIcon(getClass().getResource("/img/if_icon-87-document-font_314451.png"));
        ImageIcon newIcon4 = new ImageIcon(getClass().getResource("/img/if_About_error_notification_help_info_information_1886031.png"));
        ImageIcon newIcon5 = new ImageIcon(getClass().getResource("/img/if_users-1_984101.png"));
        ImageIcon newIcon6 = new ImageIcon(getClass().getResource("/img/if_date_error_66721.png"));
        //ImageIcon newIcon7=new ImageIcon(getClass().getResource("/img/if_student_icon_1741314.png"));
        ImageIcon newIcon8 = new ImageIcon(getClass().getResource("/img/if_5_2301003.png"));
        ImageIcon newIcon9 = new ImageIcon(getClass().getResource("/img/if_icons_exit_1564505.png"));
        ImageIcon newIcon10 = new ImageIcon(getClass().getResource("/img/if_clipboard_cut_42190.png"));
        ImageIcon newIcon11 = new ImageIcon(getClass().getResource("/img/if_Copy_1214959.png"));
        ImageIcon newIcon12 = new ImageIcon(getClass().getResource("/img/if_edit-paste_118923.png"));
        ImageIcon newIcon13 = new ImageIcon(getClass().getResource("/img/if_trash_delete_66898.png"));
        ImageIcon newIcon14 = new ImageIcon(getClass().getResource("/img/if_ic_clear_all_48px_352269.png"));
        ImageIcon newIcon15 = new ImageIcon(getClass().getResource("/img/if_17.Brush_290133.png"));
        ImageIcon newIcon16 = new ImageIcon(getClass().getResource("/img/if_ic_format_color_text_48px_352385.png"));
        ImageIcon newIcon17 = new ImageIcon(getClass().getResource("/img/if_font-type1_24866.png"));
        ImageIcon newIcon18 = new ImageIcon(getClass().getResource("/img/if_00-ELASTOFONT-STORE-READY_price_2738303.png"));
        ImageIcon newIcon19 = new ImageIcon(getClass().getResource("/img/if_gmail_184020.png"));
        ImageIcon newIcon20 = new ImageIcon(getClass().getResource("/img/if_04_EmoticonsHDcom_343148.png"));
        ImageIcon newIcon21=new ImageIcon(getClass().getResource("/img/if_basics-19_296814.png"));
        ImageIcon newIcon22=new ImageIcon(getClass().getResource("/img/if_ic_find_replace_48px_352364.png"));
        ImageIcon newIcon23=new ImageIcon(getClass().getResource("/img/if_old-go-next_23498.png"));
        ImageIcon newIcon24=new ImageIcon(getClass().getResource("/img/if_icon-125-printer-text_314822.png"));
        ImageIcon newIcon25=new ImageIcon(getClass().getResource("/img/if_date_7076.png"));

    public Notepad() {
        initcomponent();
        /////Action
//        itmSave.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                save();
//            }
//        });
        itmSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        itmOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });
        itmNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainArea.setText("");
            }
        });
        itmprint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           PrinterJob pj = PrinterJob.getPrinterJob();
            if (pj.printDialog()) {
                try {
                    pj.print();
                } catch (PrinterException exc) {
                    System.out.println("Error in printting");}
            }
            }
        });
        itmExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        itmcut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                temp=mainArea.getSelectedText();
//                mainArea.replaceRange("", mainArea.getSelectionStart(), mainArea.getSelectionEnd());
//                checkcut=true;
                mainArea.cut();
            }
        });
        itmcopy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                    temp=mainArea.getSelectedText();
//                    checkcut=false;
                mainArea.copy();

            }
        });
        itmpaste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                mainArea.replaceRange(temp, mainArea.getSelectionStart(), mainArea.getSelectionEnd());
//                if(checkcut){
//                    temp="";
//                }
                mainArea.paste();

            }
        });
        itmselect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainArea.selectAll();
            }
        });
        itmgoto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           String indx = JOptionPane.showInputDialog(null, "Enter The Line Number To Go To :");
            
            if (indx.matches("[0-9]+")) {
            int num = Integer.parseInt(indx);
            num = num - 1;
            mainArea.setCaretPosition(mainArea.getDocument().getDefaultRootElement().getElement(num).getStartOffset());
            mainArea.requestFocusInWindow();
            }
            else {
                    JOptionPane.showMessageDialog(null, "line not correct");
                    actionPerformed(e);
                }
            }
        });
        itmreplace.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              String fromField = JOptionPane.showInputDialog(null, "Enter Text to Search :");
            if (fromField.matches("[a-z]+|[A-Z]+|[0-9]+")) {
              String toField = JOptionPane.showInputDialog(null, "Enter Text to Replace :");
            
            int start = mainArea.getText().indexOf(fromField);
            if (start >= 0 && fromField.length() > 0) {
                mainArea.replaceRange(toField, start, start + fromField.length());
            }
            }
            else {
                    JOptionPane.showMessageDialog(null, "line not correct");
                    actionPerformed(e);
                }
            }
            
        });
        itmfind.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Highlighter hl = mainArea.getHighlighter();
            hl.removeAllHighlights();
            String pattern = JOptionPane.showInputDialog(null, "Please Enter a Word to Search : ");
            String text = mainArea.getText();
            int index = text.indexOf(pattern);
            while (index >= 0) {
                try {
                    hl.addHighlight(index, index + pattern.length(), DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                index = text.indexOf(pattern, index + pattern.length());
            }
            
            }
        });
        itmdelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainArea.replaceRange("", mainArea.getSelectionStart(), mainArea.getSelectionEnd());

            }
        });
        mainArea.getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                    undoManager.addEdit(e.getEdit());
            }
        });
        itmundo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(undoManager.canUndo())
                {
                    undoManager.undo();
                }
            }
        });
        itmdataandtime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           String DateTime = "yyyy-MM-dd HH:mm:ss";
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DateTime);
            mainArea.append(sdf.format(cal.getTime()));
            }
        });
        itmBold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String x = JOptionPane.showInputDialog(null, "enter font size");

                if (x.matches("[0-9]+")) {
                    mainArea.setFont(new Font("Bold", Font.BOLD, Integer.parseInt(x)));
                } else {
                    JOptionPane.showMessageDialog(null, "size not correct");
                    actionPerformed(e);
                }
            }

        });
        itmItailc_Bold.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x = JOptionPane.showInputDialog(null, "enter font size");
                if (x.matches("[0-9]+")) {
                    mainArea.setFont(new Font("itailc_Bold", Font.BOLD + Font.ITALIC, Integer.parseInt(x)));
                } else {
                    JOptionPane.showMessageDialog(null, "size not correct");
                    actionPerformed(e);
                }
            }
        });
        itmItailc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x = JOptionPane.showInputDialog(null, "enter font size");
                if (x.matches("[0-9]+")) {
                    mainArea.setFont(new Font("italic", Font.ITALIC, Integer.parseInt(x)));
                } else {
                    JOptionPane.showMessageDialog(null, "size not correct");
                    actionPerformed(e);
                }
            }
        });
        itmCENTER_BASELINE.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x = JOptionPane.showInputDialog(null, "enter font size");
                if (x.matches("[0-9]+")) {
                    mainArea.setFont(new Font("CENTER_BASELINE", Font.CENTER_BASELINE, Integer.parseInt(x)));
                } else {
                    JOptionPane.showMessageDialog(null, "size not correct");
                    actionPerformed(e);
                }
            }
        });
        itmTRUETYPE_FONT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String x = JOptionPane.showInputDialog(null, "enter font size");
                if (x.matches("[0-9]+")) {
                    mainArea.setFont(new Font("TRUETYPE_FONT", Font.TRUETYPE_FONT, Integer.parseInt(x)));
                } else {
                    JOptionPane.showMessageDialog(null, "size not correct");
                    actionPerformed(e);
                }
            }
        });
        itmfontcolor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color l = Color.BLUE;
                Color color2 = JColorChooser.showDialog(itmfontcolor, "Color the color", l);
                mainArea.setForeground(color2);

            }
        });
        itmBackground.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color l2 = Color.BLUE;
                Color color2 = JColorChooser.showDialog(itmBackground, "Color the color", l2);
                mainArea.setBackground(color2);

            }
        });
        itmwordwarp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(itmwordwarp.isSelected())
                {
                    mainArea.setLineWrap(true);
                mainArea.setWrapStyleWord(true);
                }
                else
                {
                    mainArea.setLineWrap(false);
                mainArea.setWrapStyleWord(false);
                }
            }       
        });
        itmchar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = mainArea.getText();
                JOptionPane.showMessageDialog(itmchar, "Characters : " + s.length());
            }
        });
        itmline.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(itmline, "Lines : " + mainArea.getLineCount());
            }
        });
        mainArea.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                rightclick = new JPopupMenu();
                r_undo = new JMenuItem("Undo");
                r_cut = new JMenuItem("Cut",newIcon10);
                r_copy = new JMenuItem("Copy",newIcon11);
                r_paste = new JMenuItem("Paste",newIcon12);
                r_select = new JMenuItem("Select All",newIcon14);
                rightclick.add(r_undo);
                rightclick.add(r_cut);
                rightclick.add(r_copy);
                rightclick.add(r_paste);
                rightclick.add(r_select);
                if(e.getButton()==MouseEvent.BUTTON3)
                {   
                rightclick.show(e.getComponent(), e.getX(), e.getY());
                }
                //r_undo.addActionListener();              // add actions to jmenuitems
                mainArea.getDocument().addUndoableEditListener(new UndoableEditListener() {

                        @Override
                        public void undoableEditHappened(UndoableEditEvent e) {
                            undoManager.addEdit(e.getEdit());
                        }
                });
                r_undo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
           
                        if(undoManager.canUndo())
                            {
                            undoManager.undo();
                            }
            
                    }
                });
                r_cut.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainArea.cut();
                    }
                });
                r_copy.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainArea.copy();
                    }
                });
                r_paste.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainArea.paste();
                    }
                });
                r_select.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                   mainArea.selectAll();
                    }
                });
                r_undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
                r_cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                r_copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
                r_paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
                r_select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

            }

        });

    }

    private void initcomponent() {
        filechoose = new JFileChooser(".");
        mainArea = new JTextArea();
        getContentPane().add(mainArea);
        getContentPane().add(new JScrollPane(mainArea), BorderLayout.CENTER);
        setTitle("Abdallah Rehab -->NotePad");
        setSize(800, 600);
        //////menu bar
        mbar = new JMenuBar();
        ////menu
        mnuFlie = new JMenu("Flie");
        mnuEdit = new JMenu("Edit");
        mnuFormat = new JMenu("Format");
        mnuFont = new JMenu("Font");
        mnuHelp = new JMenu("Help");
        mnuAbout = new JMenu("About");
        mnuColor = new JMenu("Color");
        counter = new JMenu("Counter");
    

        ////menu item\object from Jmenuitem
        itmNew = new JMenuItem("New", newIcon);
        itmOpen = new JMenuItem("Open", newIcon1);
        itmSave = new JMenuItem("Save", newIcon2);
        itmprint=new JMenuItem("Print",newIcon24);
        itmExit = new JMenuItem("Exit", newIcon9);
        itmundo = new JMenuItem("Undo");
        itmcut = new JMenuItem("Cut", newIcon10);
        itmcopy = new JMenuItem("Copy", newIcon11);
        itmpaste = new JMenuItem("Paste", newIcon12);
        itmdelete = new JMenuItem("Delete", newIcon13);
        itmgoto=new JMenuItem("Go To",newIcon23);
        itmreplace=new JMenuItem("Replace",newIcon22);
        itmfind=new JMenuItem("Find",newIcon21);
        itmselect = new JMenuItem("Select All", newIcon14);
        itmdataandtime=new JMenuItem("Data and Time",newIcon25);
        itmwordwarp=new JCheckBox("WordWarp");
    //itmffont=new JMenuItem("Ffont",newIcon3);
        //itmAbout=new JMenuItem("About",newIcon4);
        itmAbdo = new JMenuItem("Abdallah rehab", newIcon5);
        itmAge = new JMenuItem("20 sana", newIcon6);
        itmemail = new JMenuItem("abdorehab95@gmail.com", newIcon19);
        itmFact = new JMenuItem("FCI", newIcon8);
        itmthank_you = new JMenuItem("Thank_you", newIcon20);
        /////adding shorting 
        itmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        itmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        itmcut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        itmcopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        itmdelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        itmpaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        itmselect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        itmprint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        itmfind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        itmgoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        

//    itmFont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
//    itmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        ///add menu item
        mnuFlie.add(itmNew);
        mnuFlie.add(itmOpen);
        mnuFlie.add(itmSave);
        mnuFlie.insertSeparator(3);
        mnuFlie.add(itmprint);
        mnuFlie.insertSeparator(5);//line
        mnuFlie.add(itmExit);
        mnuEdit.add(itmundo);
        mnuEdit.insertSeparator(1);
        mnuEdit.add(itmcut);
        mnuEdit.add(itmcopy);
        mnuEdit.add(itmpaste);
        mnuEdit.add(itmdelete);
        mnuEdit.insertSeparator(6);
        mnuEdit.add(itmgoto);
        mnuEdit.add(itmreplace);
        mnuEdit.add(itmfind);
        mnuEdit.insertSeparator(10);
        mnuEdit.add(itmselect);
        mnuEdit.add(itmdataandtime);
        mnuFormat.add(itmwordwarp);
        mnuFormat.add(mnuFont);
        //mnuFormat.add(itmffont);
        mnuFormat.add(mnuColor);
        mnuFormat.add(counter);
        mnuColor.add(itmBackground = new JMenuItem("Background", newIcon15));
        mnuColor.add(itmfontcolor = new JMenuItem("fontcolor", newIcon16));

        counter.add(itmchar = new JMenuItem("Characters", newIcon17));
        counter.add(itmline = new JMenuItem("Lines", newIcon18));

        ButtonGroup line = new ButtonGroup();
        mnuFont.add(itmBold = new JRadioButtonMenuItem("BOld"));
        line.add(itmBold);
        mnuFont.add(itmItailc = new JRadioButtonMenuItem("Itailc"));
        line.add(itmItailc);
        mnuFont.add(itmItailc_Bold = new JRadioButtonMenuItem("Itailc_Bold"));
        line.add(itmItailc_Bold);
        mnuFont.add(itmCENTER_BASELINE = new JRadioButtonMenuItem("CENTER_BASELINE"));
        line.add(itmCENTER_BASELINE);
        mnuFont.add(itmTRUETYPE_FONT = new JRadioButtonMenuItem("DIALOG"));
        line.add(itmTRUETYPE_FONT);
           
        mnuFormat.add(itmwordwarp );
        mnuHelp.add(mnuAbout);
        mnuAbout.add(itmAbdo);
        mnuAbout.add(itmAge);
        mnuAbout.add(itmemail);
        mnuAbout.add(itmFact);
        mnuHelp.insertSeparator(2);
        mnuHelp.add(itmthank_you);

        ///add menu item to menu bar
        mbar.add(mnuFlie);
        mbar.add(mnuEdit);
        mbar.add(mnuFormat);
        mbar.add(mnuHelp);
        ///add menu bar to frame
        setJMenuBar(mbar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

//    public void save() {
//        if (JFileChooser.APPROVE_OPTION == filechoose.showSaveDialog(itmSave)) {///becase if prese save or cansel
//            File fout = filechoose.getSelectedFile();
//            try {
//                FileWriter write = new FileWriter(fout);
//                write.write(mainArea.getText());
//                write.close();
//
//            } catch (Exception e) {
//
//            }
//        }
//
//    }
    private void save() {
        FileDialog fileDialog = new FileDialog(this, "SaveFILE", FileDialog.SAVE);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }
        try {
            FileWriter fileWriter = new FileWriter(filename);// create file
            fileWriter.write(mainArea.getText());
            setTitle(filename);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("not find");
        }
    }

//    public void open() {
//        if (JFileChooser.APPROVE_OPTION == filechoose.showOpenDialog(itmOpen)) {///becase if prese save or cansel
//            File fin = filechoose.getSelectedFile();
//            try {
//                mainArea.setText("");
//
//                FileReader read = new FileReader(fin);
//                int c;
//                while ((c = read.read()) != -1) {
//                    String s = Character.toString((char) c);
//                    mainArea.setText(mainArea.getText() + s);
//                }
//                read.close();
//            } catch (Exception e) {
//            }
//
//        }
//
//    }
     private void open() {
        FileDialog fileDialog = new FileDialog(this, "OpenFile", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                mainArea.setText(sb.toString());

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("not find");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Notepad n = new Notepad();
    }

}
