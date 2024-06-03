/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class CheckersBoard {
	
	String [][] checkersBoard;
	int numRedPieces = 12;
	int numBlackPieces = 12;
	boolean canMove;
	int x;
	int y;
	int X;
	int Y;
	int xCap;
	int yCap;
	int moveX;
	int moveY;
	
	//Constructor for board. Baller.
	
	public CheckersBoard() {
		checkersBoard = new String [8][8];
		setCheckersBoard();
		canMove = true;
	}
	
	//Prints every time after a move, capture, etc.
	
	public void printCheckersBoard(){
		System.out.println("_________________");
		for (int i = 0; i < checkersBoard.length; i++){
			System.out.print("|");
			for (int j = 0; j < checkersBoard[i].length; j++){
				if (j == checkersBoard[i].length-1){
					System.out.println(checkersBoard[i][j]+"|");
				}
				else{
					System.out.print(checkersBoard[i][j]+"|");
				}
			}
		}
		System.out.println("_________________");
		System.out.println();
	}
	
	//Sets the board initially.
	
	public void setCheckersBoard(){
		for (int i = 0; i < checkersBoard.length; i++){
			for (int j = 0; j < checkersBoard[i].length; j++){
				if (i < 3){
					if(i % 2 == 0){
					if (j % 2 != 0){
						checkersBoard[i][j] = "R";
					}
					else{
						checkersBoard[i][j] = " ";
					}
				}
				else{
					if (j % 2 == 0){
						checkersBoard[i][j] = "R";
					}
					else{
						checkersBoard[i][j] = " ";
					}
					}
				}
				else if (i > 4){
					if(i % 2 == 0){
					if (j % 2 != 0){
						checkersBoard[i][j] = "B";
					}
					else{
						checkersBoard[i][j] = " ";
					}
				}
				else{
					if (j % 2 == 0){
						checkersBoard[i][j] = "B";
					}
					else{
						checkersBoard[i][j] = " ";
					}
					}
				}
				else{
					checkersBoard[i][j] = " ";
				}
			}
		}
	}
	
	//Called every time a piece is captured, checks the same stuff as move, just with one extra step.
	
	public void capture(int x, int y, int X, int Y, int xCap, int yCap, Player player){
		this.x = x;
		this.y = y;
		this.X = X;
		this.Y = Y;
		this.xCap = xCap;
		this.yCap = yCap;
		
		if (player.getSide() && (checkersBoard[x][y].equals("B") || checkersBoard[x][y].equals("K"))){
			
			if (xCap < X){
				System.out.println("You cannot move backwards!");
				System.out.println();
			}
			else{
				if (checkersBoard[xCap][yCap].equals(" ")){
					if(xCap > X && yCap != Y){
						if(Math.abs(X - xCap) <= 2){
							checkersBoard[xCap][yCap] = checkersBoard[X][Y];
							checkersBoard[x][y] = " ";
							checkersBoard[X][Y] = " ";
							numBlackPieces--;
						}
					}
					else if (xCap == x && Math.abs(yCap - Y) <= 2){
							checkersBoard[xCap][yCap] = checkersBoard[X][Y];
							checkersBoard[x][y] = " ";
							checkersBoard[X][Y] = " ";
							numBlackPieces--;
					}
				}
				else{
				System.out.println("The piece you chose to capture cannot actually be captured, as there is no empty space past it.");
				}
			}
		}
		
		else if (player.getSide() == false && (checkersBoard[x][y].equals("R") || checkersBoard[x][y].equals("K"))){
			
			if (xCap > X){
				System.out.println("You cannot move backwards!");
				System.out.println();
			}
			else{
				if(checkersBoard[xCap][yCap].equals(" ")){
					if(xCap < X && yCap != Y){
						if(Math.abs(X - xCap) <= 2){
							checkersBoard[xCap][yCap] = checkersBoard[X][Y];
							checkersBoard[x][y] = " ";
							checkersBoard[X][Y] = " ";
							numRedPieces--;
						}
					}
					else if(xCap == x && Math.abs(yCap - Y) <= 2){
							checkersBoard[xCap][yCap] = checkersBoard[X][Y];
							checkersBoard[x][y] = " ";
							checkersBoard[X][Y] = " ";
							numRedPieces--;
					}
				}
				else{
				System.out.println("The piece you chose to capture cannot actually be captured, as there is no empty space past it.");
				}
			}
		}
		else{
			System.out.println("You have not selected a valid piece to CAPTURE.");
			System.out.println();
		}
	}
	
	public void move(int x, int y, int moveX, int moveY, Player player){
		this.x = x;
		this.y = y;
		this.moveX = moveX;
		this.moveY = moveY;
		
		if(player.getSide() && (checkersBoard[x][y].equals("R") || checkersBoard[x][y].equals("K"))){
			
			if(checkersBoard[x][y].equals("K")){
				if (checkersBoard[moveX][moveY].equals(" ")){
					
					if(Math.abs(x-moveX) <= 1 && Math.abs(y-moveY) < 2){
						checkersBoard[moveX][moveY] = checkersBoard[x][y];
						checkersBoard[x][y] = " ";
					}
					else{
						System.out.println("Too far! Your guy's a King, but he can't move further than his men.");
						System.out.println();
					}
				}
				else{
					System.out.println("That move is invalid, as there is a piece where your king wishes to go.");
					System.out.println();
				}
			}
			else if (moveX < x){
				System.out.println("You cannot move backwards!");
			}
			else{
				if (checkersBoard[moveX][moveY].equals(" ")){
					if(moveX > x && moveY != y){
						if(Math.abs(x - moveX) <= 1 && Math.abs(y - moveY) < 2){
							checkersBoard[moveX][moveY] = checkersBoard[x][y];
							checkersBoard[x][y] = " ";
						}
						else{
							System.out.println("Too far!");
							System.out.println();
						}
					}
					else{
						System.out.println("The piece cannot move directly forward. It must stay on dark tiles.");
						System.out.println();
					}
				}
				else{
					System.out.println("That move is invalid, as there is a piece at your selected coordinates.");
				}
			}
		}
		
		else if(player.getSide() == false && (checkersBoard[x][y].equals("B") || checkersBoard[x][y].equals("K"))){
			
			if(checkersBoard[x][y].equals("K")){
				if (checkersBoard[moveX][moveY].equals(" ")){
					if(Math.abs(x-moveX) <= 1 && Math.abs(y-moveY) < 2){
						checkersBoard[moveX][moveY] = checkersBoard[x][y];
						checkersBoard[x][y] = " ";
					}
					else{
						System.out.println("Too far! Your guy's a King, but he can't move further than his men.");
						System.out.println();
					}
				}
				else{
					System.out.println("That move is invalid, as there is a piece where your king wishes to go.");
					System.out.println();
				}
			}
			
			if(moveX > x){
				System.out.println("You cannot move backwards!");
			}
			else{
				if (checkersBoard[moveX][moveY].equals(" ")){
					if(moveX < x && moveY != y){
						if (Math.abs(x - moveX) <= 1 && Math.abs(y - moveY) < 2){
							checkersBoard[moveX][moveY] = checkersBoard[x][y];
							checkersBoard[x][y] = " ";
						}
					}
					else{
						System.out.println("The piece cannot move directly forward. It must stay on dark tiles.");
						System.out.println();
					}
				}
				else{
				System.out.println("That move is invalid, as there is a piece at your selected coordinates.");
				}	
			}
		}
		
		else{
			System.out.println("You did not select a valid location containing a piece to move.");
		}
	}
	
	public int findIndex(String letter, String [] arr){
		int num = -1;
		for (int i = 0; i < arr.length; i++){
			if (arr[i].equals(letter)){
				num = i;
			}
		}
		return num;
	}
	
	public boolean isMovePossible(Player player){
		if(player.getSide()){
			for(int i = 0; i < checkersBoard.length; i++){
				for(int j = 0; j < checkersBoard[i].length; j++){
					if(checkersBoard[i][j].equals("R")){
						if(j == 0){
							if((checkersBoard[i + 1][j + 1].equals("B") && checkersBoard[i + 2][j + 2].equals(" ")) ||
							(checkersBoard[i][j + 1].equals("B") && checkersBoard[i][j + 2].equals(" ")) ||
							checkersBoard[i + 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						else if(i == checkersBoard.length-2 && j == 0){
							if((checkersBoard[i + 1][j + 1].equals("B") && checkersBoard[i + 2][j + 2].equals(" ")) ||
							(checkersBoard[i][j + 1].equals("B") && checkersBoard[i][j + 2].equals(" ")) ||
							checkersBoard[i + 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if(i == checkersBoard.length-1 && j == 0){
							if(checkersBoard[i + 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if (j == 1){
							if(checkersBoard[i + 1][j - 1].equals(" ") ||
							checkersBoard[i + 1][j + 1].equals(" ") || checkersBoard[i + 1][j + 2].equals(" ") ||
							(checkersBoard[i + 1][j + 1].equals("B") && checkersBoard[i + 2][j + 2].equals(" ")) ||
							(checkersBoard[i + 1][j + 1].equals("K") && checkersBoard[i + 2][j + 2].equals(" "))){
							canMove = true;
							}
						}
						
						//NOW IF ON THE RIGHT SIDE OF THE BOARD:
						
						
						if(j == checkersBoard[i].length - 1){
							if((checkersBoard[i + 1][j - 1].equals("B") && checkersBoard[i + 2][j - 2].equals(" ")) ||
							(checkersBoard[i][j - 1].equals("B") && checkersBoard[i][j - 2].equals(" ")) ||
							checkersBoard[i + 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						else if(i == checkersBoard.length-2 && j == checkersBoard.length - 1){
							if((checkersBoard[i + 1][j - 1].equals("B") && checkersBoard[i + 2][j - 2].equals(" ")) ||
							(checkersBoard[i][j - 1].equals("B") && checkersBoard[i][j - 2].equals(" ")) ||
							checkersBoard[i + 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if(i == checkersBoard.length-1 && j == checkersBoard.length - 1){
							if(checkersBoard[i + 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if (j == checkersBoard.length - 2){
							if(checkersBoard[i + 1][j - 1].equals(" ") ||
							checkersBoard[i + 1][j - 1].equals(" ") || checkersBoard[i + 1][j - 2].equals(" ") ||
							(checkersBoard[i + 1][j - 1].equals("B") && checkersBoard[i + 2][j - 2].equals(" ")) ||
							(checkersBoard[i + 1][j - 1].equals("K") && checkersBoard[i + 2][j - 2].equals(" "))){
							canMove = true;
							}
						}
					}
				}
			}
		}
		else if (player.getSide() == false){
			for(int i = 0; i < checkersBoard.length; i++){
				for(int j = 0; j < checkersBoard[i].length; j++){
					if(checkersBoard[i][j].equals("B")){
						if(j == 0){
							if((checkersBoard[i - 1][j + 1].equals("B") && checkersBoard[i - 2][j + 2].equals(" ")) ||
							(checkersBoard[i][j + 1].equals("B") && checkersBoard[i][j + 2].equals(" ")) ||
							checkersBoard[i - 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						else if(i == checkersBoard.length-2 && j == 0){
							if((checkersBoard[i - 1][j + 1].equals("B") && checkersBoard[i - 2][j + 2].equals(" ")) ||
							(checkersBoard[i][j + 1].equals("B") && checkersBoard[i][j + 2].equals(" ")) ||
							checkersBoard[i - 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if(i == checkersBoard.length-1 && j == 0){
							if(checkersBoard[i - 1][j + 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if (j == 1){
							if(checkersBoard[i - 1][j - 1].equals(" ") ||
							checkersBoard[i - 1][j + 1].equals(" ") || checkersBoard[i - 1][j + 2].equals(" ") ||
							(checkersBoard[i - 1][j + 1].equals("B") && checkersBoard[i - 2][j + 2].equals(" ")) ||
							(checkersBoard[i - 1][j + 1].equals("K") && checkersBoard[i - 2][j + 2].equals(" "))){
							canMove = true;
							}
						}
						
						//NOW IF ON THE RIGHT SIDE OF THE BOARD:
						
						
						if(j == checkersBoard[i].length - 1){
							if((checkersBoard[i - 1][j - 1].equals("B") && checkersBoard[i - 2][j - 2].equals(" ")) ||
							(checkersBoard[i][j - 1].equals("B") && checkersBoard[i][j - 2].equals(" ")) ||
							checkersBoard[i - 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						else if(i == checkersBoard.length-2 && j == checkersBoard.length - 1){
							if((checkersBoard[i - 1][j - 1].equals("B") && checkersBoard[i - 2][j - 2].equals(" ")) ||
							(checkersBoard[i][j - 1].equals("B") && checkersBoard[i][j - 2].equals(" ")) ||
							checkersBoard[i - 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if(i == checkersBoard.length-1 && j == checkersBoard.length - 1){
							if(checkersBoard[i - 1][j - 1].equals(" ")){
								canMove = true;
							}
						}
						
						else if (j == checkersBoard.length - 2){
							if(checkersBoard[i - 1][j - 1].equals(" ") ||
							checkersBoard[i - 1][j - 1].equals(" ") || checkersBoard[i - 1][j - 2].equals(" ") ||
							(checkersBoard[i - 1][j - 1].equals("B") && checkersBoard[i - 2][j - 2].equals(" ")) ||
							(checkersBoard[i - 1][j - 1].equals("K") && checkersBoard[i - 2][j - 2].equals(" "))){
							canMove = true;
							}
						}
					}
				}
			}
		}
		else{
			canMove = false;
		}
		return canMove;
	}
	
	public boolean isOver(){
		if(numBlackPieces == 0 || numRedPieces == 0){
			return true;
		}
		if(canMove == false){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void makeKing(){
		
		for (int i = 0; i < checkersBoard.length; i+=7){
			if(i==0){
				if(findIndex("B", checkersBoard[i]) != -1){
				checkersBoard[i][findIndex("B", checkersBoard[i])] = "K";	
				}
			}
			else{
				if(findIndex("R", checkersBoard[i]) != -1){
					checkersBoard[i][findIndex("R", checkersBoard[i])] = "K";
				}
			}
		}
	}
}

//RULES TO REMEMBER:
//if possible to capture multiple pieces in one turn, it is required the player do so.
//King pieces are achieved by getting to the back/front of the board.