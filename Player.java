package pkg;
import java.util.Scanner;
import java.util.Random;

public class Player{
    
    boolean isRedPieces;
    
    public Player(String answer){
        if (answer.equals("R") || answer.equals("r"))
            isRedPieces = true;
        else 
            isRedPieces = false;
    }
    
    public boolean getSide(){
       return isRedPieces;
    }
}