package com.lld.splitwise.usermanagement.services;

import com.lld.splitwise.usermanagement.models.User;
import com.lld.splitwise.usermanagement.models.UserDto;
import lombok.Data;

import java.util.Map;

@Data
public class InMemoryUserRegistration implements IUserRegistration{
    Map<String, User > loggedInUsers;


    public InMemoryUserRegistration( Map<String, User > loggedInUsers){
        this.loggedInUsers = loggedInUsers;
    }

    @Override
    public void registerUser(UserDto user) {
        loggedInUsers.put(user.getUserId(),  user);
    }
}
