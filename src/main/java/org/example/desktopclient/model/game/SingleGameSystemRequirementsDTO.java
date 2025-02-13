package org.example.desktopclient.model.game;

public class SingleGameSystemRequirementsDTO{
        String cpu;
        String gpu;
        Integer expectedStorage;
        Integer storage;
        String operatingSystem;
        Integer ram;

    public SingleGameSystemRequirementsDTO() {
    }

    public SingleGameSystemRequirementsDTO(String cpu, String gpu, Integer expectedStorage, Integer storage, String operatingSystem, Integer ram) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.expectedStorage = expectedStorage;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Integer getExpectedStorage() {
        return expectedStorage;
    }

    public void setExpectedStorage(Integer expectedStorage) {
        this.expectedStorage = expectedStorage;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }
}
