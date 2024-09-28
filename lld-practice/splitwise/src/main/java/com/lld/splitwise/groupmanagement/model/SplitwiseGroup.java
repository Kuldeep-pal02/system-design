package com.lld.splitwise.groupmanagement.model;

import com.lld.splitwise.expanse.Expense;
import com.lld.splitwise.usermanagement.models.User;
import lombok.Data;

import java.util.List;

@Data
public class SplitwiseGroup {
    private String groupId;         // Unique identifier for the group
    private String groupName;       // Name of the group
    private User createdBy;         // User who created the group
    private List<User> members;     // List of members in the group
    private List<Expense> expenses; // List of expenses in the group

    public void addMember(User user) {
        members.add(user);
    }

    public void removeMember(User user) {
        members.remove(user);
    }
}
