package com.aththanagoda.groceryApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class Display_Drivers extends AppCompatActivity {

    List<Driver> driverList;

    private RoomDB database;
    private RecyclerView mDriverList;
private DriverAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__drivers);

        mDriverList = findViewById(R.id.rcvDriverList);

        database = RoomDB.getInstance(this);
        driverList= database.driverDAO().getDriverList();

        Log.d("DRIVERLIST",driverList.toString());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mDriverList.setLayoutManager(linearLayoutManager);

        adapter = new DriverAdapter(driverList,Display_Drivers.this);

        mDriverList.setAdapter(adapter);




    }
}