package za.ac.tut.bheki97.certifyapp.dept;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
public class Department {

    @Id
    @Column(name = "dept_id")
    private long deptId;
    @Column(name ="dept_name" )
    private String deptName;
    @Column(name = "stamp_name")
    private String stampName;
    private boolean active = true;


    public Department() {
    }

    public Department(long deptId, String deptName, String stampName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.stampName = stampName;
    }

    public Department(long deptId) {
        this.deptId = deptId;
    }

    public Department(String deptName, String stampName) {
        this.deptName = deptName;
        this.stampName = stampName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptId == that.deptId && active == that.active && Objects.equals(deptName, that.deptName) && Objects.equals(stampName, that.stampName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, stampName, active);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", stampName='" + stampName + '\'' +
                ", active=" + active +
                '}';
    }
}
