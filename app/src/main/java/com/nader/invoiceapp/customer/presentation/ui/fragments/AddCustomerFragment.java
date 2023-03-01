package com.nader.invoiceapp.customer.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.nader.invoiceapp.core.utils.GlobalFunctions;
import com.nader.invoiceapp.databinding.FragmentAddCustomerBinding;

public class AddCustomerFragment extends BottomSheetDialogFragment {
    private FragmentAddCustomerBinding binding;

    private AddFragmentListeners listeners;

    public void setListeners(AddFragmentListeners listeners) {
        this.listeners = listeners;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddCustomerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAdd.setOnClickListener(v -> {
            if (binding.etName.getText().length() > 0) {
                if (listeners != null) {
                    listeners.onAddCustomer(binding.etName.getText().toString());
                }
                dismiss();
            } else {
                GlobalFunctions.showToast(requireActivity(), "Please enter a name");
            }

        });
    }
}
