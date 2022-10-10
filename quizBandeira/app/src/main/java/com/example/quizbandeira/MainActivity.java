package com.example.quizbandeira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btniniciar,btnsair;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btniniciar = (Button)findViewById(R.id.bntIniciar);
        Button btnsair = (Button)findViewById(R.id.btnSair);
        EditText editText = (EditText)findViewById(R.id.editText);
        btniniciar.setEnabled(false);
        /*editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                btniniciar.setEnabled(editText.getText().length() > 1);
                return false;
            }
        }); */
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                btniniciar.setEnabled(editText.getText().length() > 0);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }

    public void proximo(View view){
        Intent it = new Intent(this, MainActivity2.class);
        it.putExtra("Nome", "");
        startActivity(it);
    }
}