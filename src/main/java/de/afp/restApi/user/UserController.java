package de.afp.restApi.user;

import java.util.List;
import java.util.Optional;

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
@RequestMapping(path = "/user")
public class UserController {

    private final UserService USERSERVICE;

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
        return new ResponseEntity<List<UserModel>>(ul, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
        UserModel u = USERSERVICE.userUpdate(userModel);
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

}
