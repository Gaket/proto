package ru.innopolis.yorsogettingxbox.models;

public class Document {

    private String name;
    private boolean chainStatus;
    private int percentDone;

    public Document(String name, boolean chainStatus, int percentDone) {
        this.name = name;
        this.chainStatus = chainStatus;
        this.percentDone = percentDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChainStatus() {
        return chainStatus;
    }

    public void setChainStatus(boolean chainStatus) {
        this.chainStatus = chainStatus;
    }

    public int getPercentDone() {
        return percentDone;
    }

    public void setPercentDone(int percentDone) {
        this.percentDone = percentDone;
    }
}
