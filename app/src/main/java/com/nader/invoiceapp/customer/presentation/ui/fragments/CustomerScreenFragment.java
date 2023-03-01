package com.nader.invoiceapp.customer.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.customer.presentation.ui.adapters.CustomerAdapter;
import com.nader.invoiceapp.customer.presentation.viewmodels.CustomerViewModel;
import com.nader.invoiceapp.databinding.FragmentCustomerScreenBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CustomerScreenFragment extends Fragment {

    private FragmentCustomerScreenBinding binding;
    private CustomerScreenFragmentArgs args;
    private CustomerViewModel customerViewModel;
    @Inject
    CustomerAdapter customerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomerScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        implementListeners();
    }


    private void initViews() {
        assert getArguments() != null;
        args = CustomerScreenFragmentArgs.fromBundle(getArguments());
        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);

        binding.rvCustomers.setAdapter(customerAdapter);
        ArrayList<CustomerModel> allCustomers = customerViewModel.getAllCustomersByMenuId(args.getMenuModel().getId());
        if (allCustomers.size() > 0) {
            customerAdapter.setData(allCustomers);
            binding.animationView.setVisibility(View.GONE);
            binding.rvCustomers.setVisibility(View.VISIBLE);
        }

    }

    private void implementListeners() {
        customerAdapter.setListener(customerModel -> {
            Navigation.findNavController(binding.getRoot()).navigate(
                    CustomerScreenFragmentDirections.actionCustomerScreenFragmentToInvoicesScreenFragment(
                            customerModel
                    )
            );
        });
        binding.floatingActionButton.setOnClickListener(v -> {
            AddCustomerFragment addCustomerFragment = new AddCustomerFragment();
            addCustomerFragment.setListeners(name -> {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setName(name);
                customerModel.setMenuId(args.getMenuModel().getId());
                boolean isSuccessful = customerViewModel.addCustomer(
                        customerModel
                );
                if (isSuccessful) {
                    customerAdapter.setData(customerViewModel.getAllCustomersByMenuId(args.getMenuModel().getId()));
                }
            });
            addCustomerFragment.show(requireActivity().getSupportFragmentManager(), "");
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}