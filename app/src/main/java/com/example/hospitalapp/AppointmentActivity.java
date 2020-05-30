package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppointmentActivity extends AppCompatActivity {

    private UserObj user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        this.user = (UserObj) getIntent().getSerializableExtra("User");
    }

    public void addNew(View view){
        Intent intent = new Intent(this, AddAppointmentActivity.class);
        intent.putExtra("User",user);
        startActivity(intent);
    }

    public void viewList(View view){
        Intent intent =  new Intent(this, ListAppointmentActivity.class);
        intent.putExtra("User",user);
        startActivity(intent);
    }
}
