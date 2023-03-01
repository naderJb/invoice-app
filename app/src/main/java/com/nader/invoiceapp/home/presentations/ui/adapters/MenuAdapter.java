package com.nader.invoiceapp.home.presentations.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nader.invoiceapp.databinding.MenuItemBinding;
import com.nader.invoiceapp.home.data.model.MenuModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private ArrayList<MenuModel> menuModels = new ArrayList<>();
    private MenuAdapterListener menuAdapterListener;

    @Inject
    public MenuAdapter() {
    }

    public void setMenuAdapterListener(MenuAdapterListener menuAdapterListener) {
        this.menuAdapterListener = menuAdapterListener;
    }

    public void setData(ArrayList<MenuModel> menuModels) {
        this.menuModels.addAll(menuModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(menuModels.get(position), menuAdapterListener);
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        private MenuItemBinding binding;

        public MenuViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MenuModel menuModel, MenuAdapterListener menuAdapterListener) {
            binding.btnMenu.setText(menuModel.getName());
            binding.btnMenu.setOnClickListener(view -> {
                if (menuAdapterListener != null) {
                    menuAdapterListener.onItemClickListener(menuModel);
                }
            });
        }
    }
}
