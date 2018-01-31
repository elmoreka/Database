package com.example.gohee_000.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gohee_000.database.R;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        dbHelper.insertStudent("Karl", "7044567890");
        dbHelper.insertStudent("Steve", "7041234567");
        dbHelper.insertStudent("Kyle", "7042345678");
        dbHelper.insertStudent("Kourtney", "7043456789");
        dbHelper.insertStudent("Kelly", "7045678901");
        dbHelper.insertStudent("Ross", "7046789012");

        dbHelper.getAllStudents();
    }
}
