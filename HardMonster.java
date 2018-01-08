import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class HardMonster extends JFrame implements ActionListener{

	private JLabel label;
	 public HardMonster() throws IOException
	  {
		//Creates text field for the use
	    super("Battle");
	    JPanel pane = (JPanel) getContentPane();
	    pane.setLayout(new BorderLayout());
	    
	    JPanel fieldPane = new JPanel();
	    fieldPane.setSize(700, 200);
	    fieldPane.setLayout(new GridLayout(10,1));
	    fieldPane.setBackground(new Color (51,204,255));
	    fieldPane.add(new JLabel("You have stumbled upon a monster!"));
	    fieldPane.add(new JLabel("He has 30 Attack and 100 Health!"));
	    fieldPane.add(new JLabel("Fight or Run?"));
	    CharacterCreation emon = new CharacterCreation();
	    emon.setStrength(30);
	    emon.setHealth(100);
	    
	    label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("hard.png")).getImage();
		label.setIcon(new ImageIcon(img));
		add(label);
		pack();
	    pane.add(fieldPane,BorderLayout.NORTH);
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout());
	    //button options
	    //Attack Option
	    JButton AttackButton = new JButton ("Attack");
	    AttackButton.addActionListener(this);
	    //Run Option
	    JButton RunButton = new JButton ("Run");
	    RunButton.addActionListener(this);
	    buttonPane.add(AttackButton);
	    buttonPane.add(RunButton);

	    pane.add(buttonPane,BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	  
	  }
 public void actionPerformed( ActionEvent evt)  
 {
	 CharacterCreation emon = new CharacterCreation();
	 CharacterCreation user = new CharacterCreation();
	    emon.setStrength(30);
	    emon.setHealth(100);
	  if (evt.getActionCommand().equals("Run")){ 
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
	  
	  else if (evt.getActionCommand().equals("Attack")){ 
		  emon.setHealth(emon.getHealth()-user.getStrength());
			user.setHealth(user.getHealth()-emon.getStrength());
			if (emon.getHealth()<=0){
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
			else if (user.getHealth()<=0){
				System.exit(0);
			}
	  }
 }
	
public static void main ( String[] args ) throws IOException
 {
	  HardMonster calc = new HardMonster();
      
 }
}
