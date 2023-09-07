package za.ac.tut.bheki97.certifyapp.commissioner;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import za.ac.tut.bheki97.certifyapp.office.Office;
import za.ac.tut.bheki97.certifyapp.user.User;

import java.util.Objects;

@Entity
public class Commissioner extends User {

    private boolean authorized;
    private String signatureFileName;
    private long oathId;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public Commissioner() {
    }

    public Commissioner(String email, String password, String name, String surname, String cellNo, String role, boolean authorized, String signatureFileName, long oathId, Office office) {
        super(email, password, name, surname, cellNo, role);
        this.authorized = authorized;
        this.signatureFileName = signatureFileName;
        this.oathId = oathId;
        this.office = office;
    }

    public Commissioner(User user, String signatureFileName, long oathId, Office office) {
        super(user);
        this.signatureFileName = signatureFileName;
        this.oathId = oathId;
        this.office = office;
    }

    public Commissioner(User user, long oathId, Office office) {
        super(user);
        this.oathId = oathId;
        this.office = office;
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

    public long getOathId() {
        return oathId;
    }

    public void setOathId(long oathId) {
        this.oathId = oathId;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commissioner that = (Commissioner) o;
        return authorized == that.authorized && oathId == that.oathId && Objects.equals(signatureFileName, that.signatureFileName) && Objects.equals(office, that.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authorized, signatureFileName, oathId, office);
    }

    @Override
    public String toString() {
        return super.toString()+"\nCommissioner{" +
                "authorized=" + authorized +
                ", signatureFileName='" + signatureFileName + '\'' +
                ", oathId=" + oathId +
                ", office=" + office.toString() +
                '}';
    }
}
