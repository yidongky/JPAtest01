package com.dongki.jpatest01.Repository;

import com.dongki.jpatest01.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findFirst2ByUserNameLikeOrderByIdDesc(String name);

}
