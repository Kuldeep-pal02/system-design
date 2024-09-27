package com.lld.splitwise.usermanagement.models;


import com.lld.splitwise.usermanagement.models.acl.MyRole;
import lombok.Data;

import java.util.List;

@Data
public
class User {
    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private List<MyRole> roleList;

}

