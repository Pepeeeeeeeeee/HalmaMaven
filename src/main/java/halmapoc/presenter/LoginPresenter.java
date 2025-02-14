package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.model.AppNameModel;
import halmapoc.view.LoginView;
import halmapoc.view.MainMenuAuthView;
import halmapoc.view.RegisterView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPresenter {
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
