package com.lucene.handson.model;

import com.lucene.handson.common.RandomStringGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String description;

    public static List<User> getNRandomUser( int n){
        List<User> userList = new ArrayList<>( n);
        StringBuilder stringBuilder = new StringBuilder();
        for( int i =0;i<n ; i++){
            User user = new User();
            stringBuilder.setLength( 0 );
            user.setId(UUID.randomUUID().toString());
            String name = RandomStringGenerator.generateRandomString();

            user.setName( name );
            user.setEmail(stringBuilder.append( name ).append("@gmail.com").toString());
            user.setDescription( "Description : "+ name);
            userList.add(user);
        }
        return userList;

    }
}
