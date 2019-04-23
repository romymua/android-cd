package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    UserDataDao userDataDao;

    EditText name_txt,dob_txt,phone_txt,email_txt,password_txt,conf_password_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up); /* Consider limitting spacing after each line of code/s */

        name_txt = findViewById(R.id.name_txt); /* Consider following standard naming convention for component (ex. for EditText: etUserame, etPassword) */

        dob_txt = findViewById(R.id.dob_txt);

        phone_txt = findViewById(R.id.phone_txt);

        email_txt = findViewById(R.id.email_txt);

        password_txt = findViewById(R.id.password_txt);

        conf_password_txt = findViewById(R.id.conf_password_txt);

        userDataDao = AppDatabase.getInstance(this).userDataDao();
    }

    public void Register(View view)
    {
        if (name_txt.getText().length()>0 && dob_txt.getText().length()>0 && phone_txt.getText().length()>0 && email_txt.getText().length()>0 && password_txt.getText().length()>0 )
        {
            if (password_txt.getText().toString().equals(conf_password_txt.getText().toString())) {
                userDataDao.save(new user_data(name_txt.getText().toString(), email_txt.getText().toString(), phone_txt.getText().toString(), dob_txt.getText().toString(), password_txt.getText().toString()));

                startActivity(new Intent(this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
            else
            {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}
