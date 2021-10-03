package com.example.ethernet_v1;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,String,String> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected String doInBackground(String... voids) {

        String message = voids[0];
        String IP = voids[1];
        String Port = voids[2];


        try{
            s=new Socket(IP,Integer.valueOf(Port));
            pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        return null;
    }
}
