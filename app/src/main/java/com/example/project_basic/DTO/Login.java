package com.example.project_basic.DTO;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "taikhoan")
public class Login {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tendangnhap,matkhau;

    public Login(String tendangnhap, String matkhau) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
