package com.example.a6109_19.a2014mid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.layer);
        final RadioButton rb0 = (RadioButton) findViewById(R.id.radio0);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.radio1);

        final TableRow table = (TableRow) findViewById(R.id.tableRow2);
        final EditText et1 = (EditText) findViewById(R.id.editText1);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox1);
        Button bl1 = (Button) findViewById(R.id.button1);
        Button bl2 = (Button) findViewById(R.id.button2);

        final RadioButton rb2 = (RadioButton) findViewById(R.id.radio2); //image View
        final RadioButton rb3 = (RadioButton) findViewById(R.id.radio3); //Text View
        final ImageView img = (ImageView)View.inflate(this, R.layout.myimageview, null);
        final TextView textview = (TextView) View.inflate(this, R.layout.mytextview, null);


        rb0.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                table.setVisibility(View.GONE);
                ch1.setChecked(false);
            }
        });

        rb1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                table.setVisibility(View.VISIBLE);
            }
        });

        bl1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if((boolean) rb0.isChecked())
                {
                    if((boolean) ch1.isChecked())
                    {
                        Toast.makeText(getApplicationContext(), "Input 1: " + et1.getText() + ", " + "Input 2: " + et2.getText() + " (Save Checked)", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Input 1: " + et1.getText() + ", " + "Input 2: " + et2.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    if((boolean) ch1.isChecked())
                    {
                        Toast.makeText(getApplicationContext(), "Input 1: " + et1.getText() + ", " + "Input 2: " + et2.getText() + " (Save Checked)", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Input 1: " + et1.getText() + ", " + "Input 2: " + et2.getText(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        bl2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });


        layout.addView(img);
        img.setVisibility(View.INVISIBLE);

        rb2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if((boolean) rb2.isChecked())
                {
//    			  layout.removeView(textview);
                    img.setVisibility(View.VISIBLE);
                }
                else {
//        		  layout.removeView(textview);
                    img.setVisibility(View.INVISIBLE);
                    layout.removeView(img);
                }
            }
        });

        layout.addView(textview);
        textview.setVisibility(layout.INVISIBLE);

        rb3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if((boolean) rb3.isChecked())
                {
//      	      layout.removeView(img);
                    textview.setVisibility(View.VISIBLE);
                }
                else {
//        		  layout.removeView(textview);
                    textview.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}