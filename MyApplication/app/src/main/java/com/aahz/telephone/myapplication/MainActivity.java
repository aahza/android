package com.aahz.telephone.myapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private Button sendSms;
    private Button showSms;
    private EditText phoneText;
    private EditText smsText;
    private SmsManager smsManager;
    private SmsIntent smsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSms = (Button) findViewById(R.id.send_sms);
        showSms = (Button) findViewById(R.id.show_sms);
        phoneText = (EditText) findViewById(R.id.phone_text);
        smsText = (EditText) findViewById(R.id.sms_text);

        sendSms.setOnClickListener(this::sendSmsClick);
        showSms.setOnClickListener(this::sendSmsClick);

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

                smsManager.sendTextMessage(phoneText.getText().toString(),
                        null, "СМС от Саши", p, null);
                break;

            case R.id.show_sms:
                Uri uri = Uri.parse("content://sms/");
                Cursor c = getContentResolver().query(uri, null, null, null, null);

                int indexes = c.getColumnCount();
                smsText.setText("columns =" + indexes);
                Log.d("SMS ", "indexes =" + indexes);

                c.moveToFirst();

                smsText.setText("address =" + c.getString(c.getColumnIndex("address")));

                String stype = "";
                for(int index = 0; index < indexes; index++) {
                    int intType = c.getType(index);

                    if(Cursor.FIELD_TYPE_STRING == intType ) { stype = "String";
                    } else if (Cursor.FIELD_TYPE_INTEGER == intType) { stype = "int";
                    } else if (Cursor.FIELD_TYPE_FLOAT == intType) { stype = "float";
                    } else if (Cursor.FIELD_TYPE_BLOB == intType) { stype = "Blog";
                    } else { stype = "Null";}
                    Log.d("SMS ",  stype + " " + c.getColumnName(index));
        }
                break;
//               D: int _id
//D: int thread_id
//D: String address
//D: Null person
//D: int date
//D: int date_sent
//D: Null protocol
//D: int read
//D: int status
//D: int type
//D: Null reply_path_present
//D: Null subject
//D: String body
//D: Null service_center
//D: int locked
//D: int error_code
//D: int seen
//D: int deletable
//D: int hidden
//D: Null group_id
//D: Null group_type
//D: Null delivery_date
//D: int app_id
//D: int msg_id
//D: Null callback_number
//D: int reserved
//D: int pri
//D: int teleservice_id
//D: Null link_url
//D: int svc_cmd
//D: Null svc_cmd_content
//D: int roam_pending
//D: int sim_slot
//D: Null sim_imsi
//D: int spam_report
//D: int safe_message
//D: int sub_id
//D: String creator

//                int count = 0;
//                while (c.moveToNext()) {
//                    Log.d("SMS " + count++,
//                            " address " + c.getString(c.getColumnIndex("address")) +
////                            " person " + c.getString(c.getColumnIndex("person")) +
//                                    " status " + c.getString(c.getColumnIndex("status")) +
//                                    "\n body: " + c.getString(c.getColumnIndex("body"))
//
//                    );
//                }
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

    public boolean isSimExists() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        int SIM_STATE = telephonyManager.getSimState();

        if (SIM_STATE == TelephonyManager.SIM_STATE_READY)
            return true;
        else {
            // we can inform user about sim state
            switch (SIM_STATE) {
                case TelephonyManager.SIM_STATE_ABSENT:
                case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                case TelephonyManager.SIM_STATE_UNKNOWN:
                    break;
            }
            return false;
        }
    }
}
