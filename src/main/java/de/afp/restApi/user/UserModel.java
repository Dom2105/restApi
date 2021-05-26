package de.afp.restApi.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int userId;
    @Column(unique = true, columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "password", columnDefinition = "varchar(50)")
    private String pw;

    public UserModel() {
    }

    public UserModel(String email, String pw) {
        this.email = email;
        setPw(pw);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "{" + " userId='" + getUserId() + "'" + ", email='" + getEmail() + "'" + ", pw='" + getPw() + "'" + "}";
    }

}