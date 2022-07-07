package com.example.homie_.Activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.homie_.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    TextView back_txt;
    private Button signup_btn;
    private EditText editUser, editEmail, editPass, editPass2;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.signup_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        signup_btn = (Button) findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(this);

//        editUser = (EditText) findViewById(R.id.user);
//        editEmail= (EditText) findViewById(R.id.email);
//        editPass = (EditText) findViewById(R.id.pass);
//        editPass2 = (EditText) findViewById(R.id.pass2);
//
//        progressBar = findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.signup_btn:
                Signup();
                break;
            case R.id.back_txt:
                Back();
                break;
        }
    }
    public  void Back(){
        Intent iBack = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(iBack);
    }

    private void Signup(){

        String email = editEmail.getText().toString().trim();
        String password = editPass.getText().toString().trim();
        String pass2 = editPass2.getText().toString().trim();
        String username = editUser.getText().toString().trim();

        //check validate username
        if (username.isEmpty()){
            editUser.setError("User name is required!");
            editUser.requestFocus();
            return;
        }
        //check validate Email
        if (email.isEmpty()){
            editEmail.setError("Email is required!");
            editEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please provide valid email");
            editEmail.requestFocus();
            return;
        }
        //check validate pass
        if (password.isEmpty()){
            editPass.setError("Password is required!");
            editPass.requestFocus();
            return;
        }
        if (password.length()< 6){
            editPass.setError("Password is too short. Password must be longer than 6 characters");
            editPass.requestFocus();
            return;
        }
        if (pass2.isEmpty()){
            editPass2.setError("Confirm password is required!");
            editPass2.requestFocus();
            return;
        }
        if (!pass2.equals(password)){
            editPass2.setError("Incorrect");
            editPass2.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            User user = new User(username,email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .push().setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignupActivity.this, "User has been registered successfully!",Toast.LENGTH_LONG).show();
                                        //redirect to login layout
                                    }else {
                                        Toast.makeText(SignupActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                    }
                                    progressBar.setVisibility(View.GONE);

                                }

                            });

                        }else {
                            Toast.makeText(SignupActivity.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
    }
}

