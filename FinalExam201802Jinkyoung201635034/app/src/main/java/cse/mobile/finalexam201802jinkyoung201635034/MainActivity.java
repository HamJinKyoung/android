package cse.mobile.finalexam201802jinkyoung201635034;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE_ACTIVITY = 0;

    ArrayList<String> list = new ArrayList<String>();
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

//        Intent sIntent = Intent.parseIntent();
//        sIntent.putExtra("")

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(getApplicationContext(),"New Contact",Toast.LENGTH_SHORT).show();
                Intent sIntent = Intent.makeMainActivity(getComponentName());
                startActivityForResult(sIntent, REQ_CODE_ACTIVITY);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                NoticeDialogFragment noticedialogFragment = new NoticeDialogFragment();

                break;
            case R.id.share:
                ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
//                shareDialogFragment.show();
                getSupportFragmentManager().executePendingTransactions();
                shareDialogFragment.getDialog().findViewById(R.id.pbShareContact);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public static class NoticeDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle("Delete Contact")
                    .setMessage("Are you sure to delete the contact?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

            return super.onCreateDialog(savedInstanceState);
        }
    }
    public static class ShareDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle("Share Contact")
                    .setMessage("Sharing Contact...");
//                    .setView(R.layout.dialog_sharecontactprogress);

            return super.onCreateDialog(savedInstanceState);
        }
    }



}
