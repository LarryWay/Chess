import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Console{

    JPanel panel;
    Vars vars;
    Board board;

    JButton resetButton;
    JButton helpButton;

    JPanel displayPanel;
    JPanel helpPanel;

    LinkedList<String> storedText = new LinkedList<>();

    final int buttonsGap = 50;
    final int panelLines = 25;

    int HEIGHT;
    int WIDTH;

    public Console(JPanel panel, Vars vars, Board board){
        this.panel = panel;
        this.vars = vars;
        this.board = board;

        this.HEIGHT = vars.BOARD_SIZE + (vars.TURN_PANEL_SIZE * 2);
        this.WIDTH = vars.CONSOLE_SIZE;

        setPanel();




    }


    public void setPanel(){
        displayPanel = new JPanel();
        resetButton = new JButton();
        helpButton = new JButton();
        helpPanel = new JPanel();


        board.assignConsole(this);
        panel.setLayout(null);
        panel.setBounds(vars.BOARD_SIZE, 0, this.WIDTH, this.HEIGHT);
        panel.setBackground(Color.BLACK);

        setupResetButton(resetButton);
        setupTextBox(displayPanel);
        setupHelpButton();
        setupHelpPanel();

        panel.add(helpPanel);
        panel.add(helpButton);
        panel.add(resetButton);
        panel.add(displayPanel);




    }

    public void setupHelpButton(){
        final int BUTTON_WIDTH = 50;
        final int BUTTON_HEIGHT = 50;


        helpButton.setBounds(WIDTH - (BUTTON_WIDTH), HEIGHT - (BUTTON_HEIGHT) , BUTTON_WIDTH, BUTTON_HEIGHT);
        helpButton.setText("?");

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                helpPanel.setVisible(true);

            }
        });

    }


    public void setupHelpPanel(){
        final int PANEL_WIDTH = vars.CONSOLE_SIZE - 30;
        final int PANEL_HEIGHT = this.HEIGHT - 30;

        JButton exitButton = new JButton();
        exitButton.setBounds(PANEL_WIDTH, PANEL_HEIGHT, 30, 30);
        exitButton.setText("X");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpPanel.setVisible(false);
            }
        });

        helpPanel.setVisible(false);
        helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));

        helpPanel.setBounds((this.WIDTH - PANEL_WIDTH) / 2, (this.HEIGHT - PANEL_HEIGHT) / 2, PANEL_WIDTH, PANEL_HEIGHT);

        helpPanel.add(new JLabel("Instructions"));
        helpPanel.add(new JLabel("Yeah no I'm too lazy to type out the"));
        helpPanel.add(new JLabel("instructions of chess"));




        helpPanel.setBackground(Color.LIGHT_GRAY);
        helpPanel.add(exitButton);



    }

    public void setupResetButton(JButton button){
        final int WIDTH = 200;
        final int HEIGHT = 30;
        button.setBounds((vars.CONSOLE_SIZE - WIDTH) / 2, buttonsGap, WIDTH, HEIGHT);
        button.setText("RESET");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                board.resetBoard();

            }
        });




    }

    public void setupTextBox(JPanel panel){
        final int HEIGHT = 400;
        final int WIDTH = 250;


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds((this.WIDTH - WIDTH) / 2, buttonsGap * 3 , WIDTH, HEIGHT);

    }


    public void shiftTextBox(int numOfRows){

        displayPanel.removeAll();

        for(int x = 0 ; x < numOfRows ; x++){
            displayPanel.add(new JLabel(storedText.get(storedText.size() - numOfRows + x)));
        }


    }

    public void addConsoleText(String words){
        storedText.add(words);

        if(storedText.size() > panelLines){
            shiftTextBox(panelLines);
        }else{
            displayPanel.add(new JLabel(words));
        }

        //does nothing for now

    }


    public void displayPlayerTurn(){
        if(vars.turn % 2 == 0){
            addConsoleText("White Side's Turn");
        }else{
            addConsoleText("Black Side's Turn");
        }
    }



}