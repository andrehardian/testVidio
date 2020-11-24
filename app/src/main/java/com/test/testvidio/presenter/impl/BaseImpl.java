package com.test.testvidio.presenter.impl;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.test.testvidio.presenter.manager.ServiceManager;
import com.test.testvidio.view.fragment.BaseFragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.HttpRequest;

@EBean
public class BaseImpl<T> implements ConnectionListener {
    @Bean
    protected ServiceManager serviceManager;
    @RootContext
    protected Activity activity;

    protected T viewAct;
    private FragmentManager fragmentManager;
    private int layoutFragment;

    @AfterInject
    protected void inject() {
        serviceManager.setConnectionListener(this);
    }

    public void setViewAct(T viewAct) {
        this.viewAct = viewAct;
    }

    public void initFragment(FragmentManager fragmentManager, int layout) {
        this.fragmentManager = fragmentManager;
        layoutFragment = layout;
    }

    public void setLayoutFragment(int layoutFragment) {
        this.layoutFragment = layoutFragment;
    }

    protected void showFragment(BaseFragment fragment) {
        fragmentManager.beginTransaction().replace(layoutFragment, fragment.setCallback(this))
                .commitAllowingStateLoss();
    }

    @Override
    public void onSuccessWithData(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }

    @Override
    public void onMessageSuccess(String s) {

    }

    @Override
    public void onError(Object o, HttpRequest httpRequest) {

    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String messageError) {

    }

    public void backpressed() {
        Fragment fragment = fragmentManager.findFragmentById(layoutFragment);
        if (fragment instanceof BaseFragment) {
            ((BaseFragment) fragment).backPressed();
        }
    }
}
