package de.afp.restApi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.afp.restApi.news.NewsModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

}
