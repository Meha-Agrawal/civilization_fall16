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
import view.GridFX;
import model.Civilization;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Dialog;
import java.util.Optional;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private Civilization myCiv;
    private Stage myStage;
    private StartScreen myScreen;
    //private GameScreen myGS;
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        //TODO
        myStage = primaryStage;
        myScreen = new StartScreen();
        myStage.setScene(new Scene(myScreen));
        myStage.setTitle("Civilization.");
        myStage.show();
        TextInputDialog civName = new TextInputDialog("Town Name");
        civName.setTitle("A New Settlement");
        civName.setHeaderText("You have built a Settlement!");
        civName.setContentText("Enter the Name of your first Town: ");

        myScreen.getStartButton().setOnAction(e -> {
            if (myScreen.getCivList().getSelectionModel().getSelectedItem() != null) {
                startGame();
            }
        });
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

        String myChoice = myScreen.getCivList().getSelectionModel().getSelectedItem().toString();
        if (myChoice.equals("Ancient Egypt")) {
            myCiv = new Egypt();
            GameController.setCivilization(myCiv);
        } else if (myChoice.equals("Qin Dynasty")) {
            myCiv = new QinDynasty();
            GameController.setCivilization(myCiv);
        } else if (myChoice.equals("Roman Empire")) {
            myCiv = new RomanEmpire();
            GameController.setCivilization(myCiv);
        }
        TextInputDialog civName = new TextInputDialog("Town Name");
        civName.setTitle("A New Settlement");
        civName.setHeaderText("You have built a Settlement!");
        civName.setContentText("Enter the Name of your first Town: ");
        Optional<String> result = civName.showAndWait();
        Bandit myBandit = new Bandit();
        //myGS = new GameScreen();
        Scene myScene = new Scene(new GameScreen());
        GridFX.getMap().putSettlement(result.toString(), myCiv, 0, 9);
        GridFX.getMap().addEnemies(myBandit, 1);
        myStage.setScene(myScene);
        //GameScreen.getMyGameScreen().update();
        return myScene;
    }




}
