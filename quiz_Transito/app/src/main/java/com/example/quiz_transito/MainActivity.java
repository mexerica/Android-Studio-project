package com.example.quiz_transito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn1, btn2, btn3, proximo;
    ImageView img;
    int contar = 0, estagio = 1;
    int[] respota1 = new int[]{1, 5, 7, 12, 15, 18, 21, 23, 25};
    int[] respota2 = new int[]{2, 4, 9, 11, 13, 17, 20, 22, 26};
    int[] respota3 = new int[]{3, 6, 8, 10, 14, 16, 19, 24, 27, 28};
    boolean acertou = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        proximo = (Button)findViewById(R.id.proximo);
        img = (ImageView)findViewById(R.id.img);
        proximo.setEnabled(false);
    }

    public void first(View view){
        acertou = false;
        for (int i = 0; i < respota1.length; i++) {
            if (estagio == respota1[i]){
                acertou = true;
                break;
            }
        }
        btn1.setEnabled(false);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        proximo.setEnabled(true);
    }

    public void second(View view){
        acertou = false;
        for (int i = 0; i < respota2.length; i++) {
            if (estagio == respota2[i]){
                acertou = true;
                break;
            }
        }
        btn1.setEnabled(true);
        btn2.setEnabled(false);
        btn3.setEnabled(true);
        proximo.setEnabled(true);
    }

    public void third(View view){
        acertou = false;
        for (int i = 0; i < respota3.length; i++) {
            if (estagio == respota3[i]){
                acertou = true;
                break;
            }
        }
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(false);
        proximo.setEnabled(true);
    }

    public void continuar(View view){
        if (acertou) contar++;
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        proximo.setEnabled(false);
        estagio++;
        if (estagio < 29) {
            txt.setText("Questao " + estagio + " de 28");
            this.mudarimg();
        } else if (estagio == 29) {
            txt.setText("Resultado: " + contar);
        } else{
            estagio = 1;
            contar = 0;
            txt.setText("Questao " + estagio + " de 28");
            this.mudarimg();
        }
        this.mudarbtn();
    }

    public void mudarimg(){
        if (estagio == 1) img.setImageResource(R.drawable._0km);
        else if (estagio == 2) img.setImageResource(R.drawable.aeroporto);
        else if (estagio == 3) img.setImageResource(R.drawable.obras);
        else if (estagio == 4) img.setImageResource(R.drawable.area_escolar);
        else if (estagio == 5) img.setImageResource(R.drawable.pare);
        else if (estagio == 6) img.setImageResource(R.drawable.siga_em_frente);
        else if (estagio == 7) img.setImageResource(R.drawable.alfandega);
        else if (estagio == 8) img.setImageResource(R.drawable.aultura_maxima_permitida);
        else if (estagio == 9) img.setImageResource(R.drawable.circulacao_exclusiva_bicicleta);
        else if (estagio == 10) img.setImageResource(R.drawable.de_preferencia);
        else if (estagio == 11) img.setImageResource(R.drawable.faixa_pedesre);
        else if (estagio == 12) img.setImageResource(R.drawable.largura_maxima_permitida);
        else if (estagio == 13) img.setImageResource(R.drawable.mao_dupla);
        else if (estagio == 14) img.setImageResource(R.drawable.passagem_obritoria);
        else if (estagio == 15) img.setImageResource(R.drawable.peso_bruto_total_maximo_permitido);
        else if (estagio == 16) img.setImageResource(R.drawable.pista_sinuosa_a_esquerda);
        else if (estagio == 17) img.setImageResource(R.drawable.placa_circulacao_exclusiva_de_onibus);
        else if (estagio == 18) img.setImageResource(R.drawable.placa_peso_maximo_permitido_por_eixo);
        else if (estagio == 19) img.setImageResource(R.drawable.placa_sentido_de_circulacao_na_rotatoria);
        else if (estagio == 20) img.setImageResource(R.drawable.proibido_acionar_buzina);
        else if (estagio == 21) img.setImageResource(R.drawable.proibido_estacionar);
        else if (estagio == 22) img.setImageResource(R.drawable.proibido_estacionar_parar);
        else if (estagio == 23) img.setImageResource(R.drawable.proibido_mudar_de_faixa);
        else if (estagio == 24) img.setImageResource(R.drawable.proibido_retornar_esquerda);
        else if (estagio == 25) img.setImageResource(R.drawable.proibido_transito_pedestres);
        else if (estagio == 26) img.setImageResource(R.drawable.proibido_ultrapassar);
        else if (estagio == 27) img.setImageResource(R.drawable.semaforo_a_frente);
        else img.setImageResource(R.drawable.sentido_proibido);
    }

    public void mudarbtn(){
        if (estagio == 1) {
            btn1.setText("Limite máximo de velocidade");
            btn2.setText("Áeroporto");
            btn3.setText("Obras");
        }
        else if (estagio == 4) {
            btn1.setText("pare");
            btn2.setText("Área escolar");
            btn3.setText("Siga em frente");
        }
        else if (estagio == 7) {
            btn1.setText("Alfandega");
            btn2.setText("Circulação exclusiva de bicicletas");
            btn3.setText("Altura maxima permitida");
        }
        else if (estagio == 10) {
            btn1.setText("ALargura máxima permitida");
            btn2.setText("Faixa de pedestres");
            btn3.setText("Dê preferencia");
        }
        else if (estagio == 13) {
            btn1.setText("Peso bruto total máximo permitido");
            btn2.setText("Mão dupla");
            btn3.setText("Passagem obrigatória");
        }
        else if (estagio == 16) {
            btn1.setText("Peso maximo permitido por eixo");
            btn2.setText("Circulacão exclusiva de onibus");
            btn3.setText("Pista sinuosa a esquerda");
        }
        else if (estagio == 19) {
            btn1.setText("Proibido estacionar");
            btn2.setText("Proibido acionar a busina");
            btn3.setText("Sentido de circulação na rotatória");
        }
        else if (estagio == 22) {
            btn1.setText("Proibido mudar de faixa");
            btn2.setText("Proibido estacionar e parar");
            btn3.setText("Proibido estacionar á esquerda");
        }
        else if (estagio == 25) {
            btn1.setText("Proibido transito de pedestres");
            btn2.setText("Proibido ultrapassar");
            btn3.setText("Semáforo á frente");
        }
        else if (estagio == 28) {
            btn3.setText("Sentido proibido");
        }
        else if (estagio > 28) {
            proximo.setText("Resetar");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            proximo.setEnabled(true);
        }
    }
}