package halmapoc;

import halmapoc.extraUtil.DBTests;
import halmapoc.model.AppNameModel;
import halmapoc.presenter.MainMenuPresenter;
import halmapoc.view.MainMenuView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {
    private static final int TIMEOUT = 5000; // If no response in 5 seconds, exit
    private static final AtomicBoolean isResponsive = new AtomicBoolean(true);

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

        startWatchdog();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    private void startWatchdog() {
        Thread watchdog = new Thread(() -> {
            while (true) {
                try {
                    isResponsive.set(false);
                    Platform.runLater(() -> isResponsive.set(true));

                    Thread.sleep(TIMEOUT);

                    if (!isResponsive.get()) {
                        System.out.println("Application is unresponsive. Exiting...");
                        Platform.exit();
                        System.exit(1);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        watchdog.setDaemon(true);
        watchdog.start();
    }
}
