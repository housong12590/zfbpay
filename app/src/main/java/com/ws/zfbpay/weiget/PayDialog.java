package com.ws.zfbpay.weiget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ws.zfbpay.R;

public class PayDialog extends Dialog {

    private int width;
    private String text;
    private TextView textView;
    private View ll_affirm;
    private View ll_pay;
    private boolean canBack;

    public PayDialog(@NonNull Context context, String text) {
        this(context, R.style.comment_dialog_animation);
        this.text = text;
    }

    public PayDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        init();
    }


    public void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_pay_layout);
        textView = (TextView) findViewById(R.id.textView);
        ll_affirm = findViewById(R.id.ll_affirm);
        ll_pay = findViewById(R.id.ll_pay);
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_affirm.setVisibility(View.VISIBLE);
                ll_pay.setVisibility(View.GONE);
                canBack = false;
            }
        });
        findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!canBack) {
                    ll_affirm.setVisibility(View.GONE);
                    ll_pay.setVisibility(View.VISIBLE);
                }
                canBack = true;
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setCanceledOnTouchOutside(true);

        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = width;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);
        dialogWindow.setWindowAnimations(R.style.comment_dialog_animation);
    }

    @Override
    public void show() {
        float v = Float.parseFloat(text);
        String format = String.format("%.2f", v);
        textView.setText("¥" + format);
        super.show();
    }
}
