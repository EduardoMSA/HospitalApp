package com.example.hospitalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText editId;
    //private String id ="", password="";
    private FirebaseAuth mAuth;
    private String TAG = "LOGIN";
    private DatabaseReference mRootReference;
    private ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = (EditText)findViewById(R.id.idEditText);
        mAuth = FirebaseAuth.getInstance();

        mRootReference = FirebaseDatabase.getInstance().getReference();
        users = new ArrayList<String>();

        mRootReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    UserObj user = snapshot.getValue(UserObj.class);
                    users.add(user.getID());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void login(View view){
        if(users.contains(editId.getText().toString())){
            Intent menu = new Intent(this, MenuActivity.class);
            menu.putExtra("ID",editId.getText().toString());
            startActivity(menu);
        } else {
            Toast.makeText(this,"ID not found",Toast.LENGTH_LONG).show();
        }
    }
}
