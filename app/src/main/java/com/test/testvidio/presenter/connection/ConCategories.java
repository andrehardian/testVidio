package com.test.testvidio.presenter.connection;

import android.content.Context;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConCategories extends HttpRequest<Object, String[]> {
    public ConCategories(Context context) {
        super(context, String[].class, URL.CATEGORIES, HttpMethod.GET);
    }
}
