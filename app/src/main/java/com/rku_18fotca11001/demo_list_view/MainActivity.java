package com.rku_18fotca11001.demo_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstdata;
    ArrayAdapter<String> adapter;
    ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstdata = findViewById(R.id.lstdata);
        list = new ArrayList<String>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                //getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list
        );
        generateData();
        lstdata.setAdapter(arrayAdapter);

    }
            private  void generateData(){

             String jsonString = getResources().getString(R.string.jsondata);
             try {
                    JSONObject obj = new JSONObject(jsonString);
                    JSONArray array = obj.getJSONArray("formulas");

                    for (int i = 0; i < array.length(); i++)
                    {
                        list.add(array.getString(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
//                 Log.e("Myerror",e.toString());
                }
            }
}