module game.dragdrop {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens Main to javafx.fxml;
    exports Main;
}