package view;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private Button startBtn = new Button("START");
    private ListView<CivEnum> civList;
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        //TODO
        ImageView myBackground = new ImageView(new Image(
            "File:./src/main/java/view/civ_background.png"));
        ObservableList<CivEnum> civs = FXCollections.observableArrayList(
            CivEnum.ANCIENT_EGYPT, CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        civList = new ListView<CivEnum>(civs);
        civList.setMaxWidth(200);
        civList.setMaxHeight(200);
        civList.setTranslateY(75);
        this.getChildren().addAll(myBackground, startBtn, getCivList());
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        //TODO
        startBtn.setTranslateY(200);
        return startBtn;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        //TODO
        return civList;
    }
}
