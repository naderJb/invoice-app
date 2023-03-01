package com.nader.invoiceapp.core.di;

import android.content.Context;

import com.nader.invoiceapp.core.utils.DBHelper;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DBModule {
    @Provides
    public static DBHelper provideDBHelper(@ApplicationContext Context context) {
        return new DBHelper(context);
    }
}
