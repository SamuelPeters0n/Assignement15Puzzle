import java.awt.event.ActionEvent;
import java.util.ArrayList;



public class GameMechanic {
    public void ButtonMover(ActionEvent e, ArrayList<ButtonWithPositionVariable> allButtons) {
        ButtonWithPositionVariable pressedButtonCopy = (ButtonWithPositionVariable) e.getSource();
        int pressedButtonsPosition = pressedButtonCopy.getPosition();
        ButtonWithPositionVariable pressedButton = ButtonWithPositionVariable.positionOf(pressedButtonsPosition, allButtons);


        // Möjliga sätt för brickorna att röra sig på vårt 15 pussel.
        if (ButtonWithPositionVariable.positionOf(pressedButtonsPosition - 4, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition + 4, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition - 1, allButtons).getText() == "" ||
                ButtonWithPositionVariable.positionOf(pressedButtonsPosition + 1, allButtons).getText() == "") {

            // Döper om de knappar som flyttats
            for (ButtonWithPositionVariable element : allButtons) {
                if (element.getText() == "") {
                    element.setText(pressedButton.getText());
                }
            }
            pressedButton.setText("");

        }

    }

    public void cheatMode(ArrayList<ButtonWithPositionVariable> allButtons) {

        // Sorterar brickorna så att man vinner på ett drag
        allButtons.get(14).setPosition(15);
        allButtons.get(14).setText("");

        allButtons.get(15).setPosition(16);
        allButtons.get(15).setText("15");
    }

    public void sortButtons(ArrayList<ButtonWithPositionVariable> allButtons) {
        // Sorterar ordningen på alla knappar.
        for (int rNr = 0; rNr < allButtons.size(); rNr++) {
            allButtons.get(rNr).setPosition(rNr + 1);
            allButtons.get(rNr).setText(String.valueOf(rNr + 1));

            if (rNr == allButtons.size() - 1) {
                // Sista knappen ska bli blank.
                allButtons.get(15).setPosition(16);
                allButtons.get(15).setText("");
            }

        }


    }
}
