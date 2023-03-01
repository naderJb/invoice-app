package com.nader.invoiceapp.customer.data.repo;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.customer.data.remote.CustomerDataSource;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerDataSource customerDataSource;

    @Inject
    public CustomerRepositoryImpl(CustomerDataSource customerDataSource) {
        this.customerDataSource = customerDataSource;
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomers() {
        return customerDataSource.getAllCustomers();
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId) {
        return customerDataSource.getAllCustomersByMenuId(menuId);
    }

    @Override
    public boolean addCustomer(CustomerModel customerModel) {
        return customerDataSource.addCustomer(customerModel);
    }
}
