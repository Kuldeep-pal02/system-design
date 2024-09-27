package com.lld.splitwise.usermanagement.services;


import com.lld.splitwise.usermanagement.models.User;

import java.security.Permission;

public interface IAuthorize {
    void checkAccess(Permission permission, User user);
}
