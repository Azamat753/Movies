package com.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.movies.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<String> infoList;

    public InfoAdapter() {
        infoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_holder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setText(infoList.get(position));
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }
    public void addText(String  text){
        infoList.add(text);
        notifyDataSetChanged();
    }
    public void deleteLastInfo(){
        infoList.clear();
        notifyDataSetChanged();
    }

}
