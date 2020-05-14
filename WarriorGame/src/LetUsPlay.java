
//------------------------------------------------------- 
//For COMP 248 Section P – Fall 2019
//--------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

public class LetUsPlay {

	public static void main(String[] args) {
		//Welcome to Nancy's Warrior Game
		//This program was created on the 30th of November 2019
		//The purpose of this program is to let 2 players play a board game with different trypes of rules in order at the end to win
		//display a welcome message to the user
		System.out.println("\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n\t*\t\t\t\t\t\t*" + "\n\t*\tWelcome to Marita and Mohona's store\t*"+"\n\t*\t\t\t\t\t\t*"+ "\n\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
		//Ask the user what he wants
		System.out.print("The default game board has 3 choice and each level has 4x4 board.\n" + "You can use this default board size or change the size\n" + "\t0 to use the default board size\n" + "\t-1 to enter your own size\n" + "==> What do you want to do? ");
		//The scanner function starts here
		Scanner myKey = new Scanner(System.in);
		//choice is a boolean to help us get out of the loop in case the user keeps typing none accepted numbers
		boolean choice = false;
		//choice2 is a boolean to help us get out of the loop in case the user keeps typing none correct size and level numbers
		boolean choice2 = false;
		//levelNum is the number of levels chosen by the user
		int levelNum=0;
		//sizeBoard is the size of the board chosen by the user
		int sizeBoard=0;
		//Declare a new object for board to create the board of the game
		Board board = new Board();
		//sizeChoice is what the user want the size of the board to be
		int sizeChoice = myKey.nextInt();
		//enter a loop so that in case the user types an illegal number, it can go back and ask him to type a legal number again
		while(!choice) {
			//if the user types 0, then he will have the default board of 3 levels and size 4
			if(sizeChoice == 0) {
				board = new Board();
				choice = true;
				levelNum = 3;
				sizeBoard = 4;
			}
			//if the user types -1 then he chooses the number of levels that he wants and the size that he wants
			else if(sizeChoice == (-1)) {
				//ask the user what he wants
				System.out.print("How many choice would you like? (minimum size 3, max 10) ");
				//this is the number of the levels that the user wants
				levelNum = myKey.nextInt();
				//is the number chosen is less than 3 or more than 10, then tell the user that it is not a legal choice and make him types again
				if (levelNum < 3 || levelNum >10) {
					//enter a loop in case he keeps typing an illegal number
					while(!choice2) {
						//display error message
						System.out.println("Sorry but " + levelNum + " is not a legal choice.");
						//make him type again
						levelNum = myKey.nextInt();
						//if the numeber are legal, then exit the loop
						if(levelNum>=3 && levelNum<=10) {
							choice2 = true;
							break;
						}
					}
				}
				//ask the user what he wants
				System.out.print("\nWhat size do you want the nxn boards on each level to be?" + "\nMinimum size is 3x3, max is 10x10." + "\n==> Enter the value of n: ");
				//he'll type the size that he wants
				sizeBoard = myKey.nextInt();
				//if the size is less than 4 or more than 10 then let the user type it again since those numbers are illegal
				if(sizeBoard < 4 || sizeBoard > 10) {
					//Initialize choice2 to false because in the last loop it ended up by true 
					choice2=false;
					//enter a loop in case the user keeps typing illegal number
					while(!choice) {
						//display error message
						System.out.println("\nSorry but " + sizeBoard + " is not a legal choice.");
						//make him type the wanted size again
						sizeBoard = myKey.nextInt();
						//if the number is legal, then exit the loop
						if(sizeBoard>=4 && sizeBoard<=10) {
							choice2 = true;
							break;
						}
					}
				}
				//create the board
				board = new Board(levelNum,sizeBoard);
				//if we are here, then everything was okay, so exit the loop
				choice = true;
			}
			//if the at the starts he tyoes anything other than 0 or -1, then display an error message and let the user type again and again till he gets the legal number
			else {
				System.out.println("Sorry but " + sizeChoice + " is not a legal choice."); 
				sizeChoice = myKey.nextInt();
			}
		}
		//display the board to the user
		System.out.print("\n\nyour0 3D board has been set up and looks like this:\n\n" + board);
		//ask for the first player's name
		System.out.print("What is player 0's name (one word only): ");
		//let the user type the name
		String namePlayer0 = myKey.next();
		//ask for the second player's name
		System.out.print("What is player 1's name (one word only): ");
		//let the user type the name
		String namePlayer1 = myKey.next();
		//the random function starts here
		Random randomChoice = new Random();
		//create a Player array containing which player's name
		String [] Player = new String[2];
		Player[0] = namePlayer0;
		Player[1] = namePlayer1;
		//playerChoice is the player that will go first and let's call the object here
		Player playerChoice;
		//otherPlayerName is the name of the player that will go second
		String otherPlayerName;
		//choose a random number between 0 and 1 which will decide who goes firsts
		int randomPlayer = randomChoice.nextInt(2);
		//display a message showing who goes first
		System.out.println("\nThe game has started " + Player[randomPlayer] + " goes first\n==================================\n\n"); 
		//declare the new object of the player that goes first
		playerChoice = new Player(Player[randomPlayer]);
		//if the random number is 0, the the Player[1] goes second
		if(randomPlayer == 0) {
			otherPlayerName = Player[1];
		}
		//if the random number is 1, the the Player[0] goes second
		else {
			otherPlayerName = Player[0];
		}
		//declare the new object of the second player
		Player otherPlayer = new Player(otherPlayerName);
		//declare the new object of the dice
		Dice dice = new Dice();
		//declare all the variables that will later be used
		//doubleDice0 is the number of times the player gets a double
		int doubleDice0 = 0;
		//doubleDice0 is the number of times the player gets a double
		int doubleDice1 = 0;
		//x0 is the position x for the player that goes first
		int x0;
		//x1 is the position x for the player that goes second
		int x1;
		//y0 is the position y for the player that goes first
		int y0;
		//y1 is the position 1 for the player that goes second
		int y1;
		//level0 is the level of the player that goes first
		int level0;
		//level1 is the level of the player that goes second
		int level1;
		//endGame is created to be able to get out of the loop of the game
		boolean endGame = false;
		//die represents the die
		int die;
		//originalX0 is the original position x before the changes were done to the player that goes first
		int originalX0;
		//originalX1 is the original position x before the changes were done to the player that goes second
		int originalX1;
		//originalY0 is the original position y before the changes were done to the player that goes first
		int originalY0;
		//originalY1 is the original position y before the changes were done to the player that goes second
		int originalY1;
		//originalLevel0 is the original level before the changes were done to the player that goes first
		int originalLevel0;
		//originalLevel1 is the original level before the changes were done to the player that goes second
		int originalLevel1;
		//toBeAddedToX0 is what should be added, so the displacement of the player that goes first
		int toBeAddedToX0;
		//toBeAddedToX1 is what should be added, so the displacement of the player that goes second
		int toBeAddedToX1;
		//toBeAddedToY0 is what should be added, so the displacement of the player that goes first
		int toBeAddedToY0;
		//toBeAddedToY1 is what should be added, so the displacement of the player that goes second
		int toBeAddedToY1;
		//energyAdj0 is how much the energy will increase, decrease for the player that goes first
		int energyAdj0;
		//energyAdj1 is how much the energy will increase, decrease for the player that goes second
		int energyAdj1;
		//challengeOrForfit represents the player's choice to either challenge or forfeit when he is at the same position as the other player
		int challengeOrForfit;
		//nextRound is the key that the players should press at the end of each round to get to the next round
		String nextRound;
		//game starts here
		//enter a loop so that the rounds continue
		while(!endGame) {
			//show whose turn it is
			System.out.print("It is " + playerChoice.getName() + "'s turn\n");
			//if the player does not have enough energy to move, then let him roll the dice 3 times
			if(playerChoice.getEnergy() <= 0) {
				//Initialize doubleDice1 
				doubleDice0 = 0;
				for(int i =0 ; i<3;i++) {
					//roll the dice
					dice.rollDice();
					//if he gets a double, which means that both dices will be equal, then his energy will increase by 2
					if(dice.isDouble()) {
						//increase this number by 1, because we got a double
						doubleDice0++;
						//gets 2 energy units
						playerChoice.setEnergy(playerChoice.getEnergy()+2);
					}
				}
				//show a message
				System.out.print("You were too weak, but you rolled " + doubleDice0 + " doubles and you gained " + (doubleDice0*2) + " energy units. Congrats!\n" );
			}
			//if the player's energy is more than 0, then he can play
			if(playerChoice.getEnergy() > 0) {
				//roll the dice
				die = dice.rollDice();
				//show the player what he rolled
				System.out.print("\t" + playerChoice.getName() + " you rolled " + dice.toString());
				//if the player gets a double, then his energy will increase by 2
				if(dice.isDouble()) {
					playerChoice.setEnergy(playerChoice.getEnergy()+2);
					//show him a congrts note
					System.out.print("Congratulations you rolled double " + dice.getDie1() + ". You energy went up by 2 units\n");
				}
				//get the position x for the first player
				x0=playerChoice.getX();
				//get the position y for the first player
				y0=playerChoice.getY();
				//get the level for the first player
				level0 = playerChoice.getLevel();
				//if the player is at the 2nd last square of the last level, then no dice rolling can get him to the end, so make him go backwards
				if(playerChoice.getLevel()==levelNum-0 && playerChoice.getX()==sizeBoard-2 && playerChoice.getY()==sizeBoard-2){
					//this is what will be subtracted from x, so how much he'll go backwards
					int toBeSubstractedFromX = die/sizeBoard;
					//this is what will be subtracted from y, so how much he'll go backwards
					int toBeSubstractedFromY = die%sizeBoard;
					//change the value of x
					x0 = x0 - toBeSubstractedFromX;
					//change the value of y
					y0 = y0 - toBeSubstractedFromY;
					//show a message explaining what happened
					System.out.print("\t!!!You're on the 2nd to the last square of the top level which means that at this point you can't win" + "\n\tto fix this problem, you'll be set back to  (" + playerChoice.getX() + "," + playerChoice.getY() + ")");
				}
				//give originalX0 the value of x0 now
				originalX0 = x0;
				//give originalY0 the value of y0 now
				originalY0 = y0;
				//give originalLevel0 the value of level0 now
				originalLevel0 = level0;
				//this is what will be added to x, so how much will the player move
				toBeAddedToX0 = die/sizeBoard;
				//this is what will be added to y, so how much will the player move
				toBeAddedToY0 = die%sizeBoard;
				//change the value of x
				x0 = x0 + toBeAddedToX0;
				//change the value of y
				y0 = y0 + toBeAddedToY0;
				//if y is bigger than the size of the board, then the changes will be different than usual and some other calculations will be done
				if(y0>=sizeBoard) {
					y0= y0%sizeBoard;
					x0 = x0 + y0/sizeBoard;
					//if x is also bigger than than the size of the board, then changes will be different than usual and some other calculations will be done and the player will go up a level
					if(x0>=sizeBoard) {
						x0=x0%sizeBoard;
						level0++;
					}
				}
				//if x is bigger than the size of the board, then the changes will be different than usual and some other calculations will be done and the level will increase
				else if(x0>=sizeBoard) {
					level0++;
					x0= x0%sizeBoard;
				}
				//if the level to which the player should be at is bigger than the number of levels, then the player won't move and looses 2 energy points
				if(level0>=levelNum) {
					//looses 2 energy points
					playerChoice.setEnergy(playerChoice.getEnergy()-2);
					//go back to the original value of x
					x0=originalX0;
					//go back to the original value of y
					y0=originalY0;
					//go back to the original value of level
					level0 = originalLevel0;
					//display a message explaining what happened
					System.out.print("!!! Soryy you need to stay where you are - that throw takes you off the grid and you\nloose 2 units of energy.\n");
				}
				//set x to the new value
				playerChoice.setX(x0);
				//set y to the new value
				playerChoice.setY(y0);
				//set the level to the new value
				playerChoice.setLevel(level0);
				//if the player is at the first position, then don't adjust his energy since it's -3, and it is not fair to make him too energy from the start
				if(playerChoice.getX()==0 && playerChoice.getY()==0 && playerChoice.getLevel() ==0) {
					energyAdj0 = 0;
					//display a message showing him what he got
					System.out.print("\tYour enrgy is adjusted by " + energyAdj0  + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level" + playerChoice.getLevel() + "\n");
				}
				//if both player are at the same position
				else if (playerChoice.equals(otherPlayer)){
					//tell the player and give him the choice
					System.out.println("Player " + otherPlayer.getName() + " is at your new location\nWhat do you want to do?\n\t0 - Challenge and risk loosing 50% of your energy units if you loose\n\t\tor move to new location and get 50% of the other players energy units\n\t1 - to move down onw level or move to (0,0) if at level 0 and loose 2 energy\nunits");
					//this will be the player's choice to either challenge or forfeit
					challengeOrForfit = myKey.nextInt();
					//challengeForfit is to make a loop in case the player keeps typing in illegal number
					boolean challengeForfit = false;
					//enter a loop in case the user keeps typing illegal numbers
					while(!challengeForfit) {
						//if the player types 0, then he chooses to challenge
						if(challengeOrForfit == 0) {
							//pick a random number between 0 and 10 
							//randomChallenge is the random number between 0 and 10
							int randomChallenge = randomChoice.nextInt(11);
							//if the number is less than 6, then this player lost the challenge
							if(randomChallenge < 6) {
								//let him stay where he is without moving
								playerChoice.setX(originalX0);
								playerChoice.setY(originalY0);
								playerChoice.setLevel(originalLevel0);
								//he looses half of his energy units
								playerChoice.setEnergy(playerChoice.getEnergy()/2);
								//show a message explaining what just happened
								System.out.print("\tSorry you lost the challege which puts you one level down\n");
								//adjust the energy to the new position
								energyAdj0 = board.getEnergyAdj(playerChoice.getLevel(), playerChoice.getX(), playerChoice.getY());
								//set the new energy with the adjustments
								playerChoice.setEnergy(playerChoice.getEnergy() + energyAdj0);
								//show the player where he is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj0 + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level " + playerChoice.getLevel() + "\n");
							}
							//if the number is between 6 and 10, then he won the challenge
							else {
								//the other player goes to this player's original position
								otherPlayer.setX(originalX0);
								otherPlayer.setY(originalY0);
								otherPlayer.setLevel(originalLevel0);
								//he looses half of his energy units
								otherPlayer.setEnergy(otherPlayer.getEnergy()/2);
								//show a message
								System.out.print("\tBravo!! You won the challenge.\n");
								//adjust the energy depending on the new position
								energyAdj0 = board.getEnergyAdj(playerChoice.getLevel(), playerChoice.getX(), playerChoice.getY());
								//set the new energy with the adjustments
								playerChoice.setEnergy(playerChoice.getEnergy() + energyAdj0);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj0  + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level " + playerChoice.getLevel() + "\n");
							}
							//exit the loop
							challengeForfit = true;
						}
						//if the player types 1, then he chooses to forfeit
						else if(challengeOrForfit ==1) {
							//if he is at level 0, then he'll go back to the initial position which is (0,0)
							if(playerChoice.getLevel() == 0) {
								playerChoice.setX(0);
								playerChoice.setY(0);
								//adjust the energy
								energyAdj0 = board.getEnergyAdj(playerChoice.getLevel(), playerChoice.getX(), playerChoice.getY());
								//set the new energy with the adjustments
								playerChoice.setEnergy(playerChoice.getEnergy() + energyAdj0);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj0  + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level " + playerChoice.getLevel() + "\n");
							}
							//otherwise the player will go one level down a level
							else {
								//go a level down
								playerChoice.setLevel(playerChoice.getLevel()-1);
								//adjust the energy
								energyAdj0 = board.getEnergyAdj(playerChoice.getLevel(), playerChoice.getX(), playerChoice.getY());
								//set the new energy with the adjustments
								playerChoice.setEnergy(playerChoice.getEnergy() + energyAdj0);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj0  + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level " + playerChoice.getLevel() + "\n");
							}
							//the player looses 2 energy points
							playerChoice.setEnergy(playerChoice.getEnergy()-2);
							//exit the loop
							challengeForfit = true;
						}
						//if the player didn't type either of the above,then it's an illegal choice, so make him type again and again until he gets a legal choice
						else {
							//show a message explaining what happened
							System.out.println("Sorry but " + challengeOrForfit + " is not a legal choice." );
							//make him type again
							challengeOrForfit = myKey.nextInt();
						}
					}
				}
				//if the players are not at the same position, and they're not at the start of the game, then do things normally and adjust the energy depending on the place to which they moved
				else {
					//adjust the energy
					energyAdj0 = board.getEnergyAdj(playerChoice.getLevel(), playerChoice.getX(), playerChoice.getY());
					//set the new energy with the adjustments
					playerChoice.setEnergy(playerChoice.getEnergy() + energyAdj0);
					//display a message showing where the player is and how much energy he got
					System.out.print("\tYour enrgy is adjusted by " + energyAdj0 + " for landint at (" + playerChoice.getX() + "," + playerChoice.getY() + ") at level " + playerChoice.getLevel() + "\n");
				}
				//if the player is at the last square on the top level, then he wins
				if(playerChoice.getX() == sizeBoard-1 && playerChoice.getY() == sizeBoard-1 && playerChoice.getLevel() == levelNum-1) {
					//show a message congrats the winner and end the game
					System.out.print("\nAt the end of this round:\n" + otherPlayer.toString() + playerChoice.toString() + "\nThe winner is player ");
					System.out.print(playerChoice.getName() + ". Well done!!!");
					//exit the loop
					endGame = true;
					break;
				}
			}
			//if the player does not have enough energy to move, then he stays where he is without moving, and it will go to the next player as he is too weak to move
			else if(playerChoice.getEnergy()<=0) {
				//display a sorry message explaining what is happening 
				System.out.print("!!!Sorry you're too weak to move\n");
			}
			//Now it's the second player's turn!
			//show whose turn it is
			System.out.print("It is " + otherPlayer.getName() + "'s turn\n");
			//if the player does not have enough energy to move, then let him roll the dice 3 times
			if(otherPlayer.getEnergy() <= 0) {
				//Initialize doubleDice1 
				doubleDice1=0;
				for(int i =0 ; i<3;i++) {
					//roll the dice
					dice.rollDice();
					//if he gets a double, which means that both dices will be equal, then his energy will increase by 2
					if(dice.isDouble()) {
						//increase this number by 1, because we got a double
						doubleDice1++;
						//gets 2 energy units
						otherPlayer.setEnergy(otherPlayer.getEnergy()+2);
					}
				}
				//show a message
				System.out.print("You were too weak, but you rolled " + doubleDice1 + " doubles and you gained " + (doubleDice1*2) + " energy units. Congrats!\n" );
			}
			//if the player's energy is more than 0, then he can play
			if(otherPlayer.getEnergy() > 0) {
				//roll the dice
				die = dice.rollDice();
				//show the player what he rolled
				System.out.print("\t" + otherPlayer.getName() + " you rolled " + dice.toString());
				//if the player rolled a double then increase his energy by 2
				if(dice.isDouble()) {
					otherPlayer.setEnergy(otherPlayer.getEnergy()+2);
					//display a congrats message
					System.out.print("Congratulations you rolled double " + dice.getDie1() + ". You energy went up by 2 units\n");
				}

				//get the position in x for the second player
				x1=otherPlayer.getX();
				//get the position in y for the second player
				y1=otherPlayer.getY();
				//get the level for the second player
				level1 = otherPlayer.getLevel();
				//if the player is at the 2nd last square of the last level, then no dice rolling can get him to the end, so make him go backwards
				if(otherPlayer.getLevel()==levelNum-1 && otherPlayer.getX()==sizeBoard-2 && otherPlayer.getY()==sizeBoard-2){
					//this is what will be subtracted from x, so how much he'll go backwards
					int toBeSubtractedFromX = die/sizeBoard;
					//this is what will be subtracted from y, so how much he'll go backwards
					int toBeSubtractedFromY = die%sizeBoard;
					//change the position in x
					x1 = x1 - toBeSubtractedFromX;
					//change the position in y
					y1 = y1 - toBeSubtractedFromY;
					//show a message explaining what happened
					System.out.print("\t!!!You're on the 2nd to the last square of the top level which means that at this point you can't win" + "\n\tto fix this problem, you'll be set back to  (" + otherPlayer.getX() + "," + otherPlayer.getY() + ")");
				}
				//give originalX1 the value of x1 now
				originalX1 = x1;				
				//give originalY1 the value of y1 now
				originalY1 = y1;
				//give originalLevel1 the value of level1 now
				originalLevel1 = level1;
				//this is what will be added to x, so how much will the player move
				toBeAddedToX1 = die/sizeBoard;
				//this is what will be added to y, so how much will the player move
				toBeAddedToY1 = die%sizeBoard;
				//change the value of x
				x1 = x1 + toBeAddedToX1;
				//change the value of y
				y1 = y1 + toBeAddedToY1;
				//if y is bigger than the size of the board, then the changes will be different than usual and some other calculations will be done
				if(y1>=sizeBoard) {
					y1= y1%sizeBoard;
					x1 = x1 + y1/sizeBoard;
					//if y is bigger than the size of the board, then the changes will be different than usual and some other calculations will be done and the player will go up a level
					if(x1>=sizeBoard) {
						x1=x1%sizeBoard;
						level1++;
					}
				}
				//if x is bigger than the size of the board, then the changes will be different than usual and some other calculations will be done and the level will increase
				else if(x1>=sizeBoard) {
					level1++;
					x1= x1%sizeBoard;
				}
				//if the level to which the player should be at is bigger than the number of levels, then the player won't move and he looses 2 energy points
				if(level1>=levelNum) {
					//looses 2 energy points
					otherPlayer.setEnergy(otherPlayer.getEnergy()-2);
					//go back to the original value of x
					x1=originalX1;
					//go back to the original value of y
					y1=originalY1;
					//go back to the original value of level
					level1 = originalLevel1;
					//display a message explaining what happened 
					System.out.print("!!! Soryy you need to stay where you are - that throw takes you off the grid and you\nloose 2 units of energy.\n");
				}
				//set x to the new value
				otherPlayer.setX(x1);
				//set y to the new value
				otherPlayer.setY(y1);
				//set level to the new value
				otherPlayer.setLevel(level1);
				//if the player is at the first position, then don't adjust his energy since it's -3, and it is not fair to make him too energy from the start
				if(otherPlayer.getX()==0 && otherPlayer.getY()==0 && otherPlayer.getLevel() ==0) {
					energyAdj1 = 0;
					System.out.print("\tYour enrgy is adjusted by " + energyAdj1  + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level" + otherPlayer.getLevel() + "\n");
				}
				//if both player are at the same position
				else if (otherPlayer.equals(playerChoice)){
					//tell the player and give him the choice
					System.out.println("Player " + playerChoice.getName() + " is at your new location\nWhat do you want to do?\n\t0 - Challenge and risk loosing 50% of your energy units if you loose\n\t\tor move to new location and get 50% of the other players energy units\n\t1 - to move down onw level or move to (0,0) if at level 0 and loose 2 energy\nunits");
					//this will be the player's choice to either challenge or forfeit
					challengeOrForfit = myKey.nextInt();
					//challengeForfit is to make a loop in case the player keeps typing in illegal number
					boolean challengeForfit = false;
					//enter a loop in case the user keeps typing illegal numbers
					while(!challengeForfit) {
						//if the player types 0, then he chooses to challenge the other player
						if(challengeOrForfit == 0) {
							//pick a random number between 0 and 10 
							//randomChallenge is the random number between 0 and 10
							int randomChallenge = randomChoice.nextInt(11);
							//if the number is less than 6, then this player lost the challenge
							if(randomChallenge < 6) {
								//let him stay where he is without moving
								otherPlayer.setX(originalX1);
								otherPlayer.setY(originalY1);
								playerChoice.setLevel(originalLevel1);
								//he looses half of his energy units
								otherPlayer.setEnergy(otherPlayer.getEnergy()/2);
								//show a message explaining what just happened
								System.out.print("\tSorry you lost the challege which puts you one level down\n");
								//adjust the energy to the new position
								energyAdj1 = board.getEnergyAdj(otherPlayer.getLevel(), otherPlayer.getX(), otherPlayer.getY());
								//set the new energy with the adjustments
								otherPlayer.setEnergy(otherPlayer.getEnergy() + energyAdj1);
								//show the player where he is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj1   + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level " + otherPlayer.getLevel() + "\n");
							}
							//if the number is between 6 and 10, then he won the challenge
							else {
								//the other player goes to this player's original position
								playerChoice.setX(originalX1);
								playerChoice.setY(originalY1);
								playerChoice.setLevel(originalLevel1);
								//the other player looses half of his energy units
								playerChoice.setEnergy(playerChoice.getEnergy()/2);
								//show a message
								System.out.print("\tBravo!! You won the challenge.\n");
								//adjust the energy depending on the new position
								energyAdj1 = board.getEnergyAdj(otherPlayer.getLevel(), otherPlayer.getX(), otherPlayer.getY());
								//set the new energy with the adjustments
								otherPlayer.setEnergy(otherPlayer.getEnergy() + energyAdj1);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj1   + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level " + otherPlayer.getLevel() + "\n");
							}
							//exit the loop
							challengeForfit = true;
						}
						//if the player types 1, then he chooses to forfeit
						else if(challengeOrForfit ==1) {
							//if he is at level 0, then he'll go back to the initial position which is (0,0)
							if(otherPlayer.getLevel()==0) {
								otherPlayer.setX(0);
								otherPlayer.setY(0);
								//adjust the energy
								energyAdj1 = board.getEnergyAdj(otherPlayer.getLevel(), otherPlayer.getX(), otherPlayer.getY());
								//set the new energy with the adjustments
								otherPlayer.setEnergy(otherPlayer.getEnergy() + energyAdj1);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj1   + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level " + otherPlayer.getLevel() + "\n");
							}
							//otherwise the player will go one level down a level
							else {
								//go down a level
								otherPlayer.setLevel(otherPlayer.getLevel()-1);
								//adjust the energy
								energyAdj1 = board.getEnergyAdj(otherPlayer.getLevel(), otherPlayer.getX(), otherPlayer.getX());
								//set the new energy with the adjustments
								otherPlayer.setEnergy(otherPlayer.getEnergy() + energyAdj1);
								//display a message showing where the player is and how much energy he got
								System.out.print("\tYour enrgy is adjusted by " + energyAdj1   + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level " + otherPlayer.getLevel() + "\n");
							}
							//the player looses 2 energy points
							otherPlayer.setEnergy(otherPlayer.getEnergy()-2);
							//exit the loop
							challengeForfit = true;
						}
						//if the player didn't type either of the above,then it's an illegal choice, so make him type again and again until he gets a legal choice
						else {
							//show a message
							System.out.println("Sorry but " + challengeOrForfit + " is not a legal choice." );
							//make him type again
							challengeOrForfit = myKey.nextInt();
						}
					}
				}
				//if the players are not at the same position, and they're not at the start of the game, then do things normally and adjust the energy depending on the place to which they moved
				else {
					//adjust the energy
					energyAdj1 = board.getEnergyAdj(otherPlayer.getLevel(), otherPlayer.getX(), otherPlayer.getY());
					//set the new energy with the adjustments
					otherPlayer.setEnergy(otherPlayer.getEnergy() + energyAdj1);
					//display a message showing where the player is and how much energy he got
					System.out.print("\tYour enrgy is adjusted by " + energyAdj1  + " for landint at (" + otherPlayer.getX() + "," + otherPlayer.getY() + ") at level " + otherPlayer.getLevel() + "\n");
				}				
				System.out.print("\nAt the end of this round:\n" + otherPlayer.toString() + playerChoice.toString());
				//if the player is at the last square on the top level, then he wins
				if(otherPlayer.getX() == sizeBoard-1 && otherPlayer.getY() == sizeBoard-1 && otherPlayer.getLevel() == levelNum-1) {
					//show a message congrats the winner
					System.out.print("\nThe winner is player " + otherPlayer.getName() + ". Well done!!!");
					//exit the loop
					endGame = true;
					break;
				}
			}
			//if the player does not have enough energy to move, then he stays where he is without moving, and it will go to the next player as he is too weak to move
			else if (otherPlayer.getEnergy()<=0){
				//display a sorry message explaining what is happening 
				System.out.print("!!!Sorry you're too weak to move\n");
			}
			//ask the player to press a key to continue so that the whole game does not play by itself
			System.out.print("Any key to continue to next round...");
			//this is the key that the player will enter, it does not matter what he types, it will just let us get to the next round
			nextRound = myKey.next();
			//skip a line
			System.out.println("\n");
		}
		//close the scanner function
		myKey.close();
		//Thank you for playing Nancy's Warrior Game!
	}

}