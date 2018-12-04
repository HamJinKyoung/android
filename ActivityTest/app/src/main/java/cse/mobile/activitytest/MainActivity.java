package cse.mobile.activitytest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE_SUBACTIVITY = 0;
    TextView mTVMainRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTVMainRet = findViewById(R.id.tvMainActivity);

        Button btMainCall = findViewById(R.id.btMainCall);
        btMainCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(getApplicationContext(),SubActivity.class);
//                startActivity(sIntent);
                startActivityForResult(sIntent,REQ_CODE_SUBACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SUBACTIVITY:
                if(resultCode == RESULT_OK) {
                    mTVMainRet.setText(data.getStringExtra("subInputStr"));
                }
                break;
        }
    }
}
