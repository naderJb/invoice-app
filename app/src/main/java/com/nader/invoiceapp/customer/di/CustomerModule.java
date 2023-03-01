package com.nader.invoiceapp.customer.di;

import com.nader.invoiceapp.customer.data.remote.CustomerDataSource;
import com.nader.invoiceapp.customer.data.remote.CustomerDataSourceImpl;
import com.nader.invoiceapp.customer.data.repo.CustomerRepository;
import com.nader.invoiceapp.customer.data.repo.CustomerRepositoryImpl;
import com.nader.invoiceapp.customer.domain.CustomerUseCase;
import com.nader.invoiceapp.customer.domain.CustomerUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
abstract public class CustomerModule {
    @Binds
    public abstract CustomerDataSource bindCustomerDataSource(
            CustomerDataSourceImpl customerDataSourceImpl
    );

    @Binds
    public abstract CustomerRepository bindCustomerRepository(
            CustomerRepositoryImpl customerRepositoryImpl
    );

    @Binds
    public abstract CustomerUseCase bindCustomerUseCase(
            CustomerUseCaseImpl customerUseCaseImpl
    );
}
