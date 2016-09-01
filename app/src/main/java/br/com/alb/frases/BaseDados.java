package br.com.alb.frases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Random;

/**
 * Created by Aristeu on 31/08/2016.
 */
public class BaseDados extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "frases";
    private static int VERSAO = 1;
    public static long Lastresult;
    public static int Fragmento;

    private SQLiteDatabase db;

    public BaseDados(Context context)
    {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE frases (id INTEGER PRIMARY KEY, frase TEXT)";

        db.execSQL(sql);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public long Inserir(ContentValues values, String table) {

        db = getWritableDatabase();

        long result = db.insert(table, null, values);

        return result;
    }

    public int getLastId(String Tabela)
    {
        int retorno = 0;

        db = getReadableDatabase();

        String sql = "SELECT MAX(id) FROM " + Tabela;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            retorno = cursor.getInt(0);
            retorno++;
        }
        else{
            retorno = 1;
        }

        return retorno;
    }

    public String getFrases(){

        String Retorno = "";

        while (Retorno == "") {
            db = getReadableDatabase();

            String sql = "Select frase from  frases where id = " + getRandomId();

            Cursor cursor = db.rawQuery(sql, null);


            if (cursor.moveToFirst())
                Retorno = cursor.getString(0);

        }

        return Retorno;
    }

    private String getRandomId() {

        Random gerador = new Random();

        String Retorno = String.valueOf(gerador.nextInt(getLastId("frases")));

        return Retorno;
    }
}
