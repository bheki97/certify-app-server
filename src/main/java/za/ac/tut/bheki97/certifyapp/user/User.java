package za.ac.tut.bheki97.certifyapp.user;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "user_id")
    private String email;
    private String password;
    private String name;
    private String surname;
    private String cellNo;
    private String role;

    private boolean active;


    public User() {
        this.active = true;
    }

    public User(User user){
        this.email = user.email;
        this.password = user.password;
        this.name = user.name;
        this.surname = user.surname;
        this.cellNo = user.cellNo;
        this.role = user.role;
        this.active = user.active;
    }

    public User(String email) {
        this.email = email;
        this.active = true;
    }

    public User(String email, String password, String name, String surname, String cellNo, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cellNo = cellNo;
        this.role = role;
        this.active = true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(cellNo, user.cellNo) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name, surname, cellNo, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellNo='" + cellNo + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
