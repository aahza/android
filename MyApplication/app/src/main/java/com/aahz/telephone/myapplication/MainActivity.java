package com.aahz.telephone.myapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button sendSms;
    private SmsManager smsManager;
    private SmsIntent smsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSms = (Button) findViewById(R.id.send_sms);
        sendSms.setOnClickListener(this::sendSmsClick);

    }

    @Override
    protected void onResume() {
        super.onResume();
        smsIntent = new SmsIntent();
        registerReceiver(smsIntent, new IntentFilter(smsIntent.ACTION_SEND));
    }

    @Override
    protected void onPause() {
        if(smsIntent != null) {
            unregisterReceiver(smsIntent);
        }
        super.onPause();
    }

    public void sendSmsClick(View v) {
        switch (v.getId()){
            case R.id.send_sms:
                smsManager = SmsManager.getDefault();

//                    smsManager.sendTextMessage("+375xxxxxxxx",
//                            null, "СМС от Саши", null, null);

                PendingIntent p = PendingIntent.getBroadcast(this, 0, new Intent(smsIntent.ACTION_SEND),
                        PendingIntent.FLAG_ONE_SHOT);

                smsManager.sendTextMessage("+375xxxxxxxx",
                        null, "СМС от Саши", p, null);
                break;
        }
    }

    private class SmsIntent extends BroadcastReceiver{
        public final String ACTION_SEND = "com.aahz.telephone.SMS_SEND";

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
                case Activity.RESULT_OK:
                    Toast.makeText(context, "SMS sent successfully", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(context, "Generic failure cause", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    Toast.makeText(context, "Service is currently unavailable", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    Toast.makeText(context, "No PDU provided", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(context, "Radio was explicitly turned off", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
