package com.socialfirebase.yaroslav.socialfirebase.helpers;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;
import com.socialfirebase.yaroslav.socialfirebase.model.Post;
import com.socialfirebase.yaroslav.socialfirebase.model.User;
import com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.home.HomePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yaroslav on 12.10.16.
 */

public class FireBaseDBHelper {
    private static final String TAG = "FireBaseDBHelper";
    private static final String USERS_NODE = "users";
    private final HomePresenter mPresenter;

    private FirebaseDatabase mFireBaseDB;
    private DatabaseReference mReference;

    private ChildEventListener childListener = new ChildEventListener() {

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            User user = dataSnapshot.getValue(User.class);
            Log.i(TAG, user.toString());
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            User user = dataSnapshot.getValue(User.class);
            Log.i(TAG, user.toString());
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private ValueEventListener valueListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                User user = snapshot.getValue(User.class);
                Log.i(TAG, user.toString());
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public FireBaseDBHelper(HomePresenter presenter){
        mFireBaseDB = FirebaseDatabase.getInstance();
        mReference = mFireBaseDB.getReference().child(USERS_NODE);
        mPresenter = presenter;
    }

    public void storeList(Map<String, Post> data){
        mReference.setValue(data);
    }

    public void loadList(int start){
        Query query = mReference
                .startAt(start)
                .limitToFirst(10);

        query.addValueEventListener(valueListener);
    }
}
