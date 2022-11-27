package net.smallacademy.qrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText qrvalue;
    Button generateBtn, scanBtn, choiceBtn, zapBtn;
    ImageView qrImage;
    String barcode = "QR Code";
    File imgQR = null;
    Bitmap mBitmap;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrvalue = findViewById(R.id.qrInput);
        generateBtn = findViewById(R.id.generateBtn);
        scanBtn = findViewById(R.id.scanBtn);
        choiceBtn = findViewById(R.id.choiceBtn);
        qrImage = findViewById(R.id.qrPlaceHolder);
        zapBtn = findViewById(R.id.zapBtn);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = qrvalue.getText().toString().trim();//getting text from input text field.
                if (data.isEmpty() || barcode.equals("Barcode") && !data.matches("[0-9]+")) {
                    qrvalue.setError("Value Required.");//writing a warning
                } else {
                    if (barcode.equals("QR Code") && data.contains("Wiki")) { //link to wikipedia
                        data = data.replace("Wiki ", "");
                        data = "https://pt.wikipedia.org/wiki/" + data;
                    } else if (data.equals("My location")) {
                        Location location = getLocation();
                        if (location != null) data = "Maps " + location.getLatitude() + " " + location.getLongitude();
                    }
                    MultiFormatWriter mWriter = new MultiFormatWriter();
                    try {
                        BarcodeEncoder mEncoder = new BarcodeEncoder();
                        BitMatrix mMatrix = mWriter.encode(data, escolher(), 400, 400);
                        mBitmap = mEncoder.createBitmap(mMatrix); //creating bitmap of code
                        qrImage.setImageBitmap(mBitmap); //Setting generated QR code to imageView
                        zapBtn.setEnabled(true);
                        zapBtn.setBackgroundColor(Color.GREEN);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        choiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barcode.equals("QR Code")) barcode = "Barcode";
                else if (barcode.equals("Barcode")) barcode = "Data Matrix";
                else if (barcode.equals("Data Matrix")) barcode = "PDF 417";
                else if (barcode.equals("PDF 417")) barcode = "Aztec";
                else barcode = "QR Code";
                choiceBtn.setText(barcode);
            }
        });

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Scanner.class));
            }
        });

        zapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent();
                imgQR = createFile();
                OutputStream outStream = null;
                try {
                    String pathofBmp = MediaStore.Images.Media.insertImage(getContentResolver(), mBitmap, "title", null);
                    Uri uri = Uri.parse(pathofBmp);
                    Intent.setAction(Intent.ACTION_SEND);
                    Intent.putExtra(Intent.EXTRA_STREAM, uri);
                    Intent.setType("image/*");
                    Intent shareIntent = Intent.createChooser(Intent, null);
                    startActivity(shareIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BarcodeFormat escolher() {
        switch (barcode) {
            case "QR Code":
                return BarcodeFormat.QR_CODE;
            case "Barcode":
                return BarcodeFormat.CODABAR;
            case "Data Matrix":
                return BarcodeFormat.DATA_MATRIX;
            case "PDF 417":
                return BarcodeFormat.PDF_417;
            default:
                return BarcodeFormat.AZTEC;
        }
    }

    private File createFile() {
        File checKFile = new File(Environment.getExternalStorageDirectory() + "/imgQR/");
        if (checKFile.exists()) checKFile.mkdirs();
        Date currentTime = Calendar.getInstance().getTime();
        File file = new File(Environment.getExternalStorageDirectory() + "/imgQR/" + "QR-" + currentTime + ".jpg");
        return file;
    }

    private void sendFile() {
        Uri imageUri = Uri.parse(imgQR.getAbsolutePath());
        zapBtn.setBackgroundColor(Color.RED);
    }

    private Location getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            zapBtn.setBackgroundColor(Color.RED);
            return null;
        }
        return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }
}
