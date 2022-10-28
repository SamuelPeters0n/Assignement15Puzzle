
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class PuzzleBoard extends JFrame implements ActionListener {

    JPanel p = new JPanel();
    ArrayList<ButtonWithPositionVariable> allButtons = ButtonWithPositionVariable.createButtonsArrayList();

    PuzzleBoard() {

        for (JButton element : allButtons) {
            element.setPreferredSize(new Dimension(100, 100));
            element.addActionListener(this);
            p.add(element);
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
