/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import javax.swing.JPanel;
import DataGui.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

/**
 *
 * @author Asus
 */
public class ScrabblePanel extends JPanel implements Observer {

    public static BufferedImage getA() {
        return a;
    }

    public static BufferedImage getB() {
        return b;
    }

    public static BufferedImage getC() {
        return c;
    }

    public static BufferedImage getD() {
        return d;
    }

    public static BufferedImage getE() {
        return e;
    }

    public static BufferedImage getF() {
        return f;
    }

    public static BufferedImage getG() {
        return g;
    }

    public static BufferedImage getH() {
        return h;
    }

    public static BufferedImage getI() {
        return i;
    }

    public static BufferedImage getJ() {
        return j;
    }

    public static BufferedImage getK() {
        return k;
    }

    public static BufferedImage getL() {
        return l;
    }

    public static BufferedImage getM() {
        return m;
    }

    public static BufferedImage getN() {
        return n;
    }

    public static BufferedImage getO() {
        return o;
    }

    public static BufferedImage getP() {
        return p;
    }

    public static BufferedImage getQ() {
        return q;
    }

    public static BufferedImage getR() {
        return r;
    }

    public static BufferedImage getS() {
        return s;
    }

    public static BufferedImage getT() {
        return t;
    }

    public static BufferedImage getU() {
        return u;
    }

    public static BufferedImage getV() {
        return v;
    }

    public static BufferedImage getW() {
        return w;
    }

    public static BufferedImage getXx() {
        return x;
    }

    public static BufferedImage getYy() {
        return y;
    }

    public static BufferedImage getZ() {
        return z;
    }

    private ObservableGame observablegame;
    //  private int serieactual;

    
    private static BufferedImage intro;
    private static BufferedImage board;
    private static BufferedImage a;
    private static BufferedImage b;
    private static BufferedImage c;
    private static BufferedImage d;
    private static BufferedImage e;
    private static BufferedImage f;
    private static BufferedImage g;
    private static BufferedImage h;
    private static BufferedImage i;
    private static BufferedImage j;
    private static BufferedImage k;
    private static BufferedImage l;
    private static BufferedImage m;
    private static BufferedImage n;
    private static BufferedImage o;
    private static BufferedImage p;
    private static BufferedImage q;
    private static BufferedImage r;
    private static BufferedImage s;
    private static BufferedImage t;
    private static BufferedImage u;
    private static BufferedImage v;
    private static BufferedImage w;
    private static BufferedImage x;
    private static BufferedImage y;
     private static BufferedImage z;
    private AwaitBeginningPanel awaitbeginningpanel;
    private AwaitDrawTilePanel awaitdrawtilepanel;
    private AwaitFirstPlayPanel awaitfirstpanel;
    private AwaitPlayPanel awaitplaypanel;
    
    public ScrabblePanel(ObservableGame obgame) {

        this.observablegame = obgame;
        this.observablegame.addObserver(this);

        setup();
        setupLayout();
        update(obgame, null);

    }

    static {
        try {
       
            intro = ImageIO.read(Resources.getResourceFile("images/intro.jpg"));
            board = ImageIO.read(Resources.getResourceFile("images/board.jpg"));
            a = ImageIO.read(Resources.getResourceFile("images/A.jpg"));
            b = ImageIO.read(Resources.getResourceFile("images/B.jpg"));
            c = ImageIO.read(Resources.getResourceFile("images/C.jpg"));
            d = ImageIO.read(Resources.getResourceFile("images/D.jpg"));
            e = ImageIO.read(Resources.getResourceFile("images/E.jpg"));
            f = ImageIO.read(Resources.getResourceFile("images/F.jpg"));
            g = ImageIO.read(Resources.getResourceFile("images/G.jpg"));
            h = ImageIO.read(Resources.getResourceFile("images/H.jpg"));
            i = ImageIO.read(Resources.getResourceFile("images/I.jpg"));
            j = ImageIO.read(Resources.getResourceFile("images/J.jpg"));
            k = ImageIO.read(Resources.getResourceFile("images/K.jpg"));
            l = ImageIO.read(Resources.getResourceFile("images/L.jpg"));
            m = ImageIO.read(Resources.getResourceFile("images/M.jpg"));
            n = ImageIO.read(Resources.getResourceFile("images/N.jpg"));
            o = ImageIO.read(Resources.getResourceFile("images/O.jpg"));
            p = ImageIO.read(Resources.getResourceFile("images/P.jpg"));
            q = ImageIO.read(Resources.getResourceFile("images/Q.jpg"));
            r = ImageIO.read(Resources.getResourceFile("images/R.jpg"));
            s = ImageIO.read(Resources.getResourceFile("images/S.jpg"));
            
            t = ImageIO.read(Resources.getResourceFile("images/T.jpg"));
            u = ImageIO.read(Resources.getResourceFile("images/U.jpg"));
            v = ImageIO.read(Resources.getResourceFile("images/V.jpg"));
            w = ImageIO.read(Resources.getResourceFile("images/W.jpg"));
            x = ImageIO.read(Resources.getResourceFile("images/X.jpg"));
            y = ImageIO.read(Resources.getResourceFile("images/Y.jpg"));
            z = ImageIO.read(Resources.getResourceFile("images/Z.jpg"));
           
            
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    
    public static BufferedImage getIntro() {
        return intro;
    }

    public static BufferedImage getBoard() {
        return board;
    }


    private void setup() {
        awaitbeginningpanel = new AwaitBeginningPanel(observablegame);
       
        awaitfirstpanel = new AwaitFirstPlayPanel(observablegame);
        awaitdrawtilepanel = new AwaitDrawTilePanel(observablegame);
        awaitplaypanel = new AwaitPlayPanel(observablegame) ; 

    }

    private void setupLayout() {
        JPanel center = new JPanel();
        center.add(awaitbeginningpanel);
        center.add(awaitfirstpanel);
       center.add(awaitdrawtilepanel);
       center.add(awaitplaypanel);
        add(center,BOTTOM_ALIGNMENT);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    public ObservableGame getObservablegame() {
        return observablegame;
    }

    public AwaitBeginningPanel getAwaitbeginningpanel() {
        return awaitbeginningpanel;
    }

   

    public AwaitFirstPlayPanel getAwaitfirstpanel() {
        return awaitfirstpanel;
    }

}
