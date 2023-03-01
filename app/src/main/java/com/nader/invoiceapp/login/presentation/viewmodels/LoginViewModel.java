package com.nader.invoiceapp.login.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

import com.nader.invoiceapp.login.data.model.UserModel;
import com.nader.invoiceapp.login.domain.LoginUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final LoginUseCase loginUseCase;

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }


    public UserModel getUserModel(String username, String password) {
        return loginUseCase.getUserModel(username, password);
    }
}
