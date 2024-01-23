module com.example.testavisualisering {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kodkamraterna to javafx.fxml;
    exports com.example.kodkamraterna;
}