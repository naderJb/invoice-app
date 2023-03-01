package com.nader.invoiceapp.customer.presentation.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nader.invoiceapp.customer.data.model.CustomerModel;
import com.nader.invoiceapp.databinding.MenuItemBinding;

import java.util.ArrayList;

import javax.inject.Inject;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private ArrayList<CustomerModel> allCustomers = new ArrayList<>();
    private CustomerAdapterListener listener;

    public void setListener(CustomerAdapterListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<CustomerModel> allCustomers) {
        this.allCustomers = allCustomers;
        notifyDataSetChanged();
    }

    @Inject
    public CustomerAdapter() {
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerViewHolder(
                MenuItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.bind(allCustomers.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return allCustomers.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        private MenuItemBinding binding;

        public CustomerViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CustomerModel customerModel, CustomerAdapterListener customerAdapterListener) {
            binding.btnMenu.setText(customerModel.getName());
            binding.btnMenu.setOnClickListener(view -> {
                if (customerAdapterListener != null) {
                    customerAdapterListener.setOnItemClickListener(customerModel);
                }
            });
        }
    }
}
