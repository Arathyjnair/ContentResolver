package com.example.user.contentresolver;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lstttview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstttview=findViewById(R.id.lstt);
        if(fetchInbox()!=null)
        {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fetchInbox());
            lstttview.setAdapter(adapter);
        }
    }
    public ArrayList fetchInbox()
    {
        ArrayList<String> sms=new ArrayList<>();
        Uri Urisms= Uri.parse("content://sms/inbox");
        Cursor cursor=getContentResolver().query(Urisms,new String[]{"address","body"},null,null,null);
        cursor.moveToFirst();

        do {


            String number = cursor.getString(0);
            String body = cursor.getString(1);

            sms.add("Mobile =" + number + " Message :" + body);
        }
            while (cursor.moveToNext());


        return  sms;
    }
}
