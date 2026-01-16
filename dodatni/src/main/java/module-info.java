module com.example.dodatni {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.dodatni to javafx.fxml;
    exports com.example.dodatni;
}