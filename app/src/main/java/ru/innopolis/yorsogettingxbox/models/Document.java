package ru.innopolis.yorsogettingxbox.models;

public class Document {

    private int id;
    private String name;
    private String link;
    private SignInfoEntity signInfo;
    private boolean chainStatus;
    private int percentDone;
    private String hash;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SignInfoEntity getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(SignInfoEntity signInfo) {
        this.signInfo = signInfo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
