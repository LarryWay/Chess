import ChessPieces.*;
import javax.swing.Icon;
import java.lang.Class;

public class TypePiece {

    BasePiece value;
    Vars vars;
    Sprites sprites;
    Icon sprite;
    boolean hasSprite = false;
    boolean isWhite;

    public TypePiece(BasePiece obj, Vars vars, Sprites sprites){
        this.value = obj;
        this.vars = vars;
        this.sprites = sprites;
        assignSprite();
    }

    public void assignSprite(){
        sprite = value.pieceSprite;
        isWhite = value.isWhite;
        hasSprite = true;

    }

    public void updatePosition(int x, int y){

        value.xPos = x;
        value.yPos = y;
    }

    public int[][] availableSpots(){

        return value.availableMoves();

    }

    public void updatePawnInt(){
        value.pawnRuleInt = 0;
    }


    public void displayAvailableSpots(){
        int[][] spots = value.availableMoves();
        int sideInt = isWhite ? 0 : 1;

        if(vars.turn % 2 == sideInt){

            for(int x = 0 ; x < spots.length ; x++){
                if (vars.boolBoard[spots[x][0]][spots[x][1]]){
                    if(vars.piecesList[spots[x][0]][spots[x][1]].isWhite == isWhite){
                        continue;
                    }
                }
                vars.panelButtons[spots[x][0]][spots[x][1]].setIcon(sprites.spotDot);
            }

        }else{
            System.out.println("Not your turn");
        }


    }


}
