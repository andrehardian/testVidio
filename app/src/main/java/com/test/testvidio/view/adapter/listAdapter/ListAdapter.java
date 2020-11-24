package com.test.testvidio.view.adapter.listAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testvidio.R;
import com.test.testvidio.presenter.listener.RecyclerListener;
import com.test.testvidio.view.adapter.BaseVH;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {
    private final ArrayList items;
    private final RecyclerListener listener;
    private final int category = 0;
    private final int detail = 1;

    public ListAdapter(ArrayList items, RecyclerListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case category:
                return createHolderCategory(parent);
            case detail:
                return createHolderDetail(parent);
        }
        return null;
    }

    private View createView(ViewGroup parent, int layout) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);
        return view;
    }

    private RecyclerView.ViewHolder createHolderDetail(ViewGroup parent) {
        return new VHDetailCategory(createView(parent, R.layout.adapter_detail), listener);
    }

    private RecyclerView.ViewHolder createHolderCategory(ViewGroup parent) {
        return new VHCategory(createView(parent, R.layout.adapter_category), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BaseVH) {
            ((BaseVH) holder).setData(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) instanceof String ? category : detail;
    }
}
