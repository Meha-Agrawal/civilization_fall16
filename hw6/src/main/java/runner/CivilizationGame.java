package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import view.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Dialog;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        //TODO
        StartScreen myScreen = new StartScreen();
        primaryStage.setScene(new Scene(myScreen));
        primaryStage.setTitle("Civilization.");
        primaryStage.show();
        TextInputDialog civName = new TextInputDialog("Town Name");
        civName.setTitle("A New Settlement");
        civName.setHeaderText("You have built a Settlement!");
        civName.setContentText("Enter the Name of your first Town: ");
        myScreen.getStartButton().setOnAction(e -> {civName.showAndWait();
        primaryStage.setScene(startGame());});
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        //TODO
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        //TODO
        Scene myScene = new Scene(new GameScreen());
        return myScene;
    }




}
