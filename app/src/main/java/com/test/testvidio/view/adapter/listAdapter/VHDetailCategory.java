package com.test.testvidio.view.adapter.listAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.test.testvidio.R;
import com.test.testvidio.model.Jokes;
import com.test.testvidio.presenter.listener.RecyclerListener;
import com.test.testvidio.presenter.utils.FormatterDate;
import com.test.testvidio.presenter.utils.UtilsDetail_;
import com.test.testvidio.view.adapter.BaseVH;

public class VHDetailCategory extends BaseVH<Jokes> {
    private ImageView image;
    private TextView detail;
    private TextView updated;

    public VHDetailCategory(@NonNull View itemView, RecyclerListener listener) {
        super(itemView, listener);
        image = findView(R.id.image);
        detail = findView(R.id.detail);
        updated = findView(R.id.updated);
    }

    @Override
    public void setData(Jokes data) {
        super.setData(data);
        UtilsDetail_.getInstance_(itemView.getContext()).setDetail(detail, image, data);
        updated.setText(FormatterDate.format(data.getUpdated()));
    }
}
