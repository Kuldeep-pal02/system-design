package com.lld.splitwise.expanse;

import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;
import com.lld.splitwise.usermanagement.models.User;

import javax.swing.*;
import java.util.List;

public class Expense {

    private String expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private SplitwiseGroup group;
    private SplitStrategy splitStrategy;

    private List<ExpenseShare> expenseShareList;

    public void calculateShares(){
        expenseShareList.addAll( this.splitStrategy.calculateShare( amount, group.getMembers() ) );
    }

}
