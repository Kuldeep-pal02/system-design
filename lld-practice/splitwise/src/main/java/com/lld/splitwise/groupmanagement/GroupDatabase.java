package com.lld.splitwise.groupmanagement;

import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;
import lombok.Data;

import java.util.Map;
@Data
public class GroupDatabase {
    private final Map<String, SplitwiseGroup> groupMap;

    public GroupDatabase(Map<String, SplitwiseGroup> groupMap) {
        this.groupMap = groupMap;
    }

}
