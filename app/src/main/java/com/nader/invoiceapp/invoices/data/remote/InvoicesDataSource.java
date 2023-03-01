package com.nader.invoiceapp.invoices.data.remote;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

import java.util.ArrayList;

public interface InvoicesDataSource {
    ArrayList<InvoiceModel> getAllInvoices();

    ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId);

    boolean addInvoice(InvoiceModel invoiceModel);
}
