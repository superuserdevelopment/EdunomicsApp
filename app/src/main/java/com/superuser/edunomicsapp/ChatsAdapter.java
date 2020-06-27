package com.superuser.edunomicsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {
    private String[] data;
    private String[] message;
    public ChatsAdapter(String[] data, String[] message){
        this.data = data;
        this.message = message;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.chat_view, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        String title = data[position];
        String messages = message[position];
        holder.title.setText(title);
        holder.message.setText(messages);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView title;
        TextView message;
        public ChatViewHolder(View itemView){
            super(itemView);
            imgIcon =  itemView.findViewById(R.id.imgIcon2);
            title = itemView.findViewById(R.id.viewTitle2);
            message = itemView.findViewById(R.id.chatContent);
        }
    }
}
