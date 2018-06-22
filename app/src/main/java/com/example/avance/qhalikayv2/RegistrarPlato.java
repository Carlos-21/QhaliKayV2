package com.example.avance.qhalikayv2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
//import com.firebase.client.Firebase;
//import com.google.firebase.firebaseApp;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class RegistrarPlato extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_plato);

        mListView = (ListView) findViewById(R.id.listView);


        //Firebase ref=new FireBase("https://qhalikai-5d449.firebaseio.com/");
    }


}
