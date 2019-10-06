/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import DataGui.ObservableGame;
import DataStates.AwaitDrawTile;
import DataStates.AwaitPlay;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class AwaitPlayPanel extends JPanel implements Observer{
          private ObservableGame game;
private JButton pressword;
private JButton playerrack[];
private Som main ; 
 private JTextField wordtoplay;
 private JTextField letter;
  private JTextField  wordnew;
 



   GridBagConstraints c2 = new GridBagConstraints();
    public AwaitPlayPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
     //   main= new Som("sons/main.wav");
       
      
        setUp();
        setLayout();
        update(game, this);
    }

    private void setUp() {

        
        playerrack = new JButton[7];
       
        
        for (int i = 0; i < 7; i++) {
         
            playerrack[i] = new JButton(new ImageIcon(ScrabblePanel.getA().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT)));
            playerrack[i].setBorder(BorderFactory.createEmptyBorder());
            playerrack[i].setContentAreaFilled(false);
            

        }
        
        
  wordtoplay = new JTextField(10);
  letter = new JTextField(1);
  wordnew = new JTextField(10);
  
      pressword = new JButton("Play Word");
       pressword.addActionListener(new playwordlistener());

    }

    private void setLayout() {

       
    
      // setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setLayout(new GridBagLayout());
      setPreferredSize(new Dimension(1920,1080));
 
        Box box = Box.createHorizontalBox();
    
        box.add(Box.createHorizontalGlue());
        
        for (int i = 0; i < 3; i++) {
          
            box.add(playerrack[i]);

        }


   
    
            box.add(Box.createVerticalBox());
           box.add(wordtoplay);
          box.add(letter);
          box.add(wordnew);
//       box.add(posy);
       box.add(pressword);
        add(box);

    }


    public void showtiles()
    {
        
        
           if( game.getGame().getPlayer().getYourRack().size()==0)
        {
             for (int i = 0; i < game.getGame().getPlayer().getYourRack().size(); i++) {
           ImageIcon icon7 = new ImageIcon(ScrabblePanel.getA().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
           playerrack[i].setIcon(icon7);
           playerrack[i].setBorder(BorderFactory.createEmptyBorder());
            playerrack[i].setContentAreaFilled(false);

                 }
        }
         else
              
             
              for(int i = 0 ; i< game.getGameData().getPlayer().getNumberofiteractions(); i++)
              {
               char temp  = game.getGameData().getPlayerRack().get(i).getLetter();
               
               
          
               switch ( temp) {
        
            case ('a'):
     
                ImageIcon icon = new ImageIcon(ScrabblePanel.getA().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);
               
   
                break;

            case ('b'):
                ImageIcon icon2 = new ImageIcon(ScrabblePanel.getB().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
               playerrack[i].setIcon(icon2);
               playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);
 
                break;

            case ('c'):
                ImageIcon icon3 = new ImageIcon(ScrabblePanel.getC().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon3);

                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;

            case ('d'):
                ImageIcon icon4 = new ImageIcon(ScrabblePanel.getD().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon4);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);
      
                break;

            case ('e'):
                ImageIcon icon5 = new ImageIcon(ScrabblePanel.getE().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon5);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);//Imagem Certa

                break;

            case ('f'):
                ImageIcon icon6 = new ImageIcon(ScrabblePanel.getF().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon6);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;

            case ('g'):
                ImageIcon icon7 = new ImageIcon(ScrabblePanel.getG().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon7);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
            case ('h'):
                ImageIcon icon8 = new ImageIcon(ScrabblePanel.getH().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon8);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('i'):
                ImageIcon icon9 = new ImageIcon(ScrabblePanel.getI().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon9);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('j'):
                ImageIcon icon10 = new ImageIcon(ScrabblePanel.getJ().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon10);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);//Imagem Certa

                break;

            case ('k'):
                ImageIcon icon11 = new ImageIcon(ScrabblePanel.getK().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon11);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;

            case ('l'):
                ImageIcon icon12 = new ImageIcon(ScrabblePanel.getL().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon12);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
            case ('m'):
                ImageIcon icon13 = new ImageIcon(ScrabblePanel.getM().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon13);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('n'):
                ImageIcon icon14 = new ImageIcon(ScrabblePanel.getN().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon14);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                    
                   
                case ('o'):
                ImageIcon icon15 = new ImageIcon(ScrabblePanel.getO().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon15);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);//Imagem Certa

                break;

            case ('p'):
                ImageIcon icon16 = new ImageIcon(ScrabblePanel.getP().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon16);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;

            case ('q'):
                ImageIcon icon17 = new ImageIcon(ScrabblePanel.getQ().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon17);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
            case ('r'):
                ImageIcon icon18 = new ImageIcon(ScrabblePanel.getR().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon18);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('s'):
                ImageIcon icon19 = new ImageIcon(ScrabblePanel.getS().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon19);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                        case ('t'):
                ImageIcon icon20 = new ImageIcon(ScrabblePanel.getT().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_FAST));
                playerrack[i].setIcon(icon20);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);//Imagem Certa

                break;

            case ('u'):
                ImageIcon icon21 = new ImageIcon(ScrabblePanel.getU().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_FAST));
                playerrack[i].setIcon(icon21);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;

            case ('v'):
                ImageIcon icon22 = new ImageIcon(ScrabblePanel.getV().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon22);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
            case ('w'):
                ImageIcon icon23 = new ImageIcon(ScrabblePanel.getW().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon23);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('x'):
                ImageIcon icon24 = new ImageIcon(ScrabblePanel.getXx().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon24);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
                case ('y'):
                ImageIcon icon25 = new ImageIcon(ScrabblePanel.getYy().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_FAST));
                playerrack[i].setIcon(icon25);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);//Imagem Certa

                break;

            case ('z'):
                ImageIcon icon26 = new ImageIcon(ScrabblePanel.getZ().getScaledInstance(ScrabblePanel.getA().getWidth() / 2, ScrabblePanel.getA().getHeight() / 2, Image.SCALE_DEFAULT));
                playerrack[i].setIcon(icon26);
                playerrack[i].setBorder(BorderFactory.createEmptyBorder());
                playerrack[i].setContentAreaFilled(false);

                break;
}
           
        
                 
    }
       
    }
           
           
           
    @Override
    public void update(Observable o, Object arg) {

  
        setVisible(game.getState() instanceof AwaitPlay);
    if (game.getState() instanceof AwaitPlay) {
        showtiles();
    }
    }

    class playwordlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         
            String text = wordtoplay.getText();
            char let = letter.getText().charAt(0);
           String wordn = wordnew.getText();
         
            game.play(text,let,wordn);
            
            wordtoplay.setText(" ");
            letter.setText(" ");
            wordnew.setText(" ");
            
            
               repaint();
           

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(ScrabblePanel.getBoard(), 1, 1, getWidth()-400 , getHeight()-200, this);

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


