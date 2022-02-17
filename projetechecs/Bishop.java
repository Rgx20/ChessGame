import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(int x, int y, ChessColor color){
        super(x, y, color);
    }

    @Override
    public boolean isMoveAuthorized(int x, int y) {
        if (x == this.getX() && y == this.getY())
            return false;
        if (x < this.getX()) {
            if (y < this.getY())
                if ((this.getX() - x) == (this.getY() - y))
                    return true;
            if (y > this.getY())
                if ((this.getX() - x) == (y - this.getY()))
                    return true;
        }
        if (x > this.getX()){
            if (y < this.getY())
                if ((x - this.getX()) == (this.getY() - y))
                    return true;
            if (y > this.getY())
                if ((x - this.getX()) == (y - this.getY()))
                    return true;
        }
        return false;

    }

    @Override
    public List<Move> getAllLegalMoves(Board board) {
        List<Move> BishopLegalMoves = new ArrayList<>();
        for(Move move : this.getAllMoves()){
            Piece arrivalCell = board.getPiece(move.getDestination());
            Coordinates destination = move.getDestination();
            if(arrivalCell == null || !this.getColor().equals(arrivalCell.getColor())) {
                int occurrence = 0;
                if(this.getY() > destination.getY()){
                    if (this.getX() > destination.getX()) {
                        for (int x = this.getX() - 1, y = this.getY() - 1; x > destination.getX() && y > destination.getY(); x--, y--)
                            if (board.getPiece(new Coordinates(x, y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            BishopLegalMoves.add(move);
                    }
                    if (this.getX() < destination.getX()) {
                        for (int x = this.getX() + 1, y = this.getY() -1; x < destination.getX() && y > destination.getY(); x++, y--)
                            if (board.getPiece(new Coordinates(x, y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            BishopLegalMoves.add(move);
                    }
                }
                if(this.getY() < destination.getY()){
                    if (this.getX() > destination.getX()) {
                        for (int x = this.getX() - 1, y = this.getY() + 1; x > destination.getX() && y < destination.getY(); x--, y++)
                            if (board.getPiece(new Coordinates(x, y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            BishopLegalMoves.add(move);
                    }
                    if (this.getX() < destination.getX()) {
                        for (int x = this.getX() +1, y = this.getY() + 1; x < destination.getX() && y < destination.getY(); x++, y++)
                            if (board.getPiece(new Coordinates(x, y)) != null)
                                occurrence++;
                        if (occurrence == 0)
                            BishopLegalMoves.add(move);
                    }
                }
            }
        }
        return BishopLegalMoves;
    }

    @Override
    public Type getType() {
        return Type.BISHOP;
    }
}
