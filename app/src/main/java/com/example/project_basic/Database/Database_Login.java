package com.example.project_basic.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project_basic.DTO.Login;

@Database(entities = {Login.class},version = 1)
public abstract class Database_Login extends RoomDatabase {
    private static final String DATABAESE_NAME="taikhoan.db";
    private static Database_Login ins;
   public static synchronized Database_Login getInstance(Context context){
       if(ins==null){
           ins= Room.databaseBuilder(context.getApplicationContext(),Database_Login.class,DATABAESE_NAME)
                   .allowMainThreadQueries().build();
       }
       return ins;
   }
   public  abstract LoginDAO loginDAO();

}
