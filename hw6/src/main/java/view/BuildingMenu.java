package view;

import controller.GameController;
import model.Building;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
        investButton.setOnAction(e -> {
                if (GameController.getCivilization().getTreasury()
                    .getCoins() >= 25) {
                    ((Building) (GameController.getLastClicked().getTile()
                        .getOccupant())).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You cannot invest!");
                    alert.setContentText("You cannot invest!");
                    alert.showAndWait();
                }
                GameScreen.getMyGameScreen().update();
                GameController.setLastClicked(GameController.getLastClicked());
            });
        demolishButton.setOnAction(e -> {
                if (!(((Building) GameController.getLastClicked().getTile()
                    .getOccupant()).isSettlement())) {
                    ((Building) GameController.getLastClicked().getTile()
                        .getOccupant()).demolish();
                    GameController.getLastClicked().getTile().setOccupant(null);
                    GameController.updateResourcesBar();
                } else if (GameController.getCivilization()
                        .getNumSettlements() > 1) {
                    ((Building) GameController.getLastClicked()
                            .getTile().getOccupant()).demolish();
                    GameController.getLastClicked().getTile()
                            .setOccupant(null);
                    GameController.updateResourcesBar();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You cannot demolish!");
                    alert.setContentText("You cannot demolish!");
                    alert.showAndWait();
                }
                GameScreen.getMyGameScreen().update();
                GameController.setLastClicked(GameController.getLastClicked());
            });
    }
}
