
//------------------------------------------------------- 
//For COMP 248 Section P – Fall 2019
//--------------------------------------------------------

public class Dice {
	//Welcome to the Dice class
	//This class was created on Novermber 29th 2019
	//the purpose of this class is to roll the dice for the driver's class
	//Tis program will roll the dice and have all the fuctions that will include using the dice
	//die1 is the first die
	private int die1;
	//die2 is the 2nd die
	private int die2;
	
	//This is a default constructor which will initialize all the variables
	public Dice()
	{}
	
	//getDie1 is an accessor method to allow us to access the value of die1
	public int getDie1(){
		return die1;
	}
	
	//getDie1 is an accessor method to allow us to access the value of die2
	public int getDie2() {
		return die2;
	}
	
	//rolldDice is a method that will roll both dices 
	public int rollDice() {
		//random number between 1 and 6 for both dices
		die1 = (int )(Math.random() * 6 + 1);
		die2 = (int )(Math.random() * 6 + 1);
		//return the sum
		return(die1+die2);
	}
	
	//isDouble returns true if both dices have the same value
	public boolean isDouble() {
		return die1==die2;
	}
	
	//toString is the method that will format what will be put to the user
	public String toString() {
		return"Die1: " + die1 + " Die2: " + die2 + "\n";
	}
	
}
