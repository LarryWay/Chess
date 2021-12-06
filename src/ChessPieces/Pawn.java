package ChessPieces;

public class Pawn extends BasePiece{


    public Pawn(boolean isWhite, int xPos, int yPos, boolean[][] boolBoard){
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
            pieceSprite = sprites.whitePawn;
        }else{
            pieceSprite = sprites.blackPawn;
        }
    }

    @Override
    public void assignPosition(boolean[][] boolBoard) {
        boolBoard[xPos][yPos] = true;
    }

    @Override
    public int[][] availableEmptySpots() {
        int sideInt = isWhite ? -1 : 1;
        int numOfPossiblePos = 0;
        int[][] returnVal;
        int iterate = 1 + pawnRuleInt;


        for(int x = 1 ; x < iterate + 1; x++){
            if (!boolBoard[xPos + (sideInt * x)][yPos]){
                numOfPossiblePos++;
            }else{
                break;
            }
        }

        returnVal = new int[numOfPossiblePos][2];

        for(int x = 0 ; x < numOfPossiblePos ; x++){
            returnVal[x][0] = xPos + (sideInt * x) + sideInt;
            returnVal[x][1] = yPos;
        }

        return returnVal;
    }

    @Override
    public int[][] availableAttacks(){
        int[][] returnVal;
        int numOfAttacks = 0;
        int sideInt = isWhite ? -1 : 1;
        int iterations = 0;

        try{
            if(boolBoard[xPos + sideInt][yPos - 1]){
                numOfAttacks++;
            }
        }catch(Exception e){

        }

        try{
            if (boolBoard[xPos + sideInt][yPos + 1]){
                numOfAttacks++;
            }
        }catch(Exception e){

        }



        returnVal = new int[numOfAttacks][2];

        try{
            if(boolBoard[xPos + sideInt][yPos + 1]){
                returnVal[iterations][0] = xPos + sideInt;
                returnVal[iterations][1] = yPos + 1;
                iterations++;
            }
        }catch(Exception e){

        }

        try{
            if (boolBoard[xPos + sideInt][yPos - 1]){
                returnVal[iterations][0] = xPos + sideInt;
                returnVal[iterations][1] = yPos - 1;
            }
        }catch (Exception e){

        }



        return returnVal;


    }

    @Override
    public int[][] availableMoves() {
        int[][] moveSpots = availableEmptySpots();
        int[][] attackSpots = availableAttacks();
        int length = moveSpots.length + attackSpots.length;
        int[][] returnList = new int[length][];
        int iterations = 0;


        for(int x = 0 ; x < moveSpots.length ; x++){
            returnList[x] = moveSpots[x];
            iterations++;
        }
        for(int x = 0 ; x < attackSpots.length ; x++){
            returnList[x + iterations] = attackSpots[x];
        }



        return returnList;


    }

}
