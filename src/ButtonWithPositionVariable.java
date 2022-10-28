import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ButtonWithPositionVariable extends JButton {
    private int postion;

    public int getPostion() {
        return postion;
    }

    //returns button with postion of given argument
    public static ButtonWithPositionVariable positionOf(int postion, ArrayList<ButtonWithPositionVariable> allButtons) {
        ButtonWithPositionVariable buttonToFind;
        if (postion > 16 || postion < 1) {
            ButtonWithPositionVariable button = new ButtonWithPositionVariable(10000000, "WRONGBUTTON");
            return button;
        }

        for (ButtonWithPositionVariable element : allButtons) {
            if (element.getPostion() == postion) {
                buttonToFind = element;
                return buttonToFind;
            }
        }

        return null;
    }

    public ButtonWithPositionVariable(int postion, String text) {
        super(text);
        this.postion = postion;
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
}

