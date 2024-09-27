package com.lld.splitwise.usermanagement.services;

import com.lld.splitwise.usermanagement.models.User;

public class SimpleInMemoryAuthenticationService  implements  IAuthenticationService{
    private final InMemoryUserRegistration inMemoryUserRegistration;

    public SimpleInMemoryAuthenticationService(InMemoryUserRegistration inMemoryUserRegistration) {
        this.inMemoryUserRegistration = inMemoryUserRegistration;
    }

    @Override
    public void authenticate(User user) {
        if( inMemoryUserRegistration.getLoggedInUsers().containsKey( user.getUserId() ) ){
            System.out.println( "User loggedIn : " + user.getName() );
            return;
        }
        throw new RuntimeException( " user not loggedIn ");

    }
}
