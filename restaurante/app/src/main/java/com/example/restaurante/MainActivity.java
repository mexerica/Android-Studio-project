package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView taxa, resultado, divisao;
    EditText consumo_total, cover, pessoas;
    BigDecimal valor, adicao, divisor;
    int prescisao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        taxa = findViewById(R.id.taxa);
        resultado = findViewById(R.id.resultado);
        divisao = findViewById(R.id.divisao);
        consumo_total = findViewById(R.id.consumo_Total);
        cover = findViewById(R.id.cover);
        pessoas = findViewById(R.id.pessoas);
    }

    public void calculos(View view){
        valor = new BigDecimal(consumo_total.getText().toString());
        adicao = new BigDecimal(cover.getText().toString());
        divisor = new BigDecimal(pessoas.getText().toString());
        BigDecimal juros = new BigDecimal("0.01");
        valor = valor.add(adicao);
        juros = valor.multiply(juros);
        valor = valor.add(juros);
        prescisao = Integer.toString(valor.intValue()).length() + 2;
        resultado.setText(String.valueOf(valor.round(new MathContext(prescisao, RoundingMode.HALF_UP))));
        prescisao = Integer.toString(juros.intValue()).length() + 2;
        taxa.setText(String.valueOf(juros.round(new MathContext(prescisao, RoundingMode.HALF_UP))));
        valor = valor.divide(divisor);
        prescisao = Integer.toString(valor.intValue()).length() + 2;
        divisao.setText(String.valueOf(valor.round(new MathContext(prescisao, RoundingMode.HALF_UP))));
    }
}