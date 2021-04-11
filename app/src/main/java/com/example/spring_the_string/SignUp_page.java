package com.example.spring_the_string;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp_page extends AppCompatActivity {


    Button signup;
    public void init() {
        signup = (Button) findViewById(R.id.sgnup_But);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent chai = new Intent(SignUp_page.this, Categories_list.class);
                startActivity(chai);


            }
        });

    }





            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_sign_up_page);
                init();



            }



}



