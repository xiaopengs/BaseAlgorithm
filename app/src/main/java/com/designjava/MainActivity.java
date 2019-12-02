package com.designjava;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String tests[] = { "RecyclerDemoActivity",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tests));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String testName = tests[position];
        try{
            Class clazz = Class.forName("com.recyclerview." + testName);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}