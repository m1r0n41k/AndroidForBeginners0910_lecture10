package com.drondon.androidforbeginners_lecture10.model;

import java.util.Date;

/**
 * Created by andriimiroshnychenko on 11/8/17.
 */

public class Message {
    private String text;
    private Date date;

    public Message(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
