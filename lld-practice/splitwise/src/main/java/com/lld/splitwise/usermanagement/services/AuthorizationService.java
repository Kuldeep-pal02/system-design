package com.lld.splitwise.usermanagement.services;

import com.lld.splitwise.usermanagement.models.User;
import com.lld.splitwise.usermanagement.models.acl.MyRole;
import lombok.Data;

import java.security.Permission;
import java.util.List;

@Data
public class AuthorizationService implements IAuthorize{
    private final List<MyRole> roleList ;
    @Override
    public void checkAccess(Permission permission, User user) {
        roleList.stream().flatMap(role -> role.getPermissionList().stream()).anyMatch(permission1 -> permission1.getPermissionName().equals( permission ));

    }
}
