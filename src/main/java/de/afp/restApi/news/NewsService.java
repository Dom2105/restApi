package de.afp.restApi.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsRepo NEWSREPO;

    @Autowired
    public NewsService(NewsRepo NEWSREPO) {
        this.NEWSREPO = NEWSREPO;
    }

    public List<NewsModel> alleNews() {
        return NEWSREPO.findAll();
    }

    public static int teil = 1;

    public NewsModel newsAnlegen(NewsModel news) {

        if (news.getText().length() <= 255 && teil == 1) {
            return eineNews(news);
        } else {
            return mehererNews(news);
        }

    }

    public NewsModel eineNews(NewsModel news) {
        return NEWSREPO.save(news);
    }

    public NewsModel mehererNews(NewsModel news) {

        String oldTitle = news.getTitel();

        String newTitle = news.getTitel() + " Teil-" + teil;
        teil = teil + 1;
        String newText;
        String rest = null;

        if (news.getText().length() <= 255) {
            newText = news.getText();

        } else {
            newText = news.getText().substring(0, 255);
            rest = news.getText().substring(255);
        }

        news.setTitel(newTitle);
        news.setText(newText);
        if (rest != null) {
            mehererNews(new NewsModel(oldTitle, rest, news.getUser()));
        }
        teil = 1;
        return NEWSREPO.save(news);
    }

    public NewsModel newsUpdate(NewsModel news) throws Exception {
        return NEWSREPO.save(news);
    }

    public List<NewsModel> alleUserNews(int id) {
        return NEWSREPO.findNewsByUser(id);
    }

    public NewsModel titelSuche(String titel) {
        NewsModel ret = new NewsModel();
        for (NewsModel news : alleNews()) {
            if (news.getTitel().equals(titel)) {
                ret = news;
            }
        }
        return ret;
    }

    public String newsLoeschen(int id) {
        String text;

        try {
            NEWSREPO.deleteById(id);
            text = "News mit der ID " + id + " wurde entfernt!";
        } catch (Exception e) {
            System.out.println(e);
            text = "News mit der ID " + id + " konnte nicht gelöscht werden";
        }

        return text;
    }

}
