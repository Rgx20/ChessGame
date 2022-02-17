import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(int x, int y, ChessColor color){
        super(x, y, color);
    }

    @Override
    public boolean isMoveAuthorized(int x, int y) {
        if (x == this.getX() && y == this.getY())
            return false;
        if (!((Math.abs(x-this.getX()) == 1 && Math.abs(y-this.getY()) == 2) || (Math.abs(x-this.getX()) == 2 && Math.abs(y-this.getY()) == 1)))
            return false;
        return true;
    }

    @Override
    public List<Move> getAllLegalMoves(Board board) {
        List<Move> KnightLegalMoves = new ArrayList<>();
        for (Move move : this.getAllMoves()){
            Piece arrivalCell = board.getPiece(move.getDestination());
            if (arrivalCell == null || !this.getColor().equals(arrivalCell.getColor()))
                KnightLegalMoves.add(move);
        }
        return KnightLegalMoves;
    }

    @Override
    public Piece.Type getType() {
        return Type.KNIGHT;
    }
}
