package cse.mobile.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String[] FRUITS = {"Apple", "Banana", "Cherry", "Durian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvFruits = findViewById(R.id.lvFruits);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FRUITS);
//        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruits, android.R.layout.simple_list_item_1);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_textview, FRUITS);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_layout, R.id.textView2, FRUITS);

        lvFruits.setAdapter(adapter);

        lvFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplication(),FRUITS[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplication(),adapter.getItem(position),Toast.LENGTH_SHORT).show();
//                String[] saFruits = getResources().getStringArray(R.array.fruits);
//                Toast.makeText(getApplication(),saFruits[position], Toast.LENGTH_SHORT).show();
            }

        });

    }
}
