import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Values extends JFrame implements ActionListener{

	private JTextField name, gender, strength, health,person;
	private JLabel label;
	 public Values() throws IOException
	  {
		//creates text field for the use
	    super("RPG Quest");
	    JPanel pane = (JPanel) getContentPane();
	    pane.setLayout(new BorderLayout());
	    setSize(700, 200);
	    //outputs the statements the user will use for the text field
	    name= new JTextField(50);
	    gender = new JTextField(50);
	    strength = new JTextField(50);
	    health = new JTextField(50);
	    person= new JTextField(50);
	    person.setEditable(false);
	    
	    JPanel fieldPane = new JPanel();
	    fieldPane.setSize(700, 200);
	    fieldPane.setLayout(new GridLayout(10,1));
	    fieldPane.setBackground(new Color (51,204,255));
	    fieldPane.add(new JLabel("Name"));
	    fieldPane.add(name);
	    fieldPane.add(new JLabel("Gender"));
	    fieldPane.add(gender);
	    fieldPane.add(new JLabel("Strength"));
	    fieldPane.add(strength);
	    fieldPane.add(new JLabel("Health"));
	    fieldPane.add(health);
	    fieldPane.add(new JLabel("Character"));
	    fieldPane.add(person);
	    
	    pane.add(fieldPane,BorderLayout.NORTH);
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout());
	    //button options
	    //Create Option
	    JButton CreateButton = new JButton ("Create");
	    CreateButton.addActionListener(this);
	    //Begin Option
	    JButton BeginButton = new JButton ("Begin");
	    BeginButton.addActionListener(this);
	    buttonPane.add(CreateButton);
	    buttonPane.add(BeginButton);

	    pane.add(buttonPane,BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	  
	  }
 public void actionPerformed( ActionEvent evt)  
 {
	 CharacterCreation user = new CharacterCreation(name.getText(), gender.getText(),Integer.parseInt(strength.getText()), Integer.parseInt(health.getText()));  
	  if (evt.getActionCommand().equals("Begin")){ 
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
	  
	  else if (evt.getActionCommand().equals("Create")){ 
		  person.setText(user.toString());
		  if (user.getGender().equalsIgnoreCase("male")){
			  label = new JLabel("");
	  		  Image img = new ImageIcon(this.getClass().getResource("male.jpg")).getImage();
	  		  label.setIcon(new ImageIcon(img));
	  		  add(label);
	  		  pack();
		  }
		  
		  else if (user.getGender().equalsIgnoreCase("female")){
			  label = new JLabel("");
	  		  Image img = new ImageIcon(this.getClass().getResource("female.jpg")).getImage();
	  		  label.setIcon(new ImageIcon(img));
	  		  add(label);
	  		  pack();
		  }
	  }
 }
	
public static void main ( String[] args ) throws IOException
 {
	  Values calc = new Values();
      
 }
}
