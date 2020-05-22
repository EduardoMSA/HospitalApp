package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Button buttonSignOut;

    private TextView nameTextView, idTextView;
    private GridLayout mainGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nameTextView = (TextView)findViewById(R.id.textViewName);
        idTextView = (TextView)findViewById(R.id.textViewId);
        mainGridLayout = (GridLayout)findViewById(R.id.gridLayout);
        buttonSignOut = (Button)findViewById(R.id.buttonSignOut);

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

                    if(current == 0){
                        startActivity(new Intent(MenuActivity.this, AppointmentActivity.class));
                    }
                    else if (current == 1){
                        startActivity(new Intent(MenuActivity.this, LocationActivity.class));
                    }
                    else if (current == 2){
                        startActivity(new Intent(MenuActivity.this, UrgencyActivity.class));
                    }

                }
            });

        }
    }
}
