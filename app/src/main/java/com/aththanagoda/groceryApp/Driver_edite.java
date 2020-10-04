package com.aththanagoda.groceryApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Driver_edite extends AppCompatActivity {

    Driver driver;
    EditText mName, mNic, mDriverID,mVehicleNo,mPhone;

    Button mUpdate;

    String name,nic,driverID, vehicleNo, phone;

    private  RoomDB database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_edite);

        final Validate validate = new Validate();

        driver = (Driver) getIntent().getSerializableExtra("driver");

        database = RoomDB.getInstance(this);


        mName = findViewById(R.id.et_up_name);
        mNic = findViewById(R.id.et_up_nic);
        mDriverID =findViewById(R.id.et_up_DriverID);
        mVehicleNo = findViewById(R.id.et_up_VehicleNo);
        mPhone = findViewById(R.id.et_up_Phone);
        mUpdate = findViewById(R.id.btnUpdate);


        mName.setText(driver.getName());
        mNic.setText(driver.getNic());
        mDriverID.setText(driver.getDriverID());
        mVehicleNo.setText(driver.getVehicleNo());
        mPhone.setText(driver.getPhone());


        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                nic= mNic.getText().toString();
                driverID = mDriverID.getText().toString();
                vehicleNo= mVehicleNo.getText().toString();
                phone=  mPhone.getText().toString();

                driver.setName(name);
                driver.setNic(nic);
                driver.setDriverID(driverID);
                driver.setVehicleNo(vehicleNo);
                driver.setPhone(phone);

                if(!name.isEmpty()&&!nic.isEmpty()&&!driverID.isEmpty()&&!vehicleNo.isEmpty()&&!phone.isEmpty()){

                    if(validate.isPhoneNumber(phone)){

                        if(validate.isNIC(nic)){

                            try {
                                database.driverDAO().updateDriver(driver);

                                Toast.makeText(Driver_edite.this,"Driver Updated",Toast.LENGTH_LONG);

                                Intent intent = new Intent(Driver_edite.this,Display_Drivers.class);
                                startActivity(intent);

                                finish();
                            }catch (Exception ex){
                                Toast.makeText(Driver_edite.this,"Driver Update failed",Toast.LENGTH_LONG);

                            }
                        }else {
                            Toast.makeText(Driver_edite.this,"NIC number not valid",Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(Driver_edite.this,"Phone number not valid",Toast.LENGTH_LONG).show();
                    }

                }




            }
        });

    }
}