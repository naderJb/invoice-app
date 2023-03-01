package com.nader.invoiceapp.customer.data.remote;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.customer.data.model.CustomerModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomerDataSourceImpl implements CustomerDataSource {
    private final DBHelper dbHelper;

    @Inject
    public CustomerDataSourceImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomers() {
        return dbHelper.getAllCustomers();
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId) {
        return dbHelper.getAllCustomersByMenuId(menuId);
    }

    @Override
    public boolean addCustomer(CustomerModel customerModel) {
        return dbHelper.addCustomer(customerModel);
    }
}
