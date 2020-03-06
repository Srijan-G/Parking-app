package com.example.finalapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Button btpicker;
    Button btproceed;
    TextView textView;
    int PLACE_PICKER_REQUEST = 1;
    //MapView mapView;
   // GoogleMap gmap;
    EditText editTextName;
    EditText editTextPhone;
    EditText editTextStartTime;
    EditText editTextEndTime;
    DatabaseReference databaseMembers = FirebaseDatabase.getInstance().getReference();
    public static String name;
    public static String phone;
    public static String start_time;
    public static String end_time;
    public static String id;
    public static String date;
    Button date_picker_from;
    Calendar calendar;
    int day,month,year;
    DatePickerDialog.OnDateSetListener mDateSetListener_from;
    EditText editTextDate;

    // String MAP_VIEW_BUNDLE_KEY="MapViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btpicker = findViewById(R.id.bt_picker);
        //textView = findViewById(R.id.text_view);
        btproceed =findViewById(R.id.proceed_bt);
        editTextName = (EditText) findViewById(R.id.Name);
        editTextPhone = (EditText) findViewById(R.id.Phone);
        editTextStartTime = (EditText) findViewById(R.id.Starting_Time);
        editTextEndTime = (EditText) findViewById(R.id.End_Time);
        date_picker_from=findViewById(R.id.btn_date_picker_from);
        editTextDate=findViewById(R.id.edt_from);

        date_picker_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar= Calendar.getInstance();
                day=calendar.get(Calendar.DAY_OF_MONTH);
                month=calendar.get(Calendar.MONTH);
                year=calendar.get(Calendar.YEAR);
                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this,mDateSetListener_from,year,month,day);
                dialog.show();
            }
        });
        mDateSetListener_from=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int jyear, int jmonth, int jdayOfMonth) {
                String date=jdayOfMonth+"-"+(jmonth+1)+"-"+jyear;
                editTextDate.setText(date);

            }
        };


        //mapView=findViewById(R.id.map_view);
        //mapView.getMapAsync((OnMapReadyCallback) this);

        btpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(MainActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

       btproceed =findViewById(R.id.proceed_bt);

        btproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMember();
               // Bitmap QRBit = printQRCode(editTextPhone.getText().toString());
                Intent i=new Intent(MainActivity.this, NearLocations.class);
                i.putExtra("phone", editTextPhone.getText().toString());
                startActivity(i);
            }
        });



    }

    private void addMember() {
         name = editTextName.getText().toString().trim();
        phone = editTextPhone.getText().toString().trim();
        start_time = editTextStartTime.toString().trim();
        end_time = editTextEndTime.getText().toString().trim();
        date=editTextDate.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {
            id = databaseMembers.push().getKey();
            //Members members;
             users user = new users(id, name, phone,start_time,end_time,date,false);
            databaseMembers.child(id).setValue(user);
            databaseMembers.child(id).child("start_time").setValue(start_time);
            Toast.makeText(this, "Details Added"+start_time, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Add a name first", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode,null);

        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                StringBuilder stringBuilder = new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().longitude);
                String longitude = String.valueOf(place.getLatLng().latitude);
                stringBuilder.append("LATITUDE:");
                stringBuilder.append(latitude);
                stringBuilder.append("\nLONGITUDE");
                stringBuilder.append(longitude);
                textView.setText(stringBuilder.toString());
            }


        }
    }





}
