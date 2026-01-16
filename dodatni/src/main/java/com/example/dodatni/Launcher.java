package com.example.dodatni;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Launcher extends Application{
    @Override
    public void start(Stage stage) {

        ObservableList<String> studenti = FXCollections.observableArrayList(
                "Nerina Čengić",
                "Amina Bukvić",
                "Emina Vatrić",
                "Ajša Brka",
                "Dalila Kršlak",
                "Ismail Mujanović",
                "Sara Hasić",
                "Berina Berić",
                "Maja Muftić",
                "Emina Karić"
        );


        Label naslov = new Label("Studenti");
        naslov.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        naslov.setMaxWidth(Double.MAX_VALUE);
        naslov.setAlignment(Pos.CENTER);

        Label lblStaro = new Label("Staro ime:");
        TextField tfStaro = new TextField();

        Label lblNovo = new Label("Novo ime:");
        TextField tfNovo = new TextField();

        Button btnEdituj = new Button("Edituj");
        btnEdituj.setPrefWidth(300);

        ListView<String> lista = new ListView<>(studenti);

       //izgled ekrana
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1, col2);


        grid.add(naslov, 0, 0, 2, 1);

        // Staro ime
        grid.add(lblStaro, 0, 1);
        grid.add(tfStaro, 1, 1);

        // Novo ime
        grid.add(lblNovo, 0, 2);
        grid.add(tfNovo, 1, 2);

        // Dugme (75%, centrirano)
        HBox dugmeBox = new HBox(btnEdituj);
        dugmeBox.setAlignment(Pos.CENTER);
        grid.add(dugmeBox, 0, 3, 2, 1);


        grid.add(lista, 0, 4, 2, 1);


        btnEdituj.setOnAction(e -> {
            String staroIme = tfStaro.getText().trim();
            String novoIme = tfNovo.getText().trim();

            if (staroIme.isEmpty() || novoIme.isEmpty()) {
                showAlert("Greška", "Polja ne smiju biti prazna!");
                return;
            }

            if (staroIme.equals(novoIme)) {
                showAlert("Upozorenje", "Staro i novo ime se podudaraju!");
                return;
            }

            boolean promjena = false;

            for (int i = 0; i < studenti.size(); i++) {
                if (studenti.get(i).equalsIgnoreCase(staroIme)) {
                    studenti.set(i, novoIme);
                    promjena = true;
                }
            }

            if (!promjena) {
                showAlert("Info", "Uneseno staro ime ne postoji u listi i ne može se zamijeniti.");
            }

            tfStaro.clear();
            tfNovo.clear();
        });

        Scene scene = new Scene(grid, 500, 500);
        stage.setTitle("Studenti");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }




    public static void main(String[] args) {
        launch();
    }


}








