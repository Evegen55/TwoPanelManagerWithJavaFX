package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.File;

/**
 * @author (created on 6/23/2017).
 */
public class Controller {

    private static int LEVEL = 0;
    private static final int TOP_LEVEL = 6;
    private static final String USER_HOME = "user.home";
    private static final String USER_ROOT = "..";

    @FXML
    private Tab myTabWithFilesUserHome;

    @FXML
    private Tab myTabWithFiles;

    public void method1() {
        LEVEL = 0;
        TreeView<String> a1 = new TreeView<>();
        a1.setRoot(getNodesForDirectory(new File(System.getProperty(USER_HOME))));
        myTabWithFilesUserHome.setContent(a1);
    }

    public void method2() {
        LEVEL = 0;
        TreeView<String> a2 = new TreeView<>();
        a2.setRoot(getNodesForDirectory(new File(USER_ROOT)));
        myTabWithFiles.setContent(a2);
    }

    /**
     *
     * @param directory
     * @return
     */
    public static TreeItem<String> getNodesForDirectory(File directory) {
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

