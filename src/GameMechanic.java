import java.awt.event.ActionEvent;
import java.util.ArrayList;



public class GameMechanic {
    public void ButtonMover(ActionEvent e, ArrayList<ButtonWithPositionVariable> allButtons) {
        ButtonWithPositionVariable pressedButtonCopy = (ButtonWithPositionVariable) e.getSource();
        int pressedButtonsPosition = pressedButtonCopy.getPostion();
        ButtonWithPositionVariable pressedButton = ButtonWithPositionVariable.positionOf(pressedButtonsPosition, allButtons);

        if (ButtonWithPositionVariable.positionOf(pressedButtonsPosition - 4, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition + 4, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition - 1, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition + 1, allButtons).getText() == "") {

            for (ButtonWithPositionVariable element : allButtons) {
                if (element.getText() == "") {
                    element.setText(pressedButton.getText());
                }
            }
            pressedButton.setText("");

        }

    }

    public void cheatMode(ArrayList<ButtonWithPositionVariable> allButtons) {
        System.out.println("Cheatmode");
        allButtons.get(14).setPostion(15);
        allButtons.get(14).setText("");

        allButtons.get(15).setPostion(16);
        allButtons.get(15).setText("15");
    }

    public void sortButtons(ArrayList<ButtonWithPositionVariable> allButtons) {
        for (int rNr = 0; rNr < allButtons.size(); rNr++) {
            allButtons.get(rNr).setPostion(rNr + 1);
            allButtons.get(rNr).setText(String.valueOf(rNr + 1));

            // felsöka platser
          //  System.out.println("position: " + allButtons.get(rNr).getPostion() + "text: " + allButtons.get(rNr).getText());

            if (rNr == allButtons.size() - 1) {
                // Sista knappen ska bli blank.
                allButtons.get(15).setPostion(16);
                allButtons.get(15).setText("");
            }

        }


    }
}
