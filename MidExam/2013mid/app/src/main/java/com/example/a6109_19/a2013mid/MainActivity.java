package com.example.a6109_19.a2013mid;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        final ImageView img = (ImageView)View.inflate(this, R.layout.myimageview, null);

        final RadioButton rb1 = (RadioButton) findViewById(R.id.radio0);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radio1);

        final EditText edit1 = (EditText) findViewById(R.id.editText1);

        final TableRow table = (TableRow) findViewById(R.id.tableRow3);
        final EditText edit2 = (EditText) findViewById(R.id.editText2);
        final CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox2);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);

        //Input1
        rb1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                table.setVisibility(View.GONE);
                ch1.setChecked(false);
            }
        });

        //Input2
        rb2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                table.setVisibility(View.VISIBLE);
            }
        });

        //OK
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str="";

                //checked Input1
                if((boolean) rb1.isChecked()){
                    str= getResources().getString(R.string.choice)+": "+rb1.getText().toString()+", "
                            +getResources().getString(R.string.input1)+": "+edit1.getText().toString()+", "
                            +getResources().getString(R.string.input2)+": ";
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                }else{ //checked Input2
                    //save check
                    if((boolean) ch1.isChecked()){
                        str= getResources().getString(R.string.choice)+": "+rb2.getText().toString()+", "
                                +getResources().getString(R.string.input1)+": "+edit1.getText().toString()+", "
                                +getResources().getString(R.string.input2)+": "+edit2.getText().toString()+" ("
                                +getResources().getString(R.string.ch_save)+")";
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    }else{ //save uncheck
                        str= getResources().getString(R.string.choice)+": "+rb2.getText().toString()+", "
                                +getResources().getString(R.string.input1)+": "+edit1.getText().toString()+", "
                                +getResources().getString(R.string.input2)+": "+edit2.getText().toString();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        //Cancel
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, getResources().getString(R.string.cancelled), Toast.LENGTH_LONG).show();
            }
        });

        //Image check
        layout.addView(img);
        img.setVisibility(View.INVISIBLE);
        ch2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if((boolean) ch2.isChecked()){
                    img.setVisibility(View.VISIBLE);
                }else{
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
