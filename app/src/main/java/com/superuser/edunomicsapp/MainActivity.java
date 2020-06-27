package com.superuser.edunomicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private View frame;
    private TextView message;
    private static int[] slides = {R.drawable.ic_one,R.drawable.ic_two, R.drawable.ic_three, R.drawable.ic_four, R.drawable.ic_five};
    private static int currentSlide = 0;
    private static String[] messages = {"Welcome to the world of Edunomics","Quality Education\nKnowledge through the industry experts.","Better Talent\n" +
            "World-class talent will be produced in various fields","Productivity at jobs\n" +
            "Talented workforce enabling innovation and productivity","Innovation Drive\n" +
            "The industry will undergo innovation with more demand."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame = findViewById(R.id.vectorView);
        message = findViewById(R.id.messageViewSlide);
        frame.setBackgroundResource(slides[currentSlide]);
        message.setText(messages[currentSlide]);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSlide<slides.length-1) {
                    currentSlide++;
                }
                else{
                    currentSlide = 0;
                }
                frame.setBackgroundResource(slides[currentSlide]);
                message.setText(messages[currentSlide]);
            }
        });
//        if(auth.getCurrentUser() != null){
//            startActivity(new Intent(this,ChatActivity.class));
//        }
    }

    public void onClickLogin(View view){
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
    public void onClickRegister(View view){
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
        finish();
    }
}