package com.example.ligabola;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login",MODE_PRIVATE);
        txtusername = findViewById(R.id.et1);
        txtpassword = findViewById(R.id.et2);
        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtusername.getText().toString().equalsIgnoreCase("dhea")
                        && txtpassword.getText().toString().equalsIgnoreCase("sabilla")){
                    //saving ke SP
                    editor = pref.edit();
                    editor.putString("username", txtusername.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    //menuju ke main menu
                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }
            }
        });
    }
}