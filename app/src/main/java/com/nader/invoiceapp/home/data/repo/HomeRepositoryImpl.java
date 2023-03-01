package com.nader.invoiceapp.home.data.repo;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomeRepositoryImpl implements HomeRepository {
    private final DBHelper dbHelper;

    @Inject
    public HomeRepositoryImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }


    @Override
    public ArrayList<MenuModel> getAllMenus() {
        return dbHelper.getAllMenus();
    }
}
