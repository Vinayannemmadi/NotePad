package sample;

import java.awt.Font;

public class Function_Formate {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String selectedFont="Arial";
	public Function_Formate(GUI gui) {
		this.gui=gui;
	}
	
	public void wordWrap() {
		if(gui.wordwrap==false) {
			gui.wordwrap=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap:On");
		}
		else {
			gui.wordwrap=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap:Off");
		}
	}
	public void createFont(int fontSize) {
		arial = new Font("Arial",Font.PLAIN,fontSize);
		comicSansMS = new Font("Comic Sans MS",Font.PLAIN,fontSize);
		timesNewRoman = new Font("Times New Roman",Font.PLAIN,fontSize);
		
		setFont(selectedFont);
	}
	public void setFont(String font) {
		selectedFont=font;
		switch(selectedFont) {
			case "Comic Sans MS":
				gui.textArea.setFont(comicSansMS);break;
			case "Arial":
				gui.textArea.setFont(arial);break;
			case "Times New Roman":
				gui.textArea.setFont(timesNewRoman);break;
		}
	}
}
