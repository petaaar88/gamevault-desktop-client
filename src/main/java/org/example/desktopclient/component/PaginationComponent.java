package org.example.desktopclient.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PaginationComponent {

    private HBox layout;
    private Button leftArrow;
    private Button rightArrow;
    private HBox pagesHbox;
    private Button rightPageNumberButton;
    private Button leftPageNumberButton;
    private Button currentPageNumberButton;

    public PaginationComponent(){
        layout = new HBox();
        layout.setPadding(new Insets(20,20,0,20));

        String css = getClass().getResource("/org/example/desktopclient/styles/paginationComponentStyles.css").toExternalForm();
        layout.getStylesheets().add(css);

        leftArrow =new Button("<");
        leftArrow.getStyleClass().add("pagination-item");
        pagesHbox = new HBox();
        currentPageNumberButton =new Button("2");
        currentPageNumberButton.getStyleClass().add("current-page");
        leftPageNumberButton =new Button("1");
        leftPageNumberButton.getStyleClass().add("pagination-item");
        rightPageNumberButton =new Button("3");
        rightPageNumberButton.getStyleClass().add("pagination-item");
        rightArrow =new Button(">");
        rightArrow.getStyleClass().add("pagination-item");

        pagesHbox.getChildren().addAll(leftPageNumberButton,currentPageNumberButton,rightPageNumberButton);

        layout.getChildren().addAll(leftArrow,pagesHbox, rightArrow);
        layout.setAlignment(Pos.CENTER);
    }

    public HBox getCompoenent(){

        return layout;
    }

    public Button getLeftArrow() {
        return leftArrow;
    }

    public void setLeftArrow(Button leftArrow) {
        this.leftArrow = leftArrow;
    }

    public Button getRightArrow() {
        return rightArrow;
    }

    public void setRightArrow(Button rightArrow) {
        this.rightArrow = rightArrow;
    }

    public HBox getLayout() {
        return layout;
    }

    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    public HBox getPagesHbox() {
        return pagesHbox;
    }

    public void setPagesHbox(HBox pagesHbox) {
        this.pagesHbox = pagesHbox;
    }

    public Button getRightPageNumberButton() {
        return rightPageNumberButton;
    }

    public void setRightPageNumberButton(Button rightPageNumberButton) {
        this.rightPageNumberButton = rightPageNumberButton;
    }

    public Button getLeftPageNumberButton() {
        return leftPageNumberButton;
    }

    public void setLeftPageNumberButton(Button leftPageNumberButton) {
        this.leftPageNumberButton = leftPageNumberButton;
    }

    public Button getCurrentPageNumberButton() {
        return currentPageNumberButton;
    }

    public void setCurrentPageNumberButton(Button currentPageNumberButton) {
        this.currentPageNumberButton = currentPageNumberButton;
    }

    //public void setContent()
}
