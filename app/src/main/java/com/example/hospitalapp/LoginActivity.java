package com.example.hospitalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;


import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class LoginActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(String id, String name){
        Intent menu = new Intent(this, MenuActivity.class);
        menu.putExtra("ID",id);
        menu.putExtra("Name",name);
        startActivity(menu);
    }

    public void scan(View view){

        if(ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {
            // Permission is not granted
            Toast.makeText(this,"Give Camera Permissions to Continue", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.CAMERA }, 101);

            return;

        }

        myScannerView = new ZXingScannerView(this);
        setContentView(myScannerView);
        myScannerView.setResultHandler(this);
        myScannerView.startCamera();

    }


    @Override
    public void handleResult(Result result) {
        Log.e("HandleResult",result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultados");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        String[] data = result.getText().split("/");

        this.login(data[0], data[1]);



    }
}
