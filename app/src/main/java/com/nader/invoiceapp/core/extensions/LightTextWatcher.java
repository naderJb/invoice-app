package com.nader.invoiceapp.core.extensions;

import android.text.TextWatcher;

abstract class LightTextWatcher implements TextWatcher {
    boolean isFirstTime = true;
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }


}
