package com.disydes.cateringboa;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class VerVuelo extends ActionBarActivity {





    public String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_vuelo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("NUMERO_VUELO");

            TextView textView = (TextView)findViewById(R.id.NUMERO_VUELO);
            textView.setText(value);
        }
    }

    public void enviarCorreo(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"fabiofigueroap@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Solicitu la aprobacion");
        i.putExtra(Intent.EXTRA_TEXT   , "Solicito la aprobacion");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(VerVuelo.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void ver(View v){

        Log.d("resultado",value);
    }

    public void pedir(View v){

        Intent intent = new Intent(this, formulario_pedir.class);
        intent.putExtra("NUMERO_VUELO", value);
        startActivity(intent);
    }





}
