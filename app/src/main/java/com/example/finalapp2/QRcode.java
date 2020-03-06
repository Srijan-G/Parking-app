package com.example.finalapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRcode extends AppCompatActivity {
    private Bitmap qRBit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        qRBit = getIntent().getParcelableExtra("bitmap");
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(qRBit);


        findViewById(R.id.bt_qrexit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap QRBit = printQRCode(MainActivity.id+"*");
                Intent i = new Intent(QRcode.this, qrexit.class);
                i.putExtra("bitmap", QRBit);
                startActivity(i);
            }
        });
    }

        public Bitmap printQRCode(String textToQR){
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(textToQR, BarcodeFormat.QR_CODE, 300, 300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                return bitmap;
            } catch (WriterException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

