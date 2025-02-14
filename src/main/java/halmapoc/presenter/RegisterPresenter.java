package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.model.AppNameModel;
import halmapoc.view.LoginView;
import halmapoc.view.MainMenuAuthView;
import halmapoc.view.RegisterView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterPresenter {
    private AppNameModel model;
    private RegisterView view;
    private Stage stage;

    public RegisterPresenter(AppNameModel appNameModel, RegisterView registerView, Stage stage) {
        this.model = appNameModel;
        this.view = registerView;
        this.stage = stage;

        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getRegister().setOnMouseClicked(event -> {
            Router.routerMainMenuAuth(stage, StageName.REGISTER, StageName.MAINMENUAUTH);
        });

        view.getLogin().setOnMouseClicked(_ -> {
            Router.routerLogin(stage, StageName.REGISTER, StageName.LOGIN);
        }); //changes the scene for the 'login scene'
    }
}
