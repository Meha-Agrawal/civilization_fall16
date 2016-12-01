package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import model.Civilization;
import javafx.scene.control.Label;

public class ResourcesMenu {
    private HBox resourceBar;
    private Label label1, label2, label3, label4, label5, label6;
    private Civilization myCiv;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        //TODO
        myCiv = GameController.getCivilization();
        resourceBar = new HBox(50);
        label1 = new Label("Strat Level: " + myCiv.getStrategy().
            getStrategyLevel());
        label2 = new Label("Resources: " + myCiv.getResources());
        label3 = new Label("Settlements: " + myCiv.getNumSettlements());
        label4 = new Label("Money: " + myCiv.getTreasury().getCoins());
        label5 = new Label("Food: " + myCiv.getFood());
        label6 = new Label("Happiness: " + myCiv.getHappiness());
        resourceBar.getChildren().
            addAll(label1, label2, label3, label4, label5, label6);
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        //CHECK CIV NULL
        label1.setText("Strat Level: " + myCiv.getStrategy().
            getStrategyLevel());
        label2.setText("Resources: " + myCiv.getResources());
        label3.setText("Settlements: " + myCiv.getNumSettlements());
        label4.setText("Money: " + myCiv.getTreasury().getCoins());
        label5.setText("Food: " + myCiv.getFood());
        label6.setText("Happiness: " + myCiv.getHappiness());
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        //TODO
        update();
        return resourceBar;
    }
}
