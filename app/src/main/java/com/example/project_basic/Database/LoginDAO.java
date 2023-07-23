package com.example.project_basic.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project_basic.DTO.Login;

import java.util.List;

@Dao
public interface LoginDAO {

    @Insert
    void InsertTaiKhoan(Login login);

    @Query("select *from taikhoan")
    List<Login>getlistlogin();
}
