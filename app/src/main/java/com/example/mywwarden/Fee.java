package com.example.mywwarden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Fee extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickStudent(View view){
        //Redirect activity to student
        MainActivity.redirectActivity(this,Student.class);
    }


    public void ClickFee(View view){
        //Redirect activity to fee
        recreate();
    }

    public void ClickMedical(View view){
        //Redirect activity to medical
        MainActivity.redirectActivity(this,Medical.class);
    }


    public void ClickAllotment(View view){
        //Redirect activity to allotment
        MainActivity.redirectActivity(this,Allotment.class);
    }

    public void ClickComplaint(View view){
        //Redirect activity to complaint
        MainActivity.redirectActivity(this,Complaint.class);
    }

    public void ClickDriver(View view){
        //Redirect activity to driver
       MainActivity.redirectActivity(this,Driver.class);
    }

    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);

    }
}
