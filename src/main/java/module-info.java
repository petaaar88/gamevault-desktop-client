module org.example.desktopclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens org.example.desktopclient.model.page to com.fasterxml.jackson.databind;
    opens org.example.desktopclient.model.game to com.fasterxml.jackson.databind;
    opens org.example.desktopclient.service.game to com.fasterxml.jackson.databind;

    opens org.example.desktopclient to javafx.fxml;
    exports org.example.desktopclient;
}