package com.cst2335.muhi0019;

import androidx.appcompat.app.AppCompatActivity;

public class MessageModel extends AppCompatActivity {
    public String message;
    public boolean isSend;
    public long id;

    public MessageModel(String message, boolean isSend, long id) {
        this.message = message;
        this.isSend = isSend;
        this.id = id;
    }

    public MessageModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }


    public long getId(long id) {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
