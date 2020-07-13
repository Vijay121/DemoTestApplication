package com.cogni.demotestapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.cogni.demotestapplication.adapters.UserRecyclerAdapter;
import com.cogni.demotestapplication.model.RowsItem;
import com.cogni.demotestapplication.model.UserContentData;
import com.cogni.demotestapplication.viewmodel.UserViewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserRecyclerAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initlizing views
        initViews();

        /*Viewmodel initilization*/
        UserViewmodel model = ViewModelProviders.of(this).get(UserViewmodel.class);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                model.getUserData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        model.getUserData().observe(this, new Observer<UserContentData>() {
            @Override
            public void onChanged(@Nullable UserContentData userContentData) {
                if (userContentData != null && userContentData.getRows().size() > 0) {
                    adapter = new UserRecyclerAdapter(MainActivity.this, userContentData.getRows());
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.user_recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

    }

}