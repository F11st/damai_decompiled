package com.youku.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuScrollerGallery extends Gallery {
    private final int MSG_SLIDE;
    private final long PERIOD;
    Handler handler;
    private boolean isAutoSlideMode;

    public YoukuScrollerGallery(Context context) {
        super(context);
        this.MSG_SLIDE = 100140;
        this.PERIOD = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.handler = new Handler() { // from class: com.youku.widget.YoukuScrollerGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100140) {
                    return;
                }
                YoukuScrollerGallery.this.scrollToRight();
                sendEmptyMessageDelayed(100140, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        };
    }

    private int isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return -1;
        }
        return motionEvent2.getX() > motionEvent.getX() ? 0 : 1;
    }

    public void cancelAutoSlide() {
        this.handler.removeMessages(100140);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            cancelAutoSlide();
        } else if (action == 1) {
            startAutoSlide();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean isAutoSlideMode() {
        return this.isAutoSlideMode;
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAutoSlide();
        } else {
            cancelAutoSlide();
        }
    }

    public void scrollToLeft() {
        cancelAutoSlide();
        onScroll(null, null, -1.0f, 0.0f);
        super.onKeyDown(21, null);
        startAutoSlide();
    }

    public void scrollToRight() {
        cancelAutoSlide();
        onScroll(null, null, 1.0f, 0.0f);
        super.onKeyDown(22, null);
        startAutoSlide();
    }

    public void startAutoSlide() {
        cancelAutoSlide();
        this.handler.sendEmptyMessageDelayed(100140, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    public YoukuScrollerGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MSG_SLIDE = 100140;
        this.PERIOD = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.handler = new Handler() { // from class: com.youku.widget.YoukuScrollerGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100140) {
                    return;
                }
                YoukuScrollerGallery.this.scrollToRight();
                sendEmptyMessageDelayed(100140, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        };
        setSoundEffectsEnabled(false);
    }

    public YoukuScrollerGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MSG_SLIDE = 100140;
        this.PERIOD = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.handler = new Handler() { // from class: com.youku.widget.YoukuScrollerGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100140) {
                    return;
                }
                YoukuScrollerGallery.this.scrollToRight();
                sendEmptyMessageDelayed(100140, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        };
    }
}
