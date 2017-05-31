/**
 * @author (created on 5/24/2017).
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class FirstAttempt extends Application {

    private static int LEVEL = 0;
    private static final int TOP_LEVEL = 6;

    public static void main(String[] args) {
        // System.getProperties().entrySet().forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeView<String> a1 = new TreeView<>();
        TreeView<String> a2 = new TreeView<>();
        BorderPane b = new BorderPane();

        ScrollPane scrollPaneLeft = new ScrollPane();
        ScrollPane scrollPaneRight = new ScrollPane();
        JSplitPane splitPane = new JSplitPane();

        a1.setRoot(getNodesForDirectory(new File(System.getProperty("user.home"))));
        scrollPaneLeft.setContent(a1);
        b.setLeft(scrollPaneLeft);

        LEVEL = 0;
        a2.setRoot(getNodesForDirectory(new File("..")));
        scrollPaneRight.setContent(a2);
        b.setRight(scrollPaneRight);

        primaryStage.setScene(new Scene(b, 600, 400));
        primaryStage.setTitle("TotalniyKomandir");
        primaryStage.show();
    }

    private TreeItem<String> getNodesForDirectory(File directory) {
        TreeItem<String> root = new TreeItem<>(directory.getName());
        for (File f : directory.listFiles()) {
            //System.out.println("Loading " + f.getName());
            if (f.isDirectory() && LEVEL < TOP_LEVEL) { //Then we call the function recursively to the LEVEL
                root.getChildren().add(getNodesForDirectory(f));
                LEVEL += 1;
            } else {
                root.getChildren().add(new TreeItem<>(f.getName() + "\tFILE"));
            }
        }
        return root;
    }
}
