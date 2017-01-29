package com.example.ashok.customlistview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends TabActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
        TabHost.TabSpec tabSpec=tabHost.newTabSpec("tab 1");
        tabSpec.setIndicator("Home");
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("tab 2");
        tabSpec1.setIndicator("Image");
        Intent inent=new Intent(getApplicationContext(),ImageActivity.class);
        tabSpec1.setContent(inent);
        tabHost.addTab(tabSpec1);

        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
