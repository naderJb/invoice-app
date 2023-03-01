package com.nader.invoiceapp.login.domain;

import com.nader.invoiceapp.login.data.model.UserModel;
import com.nader.invoiceapp.login.data.repo.LoginRepository;

import javax.inject.Inject;

public class LoginUseCaseImpl implements LoginUseCase {
    private final LoginRepository loginRepository;

    @Inject
    public LoginUseCaseImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public UserModel getUserModel(String username, String password) {
        return loginRepository.getUserModel(username, password);
    }
}
