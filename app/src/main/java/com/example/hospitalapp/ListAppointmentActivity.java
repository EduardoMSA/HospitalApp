package com.example.hospitalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListAppointmentActivity extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerAdapter rAdapter;
    private DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appointment);
        List<AppointmentObj> list = getAppointments();
        rAdapter = new RecyclerAdapter(list,this);
        rView = findViewById(R.id.recycler_appointment);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(rAdapter);
    }

    public List<AppointmentObj> getAppointments(){

        mRootReference = FirebaseDatabase.getInstance().getReference();
        final List<AppointmentObj> appointments = new ArrayList<AppointmentObj>();

        mRootReference.child("Appointments").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    AppointmentObj obj = snapshot.getValue(AppointmentObj.class);
                    appointments.add(obj);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return appointments;

    }
}
