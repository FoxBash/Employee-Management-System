package com.paul.employeemanager.Service;

import com.paul.employeemanager.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Optional<Account> findOneByUsername(String username) {
        return accountRepo.findOneByUsername(username);

    }
    public void addAccount(Account account) {
        accountRepo.save(account);
    }
}
