package cse.mobile.dialogtest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이런식으로 하지 않고,
//                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MainActivity.this);
//                adBuilder.setMessage("Time out!!");
//                adBuilder.setTitle("Notice");
//                adBuilder.setIcon(R.mipmap.ic_launcher);
//                adBuilder.show();
                //이렇게 쓴다. set들이 builder객체를 return하니까
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Time out!!")
                        .setTitle("Notice")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .setCancelable(false) //버튼을 눌렀을 때만 없어지게
                        .show();
            }
        });

        Button btNoticeDialog = findViewById(R.id.btNoticeDialog);
        btNoticeDialog.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment noticeDialogFragment = new NoticeDialogFragment();
                noticeDialogFragment.setCancelable(false);
                noticeDialogFragment.show(getSupportFragmentManager(),"noticeDialogFragment");
            }
        }));

        Button btListDialog = findViewById(R.id.btListDialog);
        btListDialog.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment listDialogFragment = new ListDialogFragment();
                listDialogFragment.setCancelable(false);
                listDialogFragment.show(getSupportFragmentManager(),"listDialogFragment");
            }
        }));
    }

    public static class NoticeDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity())
                    .setMessage("Time out!!")
                    .setTitle("Notice")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setCancelable(false);
            return adBuilder.create();
//            return super.onCreateDialog(savedInstanceState);
        }
    }

    public static class ListDialogFragment extends DialogFragment {
        final CharSequence[] items = {"Red", "Green", "Blue"};
        boolean[] checkedItems = {true, false, true};
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("ListDialog")
                    .setIcon(R.mipmap.ic_launcher)
//                    .setItems(items, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
//                        }
//                    })
                    .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            String str = (isChecked)? "Checked" : "Unchecked";
                            Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setCancelable(false);
            return adBuilder.create();
        }
    }
}
