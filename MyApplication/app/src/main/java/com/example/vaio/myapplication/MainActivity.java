package com.example.vaio.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.vaio.myapplication.R;

public class MainActivity extends AppCompatActivity{

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);
        mContext=this;
        final EditText ed1 = (EditText) findViewById(R.id.editText);
        final EditText ed2 = (EditText) findViewById(R.id.editText2);
        final EditText ed3 = (EditText) findViewById(R.id.editText3);
        Button b1 = (Button) findViewById(R.id.button);
        final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String ph  = ed2.getText().toString();
                String e  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();
                showMsg();
            }
        });
    }

private void showMsg(){
    Toast.makeText(mContext,"Preference saved sucessfully",Toast.LENGTH_LONG).show();



}

        //(TextView)findViewById(R.id.vaibhav).settext("vu(menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.activity_menu, menu);
      // return super.onCreateOptionsMenu(menu);
            menu.add(Menu.NONE, R.id.action_favorite, Menu.NONE, R.string.action_settings);
            menu.add(Menu.NONE, R.id.action_settings, Menu.NONE, R.string.action_settings);
            return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_settings:
                    Intent intent = new Intent(this, ChildActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.action_favorite:

                    return true;

                default:
                    // If we got here, the user's action was not recognized.
                    // Invoke the superclass to handle it.
                    return super.onOptionsItemSelected(item);

           }
        }




    }
