package de.afp.restApi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepo extends JpaRepository<UserAdminModel, Integer> {

}
