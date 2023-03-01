package com.nader.invoiceapp.invoices.domain;

import com.nader.invoiceapp.invoices.data.model.InvoiceModel;
import com.nader.invoiceapp.invoices.data.repo.InvoicesRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoicesUseCaseImpl implements InvoicesUSeCase {
    private final InvoicesRepository invoicesRepository;

    @Inject
    public InvoicesUseCaseImpl(InvoicesRepository invoicesRepository) {
        this.invoicesRepository = invoicesRepository;
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoices() {
        return invoicesRepository.getAllInvoices();
    }

    @Override
    public ArrayList<InvoiceModel> getAllInvoicesByCustomerId(int customerId) {
        return invoicesRepository.getAllInvoicesByCustomerId(customerId);
    }

    @Override
    public boolean addInvoice(InvoiceModel invoiceModel) {
        return invoicesRepository.addInvoice(invoiceModel);
    }
}
