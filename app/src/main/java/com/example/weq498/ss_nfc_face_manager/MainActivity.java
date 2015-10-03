package com.example.weq498.ss_nfc_face_manager;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    Button face_signon_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FragmentManager fm = getFragmentManager();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        face_signon_btn = (Button) findViewById(R.id.face_signon_btn);
        face_signon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera_capture capture = new camera_capture();
                fm.beginTransaction().addToBackStack(null).add(R.id.frame, capture).commit();
            }
        });
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
    public void finish(){
        if(getFragmentManager().getBackStackEntryCount() == 0){
            super.finish();
        }else {
            getFragmentManager().popBackStack();
        }
    }
}
