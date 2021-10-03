package com.example.ethernet_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,eIP,ePort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.et1);
        eIP = (EditText) findViewById(R.id.etIP);
        ePort = (EditText) findViewById(R.id.etPort);
    }


    public void send (View v){
        MessageSender messageSender = new MessageSender();
        messageSender.execute(e1.getText().toString(),eIP.getText().toString(),ePort.getText().toString());

    }


}