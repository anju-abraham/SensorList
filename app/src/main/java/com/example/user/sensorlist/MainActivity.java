package com.example.user.sensorlist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager msensorManager ;
    TextView tvSensors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSensors = (TextView) findViewById(R.id.tvSensors);
        tvSensors.setVisibility(View.GONE);

        msensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList = msensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 1; i < mList.size(); i++) {
            tvSensors.setVisibility(View.VISIBLE);
            tvSensors.append("\n" + mList.get(i).getName() + "--" + mList.get(i).getVendor());
        }

    }
}
