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

public class LoginPresenter extends AuthManager {
    private AppNameModel model;
    private LoginView view;
    private Stage stage;

    public LoginPresenter(AppNameModel appNameModel, LoginView loginView, Stage stage) {
        this.model = appNameModel;
        this.view = loginView;
        this.stage = stage;

        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getLogin().setOnMouseClicked(_ -> {
            PlayerModel player = login(view.getUsername().getText(), view.getPassword().getText());
            while(player == null){
                view.getUsername().clear();
                view.getPassword().clear();
                player = login(view.getUsername().getText(), view.getPassword().getText());
            }
            Router.routerMainMenuAuth(stage, StageName.LOGIN, StageName.MAINMENUAUTH);
        });

        view.getRegister().setOnMouseClicked(_ -> {
            Router.routerRegister(stage, StageName.LOGIN, StageName.REGISTER);
        });

        view.getBack().setOnMouseClicked(_ -> {
            Router.routerBack(StageName.LOGIN, StageName.MAINMENU);
        });
    }
}
