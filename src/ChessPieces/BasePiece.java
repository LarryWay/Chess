package ChessPieces;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.Icon;

public abstract class BasePiece implements DefaultMethods{

    Sprites sprites = new Sprites();
    public Icon pieceSprite;
    public boolean isWhite;
    public int xPos;
    public int yPos;
    boolean[][] boolBoard;

    public BasePiece(boolean isWhite){
        this.isWhite = isWhite;
    }

    public int[][] convertLinkedList(LinkedList<Integer> list){
        int[][] returnVal = new int[list.size() / 2][2];
        for(int x = 0 ; x < list.size() / 2; x++){
            returnVal[x][0] = (int) (list.get(x * 2));
            returnVal[x][1] = (int) (list.get(x * 2 + 1));
            //System.out.println((int) list.get(x * 2) + " " + (int) list.get(x * 2 + 1));
        }

        return returnVal;
    }



}
