package com.nader.invoiceapp.login.presentation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.nader.invoiceapp.R;
import com.nader.invoiceapp.core.utils.DBHelper;
import com.nader.invoiceapp.core.utils.GlobalFunctions;
import com.nader.invoiceapp.databinding.FragmentLoginBinding;
import com.nader.invoiceapp.login.data.model.UserModel;
import com.nader.invoiceapp.login.presentation.viewmodels.LoginViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginScreenFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Inject
    DBHelper dbHelper;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        implementListeners();

    }

    private void initViews() {
        initDropDown();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    private void implementListeners() {
        binding.btnLogin.setOnClickListener(v -> validateAllFields());
    }

    private void initDropDown() {
        String[] items = getResources().getStringArray(R.array.languages);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.dropdown_item, items);
        binding.actLanguage.setAdapter(adapter);
    }

    private void validateAllFields() {
        boolean isUsernameValid = binding.etUsername.getText().length() > 0;
        boolean isPasswordValid = binding.etPassword.getText().length() > 0;
        boolean isLanguageValid = binding.actLanguage.getText().length() > 0;

        if (isUsernameValid) {
            binding.tilUsername.setError(null);
        } else {
            binding.tilUsername.setError(getString(R.string.login_username_error));
        }

        if (isPasswordValid) {
            binding.tilPassword.setError(null);
        } else {
            binding.tilPassword.setError(getString(R.string.login_password_error));
        }

        if (isLanguageValid) {
            binding.tilLanguage.setError(null);
        } else {
            binding.tilLanguage.setError(getString(R.string.login_language_error));
        }

        if (!(isUsernameValid && isPasswordValid && isLanguageValid)) {
            GlobalFunctions.showToast(
                    requireContext(),
                    getString(R.string.login_fillAllFIelds)
            );
        } else {
            performLogin();
        }
    }

    private void performLogin() {
        UserModel userModel = loginViewModel.getUserModel(
                binding.etUsername.getText().toString(),
                GlobalFunctions.digest("SHA-256", binding.etPassword.getText().toString().trim())
        );
        if (userModel != null) {
            Navigation.findNavController(binding.getRoot()).navigate(
                    LoginScreenFragmentDirections.actionLoginFragmentToHomeScreenFragment(userModel)
            );
        } else {
            //Toast
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}