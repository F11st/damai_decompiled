package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TouchTracker implements View.OnTouchListener {
    private final GestureDetector gestureDetector;
    private boolean isYawing;
    private final float scrollSlopPx;
    private final TouchEnabledVrView target;
    private PointF lastTouchPointPx = new PointF();
    private PointF startTouchPointPx = new PointF();
    private boolean touchTrackingEnabled = true;
    private boolean verticalTrackingEnabled = false;
    private boolean flingingEnabled = false;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class FlingGestureListener implements GestureDetector.OnGestureListener {
        private final Context context;
        private final OverScroller overScroller;
        private final View view;

        FlingGestureListener(Context context, View view) {
            this.context = context;
            this.view = view;
            OverScroller overScroller = new OverScroller(context);
            this.overScroller = overScroller;
            overScroller.setFriction(0.1f);
        }

        private void maybeStartFling(int i, int i2) {
            this.view.getParent().requestDisallowInterceptTouchEvent(false);
            if (Math.hypot(i, i2) < ViewConfiguration.get(this.context).getScaledMinimumFlingVelocity()) {
                return;
            }
            this.overScroller.forceFinished(true);
            final DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            OverScroller overScroller = this.overScroller;
            int round = Math.round(TouchTracker.this.lastTouchPointPx.x);
            int round2 = Math.round(TouchTracker.this.lastTouchPointPx.y);
            int round3 = Math.round(i);
            int round4 = TouchTracker.this.verticalTrackingEnabled ? Math.round(i2) : 0;
            int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            overScroller.fling(round, round2, round3, round4, i3 * (-100), i3 * 100, TouchTracker.this.verticalTrackingEnabled ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) * (-100) : 0, TouchTracker.this.verticalTrackingEnabled ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) * 100 : 0, 0, 0);
            final PointF pointF = new PointF(TouchTracker.this.lastTouchPointPx.x, TouchTracker.this.lastTouchPointPx.y);
            this.view.postOnAnimation(new Runnable() { // from class: com.google.vr.sdk.widgets.common.TouchTracker.FlingGestureListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FlingGestureListener.this.overScroller.isFinished()) {
                        return;
                    }
                    FlingGestureListener.this.overScroller.computeScrollOffset();
                    int currX = FlingGestureListener.this.overScroller.getCurrX();
                    int currY = FlingGestureListener.this.overScroller.getCurrY();
                    float f = currX;
                    TouchTracker.this.target.onPanningEvent(f - pointF.x, TouchTracker.this.verticalTrackingEnabled ? currY - pointF.y : 0.0f);
                    float f2 = currY;
                    pointF.set(f, f2);
                    TouchTracker.this.lastTouchPointPx.set(Math.min(currX, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)), f2);
                    FlingGestureListener.this.view.postOnAnimation(this);
                }
            });
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.overScroller.forceFinished(true);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            TouchTracker.this.startTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            TouchTracker.this.lastTouchPointPx.set(motionEvent2.getX(), motionEvent2.getY());
            maybeStartFling(Math.round(f), Math.round(f2));
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface TouchEnabledVrView {
        VrEventListener getEventListener();

        void onPanningEvent(float f, float f2);
    }

    public TouchTracker(Context context, View view, TouchEnabledVrView touchEnabledVrView) {
        this.gestureDetector = new GestureDetector(context, new FlingGestureListener(context, view));
        this.target = touchEnabledVrView;
        this.scrollSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.touchTrackingEnabled && this.flingingEnabled) {
            this.gestureDetector.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            this.lastTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            view.getParent().requestDisallowInterceptTouchEvent(true);
            this.isYawing = false;
            return true;
        } else if (action == 1) {
            if (!this.touchTrackingEnabled || (Math.abs(motionEvent.getX() - this.startTouchPointPx.x) < this.scrollSlopPx && Math.abs(motionEvent.getY() - this.startTouchPointPx.y) < this.scrollSlopPx)) {
                this.target.getEventListener().onClick();
            }
            view.getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        } else if (action != 2) {
            return false;
        } else {
            if (!this.touchTrackingEnabled) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            if (!this.isYawing) {
                if (!this.verticalTrackingEnabled && Math.abs(motionEvent.getY() - this.startTouchPointPx.y) > this.scrollSlopPx) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                } else if (Math.abs(motionEvent.getX() - this.startTouchPointPx.x) > this.scrollSlopPx) {
                    this.isYawing = true;
                }
            }
            this.target.onPanningEvent(motionEvent.getX() - this.lastTouchPointPx.x, this.verticalTrackingEnabled ? motionEvent.getY() - this.lastTouchPointPx.y : 0.0f);
            this.lastTouchPointPx.set(motionEvent.getX(), motionEvent.getY());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFlingingEnabled(boolean z) {
        this.flingingEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTouchTrackingEnabled(boolean z) {
        this.touchTrackingEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerticalTrackingEnabled(boolean z) {
        this.verticalTrackingEnabled = z;
    }
}
