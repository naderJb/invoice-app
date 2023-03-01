package com.nader.invoiceapp.invoices.presentation.ui.adapters;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

public interface InvoiceAdapterListener {
    public void setOnItemClickListener(InvoiceModel invoiceModel);
}
