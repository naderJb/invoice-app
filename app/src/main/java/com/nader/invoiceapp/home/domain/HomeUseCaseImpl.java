package com.nader.invoiceapp.home.domain;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomeUseCaseImpl implements HomeUseCase {
    private final DBHelper dbHelper;

    @Inject
    public HomeUseCaseImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public ArrayList<MenuModel> getAllMenus() {
        return dbHelper.getAllMenus();
    }
}
