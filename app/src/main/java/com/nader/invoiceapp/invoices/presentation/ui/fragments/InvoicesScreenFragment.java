package com.nader.invoiceapp.invoices.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nader.invoiceapp.databinding.FragmentInvoicesScreenBinding;
import com.nader.invoiceapp.invoices.data.model.InvoiceModel;
import com.nader.invoiceapp.invoices.presentation.ui.adapters.InvoiceAdapter;
import com.nader.invoiceapp.invoices.presentation.viewmodels.InvoiceViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class InvoicesScreenFragment extends Fragment {

    private FragmentInvoicesScreenBinding binding;
    private InvoiceViewModel invoiceViewModel;
    private InvoicesScreenFragmentArgs args;

    @Inject
    InvoiceAdapter invoiceAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoicesScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        implementViews();
    }


    private void initViews() {
        invoiceViewModel = new ViewModelProvider(this).get(InvoiceViewModel.class);
        assert getArguments() != null;
        args = InvoicesScreenFragmentArgs.fromBundle(getArguments());

        binding.rvInvoices.setAdapter(invoiceAdapter);
        ArrayList<InvoiceModel> allCustomers = invoiceViewModel.getAllInvoicesByCustomerId(args.getCustomerModel().getId());
        if (allCustomers.size() > 0) {
            invoiceAdapter.setData(allCustomers);
            binding.lvEmpty.setVisibility(View.GONE);
            binding.rvInvoices.setVisibility(View.VISIBLE);
        }
    }


    private void implementViews() {
        invoiceAdapter.setInvoiceAdapterListener(invoiceModel -> {

        });
        binding.fapAdd.setOnClickListener(v -> {
                    AddInvoiceFragment addInvoiceFragment = new AddInvoiceFragment();
                    addInvoiceFragment.setListeners(invoice -> {
                        invoice.setCustomerId(args.getCustomerModel().getId());
                        boolean isSuccessful = invoiceViewModel.addInvoice(
                                invoice
                        );
                        if (isSuccessful) {
                            invoiceAdapter.setData(invoiceViewModel.getAllInvoicesByCustomerId(args.getCustomerModel().getId()));
                        }
                    });
                    addInvoiceFragment.show(requireActivity().getSupportFragmentManager(), "");
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}