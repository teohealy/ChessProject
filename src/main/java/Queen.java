public class Queen extends ChessPiece{
    public Queen(String color) {
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

        int dx = Math.abs(toLine - line);
        int dy = Math.abs(toColumn - column);

        if (line == toLine || column == toColumn) {
            return new Rook(this.color).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
        } else if (dx == dy) {
            return new Bishop(this.color).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
