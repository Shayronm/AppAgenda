package com.example.user.appagenda;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {


    public Banco(Context context) {

        super(context, "dd2.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE compromisso (" +
                "_id integer primary key autoincrement not null," +
                "tipo text," +
                "descricao text," +
                "data text," +
                "hora text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {

    }
}


