import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class HealthPlus extends JFrame implements ActionListener{

	private JLabel label;
	 public HealthPlus() throws IOException
	  {
		//creates text field for the use
	    super("Level Up!");
	    JPanel pane = (JPanel) getContentPane();
	    pane.setLayout(new BorderLayout());
	    //outputs the statements the user will use for the text field
	    
	    JPanel fieldPane = new JPanel();
	    fieldPane.setSize(700, 200);
	    fieldPane.setLayout(new GridLayout(10,1));
	    fieldPane.setBackground(new Color (51,204,255));
	    fieldPane.add(new JLabel("You found a potion!"));
	    fieldPane.add(new JLabel("+5 HP!"));
	    CharacterCreation user = new CharacterCreation();
	    user.setHealth(user.getHealth()+5);
	    CharacterCreation updatedUser = new CharacterCreation(user.getName(), user.getGender(), user.getStrength(), user.getHealth());
	    user.setHealth(user.getHealth()+5);
	    fieldPane.add(new JLabel("You now have "+user.getHealth()+" HP!"));
	    
	    label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("potion.png")).getImage();
		label.setIcon(new ImageIcon(img));
		add(label);
		pack();
	    pane.add(fieldPane,BorderLayout.NORTH);
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout());
	    //button options
	    //Next Option
	    JButton NextButton = new JButton ("Next");
	    NextButton.addActionListener(this);
	    buttonPane.add(NextButton);

	    pane.add(buttonPane,BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	  
	  }
 public void actionPerformed( ActionEvent evt)  
 {
	//returns to dice roll GUI
	 if (evt.getActionCommand().equals("Next")){ 
		  setVisible(false);
		    try {
		    	
		    	RollGUI roll = new RollGUI();
				roll.setSize(700, 200);
				roll.setVisible(true);
				roll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				roll.getContentPane().setLayout(new FlowLayout());
				roll.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
				roll.repaint();
				
			} 	catch (IOException e) {
				e.printStackTrace();
			}
	    }
 }
	
public static void main ( String[] args ) throws IOException
 {
	  HealthPlus calc = new HealthPlus();
      
 }
}
