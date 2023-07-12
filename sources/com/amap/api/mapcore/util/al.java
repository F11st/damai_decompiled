package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class al extends aj {
    private static final PointF n = new PointF();
    private final a o;
    private boolean p;
    private PointF q;
    private PointF r;
    private PointF s;
    private PointF t;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        boolean a(al alVar);

        boolean b(al alVar);

        void c(al alVar);
    }

    public al(Context context, a aVar) {
        super(context);
        this.s = new PointF();
        this.t = new PointF();
        this.o = aVar;
    }

    @Override // com.amap.api.mapcore.util.ak
    protected void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 2) {
            if (this.p) {
                boolean c = c(motionEvent, i2, i3);
                this.p = c;
                if (c) {
                    return;
                }
                this.f = this.o.b(this);
            }
        } else if (i != 5) {
        } else {
            a();
            this.g = MotionEvent.obtain(motionEvent);
            this.k = 0L;
            a(motionEvent);
            boolean c2 = c(motionEvent, i2, i3);
            this.p = c2;
            if (c2) {
                return;
            }
            this.f = this.o.b(this);
        }
    }

    public PointF d() {
        return this.t;
    }

    @Override // com.amap.api.mapcore.util.ak
    protected void a(int i, MotionEvent motionEvent) {
        if (i == 2) {
            a(motionEvent);
            if (this.i / this.j <= 0.67f || !this.o.a(this)) {
                return;
            }
            this.g.recycle();
            this.g = MotionEvent.obtain(motionEvent);
        } else if (i == 3) {
            if (!this.p) {
                this.o.c(this);
            }
            a();
        } else if (i != 6) {
        } else {
            a(motionEvent);
            if (!this.p) {
                this.o.c(this);
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ak
    public void a() {
        super.a();
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.aj, com.amap.api.mapcore.util.ak
    public void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.g;
        this.q = ak.b(motionEvent);
        this.r = ak.b(motionEvent2);
        if (this.g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = n;
        } else {
            PointF pointF2 = this.q;
            float f = pointF2.x;
            PointF pointF3 = this.r;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.t = pointF;
        PointF pointF4 = this.s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
