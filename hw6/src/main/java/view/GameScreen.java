package view;

import controller.GameController;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static AbstractMenu myActionMenu = new AbstractMenu();
    private static MilitaryMenu myMilitaryMenu;
    private static WorkerMenu myWorkerMenu;
    private static RecruitMenu myRecruitMenu;
    private static BuildingMenu myBuildingMenu;
    private static StatusMenu myStatusMenu;
    private static GameScreen myGameScreen;
    private static AbstractMenu currentMenu = null;
    private static ResourcesMenu myResourceMenu;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        //TODO
        myMilitaryMenu = new MilitaryMenu();
        myWorkerMenu = new WorkerMenu();
        myRecruitMenu = new RecruitMenu();
        myBuildingMenu = new BuildingMenu();
        myStatusMenu = new StatusMenu();
        myResourceMenu = new ResourcesMenu();
        this.setTop(getResources().getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(myActionMenu.getRootNode());
        myGameScreen = this;
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
      //TODO
      this.setLeft(currentMenu.getRootNode());
      GridFX.update();
      getResources().update();

    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        //return new ResourcesMenu();
        return myResourceMenu;
    }

    public static GameScreen getMyGameScreen() {
        return myGameScreen;
    }

    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
       if (state == GameController.GameState.MILITARY) {
           currentMenu = myMilitaryMenu;
       } else if (state == GameController.GameState.WORKER) {
           currentMenu = myWorkerMenu;
       } else if (state == GameController.GameState.RECRUITING) {
           currentMenu = myRecruitMenu;
       } else if (state == GameController.GameState.BUILDING) {
           currentMenu = myBuildingMenu;
       } else if (state == GameController.GameState.NEUTRAL) {
           currentMenu = myStatusMenu;
       }
       //myGameScreen.update();
       GameScreen.getMyGameScreen().update();
    }
}
