package com.test.testvidio.presenter.connection;

public class URL {
    private final static String BASE_URL = "https://api.chucknorris.io/jokes";
    public final static String CATEGORIES = BASE_URL + "/categories";

    public static String randomJokes(String category) {
        return BASE_URL + "/random" + (category != null ? ("?category=" + category) : "");
    }

    public static String search(String search) {
        return BASE_URL + "/search?query=" + search;
    }
}
