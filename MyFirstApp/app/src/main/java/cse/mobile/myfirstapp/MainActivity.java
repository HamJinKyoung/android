package cse.mobile.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        TextView tvHello = new TextView(this);
        tvHello.setText("Hello Android in Mobile Programming.");
        setContentView(tvHello);
    }
}
