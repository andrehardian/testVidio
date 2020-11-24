package com.test.testvidio.view.fragment.detail;

import android.widget.ImageView;
import android.widget.TextView;

import com.test.testvidio.R;
import com.test.testvidio.view.activity.main.MainPres;
import com.test.testvidio.view.fragment.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.io.Serializable;

@EFragment(R.layout.detail_fragment)
public class DetailFragment extends BaseFragment<MainPres> implements DetailView {
    @FragmentArg
    protected Serializable object;

    @Bean
    protected DetailImpl impl;

    @ViewById
    protected TextView detail;
    @ViewById
    protected TextView category;

    @ViewById
    protected ImageView image;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setData(object);
    }

    @Click(R.id.back)
    @Override
    public void backPressed() {
        callback.showList();
    }

    @Click
    protected void random(){
        impl.random();
    }

    @Override
    public ImageView image() {
        return image;
    }

    @Override
    public TextView detail() {
        return detail;
    }

    @Override
    public TextView category() {
        return category;
    }
}
