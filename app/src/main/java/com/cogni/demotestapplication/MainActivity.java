package com.cogni.demotestapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.cogni.demotestapplication.adapters.UserRecyclerAdapter;
import com.cogni.demotestapplication.databinding.ActivityMainBinding;
import com.cogni.demotestapplication.viewmodel.UserViewmodel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserRecyclerAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private UserViewmodel userViewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initlizing views
        initViews();

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            userViewmodel.loadUsers();
            mSwipeRefreshLayout.setRefreshing(false);
        });

        userViewmodel.loadUsers().observe(this, userContentData -> {
            if (userContentData != null && userContentData.getRows().size() > 0) {
                adapter.setUserData(userContentData.getRows());
            }
        });
    }

    private void initViews() {
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        /*Viewmodel initilization*/
        userViewmodel = ViewModelProviders.of(this).get(UserViewmodel.class);

        recyclerView = findViewById(R.id.user_recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        recyclerView = activityMainBinding.userRecyclerview;
        adapter = new UserRecyclerAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

}