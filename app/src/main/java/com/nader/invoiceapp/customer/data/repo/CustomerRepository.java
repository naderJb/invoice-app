package com.nader.invoiceapp.customer.data.repo;

import com.nader.invoiceapp.customer.data.model.CustomerModel;

import java.util.ArrayList;

public interface CustomerRepository {
    ArrayList<CustomerModel> getAllCustomers();

    ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId);

    boolean addCustomer(CustomerModel customerModel);
}
