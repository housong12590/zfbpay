package com.ws.zfbpay.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.ws.zfbpay.R;
import com.ws.zfbpay.weiget.PayDialog;

public class TransferActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#cccccc"));
        setContentView(R.layout.activity_transfer);
        editText = (EditText) findViewById(R.id.text);
        findViewById(R.id.tv_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                new PayDialog(TransferActivity.this, text).show();
            }
        });
    }
}
