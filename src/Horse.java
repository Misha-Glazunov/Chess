public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn){
        if ((Math.abs(toLine - line) != 0) && (Math.abs(toColumn - column) != 0) && (Math.abs(toLine - line) + Math.abs(toColumn - column) == 3)) {
            if (chessboard.board[toLine][toColumn] != null) {
                if (chessboard.board[toLine][toColumn].getColor() == chessboard.nowPlayerColor()){
                    return false;
                }
            } return true;
        } else {
            return false;
        }
    }


    @Override
    public String getSymbol(){
        return "H";
    }
}