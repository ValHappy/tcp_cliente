package com.example.happy.tcpclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pantalla3 extends AppCompatActivity{

    //Principal
    private EditText ed_dir;
    private Button btn_ok;

    /**
     * Constructor Pantalla 3 (Pedir la IP)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        btn_ok = findViewById(R.id.btn_ok);
        ed_dir = findViewById(R.id.ed_dir);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(getApplicationContext(),Pantalla4.class);
                game.putExtra("ip",ed_dir.getText().toString());
                startActivity(game);
            }
        });
    }
    public EditText getEd_dir() {
        return ed_dir;
    }

    public void setEd_dir(EditText ed_dir) {
        this.ed_dir = ed_dir;
    }
}
