/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.util.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.text.*;

/**
 *
 * @author ENG.TR
 */
public class bb extends JFrame implements ActionListener {

    //MenuBar Items
    private JTextArea textArea = new JTextArea();
    private MenuBar menuBar = new MenuBar();
    private Menu File = new Menu();
    private Menu Edit = new Menu();
    private Menu Format = new Menu();
    private Menu View = new Menu();
    private Menu Help = new Menu();

    //File Menu Items
    private MenuItem newFile = new MenuItem();
    private MenuItem openFile = new MenuItem();
    private MenuItem saveFile = new MenuItem();
    private MenuItem saveFileAs = new MenuItem();
    private MenuItem PrintFile = new MenuItem();
    private MenuItem closeFile = new MenuItem();

    //Edit Menu Items
    private MenuItem undoEdit = new MenuItem();
    private MenuItem cutEdit = new MenuItem();
    private MenuItem copyEdit = new MenuItem();
    private MenuItem PasteEdit = new MenuItem();
    private MenuItem DeleteEdit = new MenuItem();
    private MenuItem findEdit = new MenuItem();
    private MenuItem replacEedit = new MenuItem();
    private MenuItem goTo = new MenuItem();
    private MenuItem selectAll = new MenuItem();
    private MenuItem timeAndDate = new MenuItem();

    //Format Menu Items
    private MenuItem wordWrap = new MenuItem();
    private MenuItem fontFormat = new MenuItem();

    //view Menu Items
    private MenuItem statusBar = new MenuItem();

    //Help Menu Items
    private MenuItem viewHelp = new MenuItem();
    private MenuItem aboutMnp = new MenuItem();

