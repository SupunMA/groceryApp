package com.aththanagoda.groceryApp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DriverDAO {

    @Query("Select * from Driver")
    List<Driver> getDriverList();

    @Insert(onConflict = REPLACE)
    void insertDriver(Driver driver);
    @Update
    void updateDriver(Driver driver);
    @Delete
    void  deleteDriver(Driver driver);
}
