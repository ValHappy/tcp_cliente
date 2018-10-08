package com.example.happy.tcpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pantalla2 extends AppCompatActivity {

    //Instrucciones
    private Button btn_next;

    /**
     * Constructor de la Pantalla 2 (Instrucciones)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solicitud = new Intent(getApplicationContext(),Pantalla3.class);
                startActivity(solicitud);
            }
        });
    }
}
