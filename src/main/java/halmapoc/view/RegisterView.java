package halmapoc.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class RegisterView extends BorderPane {
    private TextField username;
    private TextField password;
    private TextField passwordConfirm;
    private Button register;
    private Button back;
    private Label title;
    private Label login;
    private Circle circle;
    private VBox vbox;
    private HBox hbox;

    public RegisterView() {
        initialiseNodes();
        layoutNodes();
    }

    public Button getRegister() {
        return register;
    }

    public Label getLogin() {
        return login;
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getPassword() {
        return password;
    }

    public TextField getPasswordConfirm() {
        return passwordConfirm;
    }

    private void initialiseNodes() {
        username = new TextField();
        username.setPromptText("Please enter your Username...");
        password = new TextField();
        password.setPromptText("Please enter your Password...");
        passwordConfirm = new TextField();
        passwordConfirm.setPromptText("Please confirm your Password...");
        register = new Button("Register");
        back = new Button("back");
        login = new Label("Already have an account ? Login now!");
        circle = new Circle();
        title = new Label("Register");
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
            hbox.setSpacing(this.getWidth() / 3.6);
        }); //event listener for title position (doesn't work properly yet)

        setCenter(vbox); //setting vbox position relative to border pane
        vbox.getChildren().addAll( circle, username, password, passwordConfirm, register, login);


        circle.setId("avatar");
        circle.setRadius(50);

        username.setId("username");
        password.setId("password");
        passwordConfirm.setId("password");

        login.setId("register");
        register.setId("login");

        vbox.setId("vbox");
        vbox.setAlignment(Pos.CENTER);
    }
}
