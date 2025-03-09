package org.example.desktopclient.util;

import javafx.concurrent.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends Task<Void> {

    private String downloadURL;
    private String destination;

    public DownloadTask(String downloadURL, String destination) {
        this.downloadURL = downloadURL;
        this.destination = destination;
    }

    @Override
    protected Void call() throws Exception {
        try {

            URL downloadUrl = new URL(downloadURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) downloadUrl.openConnection();

            int sizeOfFile = httpURLConnection.getContentLength();
            System.out.println(sizeOfFile);


            InputStream inputStream = downloadUrl.openStream();

            String fileName = downloadURL.split("/")[downloadURL.split("/").length - 1];

            System.out.println(fileName);
            FileOutputStream downloadedFile = new FileOutputStream(destination + "/" + fileName);
            byte[] bytes = new byte[1024];

            int len;

            int downloadedContent = 0;

            while ((len = inputStream.read(bytes)) != -1) {
                downloadedFile.write(bytes, 0, len);
                downloadedContent += len;

                if (sizeOfFile > 0) {
                    updateProgress(downloadedContent, sizeOfFile);
                   // System.out.println("Downloading: " + 100 * ((float) downloadedContent / sizeOfFile) + "%");
                } else {
                   // System.out.println("Downloading: " + downloadedContent + " bytes downloaded...");
                }
            }


            downloadedFile.close();
            httpURLConnection.disconnect();
            inputStream.close();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
