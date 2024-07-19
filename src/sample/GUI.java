package sample;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
//import javax.swing.JTextArea;


public class GUI implements ActionListener{
	JFrame window;
	JTextArea textArea;
	boolean wordwrap=false;
	int size=8;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile,menuFormate,menuColor,menuEdit;
	//File items
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	//Formate items
	JMenuItem iWrap, iFontArial,iFontCSMS,iFontTNR,iFontSize8,
		iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
	JMenu menuFont,menuFontSize;
	// Color items
	JMenuItem color1,color2,color3;
	// Edit items
	JMenuItem iundo,iredo;
	
	UndoManager um=new UndoManager();
	
	Function_File file=new Function_File(this);
	Function_Formate formate=new Function_Formate(this);
	Function_Color color= new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	
	KeyHandler kHandler=new KeyHandler(this);
	
	public static void main(String args[]) {
//		System.out.println("hello world...");
		new GUI();
	}
	
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileItems();
		createFormateMenu();
		createColorItems();
		createEditItems();
		formate.selectedFont="Arial";
		formate.createFont(16);
		window.setVisible(true);
	}
	public void createWindow() {
		window=new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea=new JTextArea();
		textArea.setFont(formate.arial);
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener()
				{
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		scrollPane=
				new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	public void createMenuBar() {
		menuBar= new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile=new JMenu("File");
		menuBar.add(menuFile);
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		menuFormate=new JMenu("Formate");
		menuBar.add(menuFormate);
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);
	}
	public void createFileItems() {
		iNew=new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen=new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		iSave=new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs=new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		
		iExit=new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
		menuFile.add(iNew);
		menuFile.add(iOpen);
		menuFile.add(iSave);
		menuFile.add(iSaveAs);
		menuFile.add(iExit);
	}
	public void createFormateMenu() {
		iWrap=new JMenuItem("Word Wrap:Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormate.add(iWrap);
		
		menuFont =new JMenu("Font");
		menuFormate.add(menuFont);
//		
		menuFontSize =new JMenu("Font Size");
		menuFormate.add(menuFontSize);
		
		iFontArial= new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS= new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR= new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		iFontSize8= new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12= new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16= new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20= new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24= new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28= new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("28");
		menuFontSize.add(iFontSize28);
		
		
	}
	public void createColorItems() {
		color1=new JMenuItem("White");
		color1.addActionListener(this);
		color1.setActionCommand("White");
		menuColor.add(color1);
		
		color2=new JMenuItem("Black");
		color2.addActionListener(this);
		color2.setActionCommand("Black");
		menuColor.add(color2);
		
		color3=new JMenuItem("Red");
		color3.addActionListener(this);
		color3.setActionCommand("Red");
		menuColor.add(color3);
	}
	public void createEditItems() {
		iundo=new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setActionCommand("undo");
		menuEdit.add(iundo);
		
		iredo=new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setActionCommand("redo");
		menuEdit.add(iredo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		
		switch(command) {
			case "New":file.newFile();break;
			case "Open":file.open();break;
			case "SaveAs":file.saveAs();break;
			case "Save":file.save();break;
			case "Exit":file.exit();break;
			case "Word Wrap":formate.wordWrap();break;
			case "8":formate.createFont(8);break;
			case "12":formate.createFont(12);break;
			case "16":formate.createFont(16);break;
			case "20":formate.createFont(20);break;
			case "24":formate.createFont(24);break;
			case "28":formate.createFont(28);break;
			case "Arial":formate.setFont("Arial");break;
			case "Comic Sans MS":formate.setFont("Comic Sans MS");break;
			case "Times New Roman":formate.setFont("Times New Roman");break;
			case "White":color.changeColor("White");break;
			case "Black":color.changeColor("Black");break;
			case "Red":color.changeColor("Red");break;
			case "undo":edit.undo();break;
			case "redo":edit.redo();break;
			
		}		
		
	}
}
