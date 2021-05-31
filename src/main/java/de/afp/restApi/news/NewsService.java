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

    public NewsModel newsAnlegen(NewsModel news) {
        return NEWSREPO.save(news);
    }

    public NewsModel newsUpdate(NewsModel news) throws Exception {
        return NEWSREPO.save(news);
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
