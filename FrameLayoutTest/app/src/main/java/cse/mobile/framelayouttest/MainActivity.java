package cse.mobile.framelayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvRed = findViewById(R.id.tvRed);
        final TextView tvGreen = findViewById(R.id.tvGreen);
        final TextView tvBlue = findViewById(R.id.tvBlue);

        RadioGroup rgColor = findViewById(R.id.rgColor);
        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbcColor = group.findViewById(checkedId);

                switch(checkedId) {
                    case R.id.rbRed:
                        Toast.makeText(getApplicationContext(),rbcColor.getText()+ " checked 2", Toast.LENGTH_SHORT).show();
                        tvRed.setVisibility(View.VISIBLE);
                        tvGreen.setVisibility(View.INVISIBLE);
                        tvBlue.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbGreen:
                        Toast.makeText(getApplicationContext(),rbcColor.getText()+ " checked 2", Toast.LENGTH_SHORT).show();
                        tvRed.setVisibility(View.INVISIBLE);
                        tvGreen.setVisibility(View.VISIBLE);
                        tvBlue.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbBlue:
                        Toast.makeText(getApplicationContext(),rbcColor.getText()+ " checked 2", Toast.LENGTH_SHORT).show();
                        tvRed.setVisibility(View.INVISIBLE);
                        tvGreen.setVisibility(View.INVISIBLE);
                        tvBlue.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}
