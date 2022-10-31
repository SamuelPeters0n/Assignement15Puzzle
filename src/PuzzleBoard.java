
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
    JPanel p = new JPanel();
    String temp = "";

    JPanel functionPanel = new JPanel();


    // Win
    JPanel winPanel = new JPanel();
    JLabel winLabel = new JLabel("Let´s Puzzle!");

    JButton retryButton = new JButton("Retry");
    JButton cheatButton = new JButton("Cheat");
    ArrayList<ButtonWithPositionVariable> allButtons = ButtonWithPositionVariable.createButtonsArrayList();

    PuzzleBoard() {


        // adds retry button
        functionPanel.add(retryButton);
        functionPanel.add(cheatButton);

        retryButton.addActionListener(this);
        cheatButton.addActionListener(this);




        // Shuffle list to place buttons in random locations
        Collections.shuffle(allButtons);

        int i = 0;
        for (JButton element : allButtons) {
            allButtons.get(i).setPostion(i + 1); //*
            element.setPreferredSize(new Dimension(100, 100));
            element.addActionListener(this);
            p.add(element);
            i++;
        }



        //FÖR ATT TESTA PLATSEN AV ALLA KNAPPAR // TA BORT SEN
        /*
            for (ButtonWithPositionVariable allButton : allButtons) {
            System.out.println("Txt: " + allButton.getText() + "num" + allButton.getPostion());
            }
        */



        setLayout(new BorderLayout());
        p.setLayout(new GridLayout(4, 4));
        add(p, SOUTH);
        add(functionPanel, CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

        add(winPanel, NORTH);
        winPanel.add(winLabel);


    }

    public static void main(String[] arg) {
        PuzzleBoard a = new PuzzleBoard();
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

        if (e.getSource() == retryButton) {

            gm.sortButtons(allButtons);
            //Collections.shuffle(allButtons);


            for (ButtonWithPositionVariable allButton : allButtons) {
                System.out.println("Txt: " + allButton.getText() + "num: " + allButton.getPostion());
            }


        }


        // Kollar efter vinst. Räknar 15 knappar för att få en matchande strängTxt.
        temp = "";
        for (int k = 0; k < allButtons.size() - 1; k++) {
            temp += allButtons.get(k).getText();
        }

        // Testar/felsöker ordningen av temp strängen.
        // System.out.println(temp);

        if (temp.equals("123456789101112131415")) {
            winLabel.setText("YOU WIN!");
            System.out.println("You win");
        } else winLabel.setText("Let´s Puzzle!");


    }
}

