package com.example.happy.tcpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity{

    //Inicio
    private Button btn_play;
    private Button btn_instrucciones;

    /**
     * Constructor de la pantalla principal
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = findViewById(R.id.btn_jugar);
        btn_instrucciones = findViewById(R.id.btn_instrucciones);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(getApplicationContext(),Pantalla3.class);
                startActivity(play);
            }
        });

        btn_instrucciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instru = new Intent(getApplicationContext(),Pantalla2.class);
                startActivity(instru);
            }
        });


    }

}
