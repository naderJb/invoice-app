package com.nader.invoiceapp.login.di;

import com.nader.invoiceapp.login.data.remote.LoginRemoteDataSource;
import com.nader.invoiceapp.login.data.remote.LoginRemoteDataSourceImpl;
import com.nader.invoiceapp.login.data.repo.LoginRepository;
import com.nader.invoiceapp.login.data.repo.LoginRepositoryImpl;
import com.nader.invoiceapp.login.domain.LoginUseCase;
import com.nader.invoiceapp.login.domain.LoginUseCaseImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
abstract public class LoginModule {
    @Binds
    public abstract LoginRemoteDataSource bindLoginRemoteDataSource(
            LoginRemoteDataSourceImpl loginRemoteDataSourceImpl
    );

    @Binds
    public abstract LoginRepository bindLoginRepository(
            LoginRepositoryImpl loginRepositoryImpl
    );

    @Binds
    public abstract LoginUseCase bindLoginUseCase(
            LoginUseCaseImpl loginUseCaseImpl
    );
}
