package com.tdi.tinghir.demo.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final String CHANNEL_ID = "10";
    static final int NOTIF_ID = 100;
    static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnToastShort).setOnClickListener(this);
        findViewById(R.id.btnToastLong).setOnClickListener(this);
        findViewById(R.id.btnAlertDialog1).setOnClickListener(this);
        findViewById(R.id.btnAlertDialog2).setOnClickListener(this);
        findViewById(R.id.btnAlertDialog3).setOnClickListener(this);
        findViewById(R.id.btnAlertDialogCustomLayout).setOnClickListener(this);
        findViewById(R.id.btnNotification).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = null;
        switch (v.getId()) {
            case R.id.btnToastShort:
                Toast
                .makeText(MainActivity.this, "Voici un Toast Court", Toast.LENGTH_SHORT)
                .show();
                break;
            case R.id.btnToastLong:
                Toast
                .makeText(MainActivity.this, R.string.app_msg_long, Toast.LENGTH_LONG)
                .show();
                break;
            case R.id.btnAlertDialog1:
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Voici un titre");
                builder.setMessage("Voici un message...");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur Ok", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setCancelable(false);
                builder.show();
                break;
            case R.id.btnAlertDialog2:
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Voici un titre");
                builder.setMessage("Voici un message...");
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur Oui", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur non", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setCancelable(false);
                builder.show();
                break;
            case R.id.btnAlertDialog3:
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Voici un titre");
                builder.setMessage("Voici un message...");
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur Oui", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur non", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setNeutralButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                        .makeText(MainActivity.this, "clic sur annuler", Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                builder.setCancelable(false);
                builder.show();
                break;
            case R.id.btnAlertDialogCustomLayout:
                builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View vLyout = inflater.inflate(R.layout.dialog_custom, null);
                builder.setView(vLyout);
                builder.setCancelable(true);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                final EditText etSaisie = vLyout.findViewById(R.id.etSaisie);
                Button btnSaisie = vLyout.findViewById(R.id.btnSaisie);
                btnSaisie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String saisie = etSaisie.getText().toString();
                        alertDialog.dismiss();
                        Toast
                        .makeText(MainActivity.this, "Saisie: " + saisie, Toast.LENGTH_SHORT)
                        .show();
                    }
                });
                break;
            case R.id.btnNotification:
                Intent myIntent = new Intent(getApplicationContext(), Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), REQUEST_CODE, myIntent, 0);

                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("Titre Notification")
                        .setContentText("Contenu Notification")
                        .setSound(uri)
                        .setContentIntent(pendingIntent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "App Notif Channel", NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager notificationManager = (NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(channel);
                    notificationManager.notify(NOTIF_ID, notifBuilder.build());
                } else {
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                    notificationManager.notify(NOTIF_ID, notifBuilder.build());
                }
                break;
            default:
        }
    }
}
