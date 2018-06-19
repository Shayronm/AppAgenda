package com.example.user.appagenda;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Metodo {

    SQLiteDatabase db;
    Banco banco;

    public Metodo(Context context) {

        banco = new Banco(context);
    }

    public String inserir(String data, String hora, String tipo, String descricao) {
        ContentValues v;
        long result;

        db = banco.getWritableDatabase();

        v = new ContentValues();
        v.put("data", data);
        v.put("hora", hora);
        v.put("tipo", tipo);
        v.put("descricao", descricao);

        result = db.insert("compromisso", null, v);
        db.close();

        if (result == -1) {
            return "Erro ao inserir o registro";
        } else {
            return "Registro gravado com sucesso";
        }
    }

    public Cursor Lista() {
        Cursor cursor;
        String[] campos = {"_id", "nome", "data", "hora", "tipo", "descricao"};
        db = banco.getReadableDatabase();
        cursor = db.query("compromisso", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor buscaID(int id){
        Cursor cursor;
        String[] campos = {"_id", "nome", "data", "hora", "tipo", "descricao"};
        String where = "_id=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("compromisso", campos, where, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String alterar(int id,String data, String hora, String tipo, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id=" + id;

        valores = new ContentValues();
        valores.put("data", data);
        valores.put("hora", hora);
        valores.put("tipo", tipo);
        valores.put("descricao", descricao);

        int result = db.update("compromisso", valores, where, null);
        db.close();

        if (result == -1){
            return "Erro ao alterar o registro";
        }else {
            return "Registro alterado com sucesso";
        }
    }

    public String excluir(int id){
        String where;
        db = banco.getWritableDatabase();
        where = "_id=" + id;
        int result = db.delete("compromisso", where, null);
        db.close();

        if (result == -1){
            return "Erro ao excluir o registro";
        }else {
            return "Registro excluido com sucesso";
        }
    }
}
