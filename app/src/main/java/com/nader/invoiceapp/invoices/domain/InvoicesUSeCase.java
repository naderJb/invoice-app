package com.nader.invoiceapp.invoices.domain;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

import java.util.ArrayList;

public interface InvoicesUSeCase {
    ArrayList<InvoiceModel> getAllInvoices();

    ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId);

    boolean addInvoice(InvoiceModel invoiceModel);
}
