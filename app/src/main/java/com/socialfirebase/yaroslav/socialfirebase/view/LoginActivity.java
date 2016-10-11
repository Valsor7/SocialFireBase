package com.socialfirebase.yaroslav.socialfirebase.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.socialfirebase.yaroslav.socialfirebase.R;
import com.socialfirebase.yaroslav.socialfirebase.global.Constants;
import com.socialfirebase.yaroslav.socialfirebase.presenter.facebook.FacebookPresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private FacebookPresenter fbLoginPresenter;

    @Bind(R.id.fb_loginButton)
    LoginButton fbButton;

    @Bind(R.id.btn_next)
    Button btnNext;

    @Bind(R.id.activity_main)
    RelativeLayout relativeLayoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        fbLoginPresenter = new FacebookPresenter(this);

        initFacebook();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fbLoginPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        fbLoginPresenter.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        fbLoginPresenter.onActivityResult(requestCode, resultCode, data);
    }

    private void initFacebook() {
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add(Constants.FACEBOOK_PERMISSION_PROFILE);
        permissions.add(Constants.FACEBOOK_PERMISSION_EMAIL);
        fbButton.setReadPermissions(permissions);
        fbButton.registerCallback(fbLoginPresenter.getFbCallBackManager(), fbLoginPresenter.getFbCallback());
    }

//    private void writeNewUser(FirebaseUser authUser){
//        User user = new User(authUser.getDisplayName(), authUser.getEmail());
//        myRef = FirebaseDatabase.getInstance().getReference("users");
//        myRef.child(authUser.getUid()).setValue(user);
//    }

//    public void signOutAction(View view) {
//        myRef = FirebaseDatabase.getInstance().getReference("users");
//        final String key = mAuth.getCurrentUser().getUid();
//        if (mAuth.getCurrentUser() != null){
//            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//
//                    Log.d(TAG, key);
//
//                    myRef.child(key).removeValue(new DatabaseReference.CompletionListener() {
//                        @Override
//                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//
//                        }
//                    });
//                }
//            });
//        }
//    }

    public void showError() {
        Snackbar.make(relativeLayoutHome, "login error", Snackbar.LENGTH_SHORT);
    }
}
