package com.test.testvidio.view.fragment.list;

import android.view.View;
import android.view.inputmethod.EditorInfo;

import com.test.testvidio.R;
import com.test.testvidio.model.Jokes;
import com.test.testvidio.model.ResponseSearch;
import com.test.testvidio.presenter.impl.BaseImpl;
import com.test.testvidio.presenter.listener.RecyclerListener;
import com.test.testvidio.view.activity.main.MainPres;
import com.test.testvidio.view.adapter.listAdapter.ListAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

import java.util.ArrayList;
import java.util.Arrays;

@EBean
public class ListImpl extends BaseImpl<ListView> implements ListPres, RecyclerListener {
    @StringRes(R.string.category_list)
    protected String categoryListTitle;
    private ArrayList<String> categories = new ArrayList<>();
    private String input;
    private MainPres mainPres;
    private boolean detail;

    @Override
    public void init() {
        serviceManager.category();
        setTitle(categoryListTitle);
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof String[]) {
            categories = new ArrayList<>(Arrays.asList((String[]) o));
            showCategory();
        } else if (o instanceof ResponseSearch) {
            showDetailCategory(((ResponseSearch) o).getResult());
        }
    }

    @Override
    public void showCategory() {
        setList(categories);
    }

    private void setList(ArrayList data) {
        viewAct.list().setAdapter(new ListAdapter(data, this));

    }

    @Override
    public void showDetailCategory(ArrayList<Jokes> listDetail) {
        setList(listDetail);
    }

    @Override
    public void back() {
        if (detail) {
            setVisibilityIconSearch(View.VISIBLE);
            setTitle(categoryListTitle);
            detail = false;
            showCategory();
        } else {
            activity.finish();
        }
    }

    private void setTitle(String title) {
        viewAct.title().setText(title);
    }

    @Override
    public void action(int action) {
        if (action == EditorInfo.IME_ACTION_SEARCH) {
            input = viewAct.input().getText().toString();
            search();
        }
    }

    @Override
    public void searchClick() {
        viewAct.input().setVisibility(viewAct.input().getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof String) {
            input = (String) o;
            mainPres.showDetail((String)o);
        } else if (o instanceof Jokes) {
            mainPres.showDetail((Jokes) o);
        }
    }

    private void setVisibilityIconSearch(int visibility) {
        viewAct.searchButton().setVisibility(visibility);
    }

    private void search() {
        detail = true;
        serviceManager.search(input);
    }

    public void setMainPres(MainPres mainPres) {
        this.mainPres = mainPres;
    }
}
