import java.util.*;

public class King extends Piece {

    public King(int x, int y, ChessColor color){
		super(x, y, color);
    }

    public boolean isMoveAuthorized(int x, int y){
    	if(x == this.getX() && y == this.getY()) return false;
    	if(y != this.getY() + 1 && y != this.getY() && y != this.getY() - 1) return false;
		if(x != this.getX() + 1 && x != this.getX() && x != this.getX() - 1) return false;
		return true;
    }

	@Override
	public Type getType() {
		return Type.KING;
	}

	@Override
	public List<Move> getAllLegalMoves(Board board) {

		List<Move> KingLegalMoves = new ArrayList<>();
		ChessColor opponentColor = (this.getColor().equals(ChessColor.WHITE)) ? ChessColor.BLACK : ChessColor.WHITE;
		List<Move> opponentsLegalMoves = new ArrayList<>();
		Set<Coordinates> mySet1 = new HashSet<>();
		Set<Coordinates> mySet2 = new HashSet<>();
		List<Coordinates> neighbourOpponents = new ArrayList<>();

		for (Piece piece : board.getPieces(opponentColor)) {
			if (piece.getType().equals(Piece.Type.KING))
				continue;
			opponentsLegalMoves.addAll(piece.getAllLegalMoves(board));
		}
		for (Move move : this.getAllMoves()) {
			for (Piece piece : board.getPieces(opponentColor))
				if (move.getDestination().getX() == piece.getX() && move.getDestination().getY() == piece.getY()) {
					neighbourOpponents.add(piece.getPosition());
				}
		}
		for (Coordinates coor : neighbourOpponents) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i == coor.getX() && j == coor.getY())
						continue;
					if (j != coor.getY() + 1 && j != coor.getY() && j != coor.getY() - 1)
						continue;
					if (i != coor.getX() + 1 && i != coor.getX() && i != coor.getX() - 1)
						continue;
					if ((i == this.getX() && j == this.getY()) || board.getPiece(new Coordinates(i, j)) == null) {
						mySet1.add(new Coordinates(i, j));
					}
				}
			}
		}
		for (Coordinates cor : neighbourOpponents) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i == cor.getX() && j == cor.getY())
						continue;
					if (j != cor.getY() + 1 && j != cor.getY() && j != cor.getY() - 1)
						continue;
					if (i != cor.getX() + 1 && i != cor.getX() && i != cor.getX() - 1)
						continue;
					if (board.getPiece(new Coordinates(i, j)) != null && board.getPiece(new Coordinates(i, j)).getColor().equals(board.getPiece(cor).getColor())) {
						mySet2.add(new Coordinates(i, j));
					}
				}
			}
		}
		for (Move move : this.getAllMoves()) {
			boolean isIntercept = false;
			Piece arrivalCell = board.getPiece(move.getDestination());
			if (arrivalCell == null || opponentColor.equals(arrivalCell.getColor())) {
				for (Move mov : opponentsLegalMoves) {
					if (mov.getDestination().getX() == move.getDestination().getX()
							&& mov.getDestination().getY() == move.getDestination().getY()) {
						isIntercept = true;
						break;
					}
				}
				if (!isIntercept) {
					KingLegalMoves.add(move);
				}
			}
		}
		Set<Move> badMove = new HashSet<>();
		for(Coordinates coord : neighbourOpponents){
			for (Move move : opponentsLegalMoves) {
				if (move.getOrigin().getX() == coord.getX() && move.getOrigin().getY() == coord.getY())
					continue;
				Piece p = board.getPiece(move.getOrigin());
				for (Coordinates cord : mySet1){
					if (move.getDestination().getX() == cord.getX() && move.getDestination().getY() == cord.getY()){
						for (Move mov : p.getAllMoves()) {
							if (mov.getDestination().getX() == coord.getX() && mov.getDestination().getY() == coord.getY()) {
								badMove.add(new Move(new Coordinates(this.getX(), this.getY()), new Coordinates(coord.getX(), coord.getY())));
								break;
							}
						}
					}
				}
			}
			for (Coordinates cord : mySet2){
				if (board.getPiece(cord).isMoveAuthorized(coord.getX(), coord.getY()))
					badMove.add(new Move(new Coordinates(this.getX(), this.getY()), new Coordinates(coord.getX(), coord.getY())));
			}
		}
		List<Move> NewKingLegalMoves = new ArrayList<>();
		int i = 0;
		NewKingLegalMoves.addAll(KingLegalMoves);
		for (Move mov : KingLegalMoves) {
			for (Move move : badMove) {
				if (move.getDestination().getX() == mov.getDestination().getX()
						&& move.getDestination().getY() == mov.getDestination().getY()) {
					NewKingLegalMoves.remove(mov);
				}
			}
		}
		return NewKingLegalMoves;
    }
}
