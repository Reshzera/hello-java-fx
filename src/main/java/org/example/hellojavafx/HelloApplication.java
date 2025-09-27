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
        // --- Aba 1: UI programática ---
        VBox programmaticRoot = new VBox(12);
        programmaticRoot.setAlignment(Pos.CENTER);
        programmaticRoot.setPadding(new Insets(16));

        Label programmaticLabel = new Label("UI criada 100% via código Java");
        Button programmaticButton = new Button("Clique (programático)");
        programmaticButton.setOnAction(e -> System.out.println("Botão programático clicado!"));
        programmaticRoot.getChildren().addAll(programmaticLabel, programmaticButton);

        Tab tabProgrammatic = new Tab("Programático");
        tabProgrammatic.setClosable(false);
        tabProgrammatic.setContent(programmaticRoot); // <- direto, sem StackPane

        // --- Aba 2: UI via FXML ---
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent fxmlRoot = fxmlLoader.load();

        Tab tabFXML = new Tab("FXML");
        tabFXML.setClosable(false);
        tabFXML.setContent(fxmlRoot); // <- direto, sem StackPane

        // --- TabPane ---
        TabPane tabs = new TabPane(tabProgrammatic, tabFXML);

        Scene scene = new Scene(tabs, 480, 320);
        stage.setTitle("JavaFX: Programático vs FXML");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}