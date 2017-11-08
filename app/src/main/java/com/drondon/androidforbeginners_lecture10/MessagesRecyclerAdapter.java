package com.drondon.androidforbeginners_lecture10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.drondon.androidforbeginners_lecture10.model.Message;

import java.util.List;

/**
 * Created by andriimiroshnychenko on 11/8/17.
 */

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<MessagesRecyclerAdapter.MyViewHolder> {

    private List<Message> messages;

    public MessagesRecyclerAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //Получеам view
        View messageItem = inflater.inflate(R.layout.item_messege_output, parent, false);

        //Создаем ViewHolder
        return new MyViewHolder(messageItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Получаем сообщение
        Message message = messages.get(position);

        //Устанавливаем
        holder.tvText.setText(message.getText());
        holder.tvDate.setText(message.getDate().toString());
    }

    @Override
    public int getItemCount() {
        //Кол-во
        return messages.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvText;
        public TextView tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_message);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }

}
