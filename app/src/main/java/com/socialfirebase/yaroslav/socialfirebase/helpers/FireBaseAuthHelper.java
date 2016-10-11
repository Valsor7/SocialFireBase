package com.socialfirebase.yaroslav.socialfirebase.helpers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.socialfirebase.yaroslav.socialfirebase.global.MainApp;

/**
 * Created by yaroslav on 11.10.16.
 */

public class FireBaseAuthHelper {

    private static final String TAG = "FireBaseAuthHelper";

    private FirebaseAuth mFireBaseAuth;
    private FirebaseUser mFireBaseUser;
    private MainApp mMainApp;


    FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                mMainApp.notifyLoginStatus(true);
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out");
                mMainApp.notifyLoginStatus(false);
            }
        }
    };

    public FireBaseAuthHelper(MainApp mainApp){
        mFireBaseAuth = FirebaseAuth.getInstance();
        mFireBaseUser = mFireBaseAuth.getCurrentUser();
        mMainApp = mainApp;
        mFireBaseAuth.addAuthStateListener(mAuthListener);
    }

    public void signIn(AuthCredential credential) {
        mFireBaseAuth.signInWithCredential(credential);
    }

    public void signOut() {
        mFireBaseAuth.signOut();
    }

    private void notifyUserLoginStatus(){
        if (null != mFireBaseUser){
            Log.d(TAG, "notify logged in");
            mMainApp.notifyLoginStatus(true);
        } else {
            Log.d(TAG, "notify log out");
            mMainApp.notifyLoginStatus(false);
        }
    }

    public void startListening(){
        mFireBaseAuth.addAuthStateListener(mAuthListener);
    }

    public void stopListening(){
        if (mAuthListener != null) {
            mFireBaseAuth.removeAuthStateListener(mAuthListener);
        }
    }


}
