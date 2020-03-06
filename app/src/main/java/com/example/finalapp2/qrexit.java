package com.example.finalapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class qrexit extends AppCompatActivity {
    private Bitmap qRBit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        qRBit = getIntent().getParcelableExtra("bitmap");
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(qRBit);

    }
}
