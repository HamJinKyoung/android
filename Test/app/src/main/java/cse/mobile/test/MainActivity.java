package cse.mobile.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button btOK = findViewById(R.id.btOK);
//        btOK.setText("YES");

        TextView tvHello = new TextView(this);
        tvHello.setText("Hello, Android in code.");

//        Button btOK = new Button(this);
//        btOK.setText("OK in code.");

//        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        Button btMyButton = (Button) inflater.inflate(R.layout.mybutton, null);

        Button btMyButton = (Button) View.inflate(this, R.layout.mybutton, null);

        LinearLayout llManager = new LinearLayout(this);
        llManager.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        llManager.addView(tvHello,llParams);
//        llManager.addView(btOK,llParams);
        llManager.addView(btMyButton,llParams);

        setContentView(llManager,llParams);
    }
}
