package com.test.testvidio.view.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testvidio.presenter.listener.RecyclerListener;

public class BaseVH<T> extends RecyclerView.ViewHolder {
    private final RecyclerListener listener;

    public BaseVH(@NonNull View itemView, RecyclerListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(view -> listener.onItemClick(itemView.getTag()));
    }

    public void setData(T data) {
        itemView.setTag(data);
    }

    protected <K extends View> K findView(int id) {
        return (K) itemView.findViewById(id);
    }


}
