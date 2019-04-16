package com.e.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null){
            String value=bundle.getString("meaning");
            TextView TvCapital=findViewById(R.id.TvCapital);
            TvCapital.setText(value);
        }
        else
        {
            Toast.makeText(this,"No meaning",Toast.LENGTH_SHORT).show();
        }
    }
}
