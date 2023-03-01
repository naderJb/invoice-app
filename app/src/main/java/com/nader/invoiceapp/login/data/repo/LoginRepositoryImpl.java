package com.nader.invoiceapp.login.data.repo;

import com.nader.invoiceapp.login.data.model.UserModel;
import com.nader.invoiceapp.login.data.remote.LoginRemoteDataSource;

import javax.inject.Inject;

public class LoginRepositoryImpl implements LoginRepository {
    private final LoginRemoteDataSource remoteDataSource;

    @Inject
    public LoginRepositoryImpl(LoginRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public UserModel getUserModel(String username, String password) {
        return remoteDataSource.getUserModel(username, password);
    }
}
