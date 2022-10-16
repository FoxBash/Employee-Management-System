package com.paul.employeemanager.Security;

import com.paul.employeemanager.Model.Account;
import com.paul.employeemanager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountService.findOneByUsername(username);
        if ( optionalAccount.isPresent() ){
            Account account = optionalAccount.get();
            return new AccountDetails(account);
        }else {
            throw new UsernameNotFoundException("User with username " + username+ " could not be found");
        }
    }
}
