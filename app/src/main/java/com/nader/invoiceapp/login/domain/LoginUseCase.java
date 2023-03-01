package com.nader.invoiceapp.login.domain;

import com.nader.invoiceapp.login.data.model.UserModel;

public interface LoginUseCase {
    UserModel getUserModel(String username, String password);
}
