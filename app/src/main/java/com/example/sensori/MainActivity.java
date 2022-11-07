package com.example.sensori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);

        listView = (ListView)findViewById(R.id.listview);

        ArrayList<String> arraylist = new ArrayList<>();

        for(int i=0; i<list.size(); i++) arraylist.add(list.get(i).getStringType());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arraylist);

        listView.setAdapter(adapter);

    }
}