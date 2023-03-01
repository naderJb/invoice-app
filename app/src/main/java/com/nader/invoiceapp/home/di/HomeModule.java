package com.nader.invoiceapp.home.di;

import com.nader.invoiceapp.home.data.remote.HomeDataSource;
import com.nader.invoiceapp.home.data.remote.HomeDataSourceImpl;
import com.nader.invoiceapp.home.data.repo.HomeRepository;
import com.nader.invoiceapp.home.data.repo.HomeRepositoryImpl;
import com.nader.invoiceapp.home.domain.HomeUseCase;
import com.nader.invoiceapp.home.domain.HomeUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
abstract public class HomeModule {
    @Binds
    public abstract HomeDataSource bindHomeDataSource(
            HomeDataSourceImpl homeDataSourceImpl
    );

    @Binds
    public abstract HomeRepository bindHomeRepository(
            HomeRepositoryImpl homeRepositoryImpl
    );

    @Binds
    public abstract HomeUseCase bindHomeUseCase(
            HomeUseCaseImpl homeUseCase
    );
}
