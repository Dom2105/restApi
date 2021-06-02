package de.afp.restApi.user;

import java.util.List;

import de.afp.restApi.news.NewsModel;

public class UserNewsModel {

    private UserModel user;
    private List<NewsModel> news;

    public UserNewsModel() {
    }

    public UserNewsModel(UserModel user, List<NewsModel> news) {
        this.user = user;
        this.news = news;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<NewsModel> getNews() {
        return this.news;
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "{" + " user='" + getUser() + "'" + ", news='" + getNews() + "'" + "}";
    }

}
