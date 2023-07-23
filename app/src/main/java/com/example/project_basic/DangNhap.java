package com.example.project_basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_basic.DTO.Login;
import com.example.project_basic.Database.Database_Login;

import java.util.List;

public class DangNhap extends AppCompatActivity {
EditText edten,edmk;
Button btnky,btnnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        addControl();
        Event();
    }

    private void Event() {
       btnnhap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               nextMainActivity();
           }
       });
       btnky.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               nextdangkyActivity();
           }
       });
    }

    private void nextdangkyActivity() {
        Intent intent=new Intent(DangNhap.this, DangKy.class);
        startActivity(intent);
    }

    private void nextMainActivity() {
        String ten=edten.getText().toString().trim();
        String mk=edmk.getText().toString().trim();
        Login login=new Login(ten,mk);
        if(check(login)){
            Intent intent=new Intent(DangNhap.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"tài khoản mật khẩu k chính xác or k tồn tại",Toast.LENGTH_SHORT).show();
        }

    }
private boolean check(Login login){
    List<Login>list=Database_Login.getInstance(this).loginDAO().checklogin(login.getTendangnhap(),login.getMatkhau());
    return  list!=null && !list.isEmpty();
}

    private void addControl() {
        edten=findViewById(R.id.edtendn);
        edmk=findViewById(R.id.edmkdn);
        btnnhap=findViewById(R.id.btnnhap);
        btnky=findViewById(R.id.btnky);

    }
}