import java.util.ArrayList;
import java.util.List;

public abstract class Piece{
    protected Coordinates position;
    protected ChessColor color;
    
    public Piece(int x, int y, ChessColor color){
	    this.position = new Coordinates(x, y);
	    this.color = color;
    }

    public enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    public void move(Coordinates destination){
	this.position = destination;
    }

    public ChessColor getColor(){
	return color;
    }

    public Coordinates getPosition(){
	return position;
    }

    public int getX(){
	return position.getX();
    }
    
    public int getY(){
	return position.getY();
    }

    public abstract boolean isMoveAuthorized(int x, int y);

    public abstract List<Move> getAllLegalMoves (Board board);

    public List<Move> getAllMoves() {
        List<Move> moves = new ArrayList<>();
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                if (this.isMoveAuthorized(x, y))
                    moves.add(new Move(this.getPosition(), new Coordinates(x, y)));
        return moves;
    }

    public abstract Type getType();
}
