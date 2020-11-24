package com.test.testvidio.presenter.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.testvidio.model.Jokes;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class UtilsDetail {
    @RootContext
    protected Context context;
    public void setDetail(TextView detail, ImageView image, Jokes jokes) {
        if (jokes.getIconUrl() != null && !jokes.getIconUrl().isEmpty()) {
            Picasso.with(context).load(jokes.getIconUrl()).into(image);
        }
        detail.setText(jokes.getValue());

    }
}
