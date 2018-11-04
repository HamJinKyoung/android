package cse.mobile.togglebuttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch stWifi = (Switch) findViewById(R.id.stWifi);
        stWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(),"Wifi On", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton)view).isChecked();

        if(on) {
            Toast.makeText(getApplicationContext(),"Turn On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Turn Off", Toast.LENGTH_SHORT).show();
        }
    }
}

