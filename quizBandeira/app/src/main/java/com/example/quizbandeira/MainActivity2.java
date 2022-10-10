package com.example.quizbandeira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    RadioButton rb1, rb2, rb3, rb4,radioGroup;
    ImageView img;
    Integer State = 0;
    String Nome;
    public int Count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnResponder = (Button)findViewById(R.id.btnResponder);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        img = (ImageView) findViewById(R.id.bandeira);
        btnResponder.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btnResponder.setEnabled(true);
            }
        });
    }

    public void Responder(View view){
        if (State == 0) {
            if(rb1.isChecked()) Count++;
            img.setImageResource(R.drawable.brasil);
        }
        else if (State == 1) {
            if(rb2.isChecked()) Count++;
            img.setImageResource(R.drawable.cuba);
        }
        else if (State == 2) {
            if(rb3.isChecked()) Count++;
            img.setImageResource(R.drawable.italia);
        }
        else if (State == 3) {
            rb1.setText("bulgaria");
            rb2.setText("canadá");
            rb3.setText("china");
            rb4.setText("coréia do sul");
            if(rb4.isChecked()) Count++;
            img.setImageResource(R.drawable.bulgaria);
        }
        else if (State == 4) {
            if(rb1.isChecked()) Count++;
            img.setImageResource(R.drawable.canada);
        }
        else if (State == 5) {
            if(rb2.isChecked()) Count++;
            img.setImageResource(R.drawable.china);
        }
        else if (State == 6) {
            if(rb3.isChecked()) Count++;
            img.setImageResource(R.drawable.coreia_sul);
        }
        else if (State == 7) {
            rb1.setText("guatemala");
            rb2.setText("hungria");
            rb3.setText("restaurante");
            rb4.setText("usa");
            if(rb4.isChecked()) Count++;
            img.setImageResource(R.drawable.guatemala);
        }
        else if (State == 8) {
            if(rb1.isChecked()) Count++;
            img.setImageResource(R.drawable.hungria);
        }
        else if (State == 9) {
            if(rb2.isChecked()) Count++;
            img.setImageResource(R.drawable.restaurante);
        }
        else {
            if(rb3.isChecked()) Count++;
            Intent it = new Intent(getApplicationContext(), MainActivity3.class);
            it.putExtra("Acertos", Count);
            startActivity(it);
            finish();
        }
        State++;
    }
}