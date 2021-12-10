package ChessPieces;
import java.util.LinkedList;

public class Queen extends BasePiece{
    public Queen(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard) {
        super(isWhite);
        super.xPos = xPos;
        super.yPos = yPos;
        super.boolBoard = boolBoard;
        pieceName = "Queen";
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
        LinkedList<Integer> list = new LinkedList<>();


        Rook rookTemp = new Rook(isWhite, xPos, yPos, boolBoard);
        Bishop bishopTemp = new Bishop(isWhite, xPos, yPos, boolBoard);

        int[][] rookPredict = rookTemp.availableMoves();
        int[][] bishopPredict = bishopTemp.availableMoves();

        for(int x = 0 ; x < rookPredict.length ; x++){
            list.add(rookPredict[x][0]);
            list.add(rookPredict[x][1]);
        }

        for(int x = 0 ; x < bishopPredict.length ; x++){
            list.add(bishopPredict[x][0]);
            list.add(bishopPredict[x][1]);
        }


        return convertLinkedList(list);
    }

    @Override
    public int[][] availableAttacks() {
        return new int[0][];
    }

    @Override
    public int[][] availableMoves() {
        return availableEmptySpots();
    }
}
