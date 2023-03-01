package com.nader.invoiceapp.home.domain;

import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

public interface HomeUseCase {
    ArrayList<MenuModel> getAllMenus();
}
