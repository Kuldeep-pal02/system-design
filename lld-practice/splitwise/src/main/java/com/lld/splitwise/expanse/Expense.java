package com.lld.splitwise.expanse;

import com.lld.splitwise.groupmanagement.model.SplitwiseGroup;
import com.lld.splitwise.usermanagement.models.User;

import javax.swing.*;

public class Expense {

    private String expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private SplitwiseGroup group;
    private SplitStrategy splitStrategy;

    public void calculateShares(){
        this.splitStrategy.calculateShare( amount, group.getMembers() );
    }

}
