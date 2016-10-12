package com.socialfirebase.yaroslav.socialfirebase.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.socialfirebase.yaroslav.socialfirebase.R;
import com.socialfirebase.yaroslav.socialfirebase.adapters.PostsAdapter;
import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.model.Post;
import com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.home.EndlessRecyclerViewScrollListener;
import com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.home.HomePresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.btn_load)
    Button btnLoad;

    @Bind(R.id.rv_posts)
    RecyclerView recyclerViewPosts;


    private HomePresenter mHomePresenter;
    private PostsAdapter mPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mHomePresenter = new HomePresenter(this);
        mHomePresenter.fillData();
        mHomePresenter.storeListOfData();

        mPostAdapter = new PostsAdapter();
        recyclerViewPosts.setAdapter(mPostAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewPosts.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mHomePresenter.loadData(page);
            }
        });
        recyclerViewPosts.setLayoutManager(layoutManager);


        initViews();
    }

    private void initViews(){
        setSupportActionBar(toolbar);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                MainApp.getInstance().signOut();
            }
        });
    }

    public void setData(List<Post> data){

    }

}
