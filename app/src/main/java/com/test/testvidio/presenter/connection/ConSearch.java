package com.test.testvidio.presenter.connection;

import android.content.Context;

import com.test.testvidio.model.ResponseSearch;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConSearch extends HttpRequest<Object, ResponseSearch> {
    public ConSearch(Context context, String search) {
        super(context, ResponseSearch.class, URL.search(search), HttpMethod.GET);
    }
}
