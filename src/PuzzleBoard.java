
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.Collections;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.SwingConstants.CENTER;

public class PuzzleBoard extends JFrame implements ActionListener {

    GameMechanic gm = new GameMechanic();
    JPanel gameBoard = new JPanel();
    String temp = "";

    JPanel functionPanel = new JPanel();


    // Win
    JPanel winPanel = new JPanel();
    JLabel winLabel = new JLabel("Let´s Puzzle!");

    JButton retryButton = new JButton("Retry");
    JButton cheatButton = new JButton("Cheat");
    ArrayList<ButtonWithPositionVariable> allButtons = ButtonWithPositionVariable.createButtonsArrayList();

    PuzzleBoard() {


        // adds function buttons
        functionPanel.add(retryButton);
        functionPanel.add(cheatButton);
        retryButton.addActionListener(this);
        cheatButton.addActionListener(this);


        // initierar knappListan allButtons och lägger sedan dem i slumpvis ordning.
        for (JButton element : allButtons) {
            element.setPreferredSize(new Dimension(100, 100));
            element.addActionListener(this);
            gameBoard.add(element);
        }
        ButtonWithPositionVariable.shuffle(allButtons);


        // Layout
        setLayout(new BorderLayout());
        gameBoard.setLayout(new GridLayout(4, 4));
        add(gameBoard, SOUTH);
        add(functionPanel, CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        add(winPanel, NORTH);
        winPanel.add(winLabel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Move buttons
        if (e.getSource() != retryButton && e.getSource() != cheatButton) {
            //  GameMechanic gm = new GameMechanic();
            gm.ButtonMover(e, allButtons);
        }

        // Activate cheatMode
        if (e.getSource() == cheatButton) {
            gm.sortButtons(allButtons);
            gm.cheatMode(allButtons);
        }

        // Startar om spelet
        if (e.getSource() == retryButton) {
            ButtonWithPositionVariable.shuffle(allButtons);
        }

        // Kollar efter vinst. Räknar 15 knappar för att få en matchande strängTxt.
        temp = "";
        for (int k = 0; k < allButtons.size() - 1; k++) {
            temp += allButtons.get(k).getText();
        }
        if (temp.equals("123456789101112131415")) {
            winLabel.setText("YOU WIN!");
        } else winLabel.setText("Let´s Puzzle!");


    }
}

