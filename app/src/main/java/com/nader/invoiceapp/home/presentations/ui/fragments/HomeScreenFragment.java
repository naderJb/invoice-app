package com.nader.invoiceapp.home.presentations.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.nader.invoiceapp.databinding.FragmentHomeScreenBinding;
import com.nader.invoiceapp.home.presentations.ui.adapters.MenuAdapter;
import com.nader.invoiceapp.home.presentations.viewmodels.HomeViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeScreenFragment extends Fragment {
    private FragmentHomeScreenBinding binding;
    private HomeScreenFragmentArgs args;
    private HomeViewModel homeViewModel;

    @Inject
    MenuAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        implementListeners();
    }

    private void initViews() {
        assert getArguments() != null;
        args = HomeScreenFragmentArgs.fromBundle(getArguments());
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.rvMenu.setAdapter(adapter);
        adapter.setData(homeViewModel.getAllMenus());

    }

    private void implementListeners() {
        adapter.setMenuAdapterListener(menuModel -> Navigation.findNavController(binding.getRoot()).navigate(
                        HomeScreenFragmentDirections
                                .actionHomeScreenFragmentToCustomerScreenFragment(args.getUserModel(), menuModel)
                )
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}