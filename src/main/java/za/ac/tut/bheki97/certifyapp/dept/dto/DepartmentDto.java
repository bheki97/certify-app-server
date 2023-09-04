package za.ac.tut.bheki97.certifyapp.dept.dto;

import za.ac.tut.bheki97.certifyapp.dept.Department;
import za.ac.tut.bheki97.certifyapp.document.Document;

import java.util.Arrays;
import java.util.Objects;

public class DepartmentDto {

    private long deptId;
    private String deptName;
    private String stampName;
    private byte[] stampContent;


    public DepartmentDto() {
    }

    public DepartmentDto(String deptName, String stampName, byte[] stampContent) {
        this.deptName = deptName;
        this.stampName = stampName;
        this.stampContent = stampContent;
    }

    public DepartmentDto(long deptId, String deptName, String stampName, byte[] stampContent) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.stampName = stampName;
        this.stampContent = stampContent;
    }

    public Department toDepartment(){
        return new Department(this.deptName , this.stampName);
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getStampName() {
        return stampName;
    }

    public void setStampName(String stampName) {
        this.stampName = stampName;
    }

    public byte[] getStampContent() {
        return stampContent;
    }

    public void setStampContent(byte[] stampContent) {
        this.stampContent = stampContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDto that = (DepartmentDto) o;
        return Objects.equals(deptId, that.deptId) && Objects.equals(deptName, that.deptName) && Objects.equals(stampName, that.stampName) && Arrays.equals(stampContent, that.stampContent);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(deptId, deptName, stampName);
        result = 31 * result + Arrays.hashCode(stampContent);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", stampName='" + stampName + '\'' +
                ", stampContent=" + Arrays.toString(stampContent) +
                '}';
    }
}
