import java.io.*;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
    	
        ChessUI ui = new ChessUI();
        File file;

    	/* Pour commencer le jeu d'un cofiguration donné */
	    Board startBoard = new Board("FullBoard.txt");
    	GameUI g = new GameUI(startBoard, ui, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
    	
    	/* Pour commencer un nouveau jeu */
		//GameUI g = new GameUI(ui, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
    	/* Commencer le jeu */ 
		g.play();
    }

	
}
