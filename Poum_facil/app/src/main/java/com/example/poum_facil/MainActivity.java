package com.example.poum_facil;

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
    EditText valor_inicial, aplicacao_mensal, meses, taxa;
    TextView resultado;
    BigDecimal valor;
    BigDecimal aplicacao;
    BigDecimal juros;
    int tempo, prescisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        valor_inicial = findViewById(R.id.valor_inicial);
        aplicacao_mensal = findViewById(R.id.aplicacao_mensal);
        meses = findViewById(R.id.meses);
        taxa = findViewById(R.id.taxa);
        resultado = findViewById(R.id.resultado);
    }

    public void calcular(View view){
        valor = new BigDecimal(valor_inicial.getText().toString());
        aplicacao = new BigDecimal(aplicacao_mensal.getText().toString());
        juros = new BigDecimal(taxa.getText().toString());
        tempo = Integer.parseInt(meses.getText().toString());
        for (int i = 0; i < tempo; i++){
            valor = valor.add(aplicacao);
            valor = valor.add(valor.multiply(juros));
        }
        prescisao = Integer.toString(valor.intValue()).length() + 2;
        resultado.setText(String.valueOf(valor.round(new MathContext(prescisao, RoundingMode.HALF_UP))));
    }
}