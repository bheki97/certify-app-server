package za.ac.tut.bheki97.certifyapp.commissioner;

import jakarta.persistence.Entity;
import za.ac.tut.bheki97.certifyapp.user.User;

import java.util.Objects;

@Entity
public class Commissioner extends User {

    private boolean authorized;
    private String signatureFileName;

    private long oathId;


    public long getOathId() {
        return oathId;
    }

    public void setOathId(long oathId) {
        this.oathId = oathId;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getSignatureFileName() {
        return signatureFileName;
    }

    public void setSignatureFileName(String signatureFileName) {
        this.signatureFileName = signatureFileName;
    }

    @Override
    public String toString() {
        return "Commissioner{" +
                super.toString()+"\n"+
                "authorized=" + authorized +
                ", signatureFileName='" + signatureFileName + '\'' +
                ", oathId=" + oathId +
                '}';
    }
}
