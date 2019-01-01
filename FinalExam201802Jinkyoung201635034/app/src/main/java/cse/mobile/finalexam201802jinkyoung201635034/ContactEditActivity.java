package cse.mobile.finalexam201802jinkyoung201635034;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactEditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactedit);

        final EditText etEdit = findViewById(R.id.etEdit);
        Button btEdit = findViewById(R.id.btEdit);
        Button btCancel = findViewById(R.id.btCancel);

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent();
                sIntent.putExtra("InputStr", etEdit.getText().toString());
                setResult(RESULT_OK, sIntent);
                finish();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
