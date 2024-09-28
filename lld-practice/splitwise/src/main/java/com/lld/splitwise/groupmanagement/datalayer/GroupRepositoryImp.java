package com.lld.splitwise.groupmanagement.datalayer;

import com.lld.splitwise.groupmanagement.GroupDatabase;
import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;

public class GroupRepositoryImp implements IGroupRepository {
    private final GroupDatabase groupDatabase;

    public GroupRepositoryImp(GroupDatabase groupDatabase) {
        this.groupDatabase = groupDatabase;
    }

    @Override
    public void addGroup(SplitwiseGroup splitwiseGroup) {
        this.groupDatabase.getGroupMap().put(splitwiseGroup.getGroupId(), splitwiseGroup );
    }

    @Override
    public void updateGroup(SplitwiseGroup splitwiseGroup) {
        this.groupDatabase.getGroupMap().put( splitwiseGroup.getGroupId(), splitwiseGroup  );
    }

    @Override
    public SplitwiseGroup getGroupById(String id) {
        return this.groupDatabase.getGroupMap().get( id );
    }

    @Override
    public void deleteGroup(SplitwiseGroup splitwiseGroup) {
        this.groupDatabase.getGroupMap().remove( splitwiseGroup.getGroupId() );
    }
}
