package com.example.gfit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class RegisterPage extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private EditText mEmail,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mAuth = FirebaseAuth.getInstance();
        mEmail = (EditText)findViewById(R.id.etEmail);
        mPass = (EditText)findViewById(R.id.etPass);
    }
    private void createAccount(String email, String password) {
        Log.d(TAG, "CreateAccount:" + email);
        if(!validateForm()){
            return;
        }
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.v(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]
    }
    private boolean validateForm(){
        boolean valid = true;

        String email = mEmail.getText().toString();
        if (TextUtils.isEmpty(email)){
            mEmail.setError("Required.");
            valid = false;
        }
        else {
            mEmail.setError(null);
        }

        String password = mPass.getText().toString();
        if (TextUtils.isEmpty(password)){
            mPass.setError("Required.");
            valid = false;
        }
        else {
            mPass.setError(null);
        }
        return valid;

    }
    public void ClickSign(View view){
        createAccount(mEmail.getText().toString(),mPass.getText().toString());
    }
}
