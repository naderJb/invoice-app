package com.nader.invoiceapp.invoices.di;

import com.nader.invoiceapp.invoices.data.remote.InvoicesDataSource;
import com.nader.invoiceapp.invoices.data.remote.InvoicesDataSourceImpl;
import com.nader.invoiceapp.invoices.data.repo.InvoicesRepository;
import com.nader.invoiceapp.invoices.data.repo.InvoicesRepositoryImpl;
import com.nader.invoiceapp.invoices.domain.InvoicesUSeCase;
import com.nader.invoiceapp.invoices.domain.InvoicesUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
abstract public class InvoiceModule {
    @Binds
    public abstract InvoicesDataSource bindInvoicesDataSource(
            InvoicesDataSourceImpl invoicesDataSourceImpl
    );

    @Binds
    public abstract InvoicesRepository bindInvoicesRepository(
            InvoicesRepositoryImpl invoicesRepositoryImpl
    );

    @Binds
    public abstract InvoicesUSeCase bindInvoicesUSeCase(
            InvoicesUseCaseImpl invoicesUSeCaseImpl
    );
}
