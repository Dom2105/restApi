package de.afp.restApi.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo USERREPO;

    @Autowired
    public UserService(UserRepo USERREPO) {
        this.USERREPO = USERREPO;
    }

    public UserModel userSpeichern(UserModel userModel) {
        return USERREPO.save(userModel);
    }

    public List<UserModel> alleUser() {
        return USERREPO.findAll();
    }

    public UserModel userUpdate(UserModel userModel) {
        return USERREPO.save(userModel);
    }

    public void userLoeschen(int userId) {
        USERREPO.deleteById(userId);
    }

    public Optional<UserModel> findeUser(int id) {
        return USERREPO.findById(id);
    }

}
