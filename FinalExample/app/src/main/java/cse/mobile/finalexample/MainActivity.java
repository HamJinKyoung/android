package cse.mobile.finalexample;

import android.app.Dialog;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    static final int REQ_CODE_SUBACTIVITY = 0;

    ArrayList<String> mAlItems = new ArrayList<String>();
    ArrayAdapter<String> mAdapter;
    ListView lvMemo;

    static final String TAG = "AsyncTaskUITest";
    boolean mRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mAlItems);
        lvMemo = findViewById(R.id.lvMemo);
        lvMemo.setAdapter(mAdapter);

        lvMemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mAdapter.getItem(position),Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lvMemo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(this,"New Memo", Toast.LENGTH_SHORT).show();
                Intent sIntent = new Intent(getApplicationContext(),SubActivity.class);
                startActivityForResult(sIntent, REQ_CODE_SUBACTIVITY);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SUBACTIVITY:
                if(resultCode == RESULT_OK) {
                    mAlItems.add(data.getStringExtra("newMemo"));
                }
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.delete:
                mAlItems.remove(info.position);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.upload:

                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRunning = true;
        UploadMemoTask tkUploader = new UploadMemoTask(,100);
        tkUploader.execute();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRunning = false;
    }

    public static class UploadDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("Uploading the memo...")
                    .setView(View.inflate(getActivity(),R.layout.upload, null));
            return adBuilder.create();
        }
    }

    private class UploadMemoTask extends AsyncTask<Double, Double, Void> {
        DialogFragment mdialogFragment;
        int mFileSize;
        ProgressBar mProgressBar;

        public UploadMemoTask(DialogFragment uploadDialogFragment, int fileSize) {
            mdialogFragment = uploadDialogFragment;
            mFileSize = fileSize;
        }

        @Override
        protected Void doInBackground(Double... params) {
            double uploadSpeed = params[0];
            int remainder = mFileSize;

            while(remainder > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "remainder:" + remainder);
                publishProgress(uploadSpeed);
                remainder -= uploadSpeed;
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            mdialogFragment.setCancelable(false);
            mdialogFragment.show(getSupportFragmentManager(), "upload");
            getSupportFragmentManager().executePendingTransactions();

            mProgressBar = mdialogFragment.getDialog().findViewById(R.id.progressBar);
            mProgressBar.setMax(mFileSize);
            mProgressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Double... values) {
//            super.onProgressUpdate(values);
            mProgressBar.incrementProgressBy(values[0].intValue());
            Log.i(TAG,"getProgress(): " + mProgressBar.getProgress());
        }

        @Override
        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
            mdialogFragment.dismiss();
            Toast.makeText(getApplicationContext(),mFileSize + "Kbytes File upload completed.", Toast.LENGTH_SHORT).show();
        }
    }

}
