package com.drondon.androidforbeginners_lecture10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.drondon.androidforbeginners_lecture10.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView); //1

        LinearLayoutManager manager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(manager); //2

        final EditText editText = findViewById(R.id.editText);
        ImageButton imageButton = findViewById(R.id.imageButton);

        final List<Message> messages = new ArrayList<>();

        final MessagesRecyclerAdapter adapter = new MessagesRecyclerAdapter(messages);

        recyclerView.setAdapter(adapter);//3

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editableText = editText.getText();
                String text = editableText.toString();
                Message newMessage = new Message(text, new Date());
                messages.add(0, newMessage);
                adapter.notifyItemInserted(0);

                editText.setText("");

                recyclerView.scrollToPosition(0);
            }
        });
    }
}
