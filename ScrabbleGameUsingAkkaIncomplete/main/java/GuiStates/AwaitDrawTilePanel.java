package GuiStates;

import DataStates.AwaitDrawTile;
import DataGui.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class AwaitDrawTilePanel extends JPanel implements Observer {

    private ObservableGame game;
    private JButton actual;
    private JButton[] playerrack = new JButton[7];
    private String temp = " " ;
    public AwaitDrawTilePanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        setup();
        setLayout();

        update(game, this);

    }

    private void setup() {
        setOpaque(false);
        actual = new JButton("show");
        actual.addActionListener(new ShowState());

    }

    private void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1920, 1080));
Box box = Box.createHorizontalBox();
box.add(actual);

        add(box);
    }

    @Override
    public void update(Observable o, Object arg) {

        setVisible(game.getState() instanceof AwaitDrawTile);
temp = new String();
        if (game.getState() instanceof AwaitDrawTile) {


                    for(int i = 0 ; i< game.getGameData().getPlayer().getYourRacktempo().size(); i++)
              {
               temp  += game.getGameData().getPlayer().getYourRacktempo().get(i).getLetter();
                 
              }           
       
      game.getGameData().actorsendmessage();
     temp = new String();
              }

        repaint();
    }
    

    class ShowState implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         
            game.draw();

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();

        super.paintComponent(g);

        g.drawImage(ScrabblePanel.getBoard(), 1, 1, getWidth() - 400, getHeight() - 200, this);

if( game.getGameData().getGame().getNum() != 0)
     
for( int i = 0 ; i< game.getGameData().getGame().getPlayed().getJogadas().size(); i++)
        for ( int j = 0 ; j< game.getGameData().getGame().getPlayed().getJogadas().get(i).size();j++)
               switch ( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getLetter()) {
        
            case ('a'):
                 
            g.drawImage(ScrabblePanel.getA(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
            
                break;

            case ('b'):
           g.drawImage(ScrabblePanel.getB(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight() -40, this);
  
                break;

            case ('c'):
         g.drawImage(ScrabblePanel.getC(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
                break;

            case ('d'):
        g.drawImage(ScrabblePanel.getD(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
                break;
            case ('e'):
          g.drawImage(ScrabblePanel.getE(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('f'):
         g.drawImage(ScrabblePanel.getF(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
                break;

            case ('g'):
             g.drawImage(ScrabblePanel.getG(),game.getGame().givenumbersforguix( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy( game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
            case ('h'):
          g.drawImage(ScrabblePanel.getH(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                case ('i'):
           g.drawImage(ScrabblePanel.getI(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                case ('j'):
             g.drawImage(ScrabblePanel.getJ(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('k'):
          g.drawImage(ScrabblePanel.getK(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('l'):
      g.drawImage(ScrabblePanel.getL(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
            case ('m'):
           g.drawImage(ScrabblePanel.getM(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                case ('n'):
        g.drawImage(ScrabblePanel.getN(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                    
                   
                case ('o'):
        g.drawImage(ScrabblePanel.getO(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('p'):
          g.drawImage(ScrabblePanel.getP(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('q'):
            g.drawImage(ScrabblePanel.getQ(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
            case ('r'):
           g.drawImage(ScrabblePanel.getR(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
                  break;
                case ('s'):
           g.drawImage(ScrabblePanel.getS(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                        case ('t'):
            g.drawImage(ScrabblePanel.getT(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('u'):
              g.drawImage(ScrabblePanel.getU(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('v'):
           g.drawImage(ScrabblePanel.getV(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
            case ('w'):
              g.drawImage(ScrabblePanel.getW(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;
                case ('x'):
              g.drawImage(ScrabblePanel.getXx(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
                break;
                case ('y'):
            g.drawImage(ScrabblePanel.getYy(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

                break;

            case ('z'):
            g.drawImage(ScrabblePanel.getZ(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);
 break;
              case ('*'):
                   g.drawImage(ScrabblePanel.getW(),game.getGame().givenumbersforguix(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosx()) ,game.getGame().givenumbersforguiy(game.getGameData().getGame().getPlayed().getJogadas().get(i).get(j).getPosy()),ScrabblePanel.getA().getWidth()+20 , ScrabblePanel.getA().getHeight()-40, this);

               
                break;
            default:
                
                
          


    }
}
}
