package ChessPieces;
import java.util.LinkedList;

public class Bishop extends BasePiece{



    public Bishop(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard){
        super(isWhite);
        super.xPos = xPos;
        super.yPos = yPos;
        super.boolBoard = boolBoard;
        pieceName = "Bishop";
        assignPosition(boolBoard);
        assignSprite();

    }


    @Override
    public void assignSprite() {
        if(isWhite){
            pieceSprite = sprites.whiteBishop;
        }else{
            pieceSprite = sprites.blackBishop;
        }

    }

    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;

    }

    @Override
    public int[][] availableEmptySpots() {
        int[][] returnVal;
        LinkedList<Integer> list = new LinkedList<>();
        int returnValLength = 0;


        for(int x = -1 ; x <= 1 ; x += 2){
            for(int y = -1 ; y <= 1 ; y += 2){
                for(int z = 1 ; z < 8 ; z++){
                    try{

                        int xPredict = xPos + (z * x);
                        int yPredict = yPos + (z * y);
                        boolean catchException = boolBoard[xPredict][yPredict];


                        list.add(xPredict);
                        list.add(yPredict);

                        returnValLength++;

                        if (boolBoard[xPredict][yPredict]){
                            break;
                        }
                    }catch(Exception e){

                        break;
                    }

                }
            }
        }

        System.out.println(list.size());



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
