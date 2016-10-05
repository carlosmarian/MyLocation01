package br.com.carlosmarian.mobile.mylocation;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.carlosmarian.mobile.mylocation.view.MapsActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button) findViewById(R.id.start_tracking)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivities(new Intent(getApplicationContext(), MapsActivity.class));
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });
    }

}
