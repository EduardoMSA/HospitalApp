package com.example.hospitalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editId, editPassword;
    private Button buttonLoginIn;
    private String id ="", password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = (EditText)findViewById(R.id.idEditText);
        editPassword = (EditText)findViewById(R.id.passwordEditText);
        buttonLoginIn = (Button)findViewById(R.id.loginInButton);

        buttonLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = editId.getText().toString();
                password = editPassword.getText().toString();
                if(!id.isEmpty() && !password.isEmpty()){
                    if(password.length()>=6){
                        loginUser();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this, "Debes completar los campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginUser(){
        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
        finish();

    }
}
