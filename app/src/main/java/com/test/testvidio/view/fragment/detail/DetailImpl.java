package com.test.testvidio.view.fragment.detail;

import com.test.testvidio.model.Jokes;
import com.test.testvidio.presenter.impl.BaseImpl;
import com.test.testvidio.presenter.utils.UtilsDetail;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class DetailImpl extends BaseImpl<DetailView> implements DetailPres {
    @Bean
    protected UtilsDetail utilsDetail;
    private String category;

    @Override
    public void setData(Object data) {
        if (data == null) {
            return;
        }
        if (data instanceof String) {
            category = (String) data;
            random();
        } else if (data instanceof Jokes) {
            String[] categories = ((Jokes) data).getCategories();
            if (categories.length > 0) {
                category = categories[0];
            }
            utilsDetail.setDetail(viewAct.detail(), viewAct.image(), (Jokes) data);
        }
        viewAct.category().setText("Category :" + (category != null ? category : "-"));
    }

    @Override
    public void random() {
        serviceManager.randomJokes(category);
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof Jokes) {
            setData(o);
        }
    }
}
