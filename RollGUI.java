import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class RollGUI extends JFrame implements ActionListener{

	private JTextField dice1, dice2, total;
	private JLabel label;
	 public RollGUI() throws IOException
	  {
		//creates text field for the use
	    super("Dice Roll");
	    JPanel pane = (JPanel) getContentPane();
	    pane.setLayout(new BorderLayout());
	    //outputs the statements the user will use for the text field
	    //output value of dice 1
	    dice1= new JTextField(15);
	    //output value of dice 2
	    dice2 = new JTextField(15);
	    
	    //sum of the dice
	    total= new JTextField(15);
	    dice1.setEditable(false);
	    dice2.setEditable(false);
	    total.setEditable(false);


	    //Labeling
	    JPanel fieldPane = new JPanel();
	    fieldPane.setSize(700, 200);
	    fieldPane.setLayout(new GridLayout(3,1));
	    fieldPane.setBackground(new Color (51,204,255));
	    fieldPane.add(new JLabel("Dice 1"));
	    fieldPane.add(dice1);
	    fieldPane.add(new JLabel("Dice 2"));
	    fieldPane.add(dice2);
	    fieldPane.add(new JLabel("Total"));
	    fieldPane.add(total);
	    pane.add(fieldPane,BorderLayout.NORTH);
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout());
	    //button options
	    //Roll Option
	    JButton RollButton = new JButton ("Roll");
	    RollButton.addActionListener(this);
	    //Next Option
	    JButton NextButton = new JButton ("Next");
	    NextButton.addActionListener(this);
	    
	    buttonPane.add(RollButton);
	    buttonPane.add(NextButton);

	    pane.add(buttonPane,BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	  
	  }
 public void actionPerformed( ActionEvent evt)  
 {
	 //Random dice roll combination calculation
	 int die1 = (int)(Math.random()*6) + 1;
     int die2 = (int)(Math.random()*6) + 1;
     int sum = die1+die2;
     
     //Dice roll array images
     //2D array
     Image[][] dice = new Image[6][6];
     dice[0][0] = new ImageIcon(this.getClass().getResource("1x1.jpg")).getImage();
     dice[0][1] = new ImageIcon(this.getClass().getResource("1x2.gif")).getImage();
     dice[0][2] = new ImageIcon(this.getClass().getResource("1x3.gif")).getImage();
     dice[0][3] = new ImageIcon(this.getClass().getResource("1x4.gif")).getImage();
     dice[0][4] = new ImageIcon(this.getClass().getResource("1x5.png")).getImage();
     dice[0][5] = new ImageIcon(this.getClass().getResource("1x6.gif")).getImage();
     
     dice[1][0] = new ImageIcon(this.getClass().getResource("1x2.gif")).getImage();
     dice[1][1] = new ImageIcon(this.getClass().getResource("2x2.gif")).getImage();
     dice[1][2] = new ImageIcon(this.getClass().getResource("2x3.gif")).getImage();
     dice[1][3] = new ImageIcon(this.getClass().getResource("2x4.gif")).getImage();
     dice[1][4] = new ImageIcon(this.getClass().getResource("2x5.gif")).getImage();
     dice[1][5] = new ImageIcon(this.getClass().getResource("2x6.gif")).getImage();
     
     dice[2][0] = new ImageIcon(this.getClass().getResource("1x3.gif")).getImage();
     dice[2][1] = new ImageIcon(this.getClass().getResource("2x3.gif")).getImage();
     dice[2][2] = new ImageIcon(this.getClass().getResource("3x3.gif")).getImage();
     dice[2][3] = new ImageIcon(this.getClass().getResource("3x4.gif")).getImage();
     dice[2][4] = new ImageIcon(this.getClass().getResource("3x5.png")).getImage();
     dice[2][5] = new ImageIcon(this.getClass().getResource("3x6.gif")).getImage();
     
     dice[3][0] = new ImageIcon(this.getClass().getResource("1x4.gif")).getImage();
     dice[3][1] = new ImageIcon(this.getClass().getResource("2x4.gif")).getImage();
     dice[3][2] = new ImageIcon(this.getClass().getResource("3x4.gif")).getImage();
     dice[3][3] = new ImageIcon(this.getClass().getResource("4x4.gif")).getImage();
     dice[3][4] = new ImageIcon(this.getClass().getResource("4x5.gif")).getImage();
     dice[3][5] = new ImageIcon(this.getClass().getResource("4x6.gif")).getImage();
     
     dice[4][0] = new ImageIcon(this.getClass().getResource("1x5.png")).getImage();
     dice[4][1] = new ImageIcon(this.getClass().getResource("2x5.gif")).getImage();
     dice[4][2] = new ImageIcon(this.getClass().getResource("3x5.png")).getImage();
     dice[4][3] = new ImageIcon(this.getClass().getResource("4x5.gif")).getImage();
     dice[4][4] = new ImageIcon(this.getClass().getResource("5x5.gif")).getImage();
     dice[4][5] = new ImageIcon(this.getClass().getResource("5x6.gif")).getImage();
     
     dice[5][0] = new ImageIcon(this.getClass().getResource("1x6.gif")).getImage();
     dice[5][1] = new ImageIcon(this.getClass().getResource("2x6.gif")).getImage();
     dice[5][2] = new ImageIcon(this.getClass().getResource("3x6.gif")).getImage();
     dice[5][3] = new ImageIcon(this.getClass().getResource("4x6.gif")).getImage();
     dice[5][4] = new ImageIcon(this.getClass().getResource("5x6.gif")).getImage();
     dice[5][5] = new ImageIcon(this.getClass().getResource("6x6.gif")).getImage();

     //Commans if roll is clicked
	  if (evt.getActionCommand().equals("Roll")){ 
		  dice1.setText(String.valueOf(die1));
		  dice2.setText(String.valueOf((die2)));
		  total.setText(String.valueOf(sum));
		  label = new JLabel("");
  		  Image img = dice[die1-1][die2-1];
  		  label.setIcon(new ImageIcon(img));
  		  add(label);
  		  pack();
  		  
	    }
	  
	  else if(evt.getActionCommand().equals("Next")){
		  setVisible(false);
		  //Scenarios depending on dice roll
		    try {
		    	//Battle a medium monster
		    	if (sum==5 || sum==9){
		    	MediumMonster random = new MediumMonster();
				random.setSize(700, 200);
				random.setVisible(true);
				random.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				random.getContentPane().setLayout(new FlowLayout());
				random.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
				random.repaint();
		    	}
		    	
		    	//Battle an easy monster
		    	else if (sum==6|| sum==3){
			    	EasyMonster fight = new EasyMonster();
					fight.setVisible(true);
					fight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					fight.getContentPane().setLayout(new FlowLayout());
					fight.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
					fight.repaint();
			    }
		    	
		    	//added health
		    	else if (sum==12){
			    	HealthPlus random = new HealthPlus();
					random.setSize(700, 200);
					random.setVisible(true);
					random.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					random.getContentPane().setLayout(new FlowLayout());
					random.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
					random.repaint();
			    }
		    	else if (sum==4 || sum==7 || sum==10){
			    	HealthPlus level = new HealthPlus();
					level.setVisible(true);
					level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					level.getContentPane().setLayout(new FlowLayout());
					level.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
					level.repaint();
			    }
		    	
		    	
		    	else if (sum==11 || sum==8){
		    		AttackPlus stronger = new AttackPlus();
					stronger.setVisible(true);
					stronger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					stronger.getContentPane().setLayout(new FlowLayout());
					stronger.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
					stronger.repaint();
			    }
		    	
		    	//battle a very difficult monster
		    	else if (sum==2){
			    	HardMonster duel = new HardMonster();
					duel.setVisible(true);
					duel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					duel.getContentPane().setLayout(new FlowLayout());
					duel.getContentPane().setBackground(new Color (102,102,255));  //Change the frame's background
					duel.repaint();
			    }
		    	
			} 	catch (IOException e) {
				e.printStackTrace();
			}
	  }
 }
	
public static void main ( String[] args ) throws IOException
 {
	  RollGUI calc = new  RollGUI();
      
 }
}
