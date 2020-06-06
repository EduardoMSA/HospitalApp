package com.example.hospitalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private Button buttonSignOut;
    private DatabaseReference mRootReference;
    private TextView nameTextView, idTextView;
    private GridLayout mainGridLayout;
    private UserObj user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nameTextView = (TextView)findViewById(R.id.textViewName);
        idTextView = (TextView)findViewById(R.id.textViewId);
        mainGridLayout = (GridLayout)findViewById(R.id.gridLayout);
        buttonSignOut = (Button)findViewById(R.id.buttonSignOut);
        user = new UserObj();

//        mRootReference = FirebaseDatabase.getInstance().getReference();
//
//        mRootReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    UserObj userTmp = snapshot.getValue(UserObj.class);
//                    if(userTmp.getID().equals(getIntent().getStringExtra("ID"))){
//                        user = userTmp;
//                        idTextView.setText(user.getID());
//                        nameTextView.setText(user.getName());
//                        break;
//                    }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        idTextView.setText(getIntent().getStringExtra("ID"));
        user.setID(getIntent().getStringExtra("ID"));
        nameTextView.setText(getIntent().getStringExtra("Name"));
        user.setID(getIntent().getStringExtra("Name"));



        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //auth.signOut();
                startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                finish();
            }
        });
        setSingleEvent(mainGridLayout);
    }

    private void setSingleEvent(GridLayout gl){
        for(int i=0; i<gl.getChildCount(); i++){

            CardView cardView = (CardView) gl.getChildAt(i);
            final int current = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent;

                    if(current == 0){
                        intent = new Intent(MenuActivity.this, AppointmentActivity.class);
                        intent.putExtra("User",user);
                        startActivity(intent);
                    }
                    else if (current == 1){
                        intent = new Intent(MenuActivity.this, LocationActivity.class);
                        intent.putExtra("User",user);
                        startActivity(intent);
//                        Toast.makeText(MenuActivity.this,"Location not available currently", Toast.LENGTH_LONG).show();
                    }
                    else if (current == 2){
                        intent = new Intent(MenuActivity.this, UrgencyActivity.class);
                        intent.putExtra("User",user);
                        startActivity(intent);
                    }


                }
            });

        }
    }
}
