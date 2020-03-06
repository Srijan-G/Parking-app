package com.example.finalapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class NearLocations extends AppCompatActivity {

    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_locations);
        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        final MainActivity mainActivity=new MainActivity();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap QRBit = printQRCode(MainActivity.id);
                Intent i=new Intent(NearLocations.this, QRcode.class);
                i.putExtra("bitmap", QRBit);
                startActivity(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap QRBit = printQRCode(MainActivity.id);
                Intent i=new Intent(NearLocations.this, QRcode.class);
                i.putExtra("bitmap", QRBit);
                startActivity(i);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap QRBit = printQRCode(MainActivity.id);
                Intent i=new Intent(NearLocations.this, QRcode.class);
                i.putExtra("bitmap", QRBit);
                startActivity(i);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap QRBit = printQRCode(MainActivity.id);
                Intent i=new Intent(NearLocations.this, QRcode.class);
                i.putExtra("bitmap", QRBit);
                startActivity(i);
            }
        });

    }


    private Bitmap printQRCode(String textToQR){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(textToQR, BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
