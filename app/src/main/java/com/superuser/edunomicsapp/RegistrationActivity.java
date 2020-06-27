package com.superuser.edunomicsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailET;
    private EditText passwordET;
    private EditText confirmPasswordET;
    private String password;
    private String email;
    private String confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.emailEditText);
        passwordET = findViewById(R.id.passwordEditText2);
        confirmPasswordET = findViewById(R.id.passwordEditText3);

    }

    public void onClickRegisterNewUser(View view){
        //Intent intent = new Intent(this,LandingPageActivity.class);
        email = emailET.getText().toString();
        password = passwordET.getText().toString();
        confirmPassword = confirmPasswordET.getText().toString();
        if(validateForm()){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RegistrationActivity.this, "Creation Successful",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                createAlert("Error creating a new account",task.getException().getMessage());
                                //updateUI(null);
                            }

                            // ...
                        }
                    });
            }

        }


    private boolean validateForm(){
        if(!(email.contains("@") && email.contains("."))){
            emailET.setError("Invalid Email Address");
            return false;
        }
        if(password.length() < 6){
            passwordET.setError("Enter a password atleast 6 characters long");
            return false;
        }
        if(confirmPassword.length() < 6){
            confirmPasswordET.setError("Enter a password atleast 6 characters long");
            return false;
        }
        if(password.equals(confirmPassword) == false){
            confirmPasswordET.setError("Both Passwords do not match "+password+" "+confirmPassword);
            return false;
        }
        return true;
    }
    private void createAlert(String title, String content){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(content);
        alertDialogBuilder.create().show();
    }
}