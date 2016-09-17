package ru.innopolis.yorsogettingxbox.models;

public class SignInfoEntity {
    public String signDate;
    public SignerEntity signer;
    public boolean isSigned;
    public String transactionId;

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public SignerEntity getSigner() {
        return signer;
    }

    public void setSigner(SignerEntity signer) {
        this.signer = signer;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
