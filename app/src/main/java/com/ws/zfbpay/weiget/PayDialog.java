package com.ws.zfbpay.weiget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ws.zfbpay.R;

public class PayDialog extends Dialog {

    private int width;
    private String text;
    private TextView textView;

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
