package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by guendouz on 15/02/2018.
 */

@Dao
public interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(user_data user_data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(user_data user_data);

    @Update
    void update(user_data user_data);

    @Delete
    void delete(user_data user_data);

    @Query("DELETE FROM user_data")
    void deleteUserData();

    @Query("SELECT * FROM user_data WHERE email = :email AND password = :password")
    int getUser(String email, String password);

}
