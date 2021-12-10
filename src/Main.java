import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel boardPanel = new JPanel();
        JPanel consolePanel = new JPanel();


        Vars vars = new Vars();

        Board board = new Board(boardPanel, vars);
        Console console = new Console(consolePanel, vars, board);



        //Standard Code
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(boardPanel);
        frame.getContentPane().add(consolePanel);
        frame.setSize(vars.BOARD_SIZE + vars.CONSOLE_SIZE,vars.BOARD_SIZE + 30 + (vars.TURN_PANEL_SIZE * 2));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.revalidate();




    }

}
