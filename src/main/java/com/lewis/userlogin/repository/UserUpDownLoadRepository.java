package com.lewis.userlogin.repository;

import com.lewis.userlogin.entity.UserUpDownLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUpDownLoadRepository extends JpaRepository<UserUpDownLoad, Long> {
}
