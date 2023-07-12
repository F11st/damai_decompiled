package com.taobao.android.dinamicx.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.view.HandlerTimer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeCountDownTimerView extends RelativeLayout {
    public static final int DX_DIGIT_COUNT_DOUBLE = 2;
    public static final int DX_DIGIT_COUNT_SINGLE = 1;
    private static final String TAG = "DCountDownTimerView";
    private TextView colonFirst;
    private TextView colonSecond;
    private TextView colonThird;
    private View countDownTimerContainer;
    private long futureTime;
    private boolean hasRegisterReceiver;
    private TextView hour;
    private int interval;
    private boolean isAttached;
    private boolean isNativeTime;
    private final BroadcastReceiver mReceiver;
    private HandlerTimer mTimer;
    private TextView milli;
    private int milliSecondDigitCount;
    private TextView minute;
    private long offset;
    private OnFinishListener onFinishListener;
    private TextView second;
    private TextView seeMoreView;
    private boolean showMilliSecond;
    private boolean showSeeMoreText;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    public DXNativeCountDownTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interval = 500;
        this.milliSecondDigitCount = 1;
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DXNativeCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DXNativeCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DXNativeCountDownTimerView.this.isShown() || DXNativeCountDownTimerView.this.futureTime <= 0) {
                        DXNativeCountDownTimerView.this.mTimer.stop();
                    } else {
                        DXNativeCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_component_count_down_timer_view, this);
        this.hour = (TextView) findViewById(R$id.tv_hours);
        this.minute = (TextView) findViewById(R$id.tv_minutes);
        this.second = (TextView) findViewById(R$id.tv_seconds);
        this.milli = (TextView) findViewById(R$id.tv_milli);
        this.colonFirst = (TextView) findViewById(R$id.tv_colon1);
        this.colonSecond = (TextView) findViewById(R$id.tv_colon2);
        this.colonThird = (TextView) findViewById(R$id.tv_colon3);
        this.countDownTimerContainer = findViewById(R$id.count_down_timer_view_container);
        this.seeMoreView = (TextView) findViewById(R$id.see_more_default);
    }

    public TextView getColonFirst() {
        return this.colonFirst;
    }

    public TextView getColonSecond() {
        return this.colonSecond;
    }

    public TextView getColonThird() {
        return this.colonThird;
    }

    public View getCountDownTimerContainer() {
        return this.countDownTimerContainer;
    }

    public long getFutureTime() {
        return this.futureTime;
    }

    public TextView getHour() {
        return this.hour;
    }

    public long getLastTime() {
        long elapsedRealtime;
        if (this.futureTime <= 0) {
            return -1L;
        }
        if (this.isNativeTime) {
            elapsedRealtime = System.currentTimeMillis();
        } else {
            elapsedRealtime = SystemClock.elapsedRealtime() + this.offset;
        }
        return this.futureTime - elapsedRealtime;
    }

    public TextView getMilli() {
        return this.milli;
    }

    public TextView getMinute() {
        return this.minute;
    }

    public long getOffset() {
        return this.offset;
    }

    public OnFinishListener getOnFinishListener() {
        return this.onFinishListener;
    }

    public TextView getSecond() {
        return this.second;
    }

    public TextView getSeeMoreView() {
        return this.seeMoreView;
    }

    public HandlerTimer getTimer() {
        int i = this.showMilliSecond ? 50 : 500;
        boolean z = false;
        if (this.interval != i) {
            z = true;
            this.interval = i;
        }
        if (this.mTimer == null || z) {
            this.mTimer = new HandlerTimer(this.interval, new Runnable() { // from class: com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DXNativeCountDownTimerView.this.isAttached) {
                        DXNativeCountDownTimerView.this.updateCountView();
                    }
                }
            });
        }
        return this.mTimer;
    }

    public void hideCountDown() {
        if (this.showSeeMoreText) {
            this.seeMoreView.setVisibility(0);
            this.countDownTimerContainer.setVisibility(8);
            return;
        }
        showCountDown();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null && this.futureTime > 0) {
            handlerTimer.start();
        }
        if (this.hasRegisterReceiver) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        getContext().registerReceiver(this.mReceiver, intentFilter);
        this.hasRegisterReceiver = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttached = false;
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null) {
            handlerTimer.stop();
        }
        try {
            getContext().unregisterReceiver(this.mReceiver);
            this.hasRegisterReceiver = false;
        } catch (Exception e) {
            DinamicLog.c("DCountDownTimerView", e, new String[0]);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer == null) {
            return;
        }
        if (i == 0 && this.futureTime > 0) {
            handlerTimer.start();
        } else {
            handlerTimer.stop();
        }
    }

    public void setCurrentTime(long j) {
        this.isNativeTime = false;
        this.offset = j - SystemClock.elapsedRealtime();
    }

    public void setFutureTime(long j) {
        this.futureTime = j;
    }

    public void setMilliSecondDigitCount(int i) {
        this.milliSecondDigitCount = i;
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setShowMilliSecond(boolean z) {
        this.showMilliSecond = z;
    }

    public void setShowSeeMoreText(boolean z) {
        this.showSeeMoreText = z;
    }

    public void showCountDown() {
        this.seeMoreView.setVisibility(8);
        this.countDownTimerContainer.setVisibility(0);
    }

    @SuppressLint({"SetTextI18n"})
    public void updateCountDownViewTime() {
        if (this.countDownTimerContainer == null) {
            return;
        }
        long lastTime = getLastTime();
        if (lastTime > 0) {
            long j = 3600000;
            long j2 = lastTime / j;
            long j3 = lastTime - (j * j2);
            long j4 = 60000;
            long j5 = j3 / j4;
            long j6 = (j3 - (j4 * j5)) / 1000;
            if (j2 <= 99 && j5 <= 60 && j6 <= 60) {
                int i = (int) (j6 % 10);
                TextView textView = this.hour;
                textView.setText(((int) (j2 / 10)) + "" + ((int) (j2 % 10)));
                this.minute.setText(((int) (j5 / 10)) + "" + ((int) (j5 % 10)));
                this.second.setText(((int) (j6 / 10)) + "" + i);
            } else {
                this.hour.setText("99");
                this.minute.setText("59");
                this.second.setText("59");
            }
            showCountDown();
            return;
        }
        hideCountDown();
        this.hour.setText("00");
        this.minute.setText("00");
        this.second.setText("00");
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null) {
            handlerTimer.stop();
            this.mTimer = null;
        }
        OnFinishListener onFinishListener = this.onFinishListener;
        if (onFinishListener != null) {
            onFinishListener.onFinish();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void updateCountDownViewTimeWithMilli() {
        if (this.countDownTimerContainer == null) {
            return;
        }
        long lastTime = getLastTime();
        if (lastTime > 0) {
            long j = 3600000;
            long j2 = lastTime / j;
            long j3 = lastTime - (j * j2);
            long j4 = 60000;
            long j5 = j3 / j4;
            long j6 = j3 - (j4 * j5);
            long j7 = 1000;
            long j8 = j6 / j7;
            long j9 = (j6 - (j7 * j8)) / 1;
            if (j2 <= 99 && j5 <= 60 && j8 <= 60 && (j2 != 0 || j5 != 0 || j8 != 0 || j9 != 0)) {
                int i = (int) (j9 / 100);
                int i2 = (int) ((j9 % 100) / 10);
                TextView textView = this.hour;
                textView.setText(((int) (j2 / 10)) + "" + ((int) (j2 % 10)));
                this.minute.setText(((int) (j5 / 10)) + "" + ((int) (j5 % 10)));
                this.second.setText(((int) (j8 / 10)) + "" + ((int) (j8 % 10)));
                int i3 = this.milliSecondDigitCount;
                if (i3 == 1) {
                    this.milli.setText(String.valueOf(i));
                } else if (i3 == 2) {
                    this.milli.setText(i + "" + i2);
                }
            } else {
                this.hour.setText("99");
                this.minute.setText("59");
                this.second.setText("59");
                int i4 = this.milliSecondDigitCount;
                if (i4 == 1) {
                    this.milli.setText("9");
                } else if (i4 == 2) {
                    this.milli.setText("99");
                }
            }
            showCountDown();
            return;
        }
        hideCountDown();
        this.hour.setText("00");
        this.minute.setText("00");
        this.second.setText("00");
        int i5 = this.milliSecondDigitCount;
        if (i5 == 1) {
            this.milli.setText("0");
        } else if (i5 == 2) {
            this.milli.setText("00");
        }
        HandlerTimer handlerTimer = this.mTimer;
        if (handlerTimer != null) {
            handlerTimer.stop();
            this.mTimer = null;
        }
        OnFinishListener onFinishListener = this.onFinishListener;
        if (onFinishListener != null) {
            onFinishListener.onFinish();
        }
    }

    public void updateCountView() {
        if (this.showMilliSecond) {
            updateCountDownViewTimeWithMilli();
        } else {
            updateCountDownViewTime();
        }
    }

    public DXNativeCountDownTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interval = 500;
        this.milliSecondDigitCount = 1;
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DXNativeCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DXNativeCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DXNativeCountDownTimerView.this.isShown() || DXNativeCountDownTimerView.this.futureTime <= 0) {
                        DXNativeCountDownTimerView.this.mTimer.stop();
                    } else {
                        DXNativeCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        };
        init();
    }

    public DXNativeCountDownTimerView(Context context) {
        super(context);
        this.interval = 500;
        this.milliSecondDigitCount = 1;
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DXNativeCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DXNativeCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DXNativeCountDownTimerView.this.isShown() || DXNativeCountDownTimerView.this.futureTime <= 0) {
                        DXNativeCountDownTimerView.this.mTimer.stop();
                    } else {
                        DXNativeCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        };
        init();
    }
}
