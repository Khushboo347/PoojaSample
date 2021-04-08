package com.example.mywwarden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/*----------------------------------Home Page--------------------------------*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout Student,feestatus,Complaint,Allotment,Medical,Driver;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        Student = findViewById(R.id.Student);
        feestatus = findViewById(R.id.feestatus);
        Complaint = findViewById(R.id.Complaint);
        Allotment = findViewById(R.id.Allotment);
        Driver = findViewById(R.id.Driver);
        Medical = findViewById(R.id.Medical);


        Student.setOnClickListener(this);
        feestatus.setOnClickListener(this);
        Complaint.setOnClickListener(this);
        Allotment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()){
            case R.id.Student:
                i= new Intent(this,Student.class);startActivity(i);break;
            case R.id.feestatus:
                i= new Intent(this,Fee.class);startActivity(i);break;
            case R.id.Complaint:
                i= new Intent(this,Complaint.class);startActivity(i);break;
            case R.id.Allotment:
                i= new Intent(this,Allotment.class);startActivity(i);break;
            default:break;
        }

    }
/*------------------------------Drawer Functions-------------------------------*/
 public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //closer drawer layout
        //check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickStudent(View view){
        //Redirect activity to medical
        redirectActivity(this,Student.class);
    }


    public void ClickFee(View view){
        //Redirect activity to dashboard
        redirectActivity(this,Fee.class);
    }

    public void ClickMedical(View view){
        //Redirect activity to medical
        redirectActivity(this,Medical.class);
    }


    public void ClickAllotment(View view){
        //Redirect activity to allotment
        redirectActivity(this,Allotment.class);
    }

    public void ClickComplaint(View view){
        //Redirect activity to mess
        redirectActivity(this,Complaint.class);
    }

    public void ClickDriver(View view){
        //Redirect activity to driver
        redirectActivity(this,Driver.class);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //set message
        builder.setMessage("Are you sure you wanna logout?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Finish activity
                        activity.finishAffinity();
                        //Exit app
                        //System.exit(0);
                        dialog.dismiss();
                    }
                    });
                //Negative no button
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Dismiss dialog
                        dialog.dismiss();
                    }
                });
        //Show dialog
        builder.show();
    }




    public static void redirectActivity(Activity activity, Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}




