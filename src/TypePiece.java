import ChessPieces.*;
import javax.swing.Icon;
import java.lang.Class;

public class TypePiece {

    Object value;
    Vars vars;
    Sprites sprites;
    Icon sprite;
    boolean hasSprite = false;
    boolean isWhite;

    public TypePiece(Object obj, Vars vars, Sprites sprites){
        this.value = obj;
        this.vars = vars;
        this.sprites = sprites;
        assignSprite();
    }

    public void assignSprite(){
        if(value.getClass() == Pawn.class){
            Pawn temp = (Pawn) value;
            sprite = temp.pieceSprite;
            isWhite = temp.isWhite;
            hasSprite = true;
        }if(value.getClass() == Knight.class){
            Knight temp = (Knight) value;
            sprite = temp.pieceSprite;
            isWhite = temp.isWhite;
            hasSprite = true;
        }if(value.getClass() == Bishop.class){
            Bishop temp = (Bishop) value;
            sprite = temp.pieceSprite;
            isWhite = temp.isWhite;
            hasSprite = true;
        }if(value.getClass() == Queen.class){

        }
    }

    public void updatePosition(int x, int y){
        if(value.getClass() == Pawn.class){
            Pawn temp = (Pawn) value;
            temp.xPos = x;
            temp.yPos = y;
        }
        if (value.getClass() == Knight.class){
            Knight temp = (Knight) value;
            temp.xPos = x;
            temp.yPos = y;
        }
        if(value.getClass() == Bishop.class){
            Bishop temp = (Bishop) value;
            temp.xPos = x;
            temp.yPos = y;
        }
    }

    public int[][] availableSpots(){

        if (value.getClass() == Pawn.class){
            Pawn pawn = (Pawn) value;
            return pawn.availableMoves();
        }
        if(value.getClass() == Knight.class){
            Knight knight = (Knight) value;
            return knight.availableEmptySpots();
        }
        if (value.getClass() == Bishop.class){
            Bishop bishop = (Bishop) value;
            return bishop.availableEmptySpots();
        }
        return null;
    }


    public void displayAvailableSpots(){
        int[][] spots = availableSpots();

        for(int x = 0 ; x < spots.length ; x++){

            if (vars.boolBoard[spots[x][0]][spots[x][1]]){
                if(vars.piecesList[spots[x][0]][spots[x][1]].isWhite == isWhite){
                    continue;
                }
            }

            vars.panelButtons[spots[x][0]][spots[x][1]].setIcon(sprites.spotDot);

        }

    }


}
