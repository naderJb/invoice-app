package com.nader.invoiceapp.invoices.data.repo;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;
import com.nader.invoiceapp.invoices.data.remote.InvoicesDataSource;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoicesRepositoryImpl implements InvoicesRepository {
    private final InvoicesDataSource invoicesDataSource;

    @Inject
    public InvoicesRepositoryImpl(InvoicesDataSource invoicesDataSource) {
        this.invoicesDataSource = invoicesDataSource;
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoices() {
        return invoicesDataSource.getAllInvoices();
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId) {
        return invoicesDataSource.getAllInvoicesByCustomerId(customerId);
    }

    @Override
    public boolean addInvoice(InvoiceModel invoiceModel) {
        return invoicesDataSource.addInvoice(invoiceModel);
    }
}
