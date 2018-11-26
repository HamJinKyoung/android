package cse.mobile.listviewupdatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mALItems;
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> alitems = new ArrayList<String>();
        mALItems =new ArrayList<String>();
        ListView lvitems = findViewById(R.id.lvItems);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alitems);

        lvitems.setAdapter( mAdapter);

        final EditText etAdd = findViewById(R.id.etAdd);
        Button btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                alitems.add(etAdd.getText().toString());
                mAdapter.notifyDataSetChanged();
                etAdd.setText("");
            }
        });
        lvitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lvitems);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.cmenu_activity_main_lvitems,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem items) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)items.getMenuInfo();

        switch (items.getItemId())
        {
            case R.id.cmenuDelete:
                mALItems.remove(info.position);
                mAdapter.notifyDataSetChanged();
                return  true;

            default:
                return super.onContextItemSelected(items);
        }

    }
}