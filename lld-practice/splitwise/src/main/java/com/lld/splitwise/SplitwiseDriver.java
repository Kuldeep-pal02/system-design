package com.lld.splitwise;

import com.lld.splitwise.groupmanagement.GroupDatabase;
import com.lld.splitwise.groupmanagement.datalayer.GroupRepositoryImp;
import com.lld.splitwise.groupmanagement.datalayer.IGroupRepository;
import com.lld.splitwise.usermanagement.models.User;
import com.lld.splitwise.usermanagement.services.InMemoryUserRegistration;

import java.util.HashMap;
import java.util.List;

public class SplitwiseDriver {

    public static void main(String[] args) {
        List<User> usersInSplitwise = Utils.generateUsers();
        GroupDatabase groupDatabase = new GroupDatabase( new HashMap<>());
        InMemoryUserRegistration inMemoryUserRegistration = new InMemoryUserRegistration( new HashMap<>() );
        for( User user : usersInSplitwise ){
            inMemoryUserRegistration.registerUser( user );
        }
        IGroupRepository groupRepository = new GroupRepositoryImp( groupDatabase );
        groupRepository.addGroup( Utils.createGroup( usersInSplitwise ) );


    }
}
