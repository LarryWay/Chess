package ChessPieces;
import java.util.LinkedList;

public class King extends BasePiece{


    public King(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard){
        super(isWhite);
        super.xPos = xPos;
        super.yPos = yPos;
        super.boolBoard = boolBoard;
        assignPosition(boolBoard);
        assignSprite();
    }


    @Override
    public void assignSprite() {
        if (isWhite){
            pieceSprite = sprites.whiteKing;
        }else{
            pieceSprite = sprites.blackKing;
        }
    }

    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;

    }

    @Override
    public int[][] availableEmptySpots() {
        int[][] returnVal;
        int returnValLength = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for(int x = -1 ; x <= 1 ; x++){
            for(int y = -1; y <= 1 ; y++){
                int xPredict = xPos + x;
                int yPredict = yPos + y;

                try{
                    boolean checkException = boolBoard[xPredict][yPredict];
                    returnValLength++;
                    //System.out.println(xPredict + " " + yPredict);
                    list.add(xPredict);
                    list.add(yPredict);
                }catch(Exception e){
                    //System.out.println("Out of bounds");
                }
            }
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
