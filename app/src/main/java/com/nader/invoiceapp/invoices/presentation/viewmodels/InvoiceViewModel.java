package com.nader.invoiceapp.invoices.presentation.viewmodels;

import androidx.lifecycle.ViewModel;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;
import com.nader.invoiceapp.invoices.domain.InvoicesUSeCase;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class InvoiceViewModel extends ViewModel {
    private final InvoicesUSeCase invoicesUSeCase;

    @Inject
    public InvoiceViewModel(InvoicesUSeCase invoicesUSeCase) {
        this.invoicesUSeCase = invoicesUSeCase;
    }

    public ArrayList<InvoiceModel> getAllInvoices() {
        return invoicesUSeCase.getAllInvoices();
    }

    public ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId) {
        return invoicesUSeCase.getAllInvoicesByCustomerId(customerId);
    }

    public boolean addInvoice(InvoiceModel invoiceModel) {
        return invoicesUSeCase.addInvoice(invoiceModel);
    }
}
