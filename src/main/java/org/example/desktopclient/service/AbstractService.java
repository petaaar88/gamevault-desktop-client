package org.example.desktopclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public abstract class AbstractService {
    protected HttpClient client;
    protected ObjectMapper objectMapper;

    public AbstractService() {
        this.client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public HttpClient getClient() {
        return client;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
