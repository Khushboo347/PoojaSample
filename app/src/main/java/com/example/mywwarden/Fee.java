package com.example.mywwarden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fee extends AppCompatActivity {

    DrawerLayout drawerLayout;

    DatabaseHelper db;

    EditText add_name;
    Button add_data;
    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);

        drawerLayout = findViewById(R.id.drawer_layout);

        db = new DatabaseHelper(this);

        add_data = findViewById(R.id.add_data);
        add_name = findViewById(R.id.add_name);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)) {
                    Toast.makeText(Fee.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    listItem.clear();
                    viewData();
                } else
                {
                    Toast.makeText(Fee.this,"Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listItem = new ArrayList<>();


        userlist = findViewById(R.id.users_list);

        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(Fee.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void viewData(){
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
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
