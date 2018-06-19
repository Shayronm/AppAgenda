package com.example.user.appagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuxiliarActivity extends AppCompatActivity {

    Button btAgendar, btLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar);

        btAgendar = (Button) findViewById(R.id.btAgendar);
        btLista = (Button) findViewById(R.id.btLista);

        btAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AuxiliarActivity.this,CompromissoActivity.class);
                startActivity(i);
            }
        });

        btLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AuxiliarActivity.this, ListaActivity.class);
                startActivity(i);
            }
        });
    }
}

