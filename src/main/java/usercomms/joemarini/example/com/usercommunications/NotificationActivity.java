package usercomms.joemarini.example.com.usercommunications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class NotificationActivity extends AppCompatActivity
    implements View.OnClickListener{

    private static final int NOTIFY_ID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btnNotification).setOnClickListener(this);
    }

    private void createNotification() {
        // TODO: create the NotificationCompat Builder

        Notification.Builder builder= new Notification.Builder(this);
        // TODO: Create the intent that will start the ResultActivity when the user
        // taps the notification or chooses an action button
Intent intent=new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,NOTIFY_ID,
               intent,PendingIntent.FLAG_CANCEL_CURRENT );

        // Store the notification ID so we can cancel it later in the ResultActivity

        // TODO: Set the three required items all notifications must have
builder.setSmallIcon(R.drawable.ic_stat_sample_notification);
        builder.setContentTitle("Sample notifiction");
        builder.setContentText("This is a sample notifcation");

        // TODO: Set the notification to cancel when the user taps on it
builder.setAutoCancel(true);
        // TODO: Set the large icon to be our app's launcher icon
builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
        R.mipmap.ic_launcher));

        // TODO: Set the small subtext message
        builder.setSubText("Tap to view")


        // TODO: Set the content intent to launch our result activity
builder.setContentInfo(pendingIntent);

        // TODO: Add an expanded layout to the notification


        // TODO: Add action buttons to the Notification if they are supported
        // Use the same PendingIntent as we use for the main notification action

        // TODO: Set the lock screen visibility of the notification


        // TODO: Build the finished notification and then display it to the user
Notification notification=builder.build();
        NotificationManager mgr=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ID,notification);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNotification) {
            createNotification();
        }
    }
}
