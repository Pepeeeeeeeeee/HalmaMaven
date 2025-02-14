package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.model.AppNameModel;
import halmapoc.view.GameRulesView;
import halmapoc.view.MainMenuAuthView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuAuthPresenter {
    private AppNameModel model;
    private MainMenuAuthView view;
    private Stage stage;

    public MainMenuAuthPresenter(AppNameModel appNameModel, MainMenuAuthView mainMenuAuthView, Stage stage) {
        this.model = appNameModel;
        this.view = mainMenuAuthView;
        this.stage = stage;

        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getGamerules().setOnMouseClicked(_ -> {
            Router.routerGameRules(stage, StageName.MAINMENUAUTH, StageName.GAMERULES);
        }); //changes the scene for the 'login scene'
    }
}
