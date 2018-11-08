package cse.mobile.dialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이런식으로 하지 않고,
//                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MainActivity.this);
//                adBuilder.setMessage("Time out!!");
//                adBuilder.setTitle("Notice");
//                adBuilder.setIcon(R.mipmap.ic_launcher);
//                adBuilder.show();
                //이렇게 쓴다. set들이 builder객체를 return하니까
                 new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Time out!!")
                        .setTitle("Notice")
                        .setIcon(R.mipmap.ic_launcher)
                         .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                             }
                         })
                         .setNegativeButton("Cancel", null)
                         .setCancelable(false) //버튼을 눌렀을 때만 없어지게
                        .show();

            }
        });
    }
}
