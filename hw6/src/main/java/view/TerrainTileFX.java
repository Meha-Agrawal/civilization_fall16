package view;


import controller.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.TerrainTile;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class TerrainTileFX extends StackPane {
    private Rectangle overlay;
    private ImageView background;
    private TerrainTile tile;
    private ImageView icon = new ImageView("File:./bologna");
    /**
     * Constructor for TerrainTileFX.
     * Creates a Rectangle for the highlighting and overlay
     * Creates ImageViews for the background terrain and icon
     * Transitions states when a tile is clicked
     * @param tile
     */
    public TerrainTileFX(TerrainTile tile) {
        this.tile = tile;
        overlay = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        overlay.setStroke(Color.BLACK);
        this.background = new ImageView(tile.getImage());
        this.getChildren().addAll(background, overlay);
        updateTileView();
        this.setOnMousePressed(event -> {
                GameController.setLastClicked(this);
            });
    }
    /**
     * gets the TerrainTile of this TerrainTileFX
     * @return TerrainTile
     */
    public TerrainTile getTile() {
        return tile;
    }
    /**
     * this method updates the view of this TerrainTileFX.
     * It should check if the TerrainTile is empty. If it is empty,
     * set the overlay to be transparent. If it is not empty, fill
     * the overlay with the color of the occupant on the terrain tile
     * If the TerrainTileFX contains an icon, remove it. If the tile is
     * not empty, get the image of the occupant of the tile and add the
     *image of the occupant to the tile.
     */
    public void updateTileView() {
        //TODO
        if (this.getChildren().contains(icon)) {
            this.getChildren().remove(icon);
        }
        if (tile.isEmpty()) {
            overlay.setFill(Color.rgb(0, 0, 0, 0.0));
            //overlay = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        } else if (!tile.isEmpty()) {
            overlay.setFill(tile.getOccupant().getColor());
            icon = new ImageView(tile.getOccupant().getImage());
            this.getChildren().add(icon);
            //overlay = new Rectangle(70, 70, tile.getOccupant().getColor());
        }
        if (GameController.getLastClicked() == this) {
            //System.out.println("Inside tile hightlight");
            overlay.setStroke(Color.rgb(255, 255, 0, 1));
        } else {
            overlay.setStroke(Color.BLACK);
        }

    }
}
