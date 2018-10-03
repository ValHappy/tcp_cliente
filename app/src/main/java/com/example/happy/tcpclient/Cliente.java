package com.example.happy.tcpclient;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Thread{

    //Variable global porque lo oy a utilizar mas adelante
    Socket s;
    Receptor r;

    //Inyección de dependencias
    MainActivity activity;
    public Cliente(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public void run() {
        //Entablar una conexión con eclipse que esta esperando una conexión
        try {
            s = new Socket("10.0.2.2", 6000);

            r = new Receptor(s);
            r.setObserver(activity);
            r.start();
            enviar();

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void enviar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream os = s.getOutputStream();
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(os));
                   out.println("Deberia funcionar...");
                    out.flush();
                }catch (IOException e) {

                }
            }
        }).start();


    }
}
