package com.test.testvidio.view.adapter.listAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.test.testvidio.R;
import com.test.testvidio.presenter.listener.RecyclerListener;
import com.test.testvidio.view.adapter.BaseVH;

public class VHCategory extends BaseVH<String> {
    private TextView category;

    public VHCategory(@NonNull View itemView, RecyclerListener listener) {
        super(itemView, listener);
        category = findView(R.id.category);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        category.setText(data);
    }
}
