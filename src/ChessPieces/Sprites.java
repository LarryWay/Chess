package ChessPieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sprites {

    ImageIcon whiteKing;
    ImageIcon blackKing;

    ImageIcon whiteBishop;
    ImageIcon blackBishop;

    ImageIcon whiteRook;
    ImageIcon blackRook;

    ImageIcon whiteKnight;
    ImageIcon blackKnight;

    ImageIcon whitePawn;
    ImageIcon blackPawn;

    ImageIcon whiteQueen;
    ImageIcon blackQueen;

    public ImageIcon spotDot;

    ImageIcon[] whitePieces = new ImageIcon[]{whiteKing, whiteBishop, whiteRook, whiteKnight, whitePawn, whiteQueen};
    ImageIcon[] blackPieces = new ImageIcon[]{blackKing, blackBishop, blackRook, blackKnight, blackPawn, blackQueen};


    public void setSize(){
        BufferedImage bufferedWhiteKing = null;
        BufferedImage bufferedBlackKing = null;

        BufferedImage bufferedWhiteBishop = null;
        BufferedImage bufferedBlackBishop = null;

        BufferedImage bufferedWhiteRook = null;
        BufferedImage bufferedBlackRook = null;

        BufferedImage bufferedWhiteKnight = null;
        BufferedImage bufferedBlackKnight = null;

        BufferedImage bufferedWhiteQueen= null;
        BufferedImage bufferedBlackQueen = null;

        BufferedImage bufferedWhitePawn = null;
        BufferedImage bufferedBlackPawn = null;

        BufferedImage bufferedSpotDot = null;



        try{
            bufferedWhiteKing = ImageIO.read(new File("src/Sprites/White/WhiteKing.png"));
            bufferedBlackKing = ImageIO.read(new File("src/Sprites/Black/BlackKing.png"));

            bufferedWhiteBishop = ImageIO.read(new File("src/Sprites/White/WhiteBishop.png"));
            bufferedBlackBishop = ImageIO.read(new File("src/Sprites/Black/BlackBishop.png"));

            bufferedWhiteRook = ImageIO.read(new File("src/Sprites/White/WhiteRook.png"));
            bufferedBlackRook = ImageIO.read(new File("src/Sprites/Black/BlackRook.png"));

            bufferedWhiteQueen = ImageIO.read(new File("src/Sprites/White/WhiteQueen.png"));
            bufferedBlackQueen = ImageIO.read(new File("src/Sprites/Black/BlackQueen.png"));

            bufferedWhiteKnight = ImageIO.read(new File("src/Sprites/White/WhiteKnight.png"));
            bufferedBlackKnight = ImageIO.read(new File("src/Sprites/Black/BlackKnight.png"));

            bufferedWhitePawn = ImageIO.read(new File("src/Sprites/White/WhitePawn.png"));
            bufferedBlackPawn = ImageIO.read(new File("src/Sprites/Black/BlackPawn.png"));

            bufferedSpotDot = ImageIO.read(new File("src/Sprites/Gradient.png"));

        }catch (Exception e){
            e.printStackTrace();
        }

        BufferedImage[] bufferedWhiteImageList = new BufferedImage[]{bufferedWhiteKing, bufferedWhiteBishop, bufferedWhiteRook, bufferedWhiteKnight, bufferedWhitePawn, bufferedWhiteQueen};
        BufferedImage[] bufferedBlackImageList = new BufferedImage[]{bufferedBlackKing, bufferedBlackBishop, bufferedBlackRook, bufferedBlackKnight, bufferedBlackPawn, bufferedBlackQueen};

        for (int x = 0 ; x < bufferedWhiteImageList.length; x++) {
            whitePieces[x] = new ImageIcon(bufferedWhiteImageList[x].getScaledInstance(90,90,Image.SCALE_SMOOTH));
            blackPieces[x] = new ImageIcon(bufferedBlackImageList[x].getScaledInstance(90,90,Image.SCALE_SMOOTH));
        }


        whiteKing = whitePieces[0];
        whiteBishop = whitePieces[1];
        whiteRook = whitePieces[2];
        whiteKnight = whitePieces[3];
        whitePawn = whitePieces[4];
        whiteQueen = whitePieces[5];

        blackKing = blackPieces[0];
        blackBishop = blackPieces[1];
        blackRook = blackPieces[2];
        blackKnight = blackPieces[3];
        blackPawn = blackPieces[4];
        blackQueen = blackPieces[5];

        this.spotDot = new ImageIcon(bufferedSpotDot.getScaledInstance(40,40,Image.SCALE_SMOOTH));


    }


    public Sprites(){
        setSize();
    }


}
