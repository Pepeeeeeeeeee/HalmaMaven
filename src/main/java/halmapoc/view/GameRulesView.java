package halmapoc.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GameRulesView extends BorderPane {
    private HBox hbox;
    private GridPane grid;
    private ImageView imageView;
    private ImageView imageView2;
    private Label textArea;
    private Label textArea2;
    private Button back;
    private Label title;
    private Image image;
    private ColumnConstraints columnConstraints;
    private ColumnConstraints columnConstraints2;
    private RowConstraints rowConstraints;
    private RowConstraints rowConstraints2;

    public GameRulesView() {
        initialiseNodes();
        layoutNodes();
    }

    public Button getBack() {
        return back;
    }

    private void initialiseNodes() {
        hbox = new HBox();
        grid = new GridPane(2, 2);
        image = new Image("/stock.jpg");
        imageView = new ImageView(image);
        imageView2 = new ImageView(image);
        textArea = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        textArea2 = new Label("Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        back = new Button("Back");
        title = new Label("Game Rules!");
        columnConstraints = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints2 = new RowConstraints();
    }

    private void layoutNodes() {
        this.setId("background");
        setTop(hbox);
        hbox.setAlignment(Pos.BASELINE_LEFT);
        hbox.getChildren().addAll(back, title);
        hbox.widthProperty().addListener((obs, oldVal, newVal) -> {
            hbox.setSpacing(this.getWidth() / 2);
        }); //event listener for title position (doesn't work properly yet)

        back.setId("back");
        title.setId("title");
        hbox.setId("hbox");
        textArea.setId("textArea");
        textArea2.setId("textArea");
        imageView.setId("imageView");
        imageView2.setId("imageView");
        grid.setId("grid");


        setCenter(grid);
        grid.add(imageView, 0, 0);
        grid.add(textArea, 0, 1);
        grid.add(imageView2, 1, 1);
        grid.add(textArea2, 1, 0);

        grid.setHgap(10);
        grid.setVgap(10);

        layoutGrid();

        grid.getColumnConstraints().addAll(columnConstraints, columnConstraints2);
        grid.getRowConstraints().addAll(rowConstraints, rowConstraints2);

        grid.setAlignment(Pos.CENTER);
        textArea.setWrapText(true);
        textArea2.setWrapText(true);
//        grid.setGridLinesVisible(true);
    }

    private void layoutGrid() {
        columnConstraints.setHalignment(HPos.CENTER);
        columnConstraints2.setHalignment(HPos.CENTER);
        rowConstraints.setValignment(VPos.CENTER);
        rowConstraints2.setValignment(VPos.CENTER);
        columnConstraints.setPercentWidth(50);
        columnConstraints2.setPercentWidth(50);
        rowConstraints.setPercentHeight(50);
        rowConstraints2.setPercentHeight(50);
    }
}
