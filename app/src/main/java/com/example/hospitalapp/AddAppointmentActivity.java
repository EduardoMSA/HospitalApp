package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class AddAppointmentActivity extends AppCompatActivity {

    private EditText name, id, age, gender, allergies, problem;
    private DatabaseReference mRootReference;
    private UserObj user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        this.mRootReference = FirebaseDatabase.getInstance().getReference();
        this.user = (UserObj) getIntent().getSerializableExtra("User");

        this.gender = findViewById(R.id.editTextGender);
        this.allergies = findViewById(R.id.editTextAllergies);
        this.problem = findViewById(R.id.editTextProblem);
        this.name = findViewById(R.id.editTextName);
        this.age = findViewById(R.id.editTextAge);
        this.id = findViewById(R.id.editTextID);

    }

    public void addAppointment(View view) {
        Map<String,Object> data = new HashMap<>();
        data.put("Name",name.getText().toString());
        data.put("ID",id.getText().toString());
        data.put("Gender",gender.getText().toString());
        data.put("Allergies",allergies.getText().toString());
        data.put("Problem",problem.getText().toString());
        data.put("Age", age.getText().toString());

        mRootReference.child("Appointments").push().setValue(data);
    }
}
