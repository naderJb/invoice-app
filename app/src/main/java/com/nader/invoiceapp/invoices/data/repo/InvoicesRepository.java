package com.nader.invoiceapp.invoices.data.repo;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

import java.util.ArrayList;

public interface InvoicesRepository {
    ArrayList<InvoiceModel> getAllInvoices();

    ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId);

    boolean addInvoice(InvoiceModel invoiceModel);
}
