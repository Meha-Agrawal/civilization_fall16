package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        //TODO
        super.addMenuItem(attackButton);
        super.addMenuItem(moveButton);

        attackButton.setOnAction(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
                GameScreen.getMyGameScreen().update();
            });
        moveButton.setOnAction(e ->
            {
                GameController.moving();
                GameController.updateResourcesBar();
                GameScreen.getMyGameScreen().update();
            }
        );

    }
}
