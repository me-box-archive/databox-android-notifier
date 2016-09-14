package uk.me.robspencer.databoxnotify;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gpa = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(gpa != ConnectionResult.SUCCESS){
            Dialog d = GoogleApiAvailability.getInstance().getErrorDialog(this, gpa, 0);
            d.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        int gpa = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(gpa != ConnectionResult.SUCCESS){
            Dialog d = GoogleApiAvailability.getInstance().getErrorDialog(this, gpa, 0);
            d.show();
        }
    }
}