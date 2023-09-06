package com.chefencasa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chefencasa.app.repository.AccountRepository;
import com.chefencasa.model.AccountProto;
import com.chefencasa.model.AccountsServiceGrpc;

import java.util.List;


@GrpcService
public class AccountsService extends AccountsServiceGrpc.AccountsServiceImplBase {

    @Autowired
    AccountRepository repository;

    @Override
    public void findByNumber(AccountProto.Account request, StreamObserver<AccountProto.Account> responseObserver) {
        AccountProto.Account a = repository.findByNumber(request.getNumber());
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void findByCustomer(AccountProto.Account request, StreamObserver<AccountProto.Accounts> responseObserver) {
        List<AccountProto.Account> accounts = repository.findByCustomer(request.getCustomerId());
        AccountProto.Accounts a = AccountProto.Accounts.newBuilder().addAllAccount(accounts).build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void findAll(Empty request, StreamObserver<AccountProto.Accounts> responseObserver) {
        List<AccountProto.Account> accounts = repository.findAll();
        AccountProto.Accounts a = AccountProto.Accounts.newBuilder().addAllAccount(accounts).build();
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }

    @Override
    public void addAccount(AccountProto.Account request, StreamObserver<AccountProto.Account> responseObserver) {
        AccountProto.Account a = repository.add(request.getCustomerId(), request.getNumber());
        responseObserver.onNext(a);
        responseObserver.onCompleted();
    }


}

