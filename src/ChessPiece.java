public abstract class ChessPiece {
    public String color;
    private String symbol;
    public boolean check1 = true;
    public boolean check2 = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else {
            if (chessBoard.nowPlayer.equals(chessBoard.board[toLine][toColumn].getColor())) {
                return false;
            } else {
                return true;
            }
        }
    }

    public String getSymbol() {
        return symbol;
    }
}