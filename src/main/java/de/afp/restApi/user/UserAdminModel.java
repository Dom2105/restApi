package de.afp.restApi.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.afp.restApi.news.NewsModel;

@Entity
@Table(name = "user")
public class UserAdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int userId;
    @Column(unique = true, columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "password", columnDefinition = "varchar(50)")
    private String pw;
    @OneToMany(mappedBy = "user")
    private Set<NewsModel> news;

    public UserAdminModel() {
    }

    public UserAdminModel(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setNews(Set<NewsModel> news) {
        this.news = news;
    }

    public UserAdminModel userId(int userId) {
        setUserId(userId);
        return this;
    }

    public UserAdminModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserAdminModel pw(String pw) {
        setPw(pw);
        return this;
    }

    public UserAdminModel news(Set<NewsModel> news) {
        setNews(news);
        return this;
    }

}
