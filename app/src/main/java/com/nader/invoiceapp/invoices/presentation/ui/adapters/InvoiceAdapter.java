package com.nader.invoiceapp.invoices.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nader.invoiceapp.R;
import com.nader.invoiceapp.databinding.ItemInvoiceBinding;
import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder> {
    private InvoiceAdapterListener invoiceAdapterListener;
    private ArrayList<InvoiceModel> allInvoices = new ArrayList<>();

    @Inject
    public InvoiceAdapter() {
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InvoiceViewHolder(
                ItemInvoiceBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        holder.bind(allInvoices.get(position), invoiceAdapterListener);
    }

    @Override
    public int getItemCount() {
        return allInvoices.size();
    }

    public void setInvoiceAdapterListener(InvoiceAdapterListener invoiceAdapterListener) {
        this.invoiceAdapterListener = invoiceAdapterListener;
    }

    public void setData(ArrayList<InvoiceModel> allInvoices) {
        this.allInvoices = allInvoices;
        notifyDataSetChanged();
    }

    public static class InvoiceViewHolder extends RecyclerView.ViewHolder {
        private ItemInvoiceBinding binding;

        public InvoiceViewHolder(@NonNull ItemInvoiceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(InvoiceModel invoiceModel, InvoiceAdapterListener invoiceAdapterListener) {
            binding.tvName.setText(invoiceModel.getName());
            Context context = binding.getRoot().getContext();
            binding.tvPrice.setText(
                    context.getString(R.string.invoice_price_tv, invoiceModel.getUnitPrice().toString())
            );
            binding.tvQUantity.setText(
                    context.getString(
                            R.string.customer_quantity_tv,
                            invoiceModel.getQuantity()
                    )
            );
            binding.tvTotalPrice.setText(
                    context.getString(
                            R.string.customer_quantity_tv,
                            (invoiceModel.getQuantity() * invoiceModel.getUnitPrice())
                    )
            );
        }
    }
}
