package com.example.cui_administration_app2;

public class Computer {

    private String systemId;
    private String systemName;
    private String systemSpeed;
    private String ramSize;
    private String hardDiskSize;
    private String lcdMakeModel;

    public Computer() {
    }

    public Computer(String systemId, String systemName, String systemSpeed, String ramSize, String hardDiskSize, String lcdMakeModel) {
        this.systemId = systemId;
        this.systemName = systemName;
        this.systemSpeed = systemSpeed;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.lcdMakeModel = lcdMakeModel;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemSpeed() {
        return systemSpeed;
    }

    public void setSystemSpeed(String systemSpeed) {
        this.systemSpeed = systemSpeed;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getLcdMakeModel() {
        return lcdMakeModel;
    }

    public void setLcdMakeModel(String lcdMakeModel) {
        this.lcdMakeModel = lcdMakeModel;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "systemId='" + systemId + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemSpeed='" + systemSpeed + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", hardDiskSize='" + hardDiskSize + '\'' +
                ", lcdMakeModel='" + lcdMakeModel + '\'' +
                '}';
    }
}
