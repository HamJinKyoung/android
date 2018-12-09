package cse.mobile.activitytest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final EditText etSubInput = findViewById(R.id.etSubInput);

        if(getIntent().getStringExtra("mainRetStr") != null) {
            etSubInput.setHint(getIntent().getStringExtra("mainRetStr"));
        }

        Button btSubOK = findViewById(R.id.btSubOK);
        btSubOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent();
                sIntent.putExtra("subInputStr", etSubInput.getText().toString());
                setResult(RESULT_OK, sIntent);
                finish();
            }
        });
        Button btSubCancel = findViewById(R.id.btSubCancel);
        btSubCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}

