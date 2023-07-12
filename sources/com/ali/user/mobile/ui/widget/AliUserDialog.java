package com.ali.user.mobile.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ali.user.mobile.R;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliUserDialog extends Dialog {
    private final String mMessage;
    private final String mNegativeText;
    private final String mPositiveText;
    private final String mTitle;
    private final NegativeClickListener negativeClickListener;
    private final PositiveClickListener positiveClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class Builder {
        private Context mContext;
        private String mMessage;
        private String mNegativeText;
        private NegativeClickListener mOnNegativeClickListener;
        private PositiveClickListener mPositiveClickListener;
        private String mPositiveText;
        private String mTitle;

        public AliUserDialog build() {
            return new AliUserDialog(this.mContext, this.mTitle, this.mMessage, this.mPositiveText, this.mNegativeText, this.mPositiveClickListener, this.mOnNegativeClickListener);
        }

        public Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public Builder setOnNegativeClickListener(String str, NegativeClickListener negativeClickListener) {
            this.mNegativeText = str;
            this.mOnNegativeClickListener = negativeClickListener;
            return this;
        }

        public Builder setOnPositiveClickListener(String str, PositiveClickListener positiveClickListener) {
            this.mPositiveText = str;
            this.mPositiveClickListener = positiveClickListener;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        private Builder(Context context) {
            this.mContext = context;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface NegativeClickListener {
        void onClick(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface PositiveClickListener {
        void onClick(View view);
    }

    public static Builder Builder(Context context) {
        return new Builder(context);
    }

    public static int getScaleSize(int i) {
        if (DataProviderFactory.getDataProvider().enableElder()) {
            if (i < 12) {
                return 15;
            }
            if (i < 12 || i >= 15) {
                if (i < 15 || i >= 18) {
                    return (i < 18 || i >= 21) ? 30 : 24;
                }
                return 21;
            }
            return 18;
        }
        return i;
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.aliuser_dialog_confirm);
        Button button2 = (Button) findViewById(R.id.aliuser_dialog_cancel);
        TextView textView = (TextView) findViewById(R.id.aliuser_dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.aliuser_dialog_message);
        View findViewById = findViewById(R.id.aliuser_dialog_split);
        if (!TextUtils.isEmpty(this.mTitle)) {
            textView.setText(this.mTitle);
            textView.setVisibility(0);
            try {
                textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                textView.getPaint().setStrokeWidth(0.7f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            textView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mMessage)) {
            textView2.setText(this.mMessage);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mPositiveText)) {
            button.setText(this.mPositiveText);
            button.setVisibility(0);
        } else {
            button.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mNegativeText)) {
            button2.setText(this.mNegativeText);
            button2.setVisibility(0);
        } else {
            button2.setVisibility(8);
        }
        if (this.positiveClickListener != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.ui.widget.AliUserDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AliUserDialog.this.positiveClickListener.onClick(view);
                }
            });
        }
        if (this.negativeClickListener != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.ui.widget.AliUserDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AliUserDialog.this.negativeClickListener.onClick(view);
                }
            });
        }
        if (!TextUtils.isEmpty(this.mPositiveText) && !TextUtils.isEmpty(this.mNegativeText)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        scaleTextSize(button, button2, textView, textView2);
    }

    public static void scaleTextSize(TextView... textViewArr) {
        if (DataProviderFactory.getDataProvider().enableElder()) {
            for (TextView textView : textViewArr) {
                if (textView != null) {
                    int pxTodip = ScreenUtil.pxTodip(DataProviderFactory.getApplicationContext(), textView.getTextSize());
                    int scaleSize = getScaleSize(pxTodip);
                    if (scaleSize != pxTodip) {
                        textView.setTextSize(1, scaleSize);
                    }
                }
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.C2952layout.aliuser_dialog_layout);
        setCanceledOnTouchOutside(false);
        initView();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        try {
            getWindow().setLayout((int) (DisplayMetrics.getwidthPixels(getContext().getResources().getDisplayMetrics()) * 0.73d), -2);
        } catch (Throwable unused) {
        }
    }

    public AliUserDialog shown() {
        show();
        return this;
    }

    private AliUserDialog(Context context, String str, String str2, String str3, String str4, PositiveClickListener positiveClickListener, NegativeClickListener negativeClickListener) {
        super(context, R.C2953style.AliUserDialogTheme);
        this.mTitle = str;
        this.mMessage = str2;
        this.mPositiveText = str3;
        this.mNegativeText = str4;
        this.positiveClickListener = positiveClickListener;
        this.negativeClickListener = negativeClickListener;
    }
}
