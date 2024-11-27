public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn) {
        // Проверка для белой пешки
        if (color.equals("White")) {
            // Движение на одну клетку вперед
            if (toLine == line + 1 && column == toColumn) {
                return chessboard.board[toLine][toColumn] == null; // Проверка, что клетка свободна
            }
            // Движение на две клетки вперед с начальной позиции
            if (line == 1 && toLine == line + 2 && column == toColumn) {
                return chessboard.board[line + 1][column] == null && chessboard.board[toLine][toColumn] == null; // Проверка, что обе клетки свободны
            }
            // Удар по диагонали
            if (toLine == line + 1 && Math.abs(toColumn - column) == 1) {
                return chessboard.board[toLine][toColumn] != null && !chessboard.board[toLine][toColumn].getColor().equals(color); // Проверка, что клетка занята противником
            }
        }
        // Проверка для черной пешки
        else if (color.equals("Black")) {
            // Движение на одну клетку вперед
            if (toLine == line - 1 && column == toColumn) {
                return chessboard.board[toLine][toColumn] == null; // Проверка, что клетка свободна
            }
            // Движение на две клетки вперед с начальной позиции
            if (line == 6 && toLine == line - 2 && column == toColumn) {
                return chessboard.board[line - 1][column] == null && chessboard.board[toLine][toColumn] == null; // Проверка, что обе клетки свободны
            }
            // Удар по диагонали
            if (toLine == line - 1 && Math.abs(toColumn - column) == 1) {
                return chessboard.board[toLine][toColumn] != null && !chessboard.board[toLine][toColumn].getColor().equals(color); // Проверка, что клетка занята противником
            }
        }
        return false;
    }

    @Override
    public String getSymbol(){
        return "p";
    }
}