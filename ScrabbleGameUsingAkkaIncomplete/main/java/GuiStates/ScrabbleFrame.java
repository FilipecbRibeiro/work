/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiStates;

import Data.Files.FileUtility;
import DataGui.GameData;
import DataGui.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Asus
 */
public class ScrabbleFrame extends JFrame implements Observer {

    private ObservableGame observablegame;
    private ScrabblePanel scrabblepanel;
    private JMenuItem newObjJMI;

    public ScrabbleFrame(ObservableGame obgame) {
        super("Scrabble");

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        this.observablegame = obgame;

        Container cp = getContentPane();
        menus();
        scrabblepanel = new ScrabblePanel(obgame);

        cp.add(scrabblepanel, BorderLayout.LINE_START);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setBounds(0, 0, screen.height - 20, screen.width);
        setLocation(1, 1);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();

    }

    @Override
    public void update(Observable o, Object o1) {
        repaint();
    }

    protected void paintComponent(Graphics g) {
    }

    private void menus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);


        newObjJMI = new JMenuItem("Stop");
        newObjJMI.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newObjJMI.setMnemonic(KeyEvent.VK_S);
        JMenuItem readObjJMI = new JMenuItem("Load");
        readObjJMI.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem saveObjJMI = new JMenuItem("Save");
        saveObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exitJMI = new JMenuItem("Exit");
        exitJMI.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        gameMenu.add(newObjJMI);
        gameMenu.add(readObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.addSeparator();
        gameMenu.add(exitJMI);
        menuBar.add(gameMenu);

        newObjJMI.addActionListener(new NewObjMenuBarListener());
        readObjJMI.addActionListener(new LoadObjMenuBarListener());
        saveObjJMI.addActionListener(new SaveObjMenuBarListener());
        exitJMI.addActionListener(new ExitListener());

   
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem helpContentJMI = new JMenuItem("Credits");
        helpContentJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        JMenuItem aboutJMI = new JMenuItem("About");
        aboutJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        helpMenu.add(helpContentJMI);
        helpMenu.add(aboutJMI);
        menuBar.add(helpMenu);

        helpContentJMI.addActionListener(new HelpContentListener());
        aboutJMI.addActionListener(new AboutListener());

    }

    class NewObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
     
        }
    }

    class LoadObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showOpenDialog(ScrabbleFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    GameData stateMachineGame
                            = (GameData) FileUtility.retrieveGameFromFile(file);
                    if (stateMachineGame != null) {
                        observablegame.setGameData(stateMachineGame);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(ScrabbleFrame.this, "Operation failed: \r\n\r\n" + e);
                }

            } else {
                System.out.println("Operation canceled ");
            }
        }
    }

    class SaveObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showSaveDialog(ScrabbleFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    FileUtility.saveGameToFile(file, observablegame.getGame());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ScrabbleFrame.this, "Operation failed: \r\n\r\n" + e);
                }
            } else {
                System.out.println("Operation canceled ");
            }
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class HelpContentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ScrabbleFrame.this,
                    "Ainda Indisponivel\n",
                    "Creditos ", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ScrabbleFrame.this,
                    "\tThesis\n\t 9 Scrabble Game!!!\nOne does not Simply...",
                    "About", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
