package halmapoc.extraUtil;

import halmapoc.model.AppNameModel;
import halmapoc.presenter.*;
import halmapoc.view.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Router {
    private static StageName lastStageName;
    private static StageName currentStageName;
    private static Stage stage;

    public static void routerLogin(Stage stage, StageName lastStageName, StageName currentStageName) {
        Router.stage = stage;
        Router.lastStageName = lastStageName;
        Router.currentStageName = currentStageName;
        AppNameModel model = new AppNameModel(); //change for the actual model
        LoginView view = new LoginView(); //making new view
        Scene scene = new Scene(view); //making new scene
        scene.getStylesheets().add("/style/login.css"); //binding css file
        new LoginPresenter(model, view, stage); //making new presenter
        stage.setScene(scene); //setting and showing new scene
    }

    public static void routerRegister(Stage stage, StageName lastStageName, StageName currentStageName){
        Router.stage = stage;
        Router.lastStageName = lastStageName;
        Router.currentStageName = currentStageName;
        AppNameModel model = new AppNameModel(); //change for the actual model
        RegisterView view = new RegisterView();
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style/login.css");
        new RegisterPresenter(model, view, stage);
        stage.setScene(scene);
    }

    public static void routerGameRules(Stage stage, StageName lastStageName, StageName currentStageName){
        Router.stage = stage;
        Router.lastStageName = lastStageName;
        Router.currentStageName = currentStageName;
        AppNameModel model = new AppNameModel(); //change for the actual model
        GameRulesView view = new GameRulesView(); //making new view
        Scene scene = new Scene(view); //making new scene
        scene.getStylesheets().add("/style/gamerules.css"); //binding css file
        new GameRulesPresenter(model, view, stage); //making new presenter
        stage.setScene(scene); //setting and showing new scene
    }

    public static void routerMainMenuAuth(Stage stage, StageName lastStageName, StageName currentStageName){
        Router.stage = stage;
        Router.lastStageName = lastStageName;
        Router.currentStageName = currentStageName;
        AppNameModel model = new AppNameModel(); //change for the actual model
        MainMenuAuthView view = new MainMenuAuthView();
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style/mainmenu.css");
        new MainMenuAuthPresenter(model, view, stage);
        stage.setScene(scene);
    }

    public static void routerMainMenu(Stage stage, StageName lastStageName, StageName currentStageName){
        Router.stage = stage;
        Router.lastStageName = lastStageName;
        Router.currentStageName = currentStageName;
        AppNameModel model = new AppNameModel(); //change for the actual model
        MainMenuView view = new MainMenuView();
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style/mainmenu.css");
        new MainMenuPresenter(model, view, stage);
        stage.setScene(scene);
    }

    public static void routerExit(){
        System.exit(0);
    }

    public static void routerBack(StageName lastStageName, StageName currentStageName){
        if(Router.currentStageName.equals(StageName.GAMERULES) && Router.lastStageName.equals(StageName.MAINMENU)){
            routerMainMenu(stage, lastStageName, currentStageName);
        }
        if(Router.currentStageName.equals(StageName.GAMERULES) && Router.lastStageName.equals(StageName.MAINMENUAUTH)){
            routerMainMenuAuth(stage, lastStageName, currentStageName);
        }
        else if(Router.lastStageName.equals(StageName.MAINMENU)){
            routerMainMenu(stage, lastStageName, currentStageName);
        }
        else if(Router.lastStageName.equals(StageName.LOGIN)){
            routerLogin(stage, lastStageName, currentStageName);
        }
        else if(Router.lastStageName.equals(StageName.REGISTER)){
            routerRegister(stage, lastStageName, currentStageName);
        }
    }
}
