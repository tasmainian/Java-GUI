
public class CharacterCreation {
	//instance variables each character and monster have
	private String name;
	private String gender;
	private int strength;
	private int health;
	
	//Pre inputted values
	public CharacterCreation(){
		name = "John";
		gender = "male";
		strength = 10;
		health = 20;
	}
	
	//overload contructor values
	public CharacterCreation(String n,String g,int s,int h){
		name = n;
		gender= g;
		strength = s;
		health = h;
	}
	
	//method to get all the private instance variables
	public String getName(){
		return this.name;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public int getStrength (){
		return this.strength;
	}
	
	public int getHealth (){
		return this.health;
	}
	
	
	//Setter/Mutator Methods
	public void setName(String name){
		this.name = name.substring(0, 1).toUpperCase()+name.substring(1);
	}
		
	public void setGender(String gender){
		if (gender.equalsIgnoreCase("female")){
			this.gender = gender;
		}
		
		else if (gender.equalsIgnoreCase("male")){
			this.gender = gender;
		}
		
		else {
			System.out.println("Gender Does Not Exist. Try again.");
		}
	}
		
		public void setStrength(int strength){
			if (health+strength <= 30){
			this.strength = strength;
			}
		}
		
		public void setHealth(int health){
			if (health+strength <= 30){
			this.health = health;
			}
		}

		
		//toString Method
		public String toString(){
			return ("You are "+name+" the "+gender+" human! You have "+strength+" attack and "+health+" HP");
		}
	
	
}
