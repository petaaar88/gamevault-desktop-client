package org.example.desktopclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.desktopclient.component.GameInLibraryActionButtonComponent;
import org.example.desktopclient.model.game.GameStatus;
import org.example.desktopclient.util.JsonFileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GameInLibraryActionButtonController {

    private JsonFileManager jsonFileManager;
    private GameInLibraryActionButtonComponent component;

    public GameInLibraryActionButtonController(GameInLibraryActionButtonComponent component) {
        this.jsonFileManager = new JsonFileManager();
        this.component = component;
        this.checkGameStatus();

    }

    public void checkGameStatus() {

    }

}

