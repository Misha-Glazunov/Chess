public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessboard, int line, int column, int toLine, int toColumn) {
        // Проверка на горизонтальное или вертикальное движение
        if (toLine == line) {
            int step = (toColumn > column) ? 1 : -1;
            for (int col = column + step; col != toColumn; col += step) {
                if (chessboard.board[line][col] != null) {
                    return false; // Есть фигура на пути
                }
            }
            return true; // Движение возможно
        }
        // Проверка на диагональное движение
        else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            int rowStep = (toLine > line) ? 1 : -1;
            int colStep = (toColumn > column) ? 1 : -1;
            int row = line + rowStep;
            int col = column + colStep;

            while (row != toLine && col != toColumn) {
                if (chessboard.board[row][col] != null) {
                    return false; // Есть фигура на пути
                }
                row += rowStep;
                col += colStep;
            }
            return true; // Движение возможно
        }
        // Проверка на вертикальное движение
        else if (toColumn == column) {
            int step = (toLine > line) ? 1 : -1;
            for (int row = line + step; row != toLine; row += step) {
                if (chessboard.board[row][column] != null) {
                    return false; // Есть фигура на пути
                }
            }
            return true; // Движение возможно
        }

        return false; // Движение невозможно
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}