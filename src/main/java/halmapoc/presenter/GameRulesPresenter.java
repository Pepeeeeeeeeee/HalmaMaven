package halmapoc.presenter;

import halmapoc.extraUtil.Router;
import halmapoc.extraUtil.StageName;
import halmapoc.model.AppNameModel;
import halmapoc.view.GameRulesView;
import javafx.stage.Stage;

public class GameRulesPresenter {
    private AppNameModel model;
    private GameRulesView view;
    private Stage stage;

    public GameRulesPresenter(AppNameModel appNameModel, GameRulesView gameRulesView, Stage stage) {
        this.model = appNameModel;
        this.view = gameRulesView;
        this.stage = stage;

        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBack().setOnMouseClicked(_ -> {
            Router.routerBack(StageName.GAMERULES, StageName.MAINMENU);
        });
    }
}
