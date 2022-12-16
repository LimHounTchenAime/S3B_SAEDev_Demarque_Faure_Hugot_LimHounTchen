module game.dragdrop {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.Main to javafx.fxml;
    exports game.Main;
}