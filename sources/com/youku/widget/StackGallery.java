package com.youku.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import androidx.viewpager.widget.ViewPager;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StackGallery extends Gallery {
    private static final int MSG_STACKGALLERY_MOVE = 1;
    private static final int MSG_STACKGALLERY_REQUESTLAYOUT = 2;
    private static final long TIME_STACKGALLERY_MOVE = 5000;
    private String TAG;
    private boolean isNeedRefresh;
    private Handler mHandler;
    private MotionEvent mMotionEvent;
    private ViewPager mViewPager;

    public StackGallery(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
        this.mViewPager = null;
        this.isNeedRefresh = true;
        this.mHandler = new Handler() { // from class: com.youku.widget.StackGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1) {
                    if (i == 2 && YoukuUIUtil.viewSize(StackGallery.this) == 1.0d) {
                        StackGallery.this.requestLayout();
                        return;
                    }
                    return;
                }
                StackGallery.this.scrollToRight();
            }
        };
        setSoundEffectsEnabled(false);
    }

    private int isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return -1;
        }
        return motionEvent2.getX() > motionEvent.getX() ? 0 : 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void endMove() {
        this.mHandler.removeMessages(1);
    }

    public boolean isNeedRefresh() {
        return this.isNeedRefresh;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        endMove();
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int isScrollingLeft = isScrollingLeft(motionEvent, motionEvent2);
        if (isScrollingLeft == 0) {
            scrollToLeft();
            return false;
        } else if (isScrollingLeft == 1) {
            scrollToRight();
            return false;
        } else {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
            super.onTouchEvent(motionEvent);
            return onInterceptTouchEvent;
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(motionEvent.getX() - this.mMotionEvent.getX()) > 20.0f || Math.abs(motionEvent.getY() - this.mMotionEvent.getY()) > 20.0f) {
                return true;
            }
            return onInterceptTouchEvent;
        } else {
            return onInterceptTouchEvent;
        }
    }

    @Override // android.widget.Gallery, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.mViewPager != null && motionEvent.getAction() == 0) {
                this.mViewPager.requestDisallowInterceptTouchEvent(true);
            }
            endMove();
        } else if (action == 1) {
            startMove();
        } else if (action == 3) {
            startMove();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.isNeedRefresh = true;
            startMove();
            return;
        }
        endMove();
    }

    public void scrollToLeft() {
        endMove();
        onScroll(null, null, -1.0f, 0.0f);
        super.onKeyDown(21, null);
        startMove();
    }

    public void scrollToRight() {
        endMove();
        if (getGlobalVisibleRect(new Rect())) {
            onScroll(null, null, 1.0f, 0.0f);
            onKeyDown(22, null);
            this.mHandler.sendEmptyMessageDelayed(2, 500L);
        }
        startMove();
    }

    public void setNeedRefresh(boolean z) {
        this.isNeedRefresh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    public void startMove() {
        endMove();
        this.mHandler.sendEmptyMessageDelayed(1, 5000L);
    }

    public StackGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = getClass().getSimpleName();
        this.mViewPager = null;
        this.isNeedRefresh = true;
        this.mHandler = new Handler() { // from class: com.youku.widget.StackGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1) {
                    if (i == 2 && YoukuUIUtil.viewSize(StackGallery.this) == 1.0d) {
                        StackGallery.this.requestLayout();
                        return;
                    }
                    return;
                }
                StackGallery.this.scrollToRight();
            }
        };
        setSoundEffectsEnabled(false);
    }

    public StackGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getSimpleName();
        this.mViewPager = null;
        this.isNeedRefresh = true;
        this.mHandler = new Handler() { // from class: com.youku.widget.StackGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2 && YoukuUIUtil.viewSize(StackGallery.this) == 1.0d) {
                        StackGallery.this.requestLayout();
                        return;
                    }
                    return;
                }
                StackGallery.this.scrollToRight();
            }
        };
    }
}
