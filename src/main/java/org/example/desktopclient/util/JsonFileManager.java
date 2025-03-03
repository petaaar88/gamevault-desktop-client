package org.example.desktopclient.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileManager {

    public boolean doesFileExist(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    public void createFile(String filePath) throws Exception {
        Path jsonFile = Paths.get(filePath);
        try {
            if (!Files.exists(jsonFile)) {
                Files.createDirectories(jsonFile.getParent()); // Kreira direktorijum ako ne postoji
                Files.createFile(jsonFile); // Kreira prazan JSON fajl
                System.out.println("JSON fajl kreiran: " + jsonFile);
            } else {
                System.out.println("Fajl već postoji.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Path getConfigFilePath(String applicationName, String fileName) {
        String os = System.getProperty("os.name").toLowerCase();
        Path configDir;

        if (os.contains("win")) {
            configDir = Paths.get(System.getenv("LOCALAPPDATA"), applicationName);
        } else {
            configDir = Paths.get(System.getProperty("user.home"), ".config", applicationName);
        }

        return configDir.resolve(fileName);
    }

    public  void ensureFileExists(String applicationName, String fileName) throws IOException {
        Path configFile = getConfigFilePath(applicationName,fileName);
        Path configDir = configFile.getParent();

        if (!Files.exists(configDir)) {
            Files.createDirectories(configDir); // Kreira direktorijum ako ne postoji
            Path file =Files.createFile(configFile);
            Files.write(file, "[]".getBytes(StandardCharsets.UTF_8));
        }
        if (!Files.exists(configFile)) {
            Path file =Files.createFile(configFile); // Kreira prazan fajl ako ne postoji
            Files.write(file, "[]".getBytes(StandardCharsets.UTF_8));
        }
    }


}
