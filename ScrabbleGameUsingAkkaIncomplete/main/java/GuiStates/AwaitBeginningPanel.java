package GuiStates;



import DataGui.ObservableGame;
import DataStates.AwaitBeginning;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AwaitBeginningPanel extends JPanel implements Observer {

    private ObservableGame observablegame;
    private JButton startbotao;
    private JButton sair;
    private boolean on = false;

    private Som main;

    public AwaitBeginningPanel(ObservableGame observablegame) {
        this.observablegame = observablegame;
       
        this.observablegame.addObserver(this);

       main = new Som("sons/main.wav");

        setUp();
        setupLayout();

        update(observablegame, this);

    }

    private void setUp() {
        setOpaque(false);

        startbotao = new JButton("New Game");
    
        sair = new JButton("Quit");

        startbotao.addActionListener(new StartListener());
        sair.addActionListener(new SairListener());

    }

    private void setupLayout() {
       
      

        Box box = Box.createVerticalBox();
        setLayout(new GridBagLayout());
 
        setPreferredSize(new Dimension(1920, 1080));

        box.add(startbotao);
 
        box.add(sair);
        
        
        box.add(Box.createHorizontalGlue());
     
        add(box);
    }

    @Override
    public void update(Observable t, Object o) {
        
        setVisible(observablegame.getState() instanceof AwaitBeginning);
         
    }

   

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
           observablegame.start();
        }

    }

    class SairListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          //  observablegame.endOfGame();
   
        }
        
    }
    

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Dimension sizee = Toolkit.getDefaultToolkit().getScreenSize();

        super.paintComponent(g);
      on = main.loop(on);
       g.drawImage(ScrabblePanel.getIntro(), 1, 0, getWidth(), getHeight() , this);
      
    }
}