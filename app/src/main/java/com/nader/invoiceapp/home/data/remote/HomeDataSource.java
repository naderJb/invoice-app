package com.nader.invoiceapp.home.data.remote;

import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

public interface HomeDataSource {
    ArrayList<MenuModel> getAllMenus();
}
