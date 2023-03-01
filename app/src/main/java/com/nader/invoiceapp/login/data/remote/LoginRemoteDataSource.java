package com.nader.invoiceapp.login.data.remote;

import com.nader.invoiceapp.login.data.model.UserModel;

public interface LoginRemoteDataSource {
    UserModel getUserModel(String username, String password);
}
