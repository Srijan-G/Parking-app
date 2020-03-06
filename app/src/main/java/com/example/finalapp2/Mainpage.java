package com.example.finalapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Mainpage extends AppCompatActivity {
    Button bookslot;
    Button history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        bookslot=findViewById(R.id.bookslot);
        history=findViewById(R.id.viewHistory);
        bookslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Mainpage.this, MainActivity.class);
                startActivity(i);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i=new Intent(Mainpage.this, MainActivity.class);
                //startActivity(i);
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return true;
//    }

//    @Override

//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId())
//        {
//            case R.id.menuLogout:
//                FirebaseAuth.getInstance().signOut();
//                finish();
//                startActivity(new Intent(this, signIn.class));
//                break;
//        }
//        return true;
//
//    }
}
