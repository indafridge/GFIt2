/* package com.example.gfit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String UserId;
    private EditText Name;
    private EditText Password;
    private EditText RePassword;
    private EditText Email;
    private Button Account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page1);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        RePassword = (EditText)findViewById(R.id.etRePassword);
        Email = (EditText)findViewById(R.id.etEmail);
        Account = (Button)findViewById(R.id.btnAccount);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("DataUsers");
        UserId = mFirebaseDatabase.push().getKey();
    }

    public void addUser(String username, String password, String repassword, String email){
        User users = new User(username, password, repassword, email);
        mFirebaseDatabase.child("Users").child(UserId).setValue(users);
    }
    public void updateUser(String username, String password, String repassword, String email){
        mFirebaseDatabase.child("Users").child(UserId).child("username").setValue(username);
        mFirebaseDatabase.child("Users").child(UserId).child("password").setValue(password);
        mFirebaseDatabase.child("Users").child(UserId).child("repassword").setValue(repassword);
        mFirebaseDatabase.child("Users").child(UserId).child("email").setValue(email);
    }

    public void insertData(View view){
        addUser(Name.getText().toString().trim(),Password.getText().toString().trim(),RePassword.getText().toString().trim(),Email.getText().toString().trim());

        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this);

        builder.setTitle("Alert");
        builder.setMessage("You have registered");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(RegisterPage.this, MainActivity.class)  ;
                startActivity(intent);
            }
        });
        builder.show();
    }
}
*/