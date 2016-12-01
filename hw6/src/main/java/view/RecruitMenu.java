package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    private ListView<String> myList;
    private Button selectButton = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        //TODO
        ObservableList<String> workerUnit = FXCollections.observableArrayList(
          "Melee Unit", "Ranged Unit", "Hybrid Unit", "Siege Unit", "Settlers", "Farmers", "Coal Miners", "Anglers", "Master Builders");
        myList = new ListView<String>(workerUnit);
        super.addMenuItem(myList);
        super.addMenuItem(selectButton);

        selectButton.setOnAction(e ->
            {
                String myChoice = myList.getSelectionModel().getSelectedItems().get(0);
                if (myChoice.equals("Melee Unit")) {
                    if (((Unit) GameController.getCivilization().getMeleeUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getMeleeUnit());
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Melee Unit!");
                        alert.setContentText("You cannot make a Melee Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Ranged Unit")) {
                    if (((Unit) GameController.getCivilization().getRangedUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getRangedUnit());
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Ranged Unit!");
                        alert.setContentText("You cannot make a Ranged Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Hybrid Unit")) {
                    if (((Unit) GameController.getCivilization().getHybridUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getHybridUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Hybrid Unit!");
                        alert.setContentText("You cannot make a Hybrid Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Siege Unit")) {
                    if (((Unit) GameController.getCivilization().getSiegeUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getSiegeUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Siege Unit!");
                        alert.setContentText("You cannot make a Siege Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Settlers")) {
                    if (((Unit) GameController.getCivilization().getSettlerUnit(GameController.getCivilization().getName())).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getSettlerUnit(GameController.getCivilization().getName()));
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Settler Unit!");
                        alert.setContentText("You cannot make a Settler Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Farmers")) {
                    if (((Unit) GameController.getCivilization().getFarmerUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getFarmerUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Farmer Unit!");
                        alert.setContentText("You cannot make a Farmer Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Coal Miners")) {
                    if (((Unit) GameController.getCivilization().getCoalMinerUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getCoalMinerUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Coal Miner Unit!");
                        alert.setContentText("You cannot make a Coal Miner Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Anglers")) {
                    if (((Unit) GameController.getCivilization().getAnglerUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getAnglerUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Angler Unit!");
                        alert.setContentText("You cannot make a Angler Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                } else if (myChoice.equals("Master Builders")) {
                    if (((Unit) GameController.getCivilization().getMasterBuilderUnit()).isAffordable()) {
                        GameController.getLastClicked().getTile().setOccupant(GameController.getCivilization().getMasterBuilderUnit());
                    }  else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You cannot make a Master Unit!");
                        alert.setContentText("You cannot make a Master Unit!");
                        alert.showAndWait();
                    }
                    GameScreen.getMyGameScreen().update();
                    GameController.setLastClicked(GameController.getLastClicked());
                }
            }
            //GameScreen.getMyGameScreen().update();
        );


        //GameController.updateResourcesBar();


    }
}
