package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    Button callLogin;
    TextInputLayout regName,regUsername,regPassword,regEmail,regNumber;
    Button regbtn,regtologinbtn;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        callLogin=findViewById(R.id.login_screen);
        regName=findViewById(R.id.name);
        regUsername=findViewById(R.id.username);
        regPassword=findViewById(R.id.password);

        regEmail=findViewById(R.id.email);
        regNumber=findViewById(R.id.phone);
        regbtn=findViewById(R.id.login_btn);
        regtologinbtn=findViewById(R.id.login_screen);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("users");

                String name= regName.getEditText().getText().toString();
                String username= regUsername.getEditText().getText().toString();
                String email= regEmail.getEditText().getText().toString();
                String password= regPassword.getEditText().getText().toString();
                String phone= regNumber.getEditText().getText().toString();
                Helperclass helperclass=new Helperclass(name ,username,email,password,phone);

                reference .child(phone).setValue("first data storage");
            }
        });



        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
    }
}