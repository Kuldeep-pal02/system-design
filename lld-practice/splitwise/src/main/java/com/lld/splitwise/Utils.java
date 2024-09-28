package com.lld.splitwise;

import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;
import com.lld.splitwise.usermanagement.models.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Utils {
    List<User> generateUsers( ){
        return List.of( );
    }
    SplitwiseGroup createGroup( List<User> userList ){
        return new SplitwiseGroup();
    }
}
