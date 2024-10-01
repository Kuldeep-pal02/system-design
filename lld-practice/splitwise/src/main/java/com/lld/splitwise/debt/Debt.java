package com.lld.splitwise.debt;

import com.lld.splitwise.usermanagement.models.User;
import lombok.Data;

@Data
public class Debt {
    private int id;
    private User lender;
    private User borrower;
    private double amount;

}
