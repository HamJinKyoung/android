package com.example.a6109_19.a2015mid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

        final TextView tv1 = (TextView)findViewById(R.id.textView1);
        final TextView tv2 = (TextView)findViewById(R.id.textView2);

        RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        final RadioButton rb1 = (RadioButton)findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);

        final EditText et1 = (EditText)findViewById(R.id.editText1);
        final TableRow tr1 = (TableRow)findViewById(R.id.tableRow);
        final EditText et2 = (EditText)findViewById(R.id.editText2);
        final CheckBox cb = (CheckBox)findViewById(R.id.checkBox);

        Button bt1 = (Button)findViewById(R.id.button1);
        Button bt2 = (Button)findViewById(R.id.button2);



        tr1.setVisibility(View.GONE);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radioButton1:
                        et1.setText("");
                        tr1.setVisibility(View.GONE);
                        break;
                    case R.id.radioButton2:
                        et1.setText("");
                        et2.setText("");
                        tr1.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((boolean) rb1.isChecked()) {
                    Toast.makeText(getApplicationContext(), tv1.getText() + ": " + et1.getText() + ", " + tv2.getText() + ": ", Toast.LENGTH_SHORT).show();
                } else {
                    if ((boolean) cb.isChecked()) {
                        Toast.makeText(getApplicationContext(), tv1.getText() + ": " + et1.getText() + ", " + tv2.getText() + ": " + et2.getText() + " (Save checked)", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), tv1.getText() + ": " + et1.getText() + ", " + tv2.getText() + ": " + et2.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        FrameLayout flayout = (FrameLayout)findViewById(R.id.flayout);
        final TextView tv = (TextView)View.inflate(this, R.layout.mytextview,null);
        final ImageView iv = (ImageView)View.inflate(this, R.layout.myimageview, null);
        tv.setVisibility(View.GONE);
        iv.setVisibility(View.GONE);

        //noinspection SimplifiableIfStatement
        if (id == R.id.mTextView) {
            if(flayout.indexOfChild(tv) <0){
                flayout.addView(tv);
                tv.setVisibility(flayout.VISIBLE);


            }else{
                flayout.removeView(iv);
                iv.setVisibility(flayout.GONE);
                flayout.addView(tv);
                tv.setVisibility(flayout.VISIBLE);

            }

        }else{
            if(flayout.indexOfChild(tv)<0){
                flayout.addView(iv);
                iv.setVisibility(flayout.VISIBLE);

            }else {
                flayout.removeView(tv);
                tv.setVisibility(flayout.GONE);
                flayout.addView(iv);
                iv.setVisibility(flayout.VISIBLE);

            }

        }

        return super.onOptionsItemSelected(item);
    }
}
