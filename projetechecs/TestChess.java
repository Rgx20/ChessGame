public class TestChess{

	public static void main(String[] args) {
		
		boolean result;
		/* Test de déplacements authorisés selon les regles de pièces */
		/*result = testAuthorizedMove("KingsOnly.txt", 'k', new Coordinates(4,6));            // Authorisé
		result = result && !testAuthorizedMove("KingsOnly.txt", 'K', new Coordinates(4,6)); // Pas authorisé
		if(result==true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/

		//test de déplacement du fou
		/*boolean testBishop;
		testBishop = testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 0), new Coordinates(1,1));
		testBishop = testBishop && !testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 7), new Coordinates(1,1));
		testBishop = testBishop && testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 0), new Coordinates(0, 2));
		testBishop = testBishop && !testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 7), new Coordinates(0,2));
		testBishop = testBishop && testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 0), new Coordinates(4,2));
		testBishop = testBishop && !testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 7), new Coordinates(4,2));
		testBishop = testBishop && testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 0), new Coordinates(7,5));
		testBishop = testBishop && !testAuthorizedMove("BishopsOnly.txt", new Coordinates(2, 7), new Coordinates(7,5));
		testBishop = testBishop && !testAuthorizedMove("BishopsOnly.txt", new Coordinates(2,0), new Coordinates(2,0));
		if(testBishop == true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/

		//test du déplacement de la tour
		/*boolean testRook;
		testRook = testAuthorizedMove("RooksOnly.txt", new Coordinates(0,0), new Coordinates(0,7));
		testRook = testRook && !testAuthorizedMove("RooksOnly.txt", new Coordinates(0, 0), new Coordinates(3, 4));
		testRook = testRook && testAuthorizedMove("RooksOnly.txt", new Coordinates(7,7), new Coordinates(3,7));
		testRook = testRook && !testAuthorizedMove("RooksOnly.txt", new Coordinates(7,7), new Coordinates(4,2));
		testRook = testRook && testAuthorizedMove("RooksOnly.txt", new Coordinates(0,0), new Coordinates(5,0));
		testRook = testRook && !testAuthorizedMove("RooksOnly.txt", new Coordinates(0, 0), new Coordinates(0, 0));
		testRook = testRook && testAuthorizedMove("RooksOnly.txt", new Coordinates(7,7), new Coordinates(7,0));
		if (testRook == true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/


		//test de déplacement de la dame
		/*boolean testQueen;
		testQueen = testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 0), new Coordinates(5, 0));
		testQueen = testQueen && testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 0), new Coordinates(1, 0));
		testQueen = testQueen && testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 0), new Coordinates(4, 4));
		testQueen = testQueen && testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 7), new Coordinates(4, 6));
		testQueen = testQueen && testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 7), new Coordinates(3, 6));
		testQueen = testQueen && testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 7), new Coordinates(6, 5));
		testQueen = testQueen && !testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 0), new Coordinates(2, 1));
		testQueen = testQueen && !testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 7), new Coordinates(7, 5));
		testQueen = testQueen && !testAuthorizedMove("QueensOnly.txt", new Coordinates(4, 7), new Coordinates(4, 7));
		if (testQueen == true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/

		//test du déplacement du cavalier
		/*boolean testKnight;
		testKnight = !testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 0), new Coordinates(1, 0));
		testKnight = testKnight && !testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 0), new Coordinates(2, 1));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 0), new Coordinates(2, 2));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 0), new Coordinates(3, 1));
		testKnight = testKnight && !testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 0), new Coordinates(6, 1));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 0), new Coordinates(4, 1));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 0), new Coordinates(5, 2));
		testKnight = testKnight && !testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 7), new Coordinates(1, 6));
		testKnight = testKnight && !testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 7), new Coordinates(0, 7));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 7), new Coordinates(2, 5));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(1, 7), new Coordinates(3, 6));
		testKnight = testKnight && !testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 7), new Coordinates(5, 6));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 7), new Coordinates(5, 5));
		testKnight = testKnight && testAuthorizedMove("KnightsOnly.txt", new Coordinates(6, 7), new Coordinates(4, 6));
		if (testKnight == true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/

		//test du déplacement du pion
		/*boolean testPawn;
		testPawn = !testAuthorizedMove("PawnsOnly.txt", new Coordinates(3,1), new Coordinates(3,1));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(3, 1), new Coordinates(3, 0));
		testPawn = testPawn && testAuthorizedMove("PawnsOnly.txt", new Coordinates(3, 1), new Coordinates(3, 2));
		testPawn = testPawn && testAuthorizedMove("PawnsOnly.txt", new Coordinates(3, 1), new Coordinates(3,3));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(3, 1), new Coordinates(3, 4));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(3,1), new Coordinates(2,2));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(3,1), new Coordinates(4,2));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(4, 2), new Coordinates(4, 5));
		testPawn = testPawn && testAuthorizedMove("PawnsOnly.txt", new Coordinates(4, 2), new Coordinates(4, 3));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(4, 2), new Coordinates(3, 3));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(4, 2), new Coordinates(5, 3));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(4, 2), new Coordinates(4, 1));
		testPawn = testPawn && testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(2,5));
		testPawn = testPawn && testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(2,4));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(2,3));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(2,7));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(3,5));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(1,5));
		testPawn = testPawn && !testAuthorizedMove("PawnsOnly.txt", new Coordinates(2, 6), new Coordinates(3,6));
		if (testPawn == true) System.out.println("testAuthorizedMove: Correct!\n");
		else System.out.println("testAuthorizedMove: Pas Correct!\n");*/

		/*  Test de déplacements legal sur l'échiquier actuel, selon les regles du jeu */
		/*testLegalMove("FullBoard.txt",new Coordinates(3,0),new Coordinates(3,1));
		testLegalMove("FullBoard.txt",new Coordinates(3,1),new Coordinates(3,2));
		testLegalMove("BishopsOnly.txt",new Coordinates(2,0),new Coordinates(3,1));
		testLegalMove("KingsOnly.txt",new Coordinates(3,0),new Coordinates(3,1));
		testLegalMove("FullBoard.txt",new Coordinates(3,1),new Coordinates(3,3));
		testLegalMove("FullBoard.txt",new Coordinates(7,0),new Coordinates(7,7));
		testLegalMove("QueensOnly.txt",new Coordinates(4,0),new Coordinates(0,4));*/
		//testLegalMove("QueensOnly.txt", new Coordinates(3, 0), new Coordinates(3, 1));
		//testLegalMove("QueensOnly.txt", new Coordinates(3, 0), new Coordinates(2, 0));
		//testLegalMove("QueensOnly.txt", new Coordinates(1, 0), new Coordinates(2, 1));
		//testLegalMove("QueensOnly.txt", new Coordinates(1, 0), new Coordinates(0, 0));
		//testLegalMove("PawnsOnly.txt",new Coordinates(5,5),new Coordinates(6,4));



		/*  Tests de la mise en echec */
		//testIsCheck("TestIsCheck.txt", ChessColor.WHITE);
		//testIsCheck("TestIsCheck.txt", ChessColor.BLACK);
		//testIsCheck("QueensOnly.txt", ChessColor.WHITE);
		//testIsCheck("QueensOnly.txt", ChessColor.BLACK);

		/*  Tests de la Echec et mat "isCheckMate()" */

		
		/*  Tests pours le calcul des points en fin de partie */
    }

    public static boolean testIsCheck(String filename, ChessColor color){
		Board testBoard = new Board(filename);
		ChessUI ui = new ChessUI();
		Player white = new Human(ui, ChessColor.WHITE);
		Player black = new Human(ui, ChessColor.BLACK);
		GameUI g = new GameUI(testBoard, ui, white, black);
		Player p;

		if(color.equals(white.getColor()))
			p = white;
		else
			p = black;

		System.out.print("The Player "+p.getColor());
		if(p.getKing(testBoard) == null) {
			System.out.println(" has not KING");
			return false;
		}
		boolean isCheck = p.isCheck(testBoard);
		if(isCheck) {
			System.out.println(" is check");
		}
		else{
			System.out.println(" is not check");
		}
		return isCheck;
	}


	public static boolean testAuthorizedMove(String filename, char pieceType, Coordinates destination) {    			
		Board testBoard = new Board(filename);
		Piece testPiece = testBoard.getPiece(pieceType);
		if(testPiece == null) {
			System.out.println("Piece not found :"+pieceType); 
			return false;
			}
	    boolean authorized =  testPiece.isMoveAuthorized(destination.getX(), destination.getY());
	    System.out.print("Piece "+testPiece.getType()+" move from "+testPiece.getPosition()+" to "+destination);
	    if(authorized) 
	    	System.out.println(" is authorized.");
	    else
	    	System.out.println(" is not authorized.");
	    return authorized;
    }

	public static boolean testAuthorizedMove(String filename, Coordinates origin, Coordinates destination) {    			
		Board testBoard = new Board(filename);
		Piece testPiece = testBoard.getPiece(origin);
		if(testPiece == null) {
			System.out.println("No Piece at :"+origin); 
			return false;
			}
	    boolean authorized =  testPiece.isMoveAuthorized(destination.getX(), destination.getY());
	    System.out.print("Piece "+testPiece.getType()+" move from "+testPiece.getPosition()+" to "+destination);
	    if(authorized) 
	    	System.out.println("is authorized.");
	    else
	    	System.out.println("is not authorized.");
	    return authorized;
    }
	
	public static boolean testLegalMove(String filename, Coordinates origin, Coordinates destination) {    			
		Board testBoard = new Board(filename);
		ChessUI ui = new ChessUI();
		GameUI g = new GameUI(testBoard, ui, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));

		Piece testPiece = testBoard.getPiece(origin);
		if(testPiece == null) {
			System.out.println("No Piece at :"+origin); 
			return false;
		}
	    boolean isLegal =  g.isMoveLegal(new Move(origin,destination));
	    System.out.print("Piece "+testPiece.getType()+" move from "+testPiece.getPosition()+" to "+destination);
	    if(isLegal) 
	    	System.out.println(" is a legal move.");
	    else
	    	System.out.println(" is not a legal move.");
	    return isLegal;
    }





	
}

