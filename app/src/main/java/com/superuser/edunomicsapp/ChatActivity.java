package com.superuser.edunomicsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ChatActivity extends AppCompatActivity {
    private static final String titles[] = {"Assistant", "Maths Teacher", "Science Teacher","Physics Class", "Psychology Class", "English Class Group", "Doubts Class", "Astronomy Class", "Data Science Club"};
    private static final String messages[] = {"Hello! Welcome to Edunomics", "Your Homework is pending", "Assignment Submission Tomorrow","Bring your Lab Journal", "Complete your assignment ASAP", "Write a report on Shakespere", "Post your doubts here", "Next topic: Black Holes", "TensorFlow is so dope"};
    private RecyclerView recyclerView;
    private AutoCompleteTextView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.chatListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChatsAdapter(titles, messages));
        search = findViewById(R.id.searchAutoComplete);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        search.setAdapter(adapter);
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.w("Hello", adapter.getItem(i));
                String[] a = {adapter.getItem(i)};
                String[] b = {messages[i]};
                recyclerView.setAdapter(new ChatsAdapter(a, b));
            }
        });
        search.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
            @Override
            public void onDismiss() {
                if(search.getText().toString().isEmpty()) {
            recyclerView.setAdapter(new ChatsAdapter(titles, messages));
        }
                Log.w("Dismissed","Byebye"+search.getText().toString());
            }
        });
    }

//    public void onClickReset(View view){
//        if(search.getText().toString() == null) {
//            recyclerView.setAdapter(new ChatsAdapter(titles, messages));
//        }
//    }

}