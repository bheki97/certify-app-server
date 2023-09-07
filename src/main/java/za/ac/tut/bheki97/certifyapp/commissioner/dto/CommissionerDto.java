package za.ac.tut.bheki97.certifyapp.commissioner.dto;

import java.util.Arrays;

public class CommissionerDto {

    private String userId;

    private long authId;
    private long officeId;

    private boolean authorized;
    private String signatureFileName;
    private byte[] signatureContent;


    public CommissionerDto() {

    }

    public CommissionerDto(String userId, long authId, long officeId, boolean authorized, String signatureFileName, byte[] signatureContent) {
        this.userId = userId;
        this.authId = authId;
        this.officeId = officeId;
        this.authorized = authorized;
        this.signatureFileName = signatureFileName;
        this.signatureContent = signatureContent;
    }

    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
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

    public byte[] getSignatureContent() {
        return signatureContent;
    }

    public void setSignatureContent(byte[] signatureContent) {
        this.signatureContent = signatureContent;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "CommissionerDto{" +
                "userId='" + userId + '\'' +
                ", authId=" + authId +
                ", officeId=" + officeId +
                ", authorized=" + authorized +
                ", signatureFileName='" + signatureFileName + '\'' +
                ", signatureContent=" + Arrays.toString(signatureContent) +
                '}';
    }
}
