package view;

import controller.GameController;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        //TODO
        super.addMenuItem(moveButton);
        super.addMenuItem(convertButton);

        moveButton.setOnAction(e -> GameController.moving());
        convertButton.setOnAction(e -> {
            if(GameController.getLastClicked().getTile().getOccupant().isWorker()) {
                GameController.getLastClicked().getTile().setOccupant(((Convertable) GameController.getLastClicked().getTile().getOccupant()).convert());
                GameScreen.getMyGameScreen().update();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Alert!");
                alert.setHeaderText(null);
                alert.setContentText("You cannot convert this tile!");
                alert.showAndWait();
            }
            GameController.updateResourcesBar();
        });

    }
}
