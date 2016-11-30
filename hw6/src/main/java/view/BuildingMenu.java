package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.control.Button;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        //TODO
        super.addMenuItem(investButton);
        super.addMenuItem(demolishButton);
        System.out.println("BuildingMenu Constructor");
        investButton.setOnAction(e -> {
            ((Building) (GameController.getLastClicked().getTile().getOccupant())).invest();
        });
    }
}
