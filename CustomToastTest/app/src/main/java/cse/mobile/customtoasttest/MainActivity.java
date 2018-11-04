package cse.mobile.customtoasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOK = findViewById(R.id.btOK);
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout rootView = (LinearLayout) View.inflate(getApplicationContext(),R.layout.mytoast,null);
                TextView tvMessage = rootView.findViewById(R.id.tvMessage);
                tvMessage.setText("Button clicked through MyToast");

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.setView(rootView);
                // toast.setText("토스트에 setText하면 안됨!");

                toast.show();
            }
        });
    }
}
