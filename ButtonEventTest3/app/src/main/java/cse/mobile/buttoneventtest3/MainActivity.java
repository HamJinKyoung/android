package cse.mobile.buttoneventtest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "Button Clicked 1", Toast.LENGTH_SHORT).show();
    }

}