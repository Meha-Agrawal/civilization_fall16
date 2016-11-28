package view;

import controller.GameController;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    AbstractMenu myActionMenu;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        //TODO
        myActionMenu = new AbstractMenu();
        this.setTop(getResources().getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(myActionMenu.getRootNode());
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
      //TODO
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        return new ResourcesMenu();
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
    }
}
