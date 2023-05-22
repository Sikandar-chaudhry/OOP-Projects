module com.example.cui_administration_app2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.cui_administration_app2 to javafx.fxml;
    exports com.example.cui_administration_app2;
}