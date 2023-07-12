package com.alibaba.android.bindingx.core.internal;

import android.view.MotionEvent;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RotationGestureDetector {
    private long a;
    private double b;
    private double c;
    private boolean d;
    private int[] e = new int[2];
    private OnRotationGestureListener f;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface OnRotationGestureListener {
        void onRotation(RotationGestureDetector rotationGestureDetector);

        void onRotationBegin(RotationGestureDetector rotationGestureDetector);

        void onRotationEnd(RotationGestureDetector rotationGestureDetector);
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.f = onRotationGestureListener;
    }

    private void a() {
        if (this.d) {
            this.d = false;
            int[] iArr = this.e;
            iArr[0] = -1;
            iArr[1] = -1;
            OnRotationGestureListener onRotationGestureListener = this.f;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.onRotationEnd(this);
            }
            this.c = 0.0d;
            this.b = 0.0d;
        }
    }

    private void e(MotionEvent motionEvent) {
        this.a = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.e[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.e[1]);
        if (findPointerIndex == -1 || findPointerIndex2 == -1) {
            return;
        }
        float x = motionEvent.getX(findPointerIndex);
        double d = -Math.atan2(motionEvent.getY(findPointerIndex2) - motionEvent.getY(findPointerIndex), motionEvent.getX(findPointerIndex2) - x);
        if (Double.isNaN(this.b)) {
            this.c = 0.0d;
        } else {
            this.c = this.b - d;
        }
        this.b = d;
        double d2 = this.c;
        if (d2 > 3.141592653589793d) {
            this.c = d2 - 3.141592653589793d;
        } else if (d2 < -3.141592653589793d) {
            this.c = d2 + 3.141592653589793d;
        }
        double d3 = this.c;
        if (d3 > 1.5707963267948966d) {
            this.c = d3 - 3.141592653589793d;
        } else if (d3 < -1.5707963267948966d) {
            this.c = d3 + 3.141592653589793d;
        }
    }

    public double b() {
        return this.c;
    }

    public double c() {
        return Math.toDegrees(b());
    }

    public boolean d(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.d = false;
            this.e[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.e[1] = -1;
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked != 5) {
                if (actionMasked == 6 && this.d) {
                    int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int[] iArr = this.e;
                    if (pointerId == iArr[0] || pointerId == iArr[1]) {
                        a();
                    }
                }
            } else if (!this.d) {
                this.e[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.d = true;
                motionEvent.getEventTime();
                this.b = Double.NaN;
                e(motionEvent);
                OnRotationGestureListener onRotationGestureListener = this.f;
                if (onRotationGestureListener != null) {
                    onRotationGestureListener.onRotationBegin(this);
                }
            }
        } else if (this.d) {
            int[] iArr2 = this.e;
            if (iArr2[0] != -1 && iArr2[1] != -1) {
                e(motionEvent);
                if (this.f != null && c() != 0.0d) {
                    this.f.onRotation(this);
                }
            }
        }
        return true;
    }
}
