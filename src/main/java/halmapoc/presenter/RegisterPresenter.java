package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.managers.AuthManager;
import halmapoc.model.AppNameModel;
import halmapoc.model.PlayerModel;
import halmapoc.view.LoginView;
import halmapoc.view.MainMenuAuthView;
import halmapoc.view.RegisterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterPresenter extends AuthManager {
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
        view.getRegister().setOnMouseClicked(_ -> {
            PlayerModel player = register(view.getUsername().getText(), view.getPassword().getText(), view.getPasswordConfirm().getText());
            while(player == null){
                view.getUsername().clear();
                view.getPassword().clear();
                view.getPasswordConfirm().clear();
                player = register(view.getUsername().getText(), view.getPassword().getText(), view.getPasswordConfirm().getText());
            }
            Router.routerMainMenuAuth(stage, StageName.REGISTER, StageName.MAINMENUAUTH);
        });

        view.getLogin().setOnMouseClicked(_ -> {
            Router.routerLogin(stage, StageName.REGISTER, StageName.LOGIN);
        }); //changes the scene for the 'login scene'
    }
}
