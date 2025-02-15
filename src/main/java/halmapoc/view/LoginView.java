package halmapoc.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class LoginView extends BorderPane {
    private TextField username;
    private TextField password;
    private Button login;
    private Button back;
    private Label title;
    private Label register;
    private Circle circle;
    private VBox vbox;
    private HBox hbox;

    public LoginView() {
        initialiseNodes();
        layoutNodes();
    }

    public Button getLogin() {
        return login;
    }

    public Label getRegister() {
        return register;
    }

    public Button getBack() {
        return back;
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getPassword() {
        return password;
    }

    private void initialiseNodes() {
        username = new TextField();
        username.setPromptText("Please enter your Username...");
        password = new TextField();
        password.setPromptText("Please enter your Password...");
        login = new Button("Login");
        back = new Button("back");
        register = new Label("Do not have an account ? Register now!");
        circle = new Circle();
        title = new Label("Login");
        vbox = new VBox();
        hbox = new HBox();
    }

    private void layoutNodes() {
        this.setId("background");

        setTop(hbox);

        back.setId("back"); //setting id for .css files (styling)
        title.setId("title");
        hbox.setId("hbox");

        hbox.getChildren().addAll(back, title); //adding components to hbox
        hbox.setAlignment(Pos.BASELINE_LEFT); //setting alignment for hbox
        hbox.widthProperty().addListener((obs, oldVal, newVal) -> {
            hbox.setSpacing(this.getWidth() / 3.2);
        }); //event listener for title position (doesn't work properly yet)

        setCenter(vbox); //setting vbox position relative to border pane
        vbox.getChildren().addAll( circle, username, password, login, register);


        circle.setId("avatar");
        circle.setRadius(50);

        username.setId("username");
        password.setId("password");

        login.setId("login");
        register.setId("register");

        vbox.setId("vbox");
        vbox.setAlignment(Pos.CENTER);
    }
}
