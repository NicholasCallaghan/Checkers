/*
 *	Author:  
 *  Date: 
*/

import pkg.*;
import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		
		//SETUP OF THE GAME//
	
		Scanner sc = new Scanner (System.in);
		System.out.println("Player one, please enter your side selection ('R'/'B')");
		System.out.println("------------------------------------------------------------");
		String p1answer = sc.nextLine();
		System.out.println("------------------------------------------------------------");
		Player player1 = new Player(p1answer);
		System.out.println("Player two, please enter your side selection ('R'/'B')");
		System.out.println("------------------------------------------------------------");
		String p2answer = sc.nextLine();
		System.out.println("------------------------------------------------------------");
		Player player2 = new Player(p2answer);
		
		CheckersBoard game = new CheckersBoard();
		
		System.out.println();
		System.out.println("Here's the starting checkers board. Black typically always moves first, but in this case it will be whatever color player one decides to be. Knock yourselves out! :) ");
		System.out.println();
		game.printCheckersBoard();
		int counter = 0;
		boolean capturing = false;
		
		//THE GAME ITSELF//
		
		while (game.isOver() == false){
			
			System.out.println("WAIT! The system checks if any possible moves exist already, but check for yourself first, making sure that you can make a move, and that you don't accidentally input invalid values.");
			System.out.println("Are you capturing a piece? (y/n // Y/N)");
			String response = sc.nextLine();
			if (response.equals("y") || response.equals("Y")){
				System.out.println("Please enter the x coordinate of the piece you want to CAPTURE.");
				int xDesiredCap = sc.nextInt();
				System.out.println("Please enter the y coordinate of the piece you want to CAPTURE.");
				int yDesiredCap = sc.nextInt();
				
				System.out.println("Please enter the x coordinate of the piece you want to move.");
				int X = sc.nextInt();
				System.out.println("Please enter the y coordinate of the piece you want to move.");
				int Y = sc.nextInt();
				
				System.out.println("Please enter the x coordinate of where you want your piece to go after capturing.");
				int xCap = sc.nextInt();
				System.out.println("Please enter the y coordinate of where you want your piece to go after capturing.");
				int yCap = sc.nextInt();
				sc.nextLine();
				
				if (counter % 2 == 0){
					game.isMovePossible(player1);
					game.capture(xDesiredCap, yDesiredCap, X, Y, xCap, yCap, player1);
				}
				else{
					game.isMovePossible(player2);
					game.capture(xDesiredCap, yDesiredCap, X, Y, xCap, yCap, player2);
				}
			}
			else if (response.equals("N") || response.equals("n")){
				System.out.println("Please enter the x coordinate of the piece you want to move.");
				int x = sc.nextInt();
				System.out.println("Please enter the y coordinate of the piece you want to move.");
				int y = sc.nextInt();
			
				System.out.println("Please enter the x coordinate of where you want to go.");
				int moveX = sc.nextInt();
				System.out.println("Please enter the y coordinate of where you want to go.");
				int moveY = sc.nextInt();
				sc.nextLine();
			
				if (counter % 2 == 0){
					game.isMovePossible(player1);
					game.move(x, y, moveX, moveY, player1);
				}
				else{
					game.isMovePossible(player2);
					game.move(x, y, moveX, moveY, player2);
				}
			}
			else{
				System.out.println("You did not input a correct yes/no answer to the question. No worries, try again!");
				System.out.println();
				if(counter == 0){
					counter = counter;
				}
				else{
					counter--;
				}
			}
			
			game.makeKing();
			game.printCheckersBoard();
			System.out.println("------------------------------------------------------------");
			System.out.println("If you have the space to move a second time, the rules dicate that you are required to do so. Otherwise, it's the next player's turn.");
			System.out.println();
			counter++;
		}
		
		if (counter % 2 == 0){
			System.out.println("Player one won the game!");
		}
		else{
			System.out.println("Player two won the game!");
			System.out.println("You're a baller, no question abt it fr.");
			System.out.println("This you? :")
		}
    System.out.println("***********************************************************************");
	System.out.println("*****************************************   **************************");
	    System.out.println("************************************    ***********************");
	      System.out.println("*************************** ******* ***********************");
	        System.out.println("***********************    **** **********************");
	          System.out.println("**********************   **  *********************");
	            System.out.println("*******************      *********************");
	              System.out.println("****************      ********************");
	                System.out.println("*************  *    ******************");
	                  System.out.println("*********** *     ****************");
	                    System.out.println("********* *      *************");
	                      System.out.println("****** *   ***   *********");
	                        System.out.println("****  ********  ******");
	                          System.out.println("*  ************  *");
	                            System.out.println("***************");
	                              System.out.println("***********");
	                               System.out.println("********");
	                                 System.out.println("****");
	                                  System.out.println("**");
	}
}
