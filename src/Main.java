import ChessPieces.Sprites;
import ChessPieces.*;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Sprites sprites = new Sprites();
        Vars vars = new Vars();
        Board board = new Board(frame, vars);


        //Standard Code
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(vars.BOARD_SIZE,vars.BOARD_SIZE + 30);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.revalidate();




    }

}
