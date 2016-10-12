package com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.home;

import android.app.Activity;
import android.support.v4.util.ArrayMap;

import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.helpers.FireBaseDBHelper;
import com.socialfirebase.yaroslav.socialfirebase.model.Post;
import com.socialfirebase.yaroslav.socialfirebase.model.User;
import com.socialfirebase.yaroslav.socialfirebase.view.HomeActivity;

import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 12.10.16.
 */

public class HomePresenter {
    private static final String TAG = "HomePresenter";
    private String url = "https://firebasestorage.googleapis.com/v0/b/socialfirebase-683f3.appspot.com/o/images%2F576a6b6f1673c49e4926c6a2_FitGame1467560353768.jpg?alt=media&token=b892e5f3-d24e-4509-bb7a-32a383b85b7e";
    private MainApp mMainApp;
    private HomeActivity mActivity;
    private FireBaseDBHelper dbHelper;
    private Map<String, Post> mPosts;

    public HomePresenter(Activity activity){
        mActivity = (HomeActivity) activity;
        dbHelper = new FireBaseDBHelper(this);
    }

    public void fillData(){
        mPosts = new ArrayMap<>();
        for (int i = 0; i < 1000; i++) {
            String title = "my " + i + "title";
            Post post = new Post(String.valueOf(i), url, title, "user");
            mPosts.put(String.valueOf(i), post);
        }
    }

    public void loadData(int start){
        dbHelper.loadList(start);
    }

    public void onUploaded(List<Post> posts){
        
    }


    public void storeListOfData(){
        dbHelper.storeList(mPosts);
    }

    public void onStart(){

    }

    public void onStop(){

    }
}
