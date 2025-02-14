package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.model.AppNameModel;
import halmapoc.view.GameRulesView;
import halmapoc.view.LoginView;
import halmapoc.view.MainMenuView;
import halmapoc.view.RegisterView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuPresenter {
    private AppNameModel model;
    private MainMenuView view;
    private Stage stage;

    public MainMenuPresenter(AppNameModel model, MainMenuView view, Stage stage) {
        this.model = model;
        this.view = view;
        this.stage = stage;

        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
        view.getLogin().setOnMouseClicked(_ -> {
            Router.routerLogin(stage, StageName.MAINMENU, StageName.LOGIN);
        }); //changes the scene for the 'login scene'

        view.getRegister().setOnMouseClicked(_ -> {
            Router.routerRegister(stage, StageName.MAINMENU, StageName.REGISTER);
        });

        view.getGamerules().setOnMouseClicked(_ -> {
            Router.routerGameRules(stage, StageName.MAINMENU, StageName.GAMERULES);
        });

        view.getExit().setOnMouseClicked(_ -> {
            Router.routerExit();
        });
    }
    private void updateView() {
        // fills the view with model data
    }
}
