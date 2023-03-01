package com.nader.invoiceapp.customer.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.customer.domain.CustomerUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CustomerViewModel extends ViewModel {
    private final CustomerUseCase customerUseCase;

    @Inject
    public CustomerViewModel(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }


    public ArrayList<CustomerModel> getAllCustomers() {
        return customerUseCase.getAllCustomers();
    }

    public ArrayList<CustomerModel> getAllCustomersByMenuId(int menuId) {
        return customerUseCase.getAllCustomersByMenuId(menuId);
    }

    public boolean addCustomer(CustomerModel customerModel) {
        return customerUseCase.addCustomer(customerModel);
    }
}
