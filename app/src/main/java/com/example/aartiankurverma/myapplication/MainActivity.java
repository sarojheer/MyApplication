package com.example.aartiankurverma.myapplication;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle =new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btnadd:
                Intent i = new Intent(this, Profilepage.class);
                startActivity(i);
                break;
            case R.id.button2:
                Intent j = new Intent(this, AddingReceipt.class);
                startActivity(j);
                break;

        }
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
