package com.test.testvidio.presenter.connection;

import android.content.Context;

import com.test.testvidio.model.Jokes;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConRandom extends HttpRequest<Object, Jokes> {
    public ConRandom(Context context, String category) {
        super(context, Jokes.class, URL.randomJokes(category), HttpMethod.GET);
    }
}
