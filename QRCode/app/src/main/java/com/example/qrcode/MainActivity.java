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
    Button btnGerar,btnMudar;
    String barcode = "QR Code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.img);
        edit = (EditText)findViewById(R.id.edit);
        btnGerar = (Button)findViewById(R.id.btn1);
        btnMudar = (Button)findViewById(R.id.btn2);
    }

    public void gerar(View view){
        String myText = edit.getText().toString().trim(); //getting text from input text field.
        if (myText.equals(""))  myText = "Please write something."; //writing a warning to empty input
        if (barcode.equals("Barcode") && !myText.matches("[0-9]+")) myText ="11111111"; //checking if the barcode is a number
        if (barcode.equals("QR Code") && myText.contains("Wiki")) { //link to wikipedia
            myText = myText.replace("Wiki ", "");
            myText = "https://pt.wikipedia.org/wiki/" + myText;
        }
        MultiFormatWriter mWriter = new MultiFormatWriter(); //initializing MultiFormatWriter for QR code
        try {
            BarcodeEncoder mEncoder = new BarcodeEncoder();
            BitMatrix mMatrix = mWriter.encode(myText, escolher(), 400,400);
            Bitmap mBitmap = mEncoder.createBitmap(mMatrix); //creating bitmap of code
            img.setImageBitmap(mBitmap); //Setting generated QR code to imageView
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public BarcodeFormat escolher(){
        switch (barcode) {
            case "QR Code" : return BarcodeFormat.QR_CODE;
            case "Barcode" : return BarcodeFormat.CODABAR;
            case "Data Matrix" : return BarcodeFormat.DATA_MATRIX;
            case "PDF 417" : return BarcodeFormat.PDF_417;
            default : return BarcodeFormat.AZTEC;
            //default : return BarcodeFormat.MAXICODE;
        }
    }

    public void mudar(View view){
        if (barcode.equals("QR Code")) barcode = "Barcode";
        else if (barcode.equals("Barcode")) barcode = "Data Matrix";
        else if (barcode.equals("Data Matrix")) barcode = "PDF 417";
        else if (barcode.equals("PDF 417")) barcode = "Aztec";
        else if (barcode.equals("Aztec")) barcode = "MaxiCode";
        else barcode = "QR Code";
        btnMudar.setText(barcode);
    }
}