    //Main Class :
    public bb() {

        //Layout Properties
        this.setSize(1280, 720);
        this.setLocation(300,150);
        this.setResizable(true);
        this.setTitle("My NotePad");
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 18));
        this.textArea.setEditable(true);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        this.getContentPane().add(new JScrollPane(textArea));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // adding Menubar Items into the GUI
        
        this.setMenuBar(this.menuBar);
        this.menuBar.add(this.File);
        this.menuBar.add(this.Edit);
        this.menuBar.add(this.Format);
        this.menuBar.add(this.View);
        this.menuBar.add(this.Help);

        this.File.setLabel("File");
        this.Edit.setLabel("Edit");
        this.Format.setLabel("Format");
        this.View.setLabel("View");
        this.Help.setLabel("Help");

        //Menu Items Properties 
        this.newFile.setLabel("New");
        this.newFile.addActionListener(this);
        this.newFile.setShortcut(new MenuShortcut(KeyEvent.VK_N, false));
        this.File.add(this.newFile);

        this.openFile.setLabel("Open...");
        this.openFile.addActionListener(this);
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
        this.File.add(this.openFile);

        this.saveFile.setLabel("Save");
        this.saveFile.addActionListener(this);
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.File.add(this.saveFile);

        this.saveFileAs.setLabel("Save As...");
        this.saveFileAs.addActionListener(this);
        this.saveFileAs.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.File.add(this.saveFileAs);

        this.File.addSeparator();

        this.PrintFile.setLabel("Print...");
        this.PrintFile.addActionListener(this);
        this.PrintFile.setShortcut(new MenuShortcut(KeyEvent.VK_P, false));
        this.File.add(this.PrintFile);

        this.File.addSeparator();

        this.closeFile.setLabel("Close");
        this.closeFile.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.closeFile.addActionListener(this);
        this.File.add(this.closeFile);

        this.undoEdit.setLabel("Undo");
        this.undoEdit.addActionListener(this);
        this.undoEdit.setShortcut(new MenuShortcut(KeyEvent.VK_Z, false));
        this.Edit.add(this.undoEdit);

        this.cutEdit.setLabel("Cut");
        this.cutEdit.addActionListener(this);
        this.cutEdit.setShortcut(new MenuShortcut(KeyEvent.VK_X, false));
        this.Edit.add(this.cutEdit);

        this.copyEdit.setLabel("Copy");
        this.copyEdit.addActionListener(this);
        this.copyEdit.setShortcut(new MenuShortcut(KeyEvent.VK_C, false));
        this.Edit.add(this.copyEdit);

        this.PasteEdit.setLabel("paste");
        this.PasteEdit.addActionListener(this);
        this.PasteEdit.setShortcut(new MenuShortcut(KeyEvent.VK_V, false));
        this.Edit.add(this.PasteEdit);

        this.DeleteEdit.setLabel("Delete");
        this.DeleteEdit.addActionListener(this);
        this.DeleteEdit.setShortcut(new MenuShortcut(KeyEvent.VK_DELETE, false));
        this.Edit.add(this.DeleteEdit);

        this.Edit.addSeparator();

        this.findEdit.setLabel("Find...");
        this.findEdit.addActionListener(this);
        this.findEdit.setShortcut(new MenuShortcut(KeyEvent.VK_F, false));
        this.Edit.add(this.findEdit);

        this.replacEedit.setLabel("Replace...");
        this.replacEedit.addActionListener(this);
        this.replacEedit.setShortcut(new MenuShortcut(KeyEvent.VK_H, false));
        this.Edit.add(this.replacEedit);

        this.goTo.setLabel("Go To...");
        this.goTo.addActionListener(this);
        this.goTo.setShortcut(new MenuShortcut(KeyEvent.VK_G, false));
        this.Edit.add(this.goTo);

        this.Edit.addSeparator();

        this.selectAll.setLabel("Select All");
        this.selectAll.addActionListener(this);
        this.selectAll.setShortcut(new MenuShortcut(KeyEvent.VK_A, false));
        this.Edit.add(this.selectAll);

        this.timeAndDate.setLabel("Time/Date");
        this.timeAndDate.addActionListener(this);
        this.timeAndDate.setShortcut(new MenuShortcut(KeyEvent.VK_F5, false));
        this.Edit.add(this.timeAndDate);
        
        this.wordWrap.setLabel("Word Wrap");
        this.wordWrap.addActionListener(this);
        this.Format.add(this.wordWrap);
        
        this.fontFormat.setLabel("Font...");
        this.fontFormat.addActionListener(this);
        this.Format.add(this.fontFormat);
        
        this.statusBar.setLabel("Status Bar");
        this.statusBar.addActionListener(this);
        this.View.add(this.statusBar);
        
        this.viewHelp.setLabel("View Help");
        this.viewHelp.addActionListener(this);
        this.Help.add(this.viewHelp);
        
        this.aboutMnp.setLabel("Time/Date");
        this.aboutMnp.addActionListener(this);
        this.Help.add(this.aboutMnp);
    }

    public void actionPerformed(ActionEvent e) {

        // Actions for Every Choise :
        if (e.getSource() == this.newFile) {
            this.textArea.setText(" ");
        } else if (e.getSource() == this.closeFile) {
            this.dispose();
        } else if (e.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                this.textArea.setText("");
                try {
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    while (scan.hasNext()) {
                        this.textArea.append(scan.nextLine() + "\n");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else if (e.getSource() == this.saveFile) {
            JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    out.write(this.textArea.getText());
                    out.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } else if (e.getSource() == this.saveFileAs) {
            JFileChooser saveAs = new JFileChooser();
            int option = saveAs.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(saveAs.getSelectedFile().getPath()));
                    out.write(this.textArea.getText());
                    out.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } else if (e.getSource() == this.PrintFile) {
            PrinterJob pj = PrinterJob.getPrinterJob();
            if (pj.printDialog()) {
                try {
                    pj.print();
                } catch (PrinterException exc) {
                    System.out.println(exc);
                }
            }
        } else if (e.getSource() == this.undoEdit) {
//??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        } else if (e.getSource() == this.cutEdit) {
            textArea.cut();

        } else if (e.getSource() == this.copyEdit) {
            textArea.copy();

        } else if (e.getSource() == this.PasteEdit) {
            textArea.paste();

        } else if (e.getSource() == this.DeleteEdit) {
            textArea.replaceSelection(" ");

        } else if (e.getSource() == this.findEdit) {
            Highlighter hl = textArea.getHighlighter();
            hl.removeAllHighlights();
            String pattern = JOptionPane.showInputDialog(null, "Please Enter a Word to Search : ");
            String text = textArea.getText();
            int index = text.indexOf(pattern);
            while (index >= 0) {
                try {
                    hl.addHighlight(index, index + pattern.length(), DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                index = text.indexOf(pattern, index + pattern.length());
            }

        } else if (e.getSource() == this.replacEedit) {
            String fromField = JOptionPane.showInputDialog(null, "Enter Text to Search :");
            String toField = JOptionPane.showInputDialog(null, "Enter Text to Replace :");
            String from = fromField;
            int start = textArea.getText().indexOf(from);
            if (start >= 0 && from.length() > 0) {
                textArea.replaceRange(toField, start, start + from.length());
            }

        } else if (e.getSource() == this.goTo) {
            String indx = JOptionPane.showInputDialog(null, "Enter The Line Number To Go To :");
            int num = Integer.parseInt(indx);
            num = num - 1;
            textArea.setCaretPosition(textArea.getDocument().getDefaultRootElement().getElement(num).getStartOffset());
            textArea.requestFocusInWindow();
            
        } else if (e.getSource() == this.selectAll) {
            textArea.selectAll();
            
        } else if (e.getSource() == this.timeAndDate) {
            String DateTime = "yyyy-MM-dd HH:mm:ss";
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DateTime);
            textArea.append(sdf.format(cal.getTime()));
            
        } else if (e.getSource() == this.wordWrap) {
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            
        } else if (e.getSource() == this.fontFormat) {
            
            
        } else if (e.getSource() == this.selectAll) {
           
            
        } else if (e.getSource() == this.selectAll) {
            
        }

    }

    //Main Methode Calling :
    
    public static void main(String args[]) {
        bb app = new bb();
        app.setVisible(true);

    }
}
