package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    EditText edit;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.img);
        edit = (EditText)findViewById(R.id.edit);
        btn = (Button)findViewById(R.id.btn);
    }

    public void gerar(View view){
        String myText = edit.getText().toString().trim(); //getting text from input text field.
        MultiFormatWriter mWriter = new MultiFormatWriter(); //initializing MultiFormatWriter for QR code
        try {
            BitMatrix mMatrix = mWriter.encode(myText, BarcodeFormat.QR_CODE, 400,400);
            BarcodeEncoder mEncoder = new BarcodeEncoder();
            Bitmap mBitmap = mEncoder.createBitmap(mMatrix); //creating bitmap of code
            img.setImageBitmap(mBitmap); //Setting generated QR code to imageView
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }
}