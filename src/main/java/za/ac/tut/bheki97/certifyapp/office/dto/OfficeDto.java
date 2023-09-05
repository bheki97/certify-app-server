package za.ac.tut.bheki97.certifyapp.office.dto;


import za.ac.tut.bheki97.certifyapp.dept.Department;
import za.ac.tut.bheki97.certifyapp.office.Office;

import java.util.Arrays;

public class OfficeDto {

    private long offId;
    private long deptId;
    private String offName;
    private String stampName;
    private byte[] stampContent;


    public OfficeDto() {
    }

    public OfficeDto(long offId, long deptId, String offName, String stampName, byte[] stampContent) {
        this.offId = offId;
        this.deptId = deptId;
        this.offName = offName;
        this.stampName = stampName;
        this.stampContent = stampContent;
    }

    public OfficeDto(long deptId, String offName, String stampName, byte[] stampContent) {
        this.deptId = deptId;
        this.offName = offName;
        this.stampName = stampName;
        this.stampContent = stampContent;
    }

    public Office toOffice(){
        return new Office(new Department(this.deptId),this.offName,this.stampName);
    }

    public long getOffId() {
        return offId;
    }

    public void setOffId(long offId) {
        this.offId = offId;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getOffName() {
        return offName;
    }

    public void setOffName(String offName) {
        this.offName = offName;
    }

    public byte[] getStampContent() {
        return stampContent;
    }

    public void setStampContent(byte[] stampContent) {
        this.stampContent = stampContent;
    }

    public String getStampName() {
        return stampName;
    }

    public void setStampName(String stampName) {
        this.stampName = stampName;
    }

    @Override
    public String toString() {
        return "OfficeDto{" +
                "offId=" + offId +
                ", deptId=" + deptId +
                ", offName='" + offName + '\'' +
                ", stampName='" + stampName + '\'' +
                ", stampContent=" + Arrays.toString(stampContent) +
                '}';
    }
}
