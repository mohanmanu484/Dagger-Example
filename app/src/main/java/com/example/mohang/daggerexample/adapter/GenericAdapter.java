package com.example.mohang.daggerexample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohang.daggerexample.adapter.Binder;

import java.util.List;

public abstract class GenericAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Object> listItems;


    public GenericAdapter(List<Object> listItems) {
        this.listItems = listItems;
    }

    public void setListItems(List<Object> listItems) {
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewholder(LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Binder)holder).bind(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public abstract RecyclerView.ViewHolder getViewholder(View view);

    @Override
    public int getItemViewType(int position) {
        return getLayoutFile(listItems.get(position),position);
    }

    public abstract int getLayoutFile(Object object,int pos);
}
