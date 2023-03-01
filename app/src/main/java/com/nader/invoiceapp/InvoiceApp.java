package com.nader.invoiceapp;

import android.app.Application;
import android.content.Context;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class InvoiceApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
