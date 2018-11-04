package cse.mobile.checkboxtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox_meat:
                if (checked)
                    Toast.makeText(getApplicationContext(),"고기 선택",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"고기 선택 해제", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox_cheese:
                if (checked)
                    Toast.makeText(getApplicationContext(),"치즈 선택",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"치즈 선택 해제", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
