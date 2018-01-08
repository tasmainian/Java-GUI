import java.awt.*;  
import javax.swing.*;
public class Quest {
//START HERE
	public static void main(String[] args) throws Exception {
		//Calling to set the values of your character
		Values set = new Values();
		set.setSize(600, 300);
		set.setVisible(true);
		set.getContentPane().setLayout(new FlowLayout());
		set.getContentPane().setBackground(new Color (255,255,255));  //Change the frame's background
		set.repaint();
		
		
	}


}
