package Main;

import Modele.Classe;
import Vue.Fleche;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();


//        Classe c1 = Classe.creerClasse("ClasseTest.Poisson");
//        Classe c2 = Classe.creerClasse("ClasseTest.Animal");
//        Fleche f = new Fleche(c1,c2);

        Line line = new Line(100, 10, 10, 100);
        Polygon arrowHead = new Polygon(10, 100, 10-10, 100-5, 10-10, 100+5);

        root.getChildren().addAll(line, arrowHead);

        Scene scene = new Scene(root, 400,400);
        stage.setScene(scene);
        stage.show();
    }
}
