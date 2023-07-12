package com.taobao.android.purchase.core.dinamcX.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CountDownTextView extends AppCompatTextView {
    private long mBeginTime;
    private CountDownTimerC6567a mCountDownTimer;
    private long mCountInterval;
    private String mIdleText;
    private OnFinishListener mOnFinishListener;
    private long mTimeInFuture;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnFinishListener {
        void onFinish(CountDownTextView countDownTextView);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.purchase.core.dinamcX.view.CountDownTextView$a */
    /* loaded from: classes12.dex */
    public class CountDownTimerC6567a extends CountDownTimer {
        public CountDownTimerC6567a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (CountDownTextView.this.mOnFinishListener != null) {
                CountDownTextView.this.mOnFinishListener.onFinish(CountDownTextView.this);
            }
            CountDownTextView countDownTextView = CountDownTextView.this;
            countDownTextView.setText(countDownTextView.mIdleText);
            CountDownTextView.this.mCountDownTimer = null;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CountDownTextView.this.setText(String.valueOf(Math.round(((float) j) / 1000.0f)));
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mIdleText = "";
        this.mBeginTime = -1L;
        this.mTimeInFuture = 60L;
        this.mCountInterval = 1L;
    }

    public boolean isCountDowning() {
        return this.mBeginTime > 0 && this.mCountDownTimer != null;
    }

    public void setCountInterval(long j) {
        this.mCountInterval = j;
    }

    public void setIdleText(String str) {
        this.mIdleText = str;
        if (this.mCountDownTimer != null || str == null) {
            return;
        }
        setText(str);
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.mOnFinishListener = onFinishListener;
    }

    public void setTimeInFuture(long j) {
        this.mTimeInFuture = j;
    }

    public void startCount(long j) {
        if (j == this.mBeginTime) {
            return;
        }
        this.mBeginTime = j;
        startCount();
    }

    private void startCount() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mBeginTime;
        long j2 = currentTimeMillis - j;
        long j3 = this.mTimeInFuture;
        long j4 = (j3 * 1000) - j2;
        long j5 = this.mCountInterval;
        if (j3 <= j5 || j5 <= 0 || j <= 0 || j2 / 1000 >= j3) {
            return;
        }
        CountDownTimerC6567a countDownTimerC6567a = this.mCountDownTimer;
        if (countDownTimerC6567a != null) {
            countDownTimerC6567a.cancel();
            this.mCountDownTimer = null;
        }
        CountDownTimerC6567a countDownTimerC6567a2 = new CountDownTimerC6567a(j4, this.mCountInterval * 1000);
        this.mCountDownTimer = countDownTimerC6567a2;
        countDownTimerC6567a2.start();
    }

    public CountDownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIdleText = "";
        this.mBeginTime = -1L;
        this.mTimeInFuture = 60L;
        this.mCountInterval = 1L;
    }

    public CountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIdleText = "";
        this.mBeginTime = -1L;
        this.mTimeInFuture = 60L;
        this.mCountInterval = 1L;
    }
}
