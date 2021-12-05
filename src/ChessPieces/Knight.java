package ChessPieces;
import java.util.LinkedList;

public class Knight extends BasePiece{


    public Knight(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard) {
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
            pieceSprite = sprites.whiteKnight;
        }else{
            pieceSprite = sprites.blackKnight;
        }
    }

    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;

    }


    @Override
    public int[][] availableEmptySpots() {

        int[][] returnVal = new int[2][2];
        int returnValLength = 0;
        LinkedList<Integer> list= new LinkedList<>();

        for(int x = -1 ; x <= 1 ; x += 2){

            for(int y = 1 ; y >= -1 ; y -= 2){

                int offSet = 0;

                for(int z = 0 ; z < 2 ; z++){

                    int xPredict = xPos + x;
                    int yPredict = yPos + y;

                    if(offSet == 0){
                        xPredict += x;
                        offSet++;
                    }else if (offSet == 1){
                        yPredict += y;
                        offSet++;
                    }


                    try{
                        if (!boolBoard[xPredict][yPredict] || boolBoard[xPredict][yPredict]){
                            list.add(xPredict);
                            list.add(yPredict);
                            returnValLength++;
                        }
                    }catch (Exception e){

                    }
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
