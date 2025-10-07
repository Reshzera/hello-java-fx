package org.example.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox programmaticRoot = new VBox(12);
        programmaticRoot.setAlignment(Pos.CENTER);
        programmaticRoot.setPadding(new Insets(16));

        Label programmaticLabel = new Label("UI created using programmatic approach");
        Button programmaticButton = new Button("Click");
        programmaticButton.setOnAction(e -> System.out.println("Button clicked!"));
        programmaticRoot.getChildren().addAll(programmaticLabel, programmaticButton);

        Tab tabProgrammatic = new Tab("Programmatic");
        tabProgrammatic.setClosable(false);
        tabProgrammatic.setContent(programmaticRoot);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent fxmlRoot = fxmlLoader.load();

        Tab tabFXML = new Tab("FXML");
        tabFXML.setClosable(false);
        tabFXML.setContent(fxmlRoot);

        TabPane tabs = new TabPane(tabProgrammatic, tabFXML);

        Scene scene = new Scene(tabs, 480, 320);
        stage.setTitle("JavaFX: Programmatic vs FXML");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}