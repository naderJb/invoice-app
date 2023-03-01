package com.nader.invoiceapp.customer.data.remote;

import com.nader.invoiceapp.customer.data.model.CustomerModel;

import java.util.ArrayList;

public interface CustomerDataSource {
    ArrayList<CustomerModel> getAllCustomers();

    ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId);

    boolean addCustomer(CustomerModel customerModel);
}
