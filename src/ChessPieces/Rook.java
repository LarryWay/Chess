package ChessPieces;
import java.util.LinkedList;

public class Rook extends BasePiece {

    public Rook(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard) {
        super(isWhite);
        super.xPos = xPos;
        super.yPos = yPos;
        super.boolBoard = boolBoard;
        assignPosition(boolBoard);
        assignSprite();
    }



    @Override
    public void assignSprite(){
        if(isWhite){
            pieceSprite = sprites.whiteRook;
        }else{
            pieceSprite = sprites.blackRook;
        }
    }



    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;

    }



    @Override
    public int[][] availableEmptySpots() {
        LinkedList<Integer> list = new LinkedList<>();

        for(int z = -1 ; z <= 1 ; z += 2){
            for(int y = 1 ; y < 8 ; y++){
                int yPredict = yPos + (y * z);

                try{
                    boolean checkException = boolBoard[xPos][yPredict];

                    list.add(xPos);
                    list.add(yPredict);

                    if(checkException){
                        break;
                    }
                }catch(Exception e){
                    break;
                }
            }

            for(int x = 1 ; x < 8 ; x++){
                int xPredict = xPos + (x * z);

                try{
                    boolean checkException = boolBoard[xPredict][yPos];

                    list.add(xPredict);
                    list.add(yPos);

                    if(checkException){
                        break;
                    }
                }catch(Exception e){
                    break;
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
