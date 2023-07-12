package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLongClickListener implements View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private SpannableString buffer;
    private BaseLongClickableSpan mClickableSpan;
    private int mDownX;
    private int mDownY;
    private TextView mTextView;
    private String selectUserName;
    private Timer timer;
    private int mStart = -1;
    private int mEnd = -1;
    private boolean isLongPress = false;
    private boolean isLongPressState = false;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class LongPressTimerTask extends TimerTask {
        final long longPressTime = ViewConfiguration.getLongPressTimeout();
        int start = 0;

        LongPressTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = this.start;
            if (i >= this.longPressTime) {
                if (DagoLongClickListener.this.timer != null) {
                    DagoLongClickListener.this.timer.cancel();
                }
                DagoLongClickListener.this.isLongPress = true;
                DagoLongClickListener.this.isLongPressState = false;
                if (DagoLongClickListener.this.mClickableSpan != null) {
                    DagoLongClickListener.this.mClickableSpan.onLongClick(DagoLongClickListener.this.selectUserName);
                    return;
                }
                return;
            }
            this.start = i + 1;
        }
    }

    private void clearClickSpanBackground() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818281712")) {
            ipChange.ipc$dispatch("1818281712", new Object[]{this});
            return;
        }
        int i2 = this.mStart;
        if (i2 < 0 || (i = this.mEnd) < i2 || i >= this.buffer.length()) {
            return;
        }
        this.buffer.setSpan(new BackgroundColorSpan(0), this.mStart, this.mEnd, 33);
        this.mStart = -1;
        this.mEnd = -1;
    }

    private void getClickableSpan(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847223757")) {
            ipChange.ipc$dispatch("1847223757", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mClickableSpan == null) {
            try {
                Layout layout = this.mTextView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), i);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    this.mClickableSpan = (BaseLongClickableSpan) clickableSpanArr[0];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setClickSpanBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521185989")) {
            ipChange.ipc$dispatch("521185989", new Object[]{this});
            return;
        }
        this.mStart = this.buffer.getSpanStart(this.mClickableSpan);
        int spanEnd = this.buffer.getSpanEnd(this.mClickableSpan);
        this.mEnd = spanEnd;
        int i = this.mStart;
        if (i >= 0 && spanEnd >= i) {
            this.buffer.setSpan(new BackgroundColorSpan(-1291845632), this.mStart, this.mEnd, 33);
        }
        this.selectUserName = this.buffer.subSequence(this.mStart, this.mEnd).toString();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109100220")) {
            return ((Boolean) ipChange.ipc$dispatch("-109100220", new Object[]{this, view, motionEvent})).booleanValue();
        }
        this.mTextView = (TextView) view;
        this.buffer = new SpannableString(this.mTextView.getText());
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        getClickableSpan(x, y);
        if (this.mClickableSpan != null) {
            if (action == 0) {
                setClickSpanBackground();
                this.mDownX = x;
                this.mDownY = y;
                if (!this.isLongPressState) {
                    this.isLongPressState = true;
                    Timer timer = new Timer();
                    this.timer = timer;
                    timer.schedule(new LongPressTimerTask(), 0L, 1L);
                }
                this.mTextView.setText(this.buffer);
            } else if (action == 1 || action == 3 || action == 4) {
                clearClickSpanBackground();
                int i = x - this.mDownX;
                int i2 = y - this.mDownY;
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                if (Math.abs(i) <= scaledTouchSlop && Math.abs(i2) <= scaledTouchSlop && !this.isLongPress) {
                    this.mClickableSpan.onClick(this.mTextView);
                }
                Timer timer2 = this.timer;
                if (timer2 != null) {
                    timer2.cancel();
                }
                this.isLongPress = false;
                this.isLongPressState = false;
                this.mTextView.setText(this.buffer);
                this.mClickableSpan = null;
            } else if (action == 2) {
                int i3 = x - this.mDownX;
                int i4 = y - this.mDownY;
                int scaledTouchSlop2 = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                if (!this.isLongPress && (Math.abs(i3) > scaledTouchSlop2 || Math.abs(i4) > scaledTouchSlop2)) {
                    Timer timer3 = this.timer;
                    if (timer3 != null) {
                        timer3.cancel();
                    }
                    this.isLongPressState = false;
                }
            }
            return true;
        }
        return false;
    }
}
