package com.test.testvidio.view.fragment;

import androidx.fragment.app.Fragment;

import com.test.testvidio.presenter.impl.BaseImpl;

public class BaseFragment<T> extends Fragment {
    protected T callback;

    public void backPressed() {
        getActivity().finish();
    }

    public BaseFragment<T> setCallback(T callback) {
        this.callback = callback;
        return this;
    }


}

