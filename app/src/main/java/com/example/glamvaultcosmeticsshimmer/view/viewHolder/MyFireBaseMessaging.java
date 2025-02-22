package com.example.glamvaultcosmeticsshimmer.view.viewHolder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.glamvaultcosmeticsshimmer.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessaging extends FirebaseMessagingService {
    private static final String TAG="MyFireBas" +
            "eMessaging";
    private static final String CHANNEL_ID="notification";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Check if the message contains data
        if (remoteMessage.getData().size() > 0) {
            Log.d("Message", "Message data payload: " + remoteMessage.getData());

            // Handle the data payload here
            // You can access the data payload using remoteMessage.getData()
        }

        // Check if the message contains a notification payload
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message notification body: " + remoteMessage.getNotification().getBody());

            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

            // Handle the notification payload here
            // You can access the notification payload using remoteMessage.getNotification()
        }
    }

    @Override
    public void onNewToken(String token) {
        // If you need to handle token refresh, override this method
        Log.d(TAG, "Refreshed token: " + token);
    }
    private void showNotification(String title, String message) {
        Log.d("Notify","Working notify works");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel_name";
            String description = "channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system
            notificationManager.createNotificationChannel(channel);
        }

        // Show the notification
        notificationManager.notify(0, builder.build());
    }
}

