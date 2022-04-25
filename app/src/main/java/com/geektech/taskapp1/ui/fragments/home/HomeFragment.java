package com.geektech.taskapp1.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.geektech.taskapp1.R;
import com.geektech.taskapp1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentListener();
        initListeners();
    }

    private void fragmentListener() {
        getParentFragmentManager().setFragmentResultListener("key", this,
                new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    String text = result.getString("textKey");
                    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void initListeners() {
        binding.floatBtn.setOnClickListener(v ->{
            openFragment();
        });
    }

    private void openFragment() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.detailFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}