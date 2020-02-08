package com.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.movies.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
       textView= itemView.findViewById(R.id.v1);

    }
    public void setText(String  text) {
        textView.setText(text);

    }
}
