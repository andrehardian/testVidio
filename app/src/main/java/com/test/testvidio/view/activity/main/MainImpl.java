package com.test.testvidio.view.activity.main;

import com.test.testvidio.model.Jokes;
import com.test.testvidio.presenter.impl.BaseImpl;
import com.test.testvidio.view.fragment.detail.DetailFragment_;
import com.test.testvidio.view.fragment.list.ListFragment_;

import org.androidannotations.annotations.EBean;

import java.io.Serializable;

@EBean
public class MainImpl extends BaseImpl implements MainPres {
    @Override
    public void showList() {
        showFragment(ListFragment_.builder().build());
    }

    @Override
    public void showDetail(Serializable o) {
        showFragment(DetailFragment_.builder().object(o).build());
    }
}
