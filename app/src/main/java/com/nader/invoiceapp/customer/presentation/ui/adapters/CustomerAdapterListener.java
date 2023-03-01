package com.nader.invoiceapp.customer.presentation.ui.adapters;

import com.nader.invoiceapp.customer.data.model.CustomerModel;

public interface CustomerAdapterListener {
    void setOnItemClickListener(CustomerModel customerModel);
}
