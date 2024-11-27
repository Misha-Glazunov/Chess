public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }
    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn){
        if (((Math.abs(toColumn - column) <= 1) || (Math.abs(toLine - line) <= 1)) && ((toLine != line) || ( toColumn != column))){
            if (isUnderAttack(chessboard, toLine, toColumn)) {
                return false;
            }
        }
        else {
            return true;
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board.board[i][j] != null){
                    if (board.board[i][j].getColor() != board.nowPlayerColor()){
                        if (board.board[i][j].canMoveToPosition (board, i,j,line,column)) {
                            System.out.println("Шах");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol(){
        return "K";
    }
}