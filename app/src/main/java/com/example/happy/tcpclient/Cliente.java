package com.example.happy.tcpclient;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Thread{
    
    Socket s;
    Receptor r;
    String ip;

    //Inyección de dependencias
    Pantalla4 activity;

    /**
     * Constructor del Cliente
     * @param activity
     * @param ip
     */
    public Cliente(Pantalla4 activity, String ip){
        this.activity = activity;
        this.ip = ip;
    }

    /**
     * Metodo para iniciar el hilo y entablar una conexión con eclipse que esta esperandola
     */
    @Override
    public void run() {
        try {
            s = new Socket(ip, 5000);
            r = new Receptor(s, activity);
            r.setObserver(activity);
            r.start();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para enviar información (Strings)
     * @param mensaje
     */
    public void enviar(final String mensaje){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataOutputStream os = new DataOutputStream(s.getOutputStream());
                    os.writeUTF(mensaje);
                }catch (IOException e) {
                }
            }
        }).start();
    }
}
