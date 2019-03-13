package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username_txt,password_txt;

    UserDataDao userDataDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_txt = findViewById(R.id.username_txt);

        password_txt = findViewById(R.id.password_txt);

        userDataDao = AppDatabase.getInstance(this).userDataDao();
    }

    public void Login(View view)
    {
        if (username_txt.getText().toString().length()<3){ Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show(); }

        else if (password_txt.getText().toString().length()<3){Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();}

        else
            {

                if (userDataDao.getUser(username_txt.getText().toString(),password_txt.getText().toString())>0)
                {
                    startActivity(new Intent(this,DashActivity.class));
                }
                else
                {
                    Toast.makeText(this, "User Not Exists", Toast.LENGTH_SHORT).show();
                }
            }
    }

    public void Register(View view)
    {
        startActivity(new Intent(this,SignUpActivity.class));
    }
}
