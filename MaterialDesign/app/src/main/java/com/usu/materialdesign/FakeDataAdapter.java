package com.usu.materialdesign;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class FakeDataAdapter extends RecyclerView.Adapter<FakeDataAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AppCompatTextView textView = new AppCompatTextView(parent.getContext());
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppCompatTextView textView = (AppCompatTextView) holder.itemView;
        textView.setText("I am at position " + position);
    }

    @Override
    public int getItemCount() {
        return 1000;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

