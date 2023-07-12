package com.youku.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.StackView;
import androidx.viewpager.widget.ViewPager;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class YoukuHomePageStackView extends StackView {
    private static final int MSG_SLIDE = 10000110;
    private static final int PERIOD = 5000;
    public static final String TAG = "LXF";
    float dispatchDownXDistance;
    float dispatchDownYDistance;
    float dispatchUpXDistance;
    float dispatchUpYDistance;
    private Handler handler;
    private boolean isAutoSlideMode;
    private TimerTask task;
    private Timer timer;
    private ViewPager viewPagerFragment;

    public YoukuHomePageStackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dispatchDownXDistance = 0.0f;
        this.dispatchUpXDistance = 0.0f;
        this.dispatchDownYDistance = 0.0f;
        this.dispatchUpYDistance = 0.0f;
        this.handler = new Handler() { // from class: com.youku.widget.YoukuHomePageStackView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != YoukuHomePageStackView.MSG_SLIDE) {
                    return;
                }
                YoukuHomePageStackView.this.showNext();
                sendEmptyMessageDelayed(YoukuHomePageStackView.MSG_SLIDE, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        };
    }

    public void cancleTask() {
        this.handler.removeMessages(MSG_SLIDE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.viewPagerFragment = (ViewPager) getParent().getParent().getParent().getParent().getParent().getParent().getParent();
            this.dispatchDownXDistance = motionEvent.getX();
            this.dispatchDownYDistance = motionEvent.getY();
            cancleTask();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            this.dispatchUpXDistance = motionEvent.getX();
            float y = motionEvent.getY();
            this.dispatchUpYDistance = y;
            float f = this.dispatchUpXDistance;
            float f2 = this.dispatchDownXDistance;
            float f3 = f - f2;
            float f4 = f2 - f;
            float f5 = y - this.dispatchDownYDistance;
            getParent().requestDisallowInterceptTouchEvent(false);
            startAutoSlide();
            if (f3 > 100.0f && Math.abs(f5) < 30.0f) {
                this.viewPagerFragment.setCurrentItem(1);
                return false;
            } else if (f4 > 100.0f && Math.abs(f5) < 30.0f) {
                this.viewPagerFragment.setCurrentItem(3);
                return false;
            }
        } else if (action == 3) {
            startAutoSlide();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAutoSlide();
        } else {
            cancleTask();
        }
    }

    public void removeAllView() {
        removeAllViews();
    }

    public void startAutoSlide() {
        cancleTask();
        this.handler.sendEmptyMessageDelayed(MSG_SLIDE, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }
}
