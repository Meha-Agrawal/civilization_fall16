package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;
import javafx.scene.control.Label;

public class ResourcesMenu {
    HBox resourceBar;
    Label label1,label2, label3, label4, label5, label6;
    Civilization myCiv;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        //TODO
        System.out.println("Got here1");
        myCiv = GameController.getCivilization();
        System.out.println("Got here2");
        resourceBar = new HBox(30);
        label1 = new Label("Strat Level: "/* + myCiv.getStrategy().getStrategyLevel()*/);
        System.out.println("Got here3");
        //int myResources = GameController.getCivilization().getFood();
        label2 = new Label("Resources: "/* + myCiv.getResources()*/);
        System.out.println("Got here4");
        label3 = new Label("Settlements: "/* + myCiv.getNumSettlements()*/);
        label4 = new Label("Money: "/* + myCiv.getTreasury()*/);
        label5 = new Label("Food: "/* + myCiv.getFood()*/);
        label6 = new Label("Happiness: "/* + myCiv.getHappiness()*/);
        resourceBar.getChildren().addAll(label1, label2, label3, label4, label5, label6);
        resourceBar.getChildren().addAll();

    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {

    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        //TODO
        return resourceBar;
    }
}
