package com.example.homie_.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homie_.R;

public class ResetPassActivity extends AppCompatActivity implements View.OnClickListener {

    TextView back_txt;
    EditText phone, pass, pass2;
    Button reset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        reset = (Button) this.findViewById(R.id.resetBtn);
        back_txt = (TextView) this.findViewById(R.id.reset_backTxt);

        reset.setOnClickListener(this);
        back_txt.setOnClickListener(this);
    }

    public void Back() {
        Intent iBack = new Intent(ResetPassActivity.this, LoginActivity.class);
        startActivity(iBack);
    }

    public void ResetPass() {
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.resetBtn:
                break;
            case R.id.reset_backTxt:
                Back();
                break;
        }
    }
}
