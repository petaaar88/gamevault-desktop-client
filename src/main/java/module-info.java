module org.example.desktopclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.desktopclient to javafx.fxml;
    exports org.example.desktopclient;
}