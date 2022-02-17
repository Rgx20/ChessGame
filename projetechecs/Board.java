import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Board{
    private Piece[][] array;

    /* Create a chess Board with all pieces in starting locations */
    public Board(){
	this.array = new Piece[8][8];
	//this.addPiece(new Rook  (0, 0, ChessColor.WHITE));
	//this.addPiece(new Knight(1, 0, ChessColor.WHITE));
	//this.addPiece(new Bishop(2, 0, ChessColor.WHITE));
	this.addPiece(new King  (3, 0, ChessColor.WHITE));
	//this.addPiece(new Queen (4, 0, ChessColor.WHITE));
	//this.addPiece(new Bishop(5, 0, ChessColor.WHITE));
	//this.addPiece(new Knight(6, 0, ChessColor.WHITE));
	//this.addPiece(new Rook  (7, 0, ChessColor.WHITE));
	//this.addPiece(new Pawn  (0, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (1, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (2, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (3, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (4, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (5, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (6, 1, ChessColor.WHITE));
	//this.addPiece(new Pawn  (7, 1, ChessColor.WHITE));

	//this.addPiece(new Rook  (0, 7, ChessColor.BLACK));
	//this.addPiece(new Knight(1, 7, ChessColor.BLACK));
	//this.addPiece(new Bishop(2, 7, ChessColor.BLACK));
	this.addPiece(new King  (3, 7, ChessColor.BLACK));
	//this.addPiece(new Queen (4, 7, ChessColor.BLACK));
	//this.addPiece(new Bishop(5, 7, ChessColor.BLACK));
	//this.addPiece(new Knight(6, 7, ChessColor.BLACK));
	//this.addPiece(new Rook  (7, 7, ChessColor.BLACK));
	//this.addPiece(new Pawn  (0, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (1, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (2, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (3, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (4, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (5, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (6, 6, ChessColor.BLACK));
	//this.addPiece(new Pawn  (7, 6, ChessColor.BLACK));

    }

    /* Create a chess Board from a given configuration file 
     * Encoding: K=KING, Q=QUEEN, N=KNIGHT, B=BISHOP, R=ROOK, P=PAWN ;
     * Uppercase = BLACK; Lowercase = WHITE ;  
    */
    public Board(String fileName){
    	int pieceType;
    	int col;
    	int row;
    	String nextWord;
    	ChessColor color;
    	    
    	this.array = new Piece[8][8];
    	try {
    	    File file = new File(fileName);
        	if(file.exists()==false) {
        		System.err.println("Error: Cannot find file "+ fileName);
        		System.exit(1);		
        	} 

    	    Scanner in = new Scanner(file);
    	    while(in.hasNext()) 
    		if ((nextWord = in.nextLine()).length()>2) {
    		    pieceType = nextWord.charAt(0);
    		    col = nextWord.charAt(1)-'0';
    		    row = nextWord.charAt(2)-'0';
    		    
    		    color = ChessColor.BLACK;
    		    if (pieceType >= 'a' && pieceType <= 'z')
        			color = ChessColor.WHITE;
    		    
    		    switch(pieceType) {
    		    case 'K' : case 'k' :  
        			{ this.addPiece(new King(col, row, color));break;}
    		    case 'Q' :  case 'q' :
        			{ this.addPiece(new Queen(col, row, color));break;}
    		    case 'N' :  case 'n' :
        			{ this.addPiece(new Knight(col, row, color));break;}
    		    case 'B' :  case 'b' :
        			{ this.addPiece(new Bishop(col, row, color));break;}
    		    case 'R' :  case 'r' :
        			{ this.addPiece(new Rook(col, row, color));break;}
    		    case 'P' :  case 'p' :
        			{ this.addPiece(new Pawn(col, row, color));break;}
    		    default : 
    				{ System.err.println("Error: Unknown Piece "+(char)pieceType); System.exit(1);}
    		    }	    	
    	    }
    	    in.close();
    	}    	
    	catch(FileNotFoundException e) {
    	    System.err.println("Error file not found : "+e);
    	    System.exit(1);	
    	}
    }
    
       public List<Piece> getPieces() {
    	ArrayList<Piece> list = new ArrayList<Piece>();
    	for(int x = 0; x < 8; x++)
    		for(int y = 0; y < 8; y++)
    			if(array[x][y] != null)
    				list.add(array[x][y]);
		return list;
	}

    public List<Piece> getPieces(ChessColor color) {
    	ArrayList<Piece> list = new ArrayList<Piece>();
    	for(int x = 0; x < 8; x++)
	    	for(int y = 0; y < 8; y++){
				Piece piece = array[x][y];
				if((piece != null) && (piece.getColor() == color))
		    		list.add(array[x][y]);
	    	}
		return list;
    }

    public Piece getPiece(char pieceType) {
    	ChessColor color = ChessColor.BLACK;
        if (pieceType >= 'a' && pieceType <= 'z')
    		color = ChessColor.WHITE;
        Piece.Type type = null;
        if(pieceType == 'K' || pieceType == 'k') type = Piece.Type.KING;
        if(pieceType == 'Q' || pieceType == 'q') type = Piece.Type.QUEEN;
        if(pieceType == 'N' || pieceType == 'n') type = Piece.Type.KNIGHT;
        if(pieceType == 'B' || pieceType == 'b') type = Piece.Type.BISHOP;
        if(pieceType == 'R' || pieceType == 'r') type = Piece.Type.ROOK;
        if(pieceType == 'P' || pieceType == 'p') type = Piece.Type.PAWN;

        for(int x = 0; x < 8; x++)
    	    for(int y = 0; y < 8; y++){
    		     Piece piece = array[x][y];
    		     if((piece != null) && (piece.getType() == Piece.Type.KING) && (piece.getColor() == color))
    		    	 return piece;
    	    }
        return null;
    }
 

    public void addPiece(Piece piece){
	this.array[piece.getX()][piece.getY()] = piece;
    }

    public Piece getPiece(Coordinates coordinates){
	return array[coordinates.getX()][coordinates.getY()];
    }

    public void emptyCell(Coordinates coordinates){
	array[coordinates.getX()][coordinates.getY()] = null;
    }
    

}
