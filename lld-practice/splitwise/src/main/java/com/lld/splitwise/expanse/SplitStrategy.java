package com.lld.splitwise.expanse;

import com.lld.splitwise.usermanagement.models.User;

import java.util.List;

public interface SplitStrategy {
    List<ExpenseShare> calculateShare( double amount, List<User> userList);
}
