package com.example.user.appagenda;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CompromissoActivity extends AppCompatActivity {

    EditText ctNome, ctData, ctHora, ctTipo, ctDescricao;
    Button btSalvar;
    Cursor cursor;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromisso);

        ctData = (EditText)findViewById(R.id.ctData);
        ctHora = (EditText)findViewById(R.id.ctHora);
        ctTipo = (EditText)findViewById(R.id.ctTipo);
        ctDescricao = (EditText)findViewById(R.id.ctDescricao);
        btSalvar = (Button)findViewById(R.id.btSalvar);

        if (getIntent().getStringExtra("situacao").equals("alterar")){
            Metodo c = new Metodo(getBaseContext());
            codigo = this.getIntent().getStringExtra("codigo");
            cursor = c.buscaID(Integer.parseInt(codigo));
            ctData.setText(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            ctHora.setText(cursor.getString(cursor.getColumnIndexOrThrow("hora")));
            ctTipo.setText(cursor.getString(cursor.getColumnIndexOrThrow("tipo")));
            ctDescricao.setText(cursor.getString(cursor.getColumnIndexOrThrow("descricao")));
        }

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Metodo c = new Metodo(getBaseContext());
                String data = ctData.getText().toString();
                String hora = ctHora.getText().toString();
                String tipo = ctTipo.getText().toString();
                String descricao = ctDescricao.getText().toString();
                String r;
                if(getIntent().getStringExtra("situacao").equals("inserir")) {
                    r = c.inserir(tipo, descricao, data, hora);
                }else {
                    r = c.alterar(Integer.parseInt(codigo), tipo, descricao, data, hora);
                    Integer.parseInt(codigo);
                }

                Toast.makeText(CompromissoActivity.this, r, Toast.LENGTH_LONG).show();
            }
        });
    }
}



