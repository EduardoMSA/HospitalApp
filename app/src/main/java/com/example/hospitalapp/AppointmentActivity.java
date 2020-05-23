package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
    }

    public void addNew(View view){
        startActivity(new Intent(this, AddAppointmentActivity.class));
    }

    public void viewList(View view){
        startActivity(new Intent(this, ListAppointmentActivity.class));
    }
}
