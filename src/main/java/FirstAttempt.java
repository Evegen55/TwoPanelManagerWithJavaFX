/**
 * @author (created on 5/24/2017).
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

public class FirstAttempt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeView<String> a1 = new TreeView<>();
        TreeView<String> a2 = new TreeView<>();
        BorderPane b = new BorderPane();
        a1.setRoot(getNodesForDirectory(new File(System.getProperty("user.home"))));
        b.setLeft(a1);
        a2.setRoot(getNodesForDirectory(new File(System.getProperty("user.home"))));
        b.setRight(a2);
        primaryStage.setScene(new Scene(b, 600, 400));
        primaryStage.setTitle("Folder View");
        primaryStage.show();
    }

    private TreeItem<String> getNodesForDirectory(File directory) {
        TreeItem<String> root = new TreeItem<>(directory.getName());
        for (File f : directory.listFiles()) {
            System.out.println("Loading " + f.getName());
            //  if(f.isDirectory()) { //Then we call the function recursively
            //root.getChildren().add(getNodesForDirectory(f));
            //} else {
            root.getChildren().add(new TreeItem<>(f.getName()));
            // }
        }
        return root;
    }
}
