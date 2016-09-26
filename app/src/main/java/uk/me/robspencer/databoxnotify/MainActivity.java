package uk.me.robspencer.databoxnotify;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.fcm);
        int gpa = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(gpa != ConnectionResult.SUCCESS){
            Dialog d = GoogleApiAvailability.getInstance().getErrorDialog(this, gpa, 0);
            d.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new FCMBroadcastReceiver();
        registerReceiver(receiver, new IntentFilter("FCM_TOKEN_CHANGED"));
        int gpa = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(gpa != ConnectionResult.SUCCESS){
            Dialog d = GoogleApiAvailability.getInstance().getErrorDialog(this, gpa, 0);
            d.show();
        }
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }

    private class FCMBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            tv.setText(intent.getStringExtra("fcmID"));
        }
    }
}