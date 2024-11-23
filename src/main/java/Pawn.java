public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    public String getColor(){
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int direction = this.color.equals("White") ? 1 : -1;
        int startLine = this.color.equals("White") ? 1 : 6;

        if (column == toColumn) {
            if (line + direction == toLine && chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
            if (line == startLine && line + 2 * direction == toLine &&
                    chessBoard.board[line + direction][column] == null &&
                    chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
        }

        if (Math.abs(column - toColumn) == 1 && line + direction == toLine &&
                chessBoard.board[toLine][toColumn] != null &&
                !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
