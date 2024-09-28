package com.lld.splitwise.groupmanagement.datalayer;

import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;

public interface IGroupRepository {

    void addGroup(SplitwiseGroup splitwiseGroup);
    void updateGroup( SplitwiseGroup splitwiseGroup );
    SplitwiseGroup getGroupById( String id );
    void deleteGroup( SplitwiseGroup splitwiseGroup);

}
