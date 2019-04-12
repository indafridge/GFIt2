package com.example.gfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button Login;
    private Button Create;
    //private TextView Info;
    //private int counter =3;
    private TextView mTextMessage;
    private FirebaseAuth mAuth;

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

        email = (EditText)findViewById(R.id.etEmail);
        password = (EditText)findViewById(R.id.etPassword);
        //Info = (TextView)findViewById(R.id.tvInfo);
        mTextMessage = (TextView) findViewById(R.id.message);
        Login = (Button)findViewById(R.id.btnLogin);
        Create = (Button)findViewById(R.id.btnCreate);

        //Info.setText("No of attempts remaining: 3");

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, RegisterPage.class)  ;
                startActivity(intent);
            }
        });

      /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    } */
    private void singIn(String email, String password){
        Log.d(TAG, "signIn:" + email);
        if(!validateForm()){
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else{
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        if(!task.isSuccessful()){
                            mStatusTextView.setText("")
                        }
                    }
                });
    }

   /* public void validate(String userName, String userPassword){
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
    } */
}
