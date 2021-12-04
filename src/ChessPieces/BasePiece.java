package ChessPieces;

import javax.swing.ImageIcon;
import javax.swing.Icon;

public class BasePiece{

    Sprites sprites = new Sprites();
    public Icon pieceSprite;
    public boolean isWhite;
    public int xPos;
    public int yPos;
    boolean[][] boolBoard;

    public BasePiece(boolean isWhite){
        this.isWhite = isWhite;
    }

}
