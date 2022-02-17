import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(int x, int y, ChessColor color){
        super(x, y, color);
    }

    @Override
    public boolean isMoveAuthorized(int x, int y) {
        Rook rook = new Rook(this.getX(), this.getY(), this.getColor());
        Bishop bishop = new Bishop(this.getX(), this.getY(), this.getColor());
        return (rook.isMoveAuthorized(x, y) || bishop.isMoveAuthorized(x, y));
    }

    @Override
    public List<Move> getAllLegalMoves(Board board) {
        List<Move> QueenLegalMoves = new ArrayList<>();
        Rook rook = new Rook(this.getX(), this.getY(), this.getColor());
        Bishop bishop = new Bishop(this.getX(), this.getY(), this.getColor());
        QueenLegalMoves.addAll(rook.getAllLegalMoves(board));
        QueenLegalMoves.addAll(bishop.getAllLegalMoves(board));
        return QueenLegalMoves;
    }

    @Override
    public Piece.Type getType() {
        return Type.QUEEN;
    }
}
