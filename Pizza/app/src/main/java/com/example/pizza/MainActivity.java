package com.example.pizza;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText q1, q2, q3, q4;
    TextView resultado;
    Button btn;
    int pizza = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        btn = findViewById(R.id.btn);
        resultado = findViewById(R.id.result);
    }
    public void pedir(View view){
        pizza += 19 * parseInt(q1.getText().toString());
        pizza += 19 * parseInt(q2.getText().toString());
        pizza += 21 * parseInt(q3.getText().toString());
        pizza += 25 * parseInt(q4.getText().toString());
        resultado.setText(Integer.toString(pizza));
    }
}