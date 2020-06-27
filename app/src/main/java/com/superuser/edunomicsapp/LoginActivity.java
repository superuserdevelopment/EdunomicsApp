package com.superuser.edunomicsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailET;
    private EditText passwordET;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.usernameEditTextLogin);
        passwordET = findViewById(R.id.passwordEditTextLogin);
    }

    //Executed when "New Here" Text view is tapped
    public void onClickNewUser(View view){
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        finish();
    }



    public void onClickLoginButton(View view){
        //code for logging in
        //Intent intent = new Intent(this,LandingPageActivity.class);
        email = emailET.getText().toString();
        password = passwordET.getText().toString();
        //Pre-Validation of username and password
        if(email.length() == 0){
            emailET.setError("This can't be empty");
        }
        if(password.length() < 6){
            passwordET.setError("Enter a password atleast 6 characters long");
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                createAlert("Success!","Sign-in Successful");

                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                createAlert("Oops!",task.getException().getMessage());
                            }

                            // ...
                        }
                    });
        }

    }
    private void createAlert(String title, String content){
        androidx.appcompat.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(content);
        alertDialogBuilder.create().show();
    }
}