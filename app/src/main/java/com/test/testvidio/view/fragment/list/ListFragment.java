package com.test.testvidio.view.fragment.list;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.test.testvidio.R;
import com.test.testvidio.view.activity.main.MainPres;
import com.test.testvidio.view.fragment.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.list_fragment)
public class ListFragment extends BaseFragment<MainPres> implements ListView {
    @Bean
    protected ListImpl impl;

    @ViewById
    protected RecyclerView list;
    @ViewById
    protected EditText input;
    @ViewById
    protected ImageView search;
    @ViewById
    protected TextView title;

    @AfterViews
    protected void init() {
        impl.setMainPres(callback);
        impl.setViewAct(this);
        impl.init();
    }

    @Click
    protected void search() {
        impl.searchClick();
    }

    @Click(R.id.back)
    @Override
    public void backPressed() {
        impl.back();
    }

    @EditorAction
    protected void input(TextView textView, int action) {
        impl.action(action);
    }

    @Override
    public RecyclerView list() {
        return list;
    }

    @Override
    public EditText input() {
        return input;
    }

    @Override
    public TextView title() {
        return title;
    }

    @Override
    public ImageView searchButton() {
        return search;
    }
}
