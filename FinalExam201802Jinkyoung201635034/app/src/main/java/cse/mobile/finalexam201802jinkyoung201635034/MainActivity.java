package cse.mobile.finalexam201802jinkyoung201635034;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE_ACTIVITY = 0;

    static ArrayList<String> list = new ArrayList<String>();
    static ArrayAdapter<String> adapter;
    ListView lv;

    boolean mRunning = false;
    ShareDialogFragment shareDialogFragment = new ShareDialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        registerForContextMenu(lv);

    }

//    OptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(getApplicationContext(),"New Contact",Toast.LENGTH_SHORT).show();
                Intent sIntent = new Intent(getApplicationContext(), ContactEditActivity.class);
                startActivityForResult(sIntent, REQ_CODE_ACTIVITY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_ACTIVITY:
                if(resultCode == RESULT_OK) {
                    list.add(data.getStringExtra("InputStr"));
                }
                break;
        }
    }

//    ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cmenu_main_lvcontacts, menu);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("Delete Contact")
                        .setMessage("Are you sure to delete the contact?")
                        .setNegativeButton("No", null )
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(info.position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setCancelable(false)
                        .show();
                break;
            case R.id.share:
//                ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
                ShareFileTask share = new ShareFileTask(shareDialogFragment,100);
                shareDialogFragment.show(getSupportFragmentManager(), "shareDialogFragment");
                share.execute();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public static class ShareDialogFragment extends DialogFragment {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle("Share Contact")
                    .setView(View.inflate(getActivity(), R.layout.dialog_sharecontactprogress, null));

            return ad.create();
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
////        ShareDialogFragment shareDialogFragment = new ShareDialogFragment();
//        ShareFileTask share = new ShareFileTask(shareDialogFragment,100);
//        mRunning = true;
//        share.execute();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mRunning = false;
//    }

    private class ShareFileTask extends AsyncTask<Double, Double, Void> {
        DialogFragment mshareProgressDialog;
        int mFileSize;
        ProgressBar mProgressBar;

        public ShareFileTask(DialogFragment shareProgressDialog, int fileSize) {
            mshareProgressDialog = shareProgressDialog;
            mFileSize = fileSize;
        }

        @Override
        protected Void doInBackground(Double... params) {
            double speed = params[0];
            int remainder = mFileSize;

            while(remainder > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(speed);
                remainder -= speed;
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            mshareProgressDialog.setCancelable(false);
            mshareProgressDialog.show(getSupportFragmentManager(), "ShareFileProgressDialogFragment");
            getSupportFragmentManager().executePendingTransactions();

            mProgressBar = mshareProgressDialog.getDialog().findViewById(R.id.pbShareContact);
            mProgressBar.setMax(mFileSize);
            mProgressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Double... values) {
//            super.onProgressUpdate(values);
            mProgressBar.incrementProgressBy(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
            mshareProgressDialog.dismiss();
            Toast.makeText(getApplicationContext(), mFileSize + "Kbytes File shared completed.", Toast.LENGTH_SHORT).show();
        }
    }

}
