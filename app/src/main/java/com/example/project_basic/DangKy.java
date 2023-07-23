package com.example.project_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_basic.DTO.Login;
import com.example.project_basic.Database.Database_Login;

public class DangKy extends AppCompatActivity {
EditText edtendky,edmkdky;
Button dn,dk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        addControl();
        addEvent();
    }

    private void addEvent() {
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTaiKhoan();
            }
        });
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextDangNhapActivity();
            }
        });
    }

    private void nextDangNhapActivity() {
        Intent intent=new Intent(DangKy.this, DangNhap.class);
        startActivity(intent);
    }

    private void addTaiKhoan(){
        String tk=edtendky.getText().toString().trim();
        String mk=edmkdky.getText().toString().trim();
        if(TextUtils.isEmpty(tk) ||TextUtils.isEmpty(mk) ){
            return;
        }
        Login login=new Login(tk,mk);
        Database_Login.getInstance(this).loginDAO().InsertTaiKhoan(login);
        Toast.makeText(this,"thành công",Toast.LENGTH_SHORT).show();
    }
    private void addControl() {
        edtendky=findViewById(R.id.edtendk);
        edmkdky=findViewById(R.id.edmkdk);
        dn=findViewById(R.id.btndn);
        dk=findViewById(R.id.btndk);
    }
}