package com.lld.splitwise.expanse;

import com.lld.splitwise.usermanagement.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExpenseShare {
    //Map<User, Double > expenseMap;
    User user;
    double amount;
}
