package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;


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

        // GameController.updateResourcesBar();


    }
}
