package com.socialfirebase.yaroslav.socialfirebase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socialfirebase.yaroslav.socialfirebase.R;
import com.socialfirebase.yaroslav.socialfirebase.model.User;

import java.util.ArrayList;

/**
 * Created by yaroslav on 12.10.16.
 */

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<User> mPosts;

    public PostsAdapter(){

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View postView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new VHPost(postView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VHPost vhPost = (VHPost) holder;
        vhPost.bind();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VHPost extends RecyclerView.ViewHolder{

        VHPost(View itemView) {
            super(itemView);
        }

        void bind(){

        }
    }
}
