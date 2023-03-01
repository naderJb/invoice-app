package com.nader.invoiceapp.login.data.remote;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.login.data.model.UserModel;

import javax.inject.Inject;

public class LoginRemoteDataSourceImpl implements LoginRemoteDataSource {
    private final DBHelper dbHelper;

    @Inject
    public LoginRemoteDataSourceImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public UserModel getUserModel(String username, String password) {
        return dbHelper.getUser(username, password);
    }
}
