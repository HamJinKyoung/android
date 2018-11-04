package cse.mobile.radiobuttontest;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgColor = findViewById(R.id.rgColor);
        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_red:
                        Toast.makeText(getApplicationContext(), ((RadioButton)findViewById(R.id.radio_red)).getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_blue:
                        Toast.makeText(getApplicationContext(), "Blue Checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}

