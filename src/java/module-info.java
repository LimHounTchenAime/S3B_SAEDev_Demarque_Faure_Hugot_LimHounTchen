module game.DragDrop {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;
    requires javafx.swing;

    opens Main to javafx.fxml;
    exports Main;
}