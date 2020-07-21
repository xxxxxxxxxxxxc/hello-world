package com.thoughtworks.helloworld;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GetContractActivity extends AppCompatActivity {

    public static final int SELECT_CONTRACT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_contract);
    }


    public void selectOneContract(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, SELECT_CONTRACT_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_CONTRACT_REQUEST_CODE && resultCode == RESULT_OK) {

            Uri data1 = data.getData();
            Log.d("d", data1.toString());
            String[] queryData = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};

            try (Cursor queryCursor = getContentResolver().query(data1, queryData, null, null, null)) {
                if (queryCursor != null && queryCursor.moveToFirst()) {
                    int displayNameIdx = queryCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                    String displayName = queryCursor.getString(displayNameIdx);

                    int NumberIdx = queryCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    String phoneNumber = queryCursor.getString(NumberIdx);

                    Toast.makeText(this, String.format("%s %s", displayName, phoneNumber), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

