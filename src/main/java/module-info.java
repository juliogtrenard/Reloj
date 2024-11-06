module es.juliogtrenard.reloj {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.juliogtrenard.reloj to javafx.fxml;
    exports es.juliogtrenard.reloj;
}