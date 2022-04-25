package com.geektech.taskapp1.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.taskapp1.R;
import com.geektech.taskapp1.databinding.PageBoardBinding;

import java.util.Objects;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder> {

    private ClickListener listener;
    private PageBoardBinding binding;
    private int[] image = {R.drawable.ariel, R.drawable.aurora, R.drawable.belle};
    private String[] description = {"I'm Ariel ", "I'm Aurora", "I'm Belle"};

    public OnBoardAdapter(ClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public OnBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = PageBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OnBoardViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardViewHolder holder, int position) {
        holder.onBoard(position);
        binding.btnSkip.setOnClickListener(view -> {
            listener.skip(image.length);
        });
        binding.btnNext.setOnClickListener(view -> {
            listener.next();
        });
    }

    @Override
    public int getItemCount() {
        return description.length;
    }

    public class OnBoardViewHolder extends RecyclerView.ViewHolder {
        public OnBoardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBoard(int position) {
            binding.onBoardImg.setImageResource(image[position]);
            binding.onBoardTxt.setText(description[position]);
            if (position == image.length - 1) {
                binding.btnNext.setVisibility(View.VISIBLE);
                binding.btnSkip.setVisibility(View.GONE);
            } else {
                binding.btnNext.setVisibility(View.GONE);
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
        }
    }
    interface ClickListener {
        void skip(int size);
        void next();
    }
}
