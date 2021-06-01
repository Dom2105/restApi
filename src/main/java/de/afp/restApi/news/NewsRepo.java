package de.afp.restApi.news;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface NewsRepo extends JpaRepository<NewsModel, Integer> {

    @Modifying
    @Query("SELECT n FROM NewsModel n WHERE user_id = ?1")
    List<NewsModel> findNewsByUser(int user_id);

}
