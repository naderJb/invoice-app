package com.nader.invoiceapp.customer.domain;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.customer.data.repo.CustomerRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomerUseCaseImpl implements CustomerUseCase {
    private final CustomerRepository customerRepository;

    @Inject
    public CustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId) {
        return customerRepository.getAllCustomersByMenuId(menuId);
    }

    @Override
    public boolean addCustomer(CustomerModel customerModel) {
        return customerRepository.addCustomer(customerModel);
    }
}
