
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PuzzleBoard extends JFrame implements ActionListener {

    JPanel p = new JPanel();
    ArrayList<ButtonWithPositionVariable> allButtons = ButtonWithPositionVariable.createButtonsArrayList();

    PuzzleBoard() {

        // Shuffle list to place buttons in random locations
        int i = 0;
        Collections.shuffle(allButtons);

        for (JButton element : allButtons) {
            allButtons.get(i).setPostion(i+1);
            element.setPreferredSize(new Dimension(100, 100));
            element.addActionListener(this);
            p.add(element);
            i++;
        }
        p.setLayout(new GridLayout(4, 4));
        add(p);
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
    }
}
