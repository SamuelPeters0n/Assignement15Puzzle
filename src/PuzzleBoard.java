
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

    JPanel p = new JPanel();
    boolean cheatMode = true;
    String temp = "";

    JPanel functionPanel = new JPanel();


    // Win
    JPanel winPanel = new JPanel();
    JLabel winLabel = new JLabel("YOU WIN!");

    JButton retryButton = new JButton("Retry");
    ArrayList<ButtonWithPositionVariable> allButtons = ButtonWithPositionVariable.createButtonsArrayList();

    PuzzleBoard() {


        // adds retry button
        functionPanel.add(retryButton);
        retryButton.addActionListener(this);


        // Shuffle list to place buttons in random locations
        int i = 0;
        if (!cheatMode) {
            Collections.shuffle(allButtons);
        }


        for (JButton element : allButtons) {

            allButtons.get(i).setPostion(i + 1); //*
            element.setPreferredSize(new Dimension(100, 100));
            element.addActionListener(this);
            p.add(element);
            i++;
        }

        if (cheatMode) {
            System.out.println("Cheatmode");
            allButtons.get(14).setPostion(15);
            allButtons.get(14).setText("");

            allButtons.get(15).setPostion(16);
            allButtons.get(15).setText("15");


            // FÖR ATT TESTA PLATSEN AV ALLA KNAPPAR // TA BORT SEN
            for (ButtonWithPositionVariable allButton : allButtons) {
                System.out.println("Txt: " + allButton.getText() + "num" + allButton.getPostion());
            }
        }


        setLayout(new BorderLayout());
        p.setLayout(new GridLayout(4, 4));
        add(p, SOUTH);
        add(functionPanel, CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);


    }

    public static void main(String[] arg) {
        PuzzleBoard a = new PuzzleBoard();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        GameMechanic gm = new GameMechanic();
        gm.ButtonMover(e, allButtons);

// räknar bara 15 knappar
        for (int k = 0; k < allButtons.size() - 1; k++) {
            temp += allButtons.get(k).getText();
        }
        if (temp.equals("123456789101112131415")) {
            System.out.println("You win");

            add(winPanel, NORTH);
            winPanel.add(winLabel);
        }


    }
}
