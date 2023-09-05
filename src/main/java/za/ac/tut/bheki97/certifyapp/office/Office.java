package za.ac.tut.bheki97.certifyapp.office;

import jakarta.persistence.*;
import za.ac.tut.bheki97.certifyapp.dept.Department;

import java.util.Objects;

@Entity
public class Office {

    @Id
    @Column(name = "office_id")
    private long offId;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;

    @Column(name = "office_name")
    private String offName;
    @Column(name = "stamp_name")
    private String stampName;

    public Office() {
    }

    public Office(long offId, Department dept, String offName, String stampName) {
        this.offId = offId;
        this.dept = dept;
        this.offName = offName;
        this.stampName = stampName;
    }

    public Office(Department dept, String offName, String stampName) {
        this.dept = dept;
        this.offName = offName;
        this.stampName = stampName;
    }

    public long getOffId() {
        return offId;
    }

    public void setOffId(long offId) {
        this.offId = offId;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getOffName() {
        return offName;
    }

    public void setOffName(String offName) {
        this.offName = offName;
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
        Office office = (Office) o;
        return offId == office.offId && Objects.equals(dept, office.dept) && Objects.equals(offName, office.offName) && Objects.equals(stampName, office.stampName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offId, dept, offName, stampName);
    }

    @Override
    public String toString() {
        return "Office{" +
                "offId=" + offId +
                ", dept=" + dept.toString() +
                ", offName='" + offName + '\'' +
                ", stampName='" + stampName + '\'' +
                '}';
    }
}