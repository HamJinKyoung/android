package cse.mobile.buttoneventtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

//        ButtonClickListener buttonClickListener = new ButtonClickListener(); // 클래스의 이름도 있고, 객체의 이름도 있다.
//        button.setOnClickListener(buttonClickListener);

//        button.setOnClickListener(new ButtonClickListener()); // 임시 객체 (클래스의 이름은 있는데, 객체의 이름은 없다.)

//        button.setOnClickListener(mButtonClickListener); // 클래스의 이름은 없고, 객체의 이름은 있다.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked 4", Toast.LENGTH_SHORT).show();
            }
        }); // 클래스의 이름도 없고, 객체의 이름도 없다. 안드로이드에서는 이 방법을 가장 많이 사용!
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Button Clicked 1", Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Button Clicked 3", Toast.LENGTH_SHORT).show();
        }
    };
}
