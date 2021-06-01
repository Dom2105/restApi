package de.afp.restApi.news;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.afp.restApi.user.UserModel;

@Entity
@Table(name = "news")
public class NewsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int newsId;
    @Column(columnDefinition = "varchar(25)")
    private String titel;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public NewsModel() {
    }

    public NewsModel(String titel, String text, UserModel user) {
        this.titel = titel;
        this.text = text;
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public int getNewsId() {
        return this.newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
