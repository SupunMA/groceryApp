package com.aththanagoda.groceryApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mName, mNIC, mDriverID, mVehicleNo, mPhone, mPassword, mConfirmPassword;

    private Button mRegister;
    String name, nic,driverID,vehicleNo,phone,passeword,confirmpassword;

    RoomDB database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Validate validate = new Validate();



        mName = findViewById(R.id.etxtname);
        mNIC = findViewById(R.id.etxtnic);
        mDriverID = findViewById(R.id.etxtDriverID);
        mVehicleNo = findViewById(R.id.etxtVehicleNo);
        mPhone = findViewById(R.id.etxtPhone);
        mPassword = findViewById(R.id.etxtPassword);
        mConfirmPassword = findViewById(R.id.etxtCPassword);
        mRegister = findViewById(R.id.btnRegister);

        database = RoomDB.getInstance(this);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = mName.getText().toString();
                nic = mNIC.getText().toString();
                driverID = mDriverID.getText().toString();
                vehicleNo=mVehicleNo.getText().toString();
                phone = mPhone.getText().toString();
                passeword = mPassword.getText().toString();
                confirmpassword = mConfirmPassword.getText().toString();

                if(!name.isEmpty()&&!nic.isEmpty()&&!driverID.isEmpty()&&!vehicleNo.isEmpty()&&!phone.isEmpty()&&!passeword.isEmpty()&&!confirmpassword.isEmpty()){


                    if(validate.isPhoneNumber(phone)){

                        if(validate.isNIC(nic)){

                            if(passeword.equals(confirmpassword)){
                                Driver driver = new Driver();
                                driver.setName(name);
                                driver.setNic(nic);
                                driver.setDriverID(driverID);
                                driver.setPhone(phone);
                                driver.setVehicleNo(vehicleNo);
                                driver.setPassword(passeword);

                                database.driverDAO().insertDriver(driver);

                                Intent intent = new Intent(MainActivity.this,Display_Drivers.class);

                                startActivity(intent);

                                finish();
                            }else {
                                Toast.makeText(MainActivity.this,"Password not Matched",Toast.LENGTH_LONG).show();
                            }

                        }else {
                            Toast.makeText(MainActivity.this,"NIC not valid",Toast.LENGTH_LONG).show();
                        }


                    }else {
                        Toast.makeText(MainActivity.this,"Phone number not valid",Toast.LENGTH_LONG).show();
                    }


                }else {
                    Toast.makeText(MainActivity.this,"Please fill all field",Toast.LENGTH_LONG).show();
                }



            }
        });


    }
}