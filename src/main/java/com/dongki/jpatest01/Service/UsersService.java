package com.dongki.jpatest01.Service;

import com.dongki.jpatest01.Entity.Users;

import java.util.List;

public interface UsersService {

    public List<Users> getUsersService(String name);

    public String createUserService(Users user);

}
