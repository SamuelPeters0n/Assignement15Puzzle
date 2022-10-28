import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameMechanic {
    public void ButtonMover(ActionEvent e, ArrayList<ButtonWithPositionVariable> allButtons){
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
}
