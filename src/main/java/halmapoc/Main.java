package halmapoc;

import halmapoc.extraUtil.DBTests;
import halmapoc.model.AppNameModel;
import halmapoc.presenter.MainMenuPresenter;
import halmapoc.view.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try{
            DBTests.runTests();
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }
        AppNameModel model = new AppNameModel();

        MainMenuView view = new MainMenuView();

        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style/mainmenu.css");
        primaryStage.setScene(scene);

        new MainMenuPresenter(model, view, primaryStage);

        primaryStage.setHeight(750);
        primaryStage.setWidth(750);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
