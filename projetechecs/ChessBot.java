
public class ChessBot extends Player{
    ChessUI ui;
    public ChessBot(ChessUI ui, ChessColor color){
        super(color);
        this.ui = ui;
    }

    @Override
    public Move getMove() {
        return ui.waitForPlayerMove();
    }

}

