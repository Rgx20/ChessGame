public class GameUI {
    public Board board;
    private Player white;
    private Player black;
    private Player current;
    private ChessUI ui;

    public GameUI(ChessUI ui, Player white, Player black) {
        this(new Board(), ui, white, black);
    }

    public GameUI(Board board, ChessUI ui, Player white, Player black) {
        this.board = board;
        this.white = white;
        this.black = black;
        this.current = white;
        this.ui = ui;

        for (Piece p : board.getPieces())
            this.ui.placePiece(p.getType(), p.getColor(), p.getPosition());
    }



    public void move(Piece piece, Coordinates destination) {
        board.emptyCell(piece.getPosition());
        ui.removePiece(piece.getPosition());

        piece.move(destination);

        board.addPiece(piece);
        ui.placePiece(piece.getType(), piece.getColor(), piece.getPosition());
    }

    public void switchPlayers() {
        if (current == white)
            current = black;
        else
            current = white;
    }


    public void play() {
        int count = 0;
        while (true) {
            Move nextMove = current.getMove();
            Piece movingPiece = board.getPiece(nextMove.getOrigin());
            if (count == 50 || current.isCheckMate(board)){
                Player p1 = current;
                Player p2 = getOpponent(current);
                System.out.print("Jeu terminé ");
                if (p1.getPoint() == p2.getPoint())
                    System.out.println("sur une partie nulle avec "+current.getPoint()+"point(s) de chaque joueur !!!");
                if (p1.getPoint() > p2.getPoint()) {
                    if (p1.getClass().equals(Human.class) && p2.getClass().equals(Human.class)) {
                        System.out.println("avec la victoire des " + p1.getColor());
                        System.out.println(p1.getColor()+" : "+p1.getPoint()+" Points");
                        System.out.println(p2.getColor()+" : "+p2.getPoint()+" Points");
                    }
                    if (p1.getClass().equals(Human.class) && p2.getClass().equals(ChessBot.class)){
                        System.out.println("avec la victoire de l'Humain sur l'IA");
                        System.out.println("Humain : "+p1.getPoint()+" Points");
                        System.out.println("IA : "+p2.getPoint()+" Points");
                    }
                    if (p1.getClass().equals(ChessBot.class) && p2.getClass().equals(Human.class)){
                        System.out.println("avec la victoire de l'IA sur l'Humain");
                        System.out.println("IA : "+p1.getPoint()+" Points");
                        System.out.println("Humain : "+p2.getPoint()+" Points");
                    }
                }
                if (p2.getPoint() > p1.getPoint()) {
                    if (p2.getClass().equals(Human.class) && p1.getClass().equals(Human.class)) {
                        System.out.println("avec la victoire des " + p2.getColor());
                        System.out.println(p2.getColor() + " : " + p2.getPoint() + " Points");
                        System.out.println(p1.getColor() + " : " + p1.getPoint() + " Points");
                    }
                    if (p2.getClass().equals(Human.class) && p1.getClass().equals(ChessBot.class)) {
                        System.out.println("avec la victoire de l'Humain sur l'IA");
                        System.out.println("Humain : " + p2.getPoint() + " Points");
                        System.out.println("IA : " + p1.getPoint() + " Points");
                    }
                    if (p2.getClass().equals(ChessBot.class) && p1.getClass().equals(Human.class)) {
                        System.out.println("avec la victoire de l'IA sur l'Humain");
                        System.out.println("IA : " + p2.getPoint() + " Points");
                        System.out.println("Humain : " + p1.getPoint() + " Points");
                    }
                }
                break;
            }
            if (isMoveLegal(nextMove)){
                current.setPoint(calculatePoint(nextMove.getDestination()));
                move(movingPiece, nextMove.getDestination());
                switchPlayers();
                count++;
                if (current.isCheck(board))
                    System.out.println("Le joueur "+current.getColor()+" est en échec");
            }
        }
    }

    public boolean isMoveLegal(Move nextMove) {
        Piece movingPiece = board.getPiece(nextMove.getOrigin());
        if(movingPiece.getColor().equals(current.getColor())) {
            for (Move move : movingPiece.getAllLegalMoves(board)){
                if (move.getDestination().getX() == nextMove.getDestination().getX()
                        && move.getDestination().getY() == nextMove.getDestination().getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Player getOpponent(Player p) {
        if(p.getColor().equals(ChessColor.BLACK))
            return white;
        return black;
    }

    private int calculatePoint(Coordinates destination){
        Piece piece = board.getPiece(destination);
        if (piece == null)
            return 0;
        return switch (piece.getType()) {
            case PAWN -> 1;
            case BISHOP, KNIGHT -> 3;
            case ROOK -> 5;
            case QUEEN -> 9;
            default -> 0;
        };
    }
}