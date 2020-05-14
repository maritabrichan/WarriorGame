
//------------------------------------------------------- 
//Assignment 3
//Written by: Marita Brichan 40138194
//For COMP 248 Section P – Fall 2019
//--------------------------------------------------------

public class Board {
	//Welcome to the Board class
	//This class was created on November 29th 2019
	//The purpose of this class is to create the board representing the different positions of the players and the levels
	//the array board represents the board of the game
	public int[][][] board;
	//MIN_LEVEL represents the minimum number of levels that we could have in this game
	final public static int MIN_LEVEL = 3;
	//MIN_SIZE represents the minimum size of the board that we can have in this game
	final public static int MIN_SIZE = 3;
	//level represents the levels
	public int level;
	//size represent the size of the board
	public int size;
	
	//this is a constructor that will instialize the variables at the default board size and levels
	public Board() {
		level =3;
		size = 4;
		createBoard(level,size);
	}
	
	//this is a constructor that will inicialize the variables to the ones chosen by the user
	public Board(int l,int x) {
		this.level = l;
		this.size = x;
		createBoard(l,x);
	}
	
	//creaeBoard creats the board for the game depending of the size and teh levels
	private void createBoard(int level, int size)
	   {
	       board = new int[level][][];
	       //enter a loot for levels
	       for(int l=0;l<level;l++)
	       {
	           board[l] = new int[size][];
	    	   //enter a loop for size in x
	           for(int x=0;x<size;x++ )
	           {
	               board[l][x] = new int[size];
	              //enter a loop for size in y
	               for(int y=0;y<size;y++)
	               {
	            	   //This is how we know what number to assign each square of the board
	                   if((l+x+y)%3 == 0)
	                       board[l][x][y] = -3;
	                   else if((l+x+y)%5 == 0)
	                       board[l][x][y] = -2;
	                   else if((l+x+y)%7 == 0)
	                       board[l][x][y] = 2;
	                   else
	                       board[l][x][y] = 0;
	               }
	           }
	       }
	   }
	
	//accessor method to get the value of level
	public int getLevel() {
		return level;
	}
	
	//accessor method to get the value of size
	public int getSize() {
		return size;
	}
	
	//accessor method to adjust the energy depending on the position of the player
	public  int getEnergyAdj(int l, int x, int y) {
		return board[l][x][y];
	}
	
	//formatting of the board for the user to see
	public String toString()
	   {
	       String str = "";
	       for(int l=0;l<level;l++)
	       {
	           str += "Level "+(l)+":\n" + "--------\n\t";
	           for(int x=0;x<size;x++)
	           {
	               for(int y=0;y<size;y++)
	               {
	                   str+= String.format("%-2d",board[l][x][y])+"\t";
	               }
	               str += "\n\t";
	           }
	           str += "\n";
	       }
	          
	       return str;
	   }
	
	}
