import ChessPieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Board {

    Sprites sprites = new Sprites();
    Vars vars;
    JPanel panel;
    Console console;


    public Board(JPanel panel, Vars vars){
        this.panel = panel;
        this.vars = vars;
        this.panel.setBounds(0, vars.TURN_PANEL_SIZE, vars.BOARD_SIZE, vars.BOARD_SIZE + 30);
        this.panel.setLayout(null);

        setBoardSquares();
        placingBoardPieces();
        addPanelsToJFrame();

    }

    public void setBoardSquares(){
        int countSquares = 0;

        for(int x = 0 ; x < vars.boardPanels.length ; x++){
            for(int y = 0 ; y < vars.boardPanels[0].length ; y++){
                vars.boardPanels[x][y] = new JPanel();
                vars.boardPanels[x][y].setLayout(null);
                JButton button = new JButton();
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.setBounds(0,0,vars.SPOT_SIZE, vars.SPOT_SIZE);

                if ((countSquares + x) % 2 == 0){
                    vars.boardPanels[x][y].setBackground(Color.WHITE);
                    button.setBackground(Color.WHITE);
                }else if ((countSquares + x) % 2 == 1){
                    vars.boardPanels[x][y].setBackground(Color.DARK_GRAY);
                    button.setBackground(Color.DARK_GRAY);
                }


                vars.boardPanels[x][y].add(button);

                vars.panelButtons[x][y] = button;
                setUpButton(button);

                countSquares++;
            }
        }
    }

    public void setUpButton(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] pos = getPosClicked(button);
                JButton button = vars.panelButtons[pos[0]][pos[1]];

                if(button.getIcon() == null){

                }else if(button.getIcon() == sprites.spotDot){
                    TypePiece temp = vars.piecesList[pos[0]][pos[1]];
                    //can be used to store pieces that get collected, but for now has no use

                    if (vars.boolBoard[pos[0]][pos[1]]){
                        vars.piecesList[pos[0]][pos[1]] = null;
                        vars.boolBoard[pos[0]][pos[1]] = false;
                    }

                    vars.piecesList[vars.selectedPiecePos[0]][vars.selectedPiecePos[1]] = null;

                    vars.selectedPiece.updatePawnInt();

                    vars.piecesList[pos[0]][pos[1]] = vars.selectedPiece;
                    vars.selectedPiece = null; vars.selectedPiecePos = null;
                    vars.turn++;

                    console.displayPlayerTurn();

                    clearSelectSpots();
                    update();

                }else{
                    clearSelectSpots();
                    vars.piecesList[pos[0]][pos[1]].displayAvailableSpots();
                    vars.selectedPiece = vars.piecesList[pos[0]][pos[1]];
                    vars.selectedPiecePos = pos;
                }

            }
        });
    }

    private int[] getPosClicked(JButton button){
        int[] returnList = new int[2];

        for(int x = 0 ; x < vars.panelButtons.length; x++){
            for(int y = 0 ; y < vars.panelButtons[0].length; y++){
                if (vars.panelButtons[x][y] == button){
                    returnList[0] = x;
                    returnList[1] = y;
                }
            }
        }

        return returnList;
    }

    public void addPanelsToJFrame(){

        for(int x = 0 ; x < vars.boardPanels.length ; x++){
            for(int y = 0 ; y < vars.boardPanels.length ; y++){
                panel.add(vars.boardPanels[x][y]);
                vars.boardPanels[x][y].setBounds(y * vars.SPOT_SIZE, x * vars.SPOT_SIZE , vars.SPOT_SIZE, vars.SPOT_SIZE);
            }
        }
    }


    public void clearSelectSpots(){
        for(int x = 0 ; x < vars.panelButtons.length ; x++){
            for(int y = 0 ; y < vars.panelButtons[x].length ; y++){
                if (vars.piecesList[x][y] == null){
                    vars.panelButtons[x][y].setIcon(null);
                }
            }
        }
    }

    public void update(){
        for(int x = 0 ; x < vars.panelButtons.length ; x++){
            for(int y = 0 ; y < vars.panelButtons[x].length ; y++){
                if (vars.piecesList[x][y] != null){
                    vars.panelButtons[x][y].setIcon(vars.piecesList[x][y].sprite);
                    vars.piecesList[x][y].updatePosition(x,y);
                    vars.boolBoard[x][y] = true;
                }else{
                    vars.boolBoard[x][y] = false;
                }
            }
        }
    }


    public void placingBoardPieces(){
        for(int y = 0 ; y < vars.pawns.length / 2 ; y++){
            vars.piecesList[6][y] = new TypePiece( new Pawn(true,6, y, vars.boolBoard), vars, sprites);
        }
        for (int y = 0 ; y < (vars.pawns.length) - (vars.pawns.length / 2); y++){
            vars.piecesList[1][y] = new TypePiece(new Pawn(false, 1, y, vars.boolBoard), vars, sprites);
        }

        vars.piecesList[0][1] = new TypePiece(new Knight(false, 0, 1, vars.boolBoard), vars, sprites);
        vars.piecesList[0][6] = new TypePiece(new Knight(false, 0, 6, vars.boolBoard), vars, sprites);
        vars.piecesList[7][1] = new TypePiece(new Knight(true, 7, 1, vars.boolBoard), vars, sprites);
        vars.piecesList[7][6] = new TypePiece(new Knight(true, 7, 6, vars.boolBoard), vars, sprites);
        vars.piecesList[7][2] = new TypePiece(new Bishop(true,7,2, vars.boolBoard), vars, sprites);
        vars.piecesList[7][5] = new TypePiece(new Bishop(true,7,2, vars.boolBoard), vars, sprites);
        vars.piecesList[0][2] = new TypePiece(new Bishop(false,7,2, vars.boolBoard), vars, sprites);
        vars.piecesList[0][5] = new TypePiece(new Bishop(false,7,2, vars.boolBoard), vars, sprites);
        vars.piecesList[0][4] = new TypePiece(new King(false, 0, 4, vars.boolBoard), vars, sprites);
        vars.piecesList[7][4] = new TypePiece(new King(true, 7, 4, vars.boolBoard), vars, sprites);
        vars.piecesList[0][0] = new TypePiece(new Rook(false, 0, 0, vars.boolBoard), vars, sprites);
        vars.piecesList[0][7] = new TypePiece(new Rook(false, 0, 7, vars.boolBoard), vars, sprites);
        vars.piecesList[7][0] = new TypePiece(new Rook(true, 7, 0, vars.boolBoard), vars, sprites);
        vars.piecesList[7][7] = new TypePiece(new Rook(true, 7, 7, vars.boolBoard), vars, sprites);
        vars.piecesList[0][3] = new TypePiece(new Queen(false,0,3,vars.boolBoard), vars, sprites);
        vars.piecesList[7][3] = new TypePiece(new Queen(true,7,3,vars.boolBoard), vars, sprites);

        update();

    }

    public void resetBoard(){

        vars.turn = 0;

        for(int x = 0 ; x < vars.piecesList.length ; x++){
            for(int y = 0; y < vars.piecesList.length ; y++){

                vars.piecesList[x][y] = null;

            }
        }

        placingBoardPieces();
        update();
        clearSelectSpots();
    }

    public void assignConsole(Console console){
        this.console = console;

    }


}
