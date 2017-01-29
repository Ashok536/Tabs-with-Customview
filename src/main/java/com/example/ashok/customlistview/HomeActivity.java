package com.example.ashok.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
{
    private ListView listView;
    private String names[] = {
            "User1",
            "User2",
            "Content1",
            "Content2","Choice1","Content3","User3","Choice2","Content4","Content5","User4","Content6","Choice3","Content7"};

    private Integer imageid[] = {
            R.drawable.contact1,
            R.drawable.contact,R.drawable.conent,R.drawable.conent1,R.drawable.choice,R.drawable.conent,R.drawable.contact1,
    R.drawable.choice,R.drawable.conent,R.drawable.conent1,R.drawable.contact,R.drawable.conent1,R.drawable.choice,R.drawable.conent};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        customlistview customList = new customlistview(this, names, imageid);

        listView = (ListView) findViewById(R.id.listView);
        //int k = listView.getId();
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(), "You Clicked " + names[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
