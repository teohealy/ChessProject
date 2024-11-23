public class King extends ChessPiece{

    public King(String color) {
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

        if ((dx <= 1 && dy <= 1) && !isUnderAttack(chessBoard, toLine, toColumn)) {
            return true;
        }

        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
