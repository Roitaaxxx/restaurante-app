module com.mycompany.proyectorestaurante {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectorestaurante to javafx.fxml;
    exports com.mycompany.proyectorestaurante;
}
