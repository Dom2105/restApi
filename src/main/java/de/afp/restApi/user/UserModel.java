package de.afp.restApi.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.afp.restApi.news.NewsModel;

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
    @OneToMany(fetch = FetchType.LAZY)
    private List<NewsModel> news;

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
        Integer pwhash = pw.hashCode();

        String stingHash = pwhash.toString();
        this.pw = stingHash;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    /*
     * public String getPw() { return pw; }
     */

    public String holePw() {
        return pw;
    }

    public int getUserId() {
        return userId;
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "{" + " userId='" + getUserId() + "'" + ", email='" + getEmail() + "'" + ", news='" + "'" + "}";
    }

}
