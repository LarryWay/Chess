package ChessPieces;

public class Queen extends BasePiece implements DefaultMethods{
    public Queen(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard) {
        super(isWhite);
        super.xPos = xPos;
        super.yPos = yPos;
        super.boolBoard = boolBoard;
        assignPosition(boolBoard);
        assignSprite();
    }

    @Override
    public void assignSprite() {
        if(isWhite){
            pieceSprite = sprites.whiteQueen;
        }else{
            pieceSprite = sprites.blackQueen;
        }
    }

    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;
    }

    @Override
    public int[][] availableEmptySpots() {
        return new int[0][];
    }

    @Override
    public int[][] availableAttacks() {
        return new int[0][];
    }

    @Override
    public int[][] availableMoves() {
        return new int[0][];
    }
}
