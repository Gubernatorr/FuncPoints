module package1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens package1 to javafx.fxml;
    exports package1;
}