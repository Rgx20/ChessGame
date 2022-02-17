import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(int x, int y, ChessColor color){
        super(x, y, color);
    }

    @Override
    public boolean isMoveAuthorized(int x, int y) {
        if (x == this.getX() && y == this.getY())
            return false;
        if(x != this.getX())
            return false;
        if(this.getColor().equals(ChessColor.BLACK)) {
            if (this.getY() == 1 && (y > this.getY() + 2 || y < this.getY()))
                return false;
            if (this.getY() > 1 && (y > this.getY() + 1 || y < this.getY()))
                return false;
        }
        if(this.getColor().equals(ChessColor.WHITE)) {
            if (this.getY() == 6 && (y < this.getY() - 2 || y > this.getY()))
                return false;
            if (this.getY() < 6 && (y < this.getY() - 1 || y > this.getY()))
                return false;
        }
        return true;
    }

    @Override
    public List<Move> getAllLegalMoves(Board board) {
        List<Move> PawnLegalMoves = new ArrayList<>();
        for (Move move : this.getAllMoves()) {
            Piece arrivalCell = board.getPiece(move.getDestination());
            if (arrivalCell == null)
                PawnLegalMoves.add(move);
        }
        if(this.getColor().equals(ChessColor.BLACK)){
            if (this.getX() > 0 && this.getX() < 7) {
                Piece cell1 = board.getPiece(new Coordinates(this.getX() - 1, this.getY() + 1));
                Piece cell2 = board.getPiece(new Coordinates(this.getX() + 1, this.getY() + 1));
                if ((cell1 != null && !this.getColor().equals(cell1.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell1.getPosition()));
                if ((cell2 != null && !this.getColor().equals(cell2.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell2.getPosition()));
            }
            if (this.getX() == 0){
                Piece cell2 = board.getPiece(new Coordinates(this.getX() + 1, this.getY() + 1));
                if ((cell2 != null && !this.getColor().equals(cell2.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell2.getPosition()));
            }
            if (this.getX() == 7){
                Piece cell1 = board.getPiece(new Coordinates(this.getX() - 1, this.getY() + 1));
                if ((cell1 != null && !this.getColor().equals(cell1.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell1.getPosition()));
            }
        }
        if(this.getColor().equals(ChessColor.WHITE)){
            if (this.getX() > 0 && this.getX() < 7) {
                Piece cell1 = board.getPiece(new Coordinates(this.getX() - 1, this.getY() - 1));
                Piece cell2 = board.getPiece(new Coordinates(this.getX() + 1, this.getY() - 1));
                if ((cell1 != null && !this.getColor().equals(cell1.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell1.getPosition()));
                if ((cell2 != null && !this.getColor().equals(cell2.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell2.getPosition()));
            }
            if (this.getX() == 0){
                Piece cell2 = board.getPiece(new Coordinates(this.getX() + 1, this.getY() - 1));
                if ((cell2 != null && !this.getColor().equals(cell2.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell2.getPosition()));
            }
            if (this.getX() == 7){
                Piece cell1 = board.getPiece(new Coordinates(this.getX() - 1, this.getY() - 1));
                if ((cell1 != null && !this.getColor().equals(cell1.getColor())))
                    PawnLegalMoves.add(new Move(this.getPosition(), cell1.getPosition()));
            }
        }
        return PawnLegalMoves;
    }

    @Override
    public Piece.Type getType() {
        return Type.PAWN;
    }
}
