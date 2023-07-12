package com.taobao.android.dinamic.view;

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

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DCountDownTimerView extends RelativeLayout {
    private static final String TAG = "DCountDownTimerView";
    private TextView colonFirst;
    private TextView colonSecond;
    private View countDownTimerContainer;
    private long futureTime;
    private boolean hasRegisterReceiver;
    private TextView hour;
    private boolean isAttached;
    private boolean isNativeTime;
    private final BroadcastReceiver mReceiver;
    private HandlerTimer mTimer;
    private TextView minute;
    private long offset;
    private TextView second;
    private TextView seeMoreView;

    public DCountDownTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamic.view.DCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DCountDownTimerView.this.isShown() || DCountDownTimerView.this.futureTime <= 0) {
                        DCountDownTimerView.this.mTimer.stop();
                    } else {
                        DCountDownTimerView.this.mTimer.start();
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
        this.colonFirst = (TextView) findViewById(R$id.tv_colon1);
        this.colonSecond = (TextView) findViewById(R$id.tv_colon2);
        this.countDownTimerContainer = findViewById(R$id.count_down_timer_view_container);
        this.seeMoreView = (TextView) findViewById(R$id.see_more_default);
    }

    public TextView getColonFirst() {
        return this.colonFirst;
    }

    public TextView getColonSecond() {
        return this.colonSecond;
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

    public TextView getMinute() {
        return this.minute;
    }

    public TextView getSecond() {
        return this.second;
    }

    public TextView getSeeMoreView() {
        return this.seeMoreView;
    }

    public HandlerTimer getTimer() {
        if (this.mTimer == null) {
            this.mTimer = new HandlerTimer(1000L, new Runnable() { // from class: com.taobao.android.dinamic.view.DCountDownTimerView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DCountDownTimerView.this.isAttached) {
                        DCountDownTimerView.this.updateCountDownViewTime();
                    }
                }
            });
        }
        return this.mTimer;
    }

    public void hideCountDown() {
        this.seeMoreView.setVisibility(0);
        this.countDownTimerContainer.setVisibility(8);
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

    public void showCountDown() {
        this.seeMoreView.setVisibility(8);
        this.countDownTimerContainer.setVisibility(0);
    }

    public void updateCountDownViewTime() {
        long j;
        long j2;
        long j3;
        if (this.countDownTimerContainer == null) {
            return;
        }
        long lastTime = getLastTime();
        if (lastTime > 0) {
            long j4 = 3600000;
            j2 = lastTime / j4;
            long j5 = lastTime - (j4 * j2);
            long j6 = 60000;
            j3 = j5 / j6;
            j = (j5 - (j6 * j3)) / 1000;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
        }
        if (j2 <= 99 && j3 <= 60 && j <= 60 && (j2 != 0 || j3 != 0 || j != 0)) {
            int i = (int) (j % 10);
            TextView textView = this.hour;
            textView.setText(((int) (j2 / 10)) + "" + ((int) (j2 % 10)));
            this.minute.setText(((int) (j3 / 10)) + "" + ((int) (j3 % 10)));
            this.second.setText(((int) (j / 10)) + "" + i);
            this.countDownTimerContainer.setVisibility(0);
            this.seeMoreView.setVisibility(8);
            return;
        }
        this.countDownTimerContainer.setVisibility(8);
        this.seeMoreView.setVisibility(0);
    }

    public DCountDownTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamic.view.DCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DCountDownTimerView.this.isShown() || DCountDownTimerView.this.futureTime <= 0) {
                        DCountDownTimerView.this.mTimer.stop();
                    } else {
                        DCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        };
        init();
    }

    public DCountDownTimerView(Context context) {
        super(context);
        this.isNativeTime = true;
        this.offset = 0L;
        this.mReceiver = new BroadcastReceiver() { // from class: com.taobao.android.dinamic.view.DCountDownTimerView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (DCountDownTimerView.this.mTimer == null) {
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    DCountDownTimerView.this.mTimer.stop();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!DCountDownTimerView.this.isShown() || DCountDownTimerView.this.futureTime <= 0) {
                        DCountDownTimerView.this.mTimer.stop();
                    } else {
                        DCountDownTimerView.this.mTimer.start();
                    }
                }
            }
        };
        init();
    }
}
