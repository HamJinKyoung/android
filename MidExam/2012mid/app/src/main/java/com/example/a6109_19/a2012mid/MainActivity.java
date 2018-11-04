package com.example.a6109_19.a2012mid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends Activity {

    String select ="A";
    String check ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton rb1 = (RadioButton)findViewById(R.id.Rb1);
        RadioButton rb2 = (RadioButton)findViewById(R.id.Rb2);
        final EditText ed1 = (EditText)findViewById(R.id.editText1);
        final EditText ed2 = (EditText)findViewById(R.id.editText2);
        Button bt1 = (Button)findViewById(R.id.button1);
        Button bt2 = (Button)findViewById(R.id.button2);
        final TableRow tr = (TableRow)findViewById(R.id.tableRow3);
        final CheckBox cb = (CheckBox)findViewById(R.id.checkBox1);

        bt1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "select :"+ select +"// name : "+ ed1.getText() +"// p/w : "+ ed2.getText() +"// check :"+ check, Toast.LENGTH_LONG).show();

            }
        });

        bt2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ed1.setText("");
                ed2.setText("");
                rb1.setChecked(true);
                tr.setVisibility(TableRow.GONE);
                cb.setChecked(false);
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_LONG).show();

            }
        });
        rb1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                select = "A";
                ed1.setText("");
                ed2.setText("");
                tr.setVisibility(TableRow.GONE);

            }
        });

        rb2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                select = "B";
                tr.setVisibility(TableRow.VISIBLE);
            }
        });

        cb.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(((CheckBox)v).isChecked())
                    check ="checked";

                else
                    check = "None";

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
