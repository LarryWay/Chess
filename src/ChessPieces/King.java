package ChessPieces;
import java.util.LinkedList;

public class King extends BasePiece implements DefaultMethods{


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
        returnVal = new int[list.size()][2];
        for(int x = 0 ; x < list.size() / 2; x++){
            returnVal[x][0] = (list.get(x * 2));
            returnVal[x][1] = (list.get(x * 2 + 1));
            System.out.println((int) list.get(x * 2) + " " + (int) list.get(x * 2 + 1));
            System.out.println(returnVal[x][0] + " - " + returnVal[x][1]);
        }

        return returnVal;
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
