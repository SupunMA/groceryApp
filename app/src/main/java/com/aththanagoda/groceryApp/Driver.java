package com.aththanagoda.groceryApp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Driver")
public class Driver implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ID;
@ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "nic")
    private String nic;
    @ColumnInfo(name = "DriverID")
    private String DriverID;
    @ColumnInfo(name = "VehicleNo")
    private String VehicleNo;
    @ColumnInfo(name = "Phone")
    private String Phone;
    @ColumnInfo(name = "Password")
    private String Password;

    public Driver(String name, String nic, String driverID, String vehicleNo, String phone, String password) {
        this.name = name;
        this.nic = nic;
        DriverID = driverID;
        VehicleNo = vehicleNo;
        Phone = phone;
        Password = password;
    }

    public Driver() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        VehicleNo = vehicleNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
