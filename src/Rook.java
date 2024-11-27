public class Rook  extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn) {
        if ((toColumn - column != 0) && (toLine - line == 0)) {
            if (toColumn > column) {
                column += 1;
            } else {
                column -= 1;
            }
            do {
                if (chessboard.board[line][column] != null) {
                    return false;
                }
                if (toColumn > column) {
                    column += 1;
                } else {
                    column -= 1;
                }
            } while (toColumn - column != 0);
            if (chessboard.board[line][column] != null) {
                if (chessboard.board[line][column].getColor() == chessboard.nowPlayerColor()) {
                    return false;
                }
            } else {
                return true;
            }
        } else if ((toLine - line != 0) && (toColumn - column == 0)) {
            if (toLine > line) {
                line += 1;
            } else {
                line -= 1;
            }
            do {
                if (chessboard.board[line][column] != null) {
                    return false;
                }
                if (toLine > line) {
                    line += 1;
                } else {
                    line -= 1;
                }
            } while (toLine - line != 0);
            if (chessboard.board[line][column] != null) {
                if (chessboard.board[line][column].getColor() == chessboard.nowPlayerColor()) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}