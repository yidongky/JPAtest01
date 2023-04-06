package com.dongki.jpatest01.Service;

import com.dongki.jpatest01.Entity.Users;
import com.dongki.jpatest01.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;
    Predicate<String> StringNullCheck = (i) -> (!Optional.ofNullable(i).isPresent() && i.isEmpty());


    public List<Users> getUsersService(String name) {

        if (StringNullCheck.Check(name)) // name 파라미터가 Null 또는 길이가 0 전체 user를 리턴
            return userRepository.findAll();
        else  // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUserNameLikeOrderByIdDesc("%"+name+"%");
    }

    public String createUserService(Users user) {
        userRepository.save(user); // User Insert 쿼리 수행
        return "등록 완료";
    }

    @FunctionalInterface
    public interface Predicate<T> {
        boolean Check(T t);
    }

}
