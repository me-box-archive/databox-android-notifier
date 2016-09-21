package uk.me.robspencer.databoxnotify;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by rob on 09/06/2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("notifier", "Refreshed token: " + refreshedToken);
        Intent i = new Intent("FCM_TOKEN_CHANGED");
        i.putExtra("fcmID", refreshedToken);
        sendBroadcast(i);

        // TODO: Implement this method to send any registration to your app's servers.
        //sendRegistrationToServer(refreshedToken);
    }
}
