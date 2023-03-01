package com.nader.invoiceapp.invoices.presentation.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.nader.invoiceapp.core.utils.GlobalFunctions;
import com.nader.invoiceapp.databinding.FragmentAddInvoiceBinding;
import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

public class AddInvoiceFragment extends BottomSheetDialogFragment {
    private FragmentAddInvoiceBinding binding;

    private AddInvoiceListeners listeners;

    public void setListeners(AddInvoiceListeners listeners) {
        this.listeners = listeners;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddInvoiceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        implementListeners();
    }

    private void initViews() {
    }

    private void implementListeners() {
        binding.btnAdd.setOnClickListener(v -> {
            String price = "" + binding.etPrice.getText();
            String quantity = "" + binding.etQuantity.getText();
            String name = "" + binding.etName.getText().toString();
            if (price.isEmpty() || quantity.isEmpty() || name.isEmpty()) {
                GlobalFunctions.showToast(requireActivity(), "Fill all fields");
            } else {
                if (listeners != null) {
                    listeners.onAdd(
                            new InvoiceModel(
                                    name,
                                    Integer.parseInt(price),
                                    Float.parseFloat(quantity)
                            ));
                }
                dismiss();
            }
        });

    }
}
