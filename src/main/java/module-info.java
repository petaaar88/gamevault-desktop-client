module org.example.desktopclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.desktopclient to javafx.fxml;
    exports org.example.desktopclient;
}