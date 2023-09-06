package com.chefencasa.app.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.chefencasa.model.AccountProto;
import com.chefencasa.model.AccountProto.Account;

public class AccountRepository {

    List<Account> accounts;
    AtomicInteger id;
    
    public AccountRepository(List<Account> accounts) {
        this.accounts = accounts;
        this.id = new AtomicInteger();
        this.id.set(accounts.size());
    }

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.newBuilder().setId(1).setCustomerId(1).setNumber("111111").build());
        accounts.add(Account.newBuilder().setId(2).setCustomerId(2).setNumber("222222").build());
        accounts.add(Account.newBuilder().setId(3).setCustomerId(3).setNumber("333333").build());
        accounts.add(Account.newBuilder().setId(4).setCustomerId(4).setNumber("444444").build());
        accounts.add(Account.newBuilder().setId(5).setCustomerId(1).setNumber("555555").build());
        accounts.add(Account.newBuilder().setId(6).setCustomerId(2).setNumber("666666").build());
        accounts.add(Account.newBuilder().setId(7).setCustomerId(2).setNumber("777777").build());

        return accounts;
    }

    public List<Account> findByCustomer(int customerId) {
        return accounts.stream().filter(it -> it.getCustomerId() == customerId).toList();
    }

    public Account findByNumber(String number) {
        return accounts.stream()
                .filter(it -> it.getNumber().equals(number))
                .findFirst()
                .orElseThrow();
    }

    public AccountProto.Account add(int customerId, String number) {
        AccountProto.Account a = AccountProto.Account.newBuilder()
                .setId(id.incrementAndGet())
                .setCustomerId(customerId)
                .setNumber(number)
                .build();
        return a;
    }


}
