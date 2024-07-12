package com.lewis.userlogin.repository;

import com.lewis.userlogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "userdata", path= "userdata")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
