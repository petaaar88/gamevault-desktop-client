package org.example.desktopclient.controller;

public interface IPaginable {
    void nextPage();
    void previousPage();
    void page(int page);

}
