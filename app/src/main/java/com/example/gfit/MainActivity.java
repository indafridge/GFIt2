package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Create;
    private int counter =3;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        mTextMessage = (TextView) findViewById(R.id.message);
        Login = (Button)findViewById(R.id.btnLogin);
        Create = (Button)findViewById(R.id.btnCreate);

        Info.setText("No of attempts remaining: 3");

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, RegisterPage2.class)  ;
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }
    public void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
        else{
            counter--;

            Info.setText("No of attempts remaining: " +String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
