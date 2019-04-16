package com.e.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {
            "Nepal","Kathmandu",
            "China","Beijing",
            "India","New-Delhi",
            "bangladesh","Dhaka",


    };

    ListView LvCountries;
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvCountries = findViewById(R.id.LvCountries);

        dictionary=new HashMap<>();
        for (int i=0;i<countries.length;i+=2){
        dictionary.put(countries[i],countries[i + 1]);
        }

        ArrayAdapter countryAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        LvCountries.setAdapter(countryAdapter);

        LvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key=parent.getItemAtPosition(position).toString();
                String value=dictionary.get(key);

                Intent intent=new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("meaning",value);
                startActivity(intent);

            }
        });
    }

}