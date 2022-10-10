package com.example.quizbandeira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textResultado  = (TextView) findViewById(R.id.textresultado);
        Bundle bundle = getIntent().getExtras();
        final int[] Acertos = {bundle.getInt("Acertos")};
        textResultado.setText(String.valueOf(Acertos[0]));
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }

    public void inicio(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}