package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UrgencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgency);
    }

    public void dial(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "911"));// Initiates the Intent
        startActivity(intent);
    }
}
