import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    protected ChessColor color;
    boolean isCheck;
    protected int point;

    public Player(ChessColor color){
	    this.color = color;
	    isCheck = false;
	    point = 0;
    }

    public ChessColor getOpponentColor() {
        if(this.getColor().equals(ChessColor.WHITE))
            return ChessColor.BLACK;
        return ChessColor.WHITE;
    }

    public ChessColor getColor(){
	return color;
    }
    
    /* Methode getMove() doit être definir dans chaque classe qui étend Player */
    public abstract Move getMove();

    /* Cette methode renvoie le pièce KING de ce jouer de l'échiquier <board> */
    public Piece getKing(Board board){
        if(this.getColor().equals(ChessColor.WHITE))
           return board.getPiece('k');
        else
            return board.getPiece('K');
    }
    
    public boolean isCheck(Board board){
        for (Piece piece : board.getPieces(this.getOpponentColor())) {
            for (Move move : piece.getAllLegalMoves(board)) {
                if (move.getDestination().getX() == this.getKing(board).getX()
                        && move.getDestination().getY() == this.getKing(board).getY()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCheckMate(Board board) {
        if(this.isCheck(board)){
            if(this.getKing(board).getAllLegalMoves(board).isEmpty()) {
                if (!this.getAllMoves(board).isEmpty()) {
                    return this.isCheck(board);
                }
                return true;
            }
            return this.isCheck(board);
        }
	    return false;
    }

    public void setCheck(){
	    this.isCheck = true;
    }

    public void unSetCheck(){
	    this.isCheck = false;
    }

    /* Method returns all possible moves for this Player */
    public List<Move> getAllMoves(Board board) {
	    ArrayList<Move> listMoves =  new ArrayList<Move>();
	    for(Piece piece : board.getPieces(color))
	        listMoves.addAll(piece.getAllLegalMoves(board));
	    return listMoves;
    }

    public int getPoint(){
        return this.point;
    }

    public void setPoint(int point) {
        this.point = this.point + point;
    }
}
