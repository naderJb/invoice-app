package com.nader.invoiceapp.invoices.data.remote;

import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.invoices.data.model.InvoiceModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoicesDataSourceImpl implements InvoicesDataSource {

    private final DBHelper dbHelper;

    @Inject
    public InvoicesDataSourceImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoices() {
        return dbHelper.getAllInvoices();
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId) {
        return dbHelper.getAllInvoicesByCustomerId(customerId);
    }

    @Override
    public boolean addInvoice(InvoiceModel invoiceModel) {
        return dbHelper.addInvoice(invoiceModel);
    }
}
