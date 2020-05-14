
//------------------------------------------------------- 
//For COMP 248 Section P – Fall 2019
//--------------------------------------------------------

public class Player {
	//Welcome to the Player class
	//this class was created to the 29th of November
	//the purpose of this program is to do different functions for each player in order to be able to play the game
	//name is the name of the player
	private String name;
	//level is the level, x is the position in x, y is the position in y
	private int level, x, y,energy;
	
	//this is a default constructor inicialize everything as it should be for each player at the beginning of the game
	public Player() {
		name = "";
		energy = 10;
		level =0;
		x = 0;
		y = 0;
	}
	
	//this constructor also incialize everything as it shoudld be at the beginning of the game, but depending on the player's name
	public Player(String name) {
		this.name = name;
		energy =10;
		level =0;
		x = 0;
		y = 0;
	}
	
	//this is a constructor which takes 3 integer parameters
	public Player(int l, int x, int y) {
		this.level = l;
		this.x = x;
		this.energy = y;
		energy = 10;
		name = "";
	}
	
	//this is a copy constructor for the passed object 
	public Player(Player that) {
		this.name = that.name;
		this.level = that.level;
		this.x = that.x;
		this.energy = that.energy;
		this.y = that.y;
	}
	
	//mutator method to set the name
	public void setName(String newName) {
		name = newName;
	}
	
	//mutator method to set the level
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	
	//mutator method to set x
	public void setX(int newX) {
		x = newX;
	}

	//mutator method to set y
	public void setY(int newY) {
		y = newY;
	}
	
	//mutator method to set the energy
	public void setEnergy(int newEnergy) {
		energy = newEnergy;
	}
	
	//acessor method to the value of name
	public String getName() {
		return name;
	}
	
	//accessor method to access the value of x
	public int getX() {
		return x;
	}
	
	//accessor method to access the value of y
	public int getY() {
		return y;
	}
	
	//accessor method to access the value of level
	public int getLevel() {
		return level;
	}
	
	//accessor method to access the value of energy
	public int getEnergy() {
		return energy;
	}
	
	//a moethod to exchange positions with another object
    public void moveTo(Player p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    //aa method to determin who won the game
    public boolean won(Board b)  {
      return b.getSize()-1 == x && b.getSize()-1 == y;
    }
    
    //a method to see if both players are at the same position
    public boolean equals(Player p) {
        return this.x == p.getX() && this.y == p.getY();  
    }
    
    //toString formats everything that will be shown to the user
    public String toString() {
        return "\t" + getName() + " is on level " + getLevel() + " at the location (" + getX() + "," + getY() + ") and has " + getEnergy() + " units of energy.\n";
    }
}