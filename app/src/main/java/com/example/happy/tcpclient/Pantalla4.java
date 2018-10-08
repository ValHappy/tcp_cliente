package com.example.happy.tcpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pantalla4 extends AppCompatActivity implements Receptor.OnMessage{

    //Juego
    private Cliente c;
    private Button btn_arriba;
    private Button btn_abajo;
    private Button btn_derecha;
    private Button btn_izquierda;
    private Button btn_disparar;

    /**
     * Constructor de la pantalla de juego
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("ip");
            c = new Cliente(this, value);
            c.start();
        }

        btn_arriba = findViewById(R.id.btn_arriba);
        btn_abajo = findViewById(R.id.btn_abajo);
        btn_izquierda = findViewById(R.id.btn_izquierda);
        btn_derecha = findViewById(R.id.btn_derecha);
        btn_disparar = findViewById(R.id.btn_disparar);

        btn_arriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("arriba");
            }
        });

        btn_abajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("abajo");
            }
        });

        btn_izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("izquierda");
            }
        });

        btn_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("derecha");
            }
        });

        btn_disparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.enviar("disparar");
            }
        });

    }

    /**
     * Metodo para recibir
     * ste meodo se ejecuta en paralelo
     * @param mensaje
     */
    @Override
    public void onReceived(final String mensaje) {
        //Es lo unico que muestra lo del hilo graficamente
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Pantalla4.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
