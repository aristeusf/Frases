package br.com.alb.frases;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView frases;
    BaseDados bd;

    String Inicial = "Sim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frases = (TextView) findViewById(R.id.Frase);

        bd = new BaseDados(this);

        if(Inicial == "Sim")
        {
            ContentValues values = new ContentValues();

            int id = 1;

            values.put("id", id);
            values.put("frase", "Faça pequenas coisas agora e maiores coisas lhe serão confiadas cada dia.");
            bd.Inserir(values, "frases");

            id++;

            values.clear();
            values.put("id", id);
            values.put("frase", "Podemos escolher o que semear, mas somos obrigados a colher o que plantamos.");
            bd.Inserir(values, "frases");

            id++;

            values.clear();
            values.put("id", id);
            values.put("frase", "Lamentar aquilo que não temos é desperdiçar aquilo que já possuímos");
            bd.Inserir(values, "frases");

            id++;

            values.clear();
            values.put("id", id);
            values.put("frase", "Faça pequenas coisas agora e maiores coisas lhe serão confiadas cada dia.");
            bd.Inserir(values, "frases");
        }

        String frase = bd.getFrases();

        frases.setText(frase);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frases.setText(bd.getFrases());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
