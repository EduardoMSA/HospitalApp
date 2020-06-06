package com.example.hospitalapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.util.HashMap;
import java.util.Map;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class AddAppointmentActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private EditText problem;
    private DatabaseReference mRootReference;
    private UserObj user;
    private ZXingScannerView myScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        this.mRootReference = FirebaseDatabase.getInstance().getReference();
        this.user = (UserObj) getIntent().getSerializableExtra("User");

        this.problem = findViewById(R.id.editTextProblem);

    }

    public void addAppointment(String id, String name, String age, String gender, String allergies) {
        Map<String,Object> data = new HashMap<>();
        data.put("Name",name);
        data.put("ID",id);
        data.put("Gender",gender);
        data.put("Allergies",allergies);
        data.put("Problem",problem.getText().toString());
        data.put("Age", age);

        mRootReference.child("Appointments").push().setValue(data);

        Toast.makeText(this,"Appointment Added", Toast.LENGTH_LONG).show();

        myScannerView.stopCamera();

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
        builder.setTitle("Patient");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        String[] data = result.getText().split("/");

        this.addAppointment(data[0],data[1],data[2],data[3],data[4]);


    }
}
