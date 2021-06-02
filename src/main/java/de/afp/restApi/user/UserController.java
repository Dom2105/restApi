package de.afp.restApi.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.HttpParser;
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

import de.afp.restApi.news.NewsService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService USERSERVICE;

    @Autowired
    private UserAdminRepo admin;
    @Autowired
    private NewsService news;

    @Autowired
    public UserController(UserService USERSERVICE) {
        this.USERSERVICE = USERSERVICE;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel) {
        UserModel u = USERSERVICE.userSpeichern(userModel);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserModel>> alleUser() {
        List<UserModel> ul = USERSERVICE.alleUser();

        return new ResponseEntity<>(ul, HttpStatus.OK);

    }

    @GetMapping(path = "/uN")
    public ResponseEntity<List<UserNewsModel>> alleUserMitNews() {
        List<UserModel> ul = USERSERVICE.alleUser();
        List<UserNewsModel> lun = new ArrayList<>();
        for (UserModel u : ul) {
            lun.add(new UserNewsModel(u, news.alleUserNews(u.getUserId())));
        }

        return new ResponseEntity<>(lun, HttpStatus.OK);

    }

    @PutMapping(path = "/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
        UserModel u = USERSERVICE.userUpdate(userModel);
        u.holePw();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<UserModel> userLoeschen(@PathVariable("id") int userId) {
        USERSERVICE.userLoeschen(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/one/{id}")
    public ResponseEntity<Optional<UserModel>> findeUser(@PathVariable("id") int id) {
        Optional<UserModel> u = USERSERVICE.findeUser(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping(path = "/admin/all")
    public ResponseEntity<List<?>> adminUser() {
        List<UserAdminModel> ul = admin.findAll();
        return new ResponseEntity<List<?>>(ul, HttpStatus.OK);
    }

    @GetMapping(path = "/string")
    public ResponseEntity<String> strings() {
        String vorname = "Dominic";
        char c = vorname.charAt(1);
        int stringLaenge = vorname.length();// int
        int index = vorname.indexOf("in");// int
        String sub = vorname.substring(2, 5); // string
        String up = vorname.toUpperCase();// string
        String low = vorname.toLowerCase(); // string
        boolean eq = up.equals(low);// false
        boolean eqI = up.equalsIgnoreCase(low); // true
        boolean start = vorname.startsWith("D"); // true
        boolean con = vorname.contains("x"); // false
        String newVorname = vorname.replace("i", "I"); // DomInIc
        String untrim = " a b c ";
        String trimd = untrim.trim(); // "a b c"
        String nachname = new String("Rittig");
        vorname = vorname + " " + nachname;
        return new ResponseEntity<>(vorname, HttpStatus.OK);
    }
}
