package com.example.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText txtMobile;
    private EditText txtMessage;
    private Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMobile = (EditText)findViewById(R.id.mblTxt);
        txtMessage = (EditText)findViewById(R.id.msgTxt);
        btnSms = (Button)findViewById(R.id.btnSend);
        btnSms.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(Intent.ACTION_VIEW);
                                          i.setData(Uri.parse("smsto:"));
                                          i.setType("vnd.android-dir/mms-sms");
                                          i.putExtra("address", new String(txtMobile.getText().toString()));
                                          i.putExtra("sms_body",txtMessage.getText().toString());
                                          startActivity(Intent.createChooser(i, "Send sms via:"));
                                      }

                                  }
        );
    }
}
