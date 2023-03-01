package com.nader.invoiceapp.home.data.repo;

import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

public interface HomeRepository {
    ArrayList<MenuModel> getAllMenus();
}
