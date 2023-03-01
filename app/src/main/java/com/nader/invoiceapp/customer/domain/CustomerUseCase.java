package com.nader.invoiceapp.customer.domain;

import com.nader.invoiceapp.customer.data.model.CustomerModel;

import java.util.ArrayList;

public interface CustomerUseCase {
    ArrayList<CustomerModel> getAllCustomers();

    ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId);

    boolean addCustomer(CustomerModel customerModel);
}
