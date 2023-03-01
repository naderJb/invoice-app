package com.nader.invoiceapp.login.data.repo;

import com.nader.invoiceapp.login.data.model.UserModel;

public interface LoginRepository {
    UserModel getUserModel(String username, String password);
}
