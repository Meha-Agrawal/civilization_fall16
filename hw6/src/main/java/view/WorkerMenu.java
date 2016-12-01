package view;

import controller.GameController;
import model.Convertable;
import model.MapObject;
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

        moveButton.setOnAction(e -> {
                GameController.moving();
                GameScreen.getMyGameScreen().update();
            });
        convertButton.setOnAction(e -> {
                TerrainTileFX myTTileFX = GameController.getLastClicked();
                MapObject myMapObject = myTTileFX.getTile().getOccupant();
                if (myMapObject.isWorker() && ((Convertable) myMapObject)
                    .canConvert(myTTileFX.getTile().getType())) {
                    myTTileFX.getTile().setOccupant(((Convertable) myMapObject)
                        .convert());
                    myTTileFX.updateTileView();
                    GameController.updateResourcesBar();
                    GameScreen.getMyGameScreen().update();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Alert!");
                    alert.setContentText("You cannot convert this tile!");
                    alert.showAndWait();
                }
                GameScreen.getMyGameScreen().update();
                GameController.setLastClicked(GameController.getLastClicked());
            });

    }
}
