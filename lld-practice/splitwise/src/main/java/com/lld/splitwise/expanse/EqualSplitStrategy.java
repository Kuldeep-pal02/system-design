package com.lld.splitwise.expanse;

import com.lld.splitwise.usermanagement.models.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<ExpenseShare> calculateShare(double amount, List<User> userList) {
        List<ExpenseShare> expenseShares = new ArrayList<>();
        double shareAmount = amount / userList.size();
        for( User user : userList ){
            expenseShares.add( new ExpenseShare( user , shareAmount) );
        }
        return expenseShares;
    }
}
