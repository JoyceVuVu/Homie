package com.example.homie_.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homie_.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    private Button btnSignin;
    private TextView txtReset, txtSignup;
    private EditText editEmail, editPass;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);

//        btnSignin = (Button) findViewById(R.id.btnSignin);
//        txtSignup = (TextView) findViewById(R.id.txtSignup);
//        txtReset = (TextView) findViewById(R.id.resetpass);
//        editEmail = (EditText) findViewById(R.id.login_email);
       // editPass = (EditText) findViewById(R.id.login_pass);

//        btnSignin.setOnClickListener(this);
//        txtSignup.setOnClickListener(this);
//        txtReset.setOnClickListener(this);
//
//        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
//        mAuth = FirebaseAuth.getInstance();


    }
//    private void BtnSignin(){
//        String Email = editEmail.getText().toString().trim();
//        String Password = editPass.getText().toString().trim();
//
//        if (Email.isEmpty()){
//            editEmail.setError("Email is required!");
//            editEmail.requestFocus();
//            return;
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
//            editEmail.setError("Please enter a valid email");
//            editEmail.requestFocus();
//            return;
//        }
//        if (Password.isEmpty()){
//            editPass.setError("Password is required!");
//            editPass.requestFocus();
//            return;
//        }
//        if (Password.length()<6){
//            editPass.setError("Min password length is 6 characters!");
//            editPass.requestFocus();
//            return;
//        }
//        progressBar.setVisibility(View.VISIBLE);
//        mAuth.signInWithEmailAndPassword(Email, Password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                            progressBar.setVisibility(View.GONE);
//                        }else {
//                            Toast.makeText(LoginActivity.this,"Email or Password is incorrect. Login failed!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

//    }
//    private void Signup(){
//        Intent iSignup = new Intent(LoginActivity.this, SignupActivity.class);
//        startActivity(iSignup);
//    }
//    private void ResetPass(){
//        Intent iReset = new Intent(LoginActivity.this, ResetPassActivity.class);
//        startActivity(iReset);
//    }
//
//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.btnSignin:
//                BtnSignin();
//                break;
//            case R.id.txtSignup:
//                Signup();
//                break;
//            case R.id.resetpass:
//                ResetPass();
//                break;
//        }
//    }
}
