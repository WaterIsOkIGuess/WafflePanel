module com.wafflepanel.wafflepanel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    requires org.jsoup;
    requires rkon.core;
    requires org.json;

    opens com.wafflepanel.wafflepanel to javafx.fxml;
    exports com.wafflepanel.wafflepanel;
}