package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class aj extends ak {
    protected float a;
    protected float b;
    protected float c;
    protected float d;
    private final float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;

    public aj(Context context) {
        super(context);
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.n = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float b(MotionEvent motionEvent, int i, int i2) {
        float y = (i2 + motionEvent.getY()) - motionEvent.getRawY();
        if (i < motionEvent.getPointerCount()) {
            return motionEvent.getY(i) + y;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.q = -1.0f;
            this.r = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.a = x2 - x;
            this.b = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.c = x4 - x3;
            this.d = y4 - y3;
            this.s = x3 - x;
            this.t = y3 - y;
            this.u = x4 - x2;
            this.v = y4 - y2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(MotionEvent motionEvent, int i, int i2) {
        int i3;
        int i4 = this.l;
        if (i4 != 0 && (i3 = this.m) != 0) {
            float f = this.n;
            this.o = i4 - f;
            this.p = i3 - f;
        } else {
            DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
            float f2 = this.n;
            this.o = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - f2;
            this.p = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) - f2;
        }
        float f3 = this.n;
        float f4 = this.o;
        float f5 = this.p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = a(motionEvent, 1, i);
        float b = b(motionEvent, 1, i2);
        boolean z = rawX < f3 || rawY < f3 || rawX > f4 || rawY > f5;
        boolean z2 = a < f3 || b < f3 || a > f4 || b > f5;
        return (z && z2) || z || z2;
    }

    public PointF a(int i) {
        if (i == 0) {
            return new PointF(this.s, this.t);
        }
        return new PointF(this.u, this.v);
    }

    protected static float a(MotionEvent motionEvent, int i, int i2) {
        float x = (i2 + motionEvent.getX()) - motionEvent.getRawX();
        if (i < motionEvent.getPointerCount()) {
            return motionEvent.getX(i) + x;
        }
        return 0.0f;
    }
}
