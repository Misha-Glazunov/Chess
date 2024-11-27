public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn){
        if (((toLine - line) == (toColumn - column)) && (toLine != line)) {
            if (toColumn > column) {
                column += 1;
                line += 1;
            } else {
                column -= 1;
                line -= 1;
            }
            do {
                if (chessboard.board[line][column] != null) {
                    return false;
                }
                if (toColumn > column) {
                    column += 1;
                    line += 1;
                } else {
                    column -= 1;
                    line -= 1;
                }
            } while (toColumn - column != 0);
            if (chessboard.board[line][column] != null) {
                if (chessboard.board[line][column].getColor() == chessboard.nowPlayerColor()) {
                    return false;
                }
            } return true;
        } else if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) && (toLine - line != 0)) {
            if (toLine > line) {
                line += 1;
                column -= 1;
            } else {
                line -= 1;
                column += 1;
            }
            do {
                if (chessboard.board[line][column] != null) {
                    return false;
                }
                if (toColumn > column) {
                    column += 1;
                    line -= 1;
                } else {
                    column -= 1;
                    line += 1;
                }
            } while (toColumn - column != 0);
            if (chessboard.board[line][column] != null) {
                if (chessboard.board[line][column].getColor() == chessboard.nowPlayerColor()) {
                    return false;
                }
            } return true;
        } return false;
    }

    @Override
    public String getSymbol(){
        return "B";
    }
}