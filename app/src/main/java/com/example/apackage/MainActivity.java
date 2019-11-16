package com.example.apackage;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edlength;
    private EditText edwidth;
    private EditText edheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edlength = findViewById(R.id.length);
        edwidth = findViewById(R.id.width);
        edheight = findViewById(R.id.height);
        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reset();
                    }
                };
                int n = Integer.parseInt(edlength.getText().toString());
                int num = Integer.parseInt(edwidth.getText().toString());
                int number = Integer.parseInt(edheight.getText().toString());
                String a1 ="";
                if(n+num+number<=60) {
                    a1 = "常溫宅急便\n本島互寄:130元\n本島寄往離島:220元\n低溫宅急便\n本島互寄:160元\n本島寄往離島:260元";
                }else if(n+num+number>=61&&n+num+number<=90) {
                    a1 = "常溫宅急便\n本島互寄:170元\n本島寄往離島:280元\n低溫宅急便\n本島互寄:225元\n本島寄往離島:340元";
                }else if(n+num+number>=91&&n+num+number<=120){
                    a1 = "常溫宅急便\n本島互寄:210元\n本島寄往離島:320元\n低溫宅急便\n本島互寄:290元\n本島寄往離島:400元";
                }else if(n+num+number>=121&&n+num+number<=150){
                    a1 = "常溫宅急便\n本島互寄:250元\n本島寄往離島:360元\n低溫宅急便\n本島互寄:暫無提供\n本島寄往離島:暫無提供";
                }
                    new AlertDialog.Builder(MainActivity.this)
                        .setTitle("運費")
                        .setMessage(a1)
                        .setPositiveButton("Ok", listener)
                        .show();
            }
        });
    }
    public void reset(){
        edheight.setText("");
        edlength.setText("");
        edwidth.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
