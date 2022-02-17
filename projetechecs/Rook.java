import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public Rook(int x, int y, ChessColor color){
        super(x, y, color);
    }

    @Override
    public boolean isMoveAuthorized(int x, int y) {
        if (x == this.getX() && y == this.getY())
            return false;
        if (x != this.getX() && y != this.getY())
            return false;
        return true;
    }

    @Override
    public List<Move> getAllLegalMoves(Board board) {
        List<Move> RookLegalMoves = new ArrayList<>();
        for(Move move : this.getAllMoves()){
            Piece arrivalCell = board.getPiece(move.getDestination());
            Coordinates destination = move.getDestination();
            if(arrivalCell == null || !this.getColor().equals(arrivalCell.getColor())) {
                int occurrence = 0;
                if(this.getY() == destination.getY()){
                    if(this.getX() < destination.getX()) {
                        for (int x = this.getX() + 1; x < destination.getX(); x++)
                            if (board.getPiece(new Coordinates(x, this.getY())) != null)
                                occurrence++;
                        if (occurrence == 0)
                            RookLegalMoves.add(move);
                    }
                    if(this.getX() > destination.getX()) {
                        for (int x = destination.getX() + 1; x < this.getX(); x++)
                            if (board.getPiece(new Coordinates(x, this.getY())) != null)
                                occurrence++;
                        if (occurrence == 0)
                            RookLegalMoves.add(move);
                    }
                }
                if(this.getX() == destination.getX()) {
                    if (this.getY() < destination.getY()) {
                        for (int y = this.getY() + 1; y < destination.getY(); y++)
                            if (board.getPiece(new Coordinates(this.getX(), y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            RookLegalMoves.add(move);
                    }
                    if (this.getY() > destination.getY()) {
                        for (int y = destination.getY() + 1; y < this.getY(); y++)
                            if (board.getPiece(new Coordinates(this.getX(), y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            RookLegalMoves.add(move);
                    }
                }
            }
        }
        return RookLegalMoves;
    }

    @Override
    public Type getType() {
        return Type.ROOK;
    }
}
