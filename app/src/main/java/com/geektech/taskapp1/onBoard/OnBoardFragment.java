package com.geektech.taskapp1.onBoard;

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
import com.geektech.taskapp1.databinding.FragmentOnBoardBinding;
import com.geektech.taskapp1.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class OnBoardFragment extends Fragment implements OnBoardAdapter.ClickListener {

    private FragmentOnBoardBinding binding;
    private OnBoardAdapter adapter;
    private NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        controller = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
        new TabLayoutMediator(binding.onBoardTab, binding.onBoardPager, (((tab, position) ->
                tab.setIcon(R.drawable.tab_selector)))).attach();
    }

    private void initViewPager() {
        adapter = new OnBoardAdapter(this);
        binding.onBoardPager.setAdapter(adapter);

    }

    @Override
    public void skip(int size) {
        binding.onBoardPager.setCurrentItem(size - 1, true);
    }

    @Override
    public void next() {
        controller.navigate(R.id.home_fragment);
    }
}