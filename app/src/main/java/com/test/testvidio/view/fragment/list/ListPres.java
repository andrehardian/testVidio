package com.test.testvidio.view.fragment.list;

import com.test.testvidio.model.Jokes;

import java.util.ArrayList;

public interface ListPres {
    void init();

    void showCategory();

    void showDetailCategory(ArrayList<Jokes> listDetail);
    void back();

    void action(int action);

    void searchClick();
}
