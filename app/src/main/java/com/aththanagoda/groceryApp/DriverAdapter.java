package com.aththanagoda.groceryApp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {

   private List<Driver> driverList;
   private Activity context;
   private RoomDB database;


    public DriverAdapter(List<Driver> driverList, Activity context) {
        this.driverList = driverList;
        this.context = context;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DriverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DriverAdapter.ViewHolder holder, int position) {

        final Driver driver = driverList.get(position);

        database = RoomDB.getInstance(context);

        holder.mName.setText(driver.getName());
        holder.mNic.setText(driver.getNic());
        holder.mPhone.setText(driver.getPhone());
        holder.mDriverID.setText(driver.getDriverID());
        holder.mVehicleid.setText(driver.getVehicleNo());

        holder.mEdite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Driver_edite.class);

                intent.putExtra("driver",driver);
                context.startActivity(intent);
            }
        });

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.driverDAO().deleteDriver(driver);
                int position = holder.getAdapterPosition();
                driverList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,driverList.size());
            }
        });



    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mNic, mDriverID,mVehicleid, mPhone;
        ImageButton mEdite,mDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName= itemView.findViewById(R.id.txt_diName);
            mNic = itemView.findViewById(R.id.txt_di_Nic);
            mDriverID= itemView.findViewById(R.id.txt_diDriverID);
            mVehicleid = itemView.findViewById(R.id.txt_diVehicleNo);
            mPhone =itemView.findViewById(R.id.txt_diPhone);

            mEdite = itemView.findViewById(R.id.btnEdite);
            mDelete = itemView.findViewById(R.id.btnDelete);



        }
    }
}
