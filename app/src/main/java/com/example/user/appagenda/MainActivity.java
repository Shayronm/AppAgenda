package com.example.user.appagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String login = "shard.unique10@gmail.com";
    private final String senha = "1234";
    EditText tlogin;
    EditText tsenha;
    Button btacesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btacesso = (Button) findViewById(R.id.btacesso);

        btacesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tlogin = (EditText) findViewById(R.id.tlogin);
                EditText tsenha = (EditText) findViewById(R.id.tsenha);
                String login = tlogin.getText().toString();
                String senha = tsenha.getText().toString();
                if (login.equals("shard.unique10@gmail.com") && senha.equals("1234")) {
                    Intent i = new Intent(MainActivity.this, AuxiliarActivity.class);
                    startActivity(i);
                    alert("Login Bem Sucedido");
                } else {
                    alert("Login Mal Sucedido");
                }
            }
        });
    }


    public void alert(String m) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }
}

