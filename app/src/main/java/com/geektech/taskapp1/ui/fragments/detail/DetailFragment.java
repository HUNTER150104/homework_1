package com.geektech.taskapp1.ui.fragments.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.taskapp1.R;
import com.geektech.taskapp1.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.saveBtn.setOnClickListener(v ->{
            sendData();
            closeFragment();
        });
    }

    private void closeFragment() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment);
        navController.navigateUp();
    }

    private void sendData() {
        String text = binding.taskEt.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("textKey", text);
        getParentFragmentManager().setFragmentResult("key", bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}