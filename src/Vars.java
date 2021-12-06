import javax.swing.*;
import ChessPieces.*;

public class Vars {

    JPanel[][] boardPanels = new JPanel[8][8];
    JButton[][] panelButtons = new JButton[8][8];
    boolean[][] boolBoard = new boolean[8][8];

    TypePiece[][] piecesList = new TypePiece[8][8];

    Pawn[] pawns = new Pawn[16];

    boolean isPieceSelected = false;
    TypePiece selectedPiece;
    int[] selectedPiecePos;

    int turn = 0;



    final int SPOT_SIZE = 90;
    final int BOARD_SIZE = SPOT_SIZE * 8;





}
