package com.nader.invoiceapp.home.presentations.viewmodels;

import androidx.lifecycle.ViewModel;

import com.nader.invoiceapp.home.data.model.MenuModel;
import com.nader.invoiceapp.home.domain.HomeUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final HomeUseCase homeUseCase;

    @Inject
    public HomeViewModel(HomeUseCase homeUseCase) {
        this.homeUseCase = homeUseCase;
    }

    public ArrayList<MenuModel> getAllMenus() {
        return homeUseCase.getAllMenus();
    }
}
