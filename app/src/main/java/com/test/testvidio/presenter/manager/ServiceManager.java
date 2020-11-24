package com.test.testvidio.presenter.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.test.testvidio.model.Errors;
import com.test.testvidio.presenter.connection.ConCategories;
import com.test.testvidio.presenter.connection.ConRandom;
import com.test.testvidio.presenter.connection.ConSearch;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.ConnectionManager;
import connection.rxconnection.connection.HttpRequest;

@EBean
public class ServiceManager extends ConnectionManager implements ConnectionListener {
    @Bean
    protected DialogManager dialogManager;
    @RootContext
    protected Context context;

    private ConnectionListener connectionListener;

    @AfterInject
    protected void inject() {
        setContext(context);
    }

    @Override
    public ConnectionManager setConnectionListener(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
        return super.setConnectionListener(this);
    }

    public void category() {
        subscribe(new ConCategories(context));
    }

    public void randomJokes(String category) {
        subscribe(new ConRandom(context, category));
    }

    public void search(String input) {
        subscribe(new ConSearch(context, input));
    }

    @Override
    public void onSuccessWithData(Object o) {
        connectionListener.onSuccessWithData(o);
    }

    @Override
    public void onSuccessNull() {

    }

    @Override
    public void onMessageSuccess(String s) {

    }

    @Override
    public void onError(Object o, HttpRequest httpRequest) {
        if (o instanceof String) {
            Errors errors = new Gson().fromJson((String) o, Errors.class);
            dialogManager.errorDialog(errors != null ? errors.getMessage() : (String) o);
        }
    }


    @Override
    public void unAuthorized(HttpRequest httpRequest, String messageError) {

    }
}
