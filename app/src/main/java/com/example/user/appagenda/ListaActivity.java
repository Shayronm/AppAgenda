package com.example.user.appagenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class ListaActivity extends AppCompatActivity {

    ListView lista;
    Cursor cursor;
    String codigo;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        final Metodo c = new Metodo(getBaseContext());
        cursor = c.Lista();
        String[] campos = new String[]{"nome", "data", "hora", "tipo", "descricao"};
        int[] idViews = new int[]{R.id.data, R.id.hora, R.id.tipo, R.id.descricao};

        SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_layout, cursor, campos, idViews, 0);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(ad);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaActivity.this);
                builder.setMessage("O que deseja fazer?");
                builder.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ListaActivity.this, CompromissoActivity.class);
                        intent.putExtra("situacao", "alterar");
                        intent.putExtra("codigo", codigo);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ListaActivity.this);
                        builder.setMessage("Deseja excluir o registro?");
                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String result = c.excluir(Integer.parseInt(codigo));
                                Toast.makeText(ListaActivity.this, result, Toast.LENGTH_SHORT);
                                finish();
                                startActivity(getIntent());
                            }
                        });
                        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alerta = builder.create();
                        alerta.show();
                    }
                });
                alerta = builder.create();
                alerta.show();
            }
        });
    }
}

