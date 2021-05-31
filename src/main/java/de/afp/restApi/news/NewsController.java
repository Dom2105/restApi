package de.afp.restApi.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/news")
public class NewsController {

    public final NewsService NEWSSERVICE;

    @Autowired
    public NewsController(NewsService NEWSSERVICE) {
        this.NEWSSERVICE = NEWSSERVICE;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<NewsModel> newsAnlegen(@RequestBody NewsModel news) {
        NewsModel n = NEWSSERVICE.newsAnlegen(news);
        return new ResponseEntity<>(n, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<NewsModel>> alleNews() {
        List<NewsModel> ls = NEWSSERVICE.alleNews();
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<NewsModel> newsUpadta(@RequestBody NewsModel news) throws Exception {
        NewsModel n = NEWSSERVICE.newsUpdate(news);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> newsLoeschen(@PathVariable("id") int id) {

        String text = NEWSSERVICE.newsLoeschen(id);

        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
