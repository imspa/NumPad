package it.imwatch.sample.numpad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import it.imwatch.numpad.NumpadFragment;
import it.imwatch.numpad.NumpadFragment.OnCallListener;

import java.util.ArrayList;

/** Simple reference application which show how to integrate the ImWatchNumpad in your activity. * */
public class NumpadSampleActivity extends FragmentActivity {

    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        FragmentManager manager = getSupportFragmentManager();
        NumpadFragment numpad = (NumpadFragment) manager.findFragmentById(R.id.numpad);

        numpad.setCallListener(new OnCallListener() {

            @Override
            public void onCall(String number) {
                Toast.makeText(NumpadSampleActivity.this, "Call number: " + number, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
