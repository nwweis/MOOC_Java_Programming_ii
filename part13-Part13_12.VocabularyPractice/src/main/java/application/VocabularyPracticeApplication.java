package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) throws Exception {

        PracticeView practiceView = new PracticeView(dictionary);
        InputView inputView = new InputView(dictionary);

        BorderPane layout = new BorderPane();

        HBox switchWindow = new HBox();

        switchWindow.setPadding(new Insets(20, 20, 20, 20));
        switchWindow.setSpacing(10);

        Button newWordButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        switchWindow.getChildren().addAll(newWordButton, practiceButton);
        layout.setTop(switchWindow);

        newWordButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));

        layout.setCenter(inputView.getView());

        Scene view = new Scene(layout, 400, 300);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
