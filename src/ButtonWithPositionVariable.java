import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ButtonWithPositionVariable extends JButton {
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //returns button with position of given argument
    public static ButtonWithPositionVariable positionOf(int position, ArrayList<ButtonWithPositionVariable> allButtons) {
        ButtonWithPositionVariable buttonToFind;
        if (position > 16 || position < 1) {
            ButtonWithPositionVariable button = new ButtonWithPositionVariable(10000000, "WRONGBUTTON");
            return button;
        }

        for (ButtonWithPositionVariable element : allButtons) {
            if (element.getPosition() == position) {
                buttonToFind = element;
                return buttonToFind;
            }
        }

        return null;
    }

    public ButtonWithPositionVariable(int position, String text) {
        super(text);
        this.position = position;
    }

    public static ArrayList<ButtonWithPositionVariable> createButtonsArrayList() {
        ButtonWithPositionVariable button1 = new ButtonWithPositionVariable(1, "1");
        ButtonWithPositionVariable button2 = new ButtonWithPositionVariable(2, "2");
        ButtonWithPositionVariable button3 = new ButtonWithPositionVariable(3, "3");
        ButtonWithPositionVariable button4 = new ButtonWithPositionVariable(4, "4");
        ButtonWithPositionVariable button5 = new ButtonWithPositionVariable(5, "5");
        ButtonWithPositionVariable button6 = new ButtonWithPositionVariable(6, "6");
        ButtonWithPositionVariable button7 = new ButtonWithPositionVariable(7, "7");
        ButtonWithPositionVariable button8 = new ButtonWithPositionVariable(8, "8");
        ButtonWithPositionVariable button9 = new ButtonWithPositionVariable(9, "9");
        ButtonWithPositionVariable button10 = new ButtonWithPositionVariable(10, "10");
        ButtonWithPositionVariable button11 = new ButtonWithPositionVariable(11, "11");
        ButtonWithPositionVariable button12 = new ButtonWithPositionVariable(12, "12");
        ButtonWithPositionVariable button13 = new ButtonWithPositionVariable(13, "13");
        ButtonWithPositionVariable button14 = new ButtonWithPositionVariable(14, "14");
        ButtonWithPositionVariable button15 = new ButtonWithPositionVariable(15, "15");
        ButtonWithPositionVariable button16 = new ButtonWithPositionVariable(16, "");

        ArrayList<ButtonWithPositionVariable> allButtons = new ArrayList<ButtonWithPositionVariable>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7,
                button8, button9, button10, button11, button12, button13, button14, button15, button16));
        return allButtons;
    }

    // Gör en lista som sedan blandas, positionerna behåller sin plats.
    public static void shuffle(ArrayList<ButtonWithPositionVariable> allButtons){
        ArrayList <String> numbers = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11"
                ,"12","13","14","15",""));
        Collections.shuffle(numbers);
        for (int i = 0; i < allButtons.size(); i++) {
            allButtons.get(i).setText(numbers.get(i));
        }
    }
}

