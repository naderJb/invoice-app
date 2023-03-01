package com.nader.invoiceapp.home.data.remote;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomeDataSourceImpl implements HomeDataSource {
    private final DBHelper dbHelper;

    @Inject
    public HomeDataSourceImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public ArrayList<MenuModel> getAllMenus() {
        return dbHelper.getAllMenus();
    }
}
