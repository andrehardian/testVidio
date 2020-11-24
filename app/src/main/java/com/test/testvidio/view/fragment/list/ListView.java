package com.test.testvidio.view.fragment.list;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface ListView {
    RecyclerView list();

    EditText input();

    TextView title();

    ImageView searchButton();

}
