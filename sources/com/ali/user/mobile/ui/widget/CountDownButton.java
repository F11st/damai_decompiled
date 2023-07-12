package com.ali.user.mobile.ui.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CountDownButton extends AppCompatButton {
    private boolean isCountDowning;
    protected CountListener mCountListener;
    protected int mGetCodeTitleRes;
    protected int mTickTitleRes;
    private TimeCountDown mTimeCountDown;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface CountListener {
        void onTick(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    private class TimeCountDown extends CountDownTimer {
        TimeCountDown(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CountDownButton countDownButton = CountDownButton.this;
            if (countDownButton.mGetCodeTitleRes != 0) {
                countDownButton.setText(countDownButton.getContext().getString(CountDownButton.this.mGetCodeTitleRes));
                CountDownButton countDownButton2 = CountDownButton.this;
                countDownButton2.setBackgroundDrawable(countDownButton2.getResources().getDrawable(R.C2964drawable.aliuser_btn_background_orange_round));
            } else {
                countDownButton.setText(countDownButton.getContext().getString(R.string.aliuser_signup_verification_getCode));
            }
            CountDownButton.this.setEnabled(true);
            CountDownButton.this.isCountDowning = false;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = (j / 1000) + 1;
            CountDownButton countDownButton = CountDownButton.this;
            if (countDownButton.mTickTitleRes != 0) {
                countDownButton.setText(countDownButton.getResources().getString(CountDownButton.this.mTickTitleRes, String.valueOf(j2)));
            } else {
                countDownButton.setText(String.valueOf(j2) + CountDownButton.this.getContext().getString(R.string.aliuser_signup_verification_reGetCode));
            }
            CountDownButton.this.setEnabled(false);
            CountListener countListener = CountDownButton.this.mCountListener;
            if (countListener != null) {
                countListener.onTick(j);
            }
        }
    }

    public CountDownButton(Context context) {
        super(context);
        this.isCountDowning = false;
    }

    public void cancelCountDown() {
        TimeCountDown timeCountDown = this.mTimeCountDown;
        if (timeCountDown != null) {
            timeCountDown.cancel();
        }
        this.isCountDowning = false;
    }

    public boolean isCountDowning() {
        return this.isCountDowning;
    }

    public void setGetCodeTitle(int i) {
        this.mGetCodeTitleRes = i;
    }

    public void setTickListener(CountListener countListener) {
        this.mCountListener = countListener;
    }

    public void setTickTitleRes(int i) {
        this.mTickTitleRes = i;
    }

    public void startCountDown(long j, long j2) {
        TimeCountDown timeCountDown = new TimeCountDown(j, j2);
        this.mTimeCountDown = timeCountDown;
        timeCountDown.start();
        this.isCountDowning = true;
    }

    public CountDownButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCountDowning = false;
    }
}
