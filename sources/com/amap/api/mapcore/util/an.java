package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class an {
    private final Context a;
    private final InterfaceC4475a b;
    private boolean c;
    private MotionEvent d;
    private MotionEvent e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private final float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z = 0;
    private int A = 0;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.an$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4475a {
        boolean a(an anVar);

        boolean b(an anVar);

        void c(an anVar);
    }

    public an(Context context, InterfaceC4475a interfaceC4475a) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a = context;
        this.b = interfaceC4475a;
        this.r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float b(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void l() {
        MotionEvent motionEvent = this.d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.d = null;
        }
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.u = false;
        this.c = false;
        this.w = -1;
        this.x = -1;
        this.v = false;
    }

    public MotionEvent a() {
        return this.e;
    }

    public float c() {
        return this.g;
    }

    public float d() {
        if (this.l == -1.0f) {
            float f = this.j;
            float f2 = this.k;
            this.l = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.l;
    }

    public float e() {
        return this.j;
    }

    public float f() {
        return this.k;
    }

    public float g() {
        if (this.m == -1.0f) {
            float f = this.h;
            float f2 = this.i;
            this.m = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.m;
    }

    public float h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public float j() {
        if (this.n == -1.0f) {
            this.n = d() / g();
        }
        return this.n;
    }

    public long k() {
        return this.q;
    }

    public void a(int i, int i2) {
        this.z = i;
        this.A = i2;
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        MotionEvent motionEvent3 = this.d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.x);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x = motionEvent3.getX(findPointerIndex);
            float y = motionEvent3.getY(findPointerIndex);
            float x2 = motionEvent3.getX(findPointerIndex2);
            float y2 = motionEvent3.getY(findPointerIndex2);
            float x3 = motionEvent.getX(findPointerIndex3);
            float y3 = motionEvent.getY(findPointerIndex3);
            float x4 = motionEvent.getX(findPointerIndex4) - x3;
            float y4 = motionEvent.getY(findPointerIndex4) - y3;
            this.h = x2 - x;
            this.i = y2 - y;
            this.j = x4;
            this.k = y4;
            this.f = x3 + (x4 * 0.5f);
            this.g = y3 + (y4 * 0.5f);
            this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
            this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
            return;
        }
        this.v = true;
        if (this.c) {
            this.b.c(this);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        int a;
        int a2;
        int i;
        int i2;
        int i3;
        int a3;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            l();
        }
        boolean z = false;
        if (this.v) {
            return false;
        }
        if (this.c) {
            if (action == 1) {
                l();
            } else if (action == 2) {
                b(motionEvent);
                if (this.o / this.p > 0.67f && this.b.a(this)) {
                    this.d.recycle();
                    this.d = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.b.c(this);
                l();
            } else if (action == 5) {
                this.b.c(this);
                int i4 = this.w;
                int i5 = this.x;
                l();
                this.d = MotionEvent.obtain(motionEvent);
                if (!this.y) {
                    i4 = i5;
                }
                this.w = i4;
                if (Build.VERSION.SDK_INT >= 8) {
                    this.x = motionEvent.getPointerId(motionEvent.getActionIndex());
                } else {
                    this.x = motionEvent.getPointerId(1);
                }
                this.y = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.w);
                if (findPointerIndex < 0 || this.w == this.x) {
                    int i6 = this.w;
                    int i7 = this.x;
                    this.w = motionEvent.getPointerId(a(motionEvent, i6 != i7 ? i7 : -1, findPointerIndex));
                }
                b(motionEvent);
                this.c = this.b.b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i8 = this.w;
                    if (pointerId == i8) {
                        int a4 = a(motionEvent, this.x, actionIndex);
                        if (a4 >= 0) {
                            this.b.c(this);
                            this.w = motionEvent.getPointerId(a4);
                            this.y = true;
                            this.d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                            this.c = this.b.b(this);
                            this.d.recycle();
                            this.d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        }
                        z = true;
                        this.d.recycle();
                        this.d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    } else {
                        if (pointerId == this.x) {
                            int a5 = a(motionEvent, i8, actionIndex);
                            if (a5 >= 0) {
                                this.b.c(this);
                                this.x = motionEvent.getPointerId(a5);
                                this.y = false;
                                this.d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                this.c = this.b.b(this);
                            }
                            z = true;
                        }
                        this.d.recycle();
                        this.d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    }
                } else {
                    z = true;
                }
                if (z) {
                    b(motionEvent);
                    int i9 = this.w;
                    if (pointerId == i9) {
                        i9 = this.x;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i9);
                    this.f = motionEvent.getX(findPointerIndex2);
                    this.g = motionEvent.getY(findPointerIndex2);
                    this.b.c(this);
                    l();
                    this.w = i9;
                    this.y = true;
                }
            }
        } else if (action == 0) {
            this.w = motionEvent.getPointerId(0);
            this.y = true;
        } else if (action == 1) {
            l();
        } else if (action != 2) {
            if (action != 5) {
                if (action == 6 && this.u) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    int actionIndex2 = Build.VERSION.SDK_INT >= 8 ? motionEvent.getActionIndex() : 0;
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    if (pointerCount2 > 2) {
                        int i10 = this.w;
                        if (pointerId2 == i10) {
                            int a6 = a(motionEvent, this.x, actionIndex2);
                            if (a6 >= 0) {
                                this.w = motionEvent.getPointerId(a6);
                            }
                        } else if (pointerId2 == this.x && (a3 = a(motionEvent, i10, actionIndex2)) >= 0) {
                            this.x = motionEvent.getPointerId(a3);
                        }
                    } else {
                        int i11 = this.w;
                        if (pointerId2 == i11) {
                            i11 = this.x;
                        }
                        int findPointerIndex3 = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex3 < 0) {
                            this.v = true;
                            if (this.c) {
                                this.b.c(this);
                            }
                            return false;
                        }
                        this.w = motionEvent.getPointerId(findPointerIndex3);
                        this.y = true;
                        this.x = -1;
                        this.f = motionEvent.getX(findPointerIndex3);
                        this.g = motionEvent.getY(findPointerIndex3);
                    }
                }
            } else {
                int i12 = this.z;
                if (i12 != 0 && (i3 = this.A) != 0) {
                    float f = this.r;
                    this.s = i12 - f;
                    this.t = i3 - f;
                } else {
                    DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
                    float f2 = this.r;
                    this.s = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - f2;
                    this.t = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) - f2;
                }
                MotionEvent motionEvent2 = this.d;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.d = MotionEvent.obtain(motionEvent);
                this.q = 0L;
                if (Build.VERSION.SDK_INT >= 8) {
                    i = motionEvent.getActionIndex();
                    i2 = motionEvent.findPointerIndex(this.w);
                    int pointerId3 = motionEvent.getPointerId(i);
                    this.x = pointerId3;
                    if (i2 < 0 || i2 == i) {
                        i2 = a(motionEvent, i2 != i ? pointerId3 : -1, i2);
                        this.w = motionEvent.getPointerId(i2);
                    }
                } else if (motionEvent.getPointerCount() > 0) {
                    i = motionEvent.findPointerIndex(1);
                    i2 = motionEvent.findPointerIndex(this.w);
                    this.x = motionEvent.getPointerId(i);
                } else {
                    i = 0;
                    i2 = 0;
                }
                this.y = false;
                b(motionEvent);
                float f3 = this.r;
                float f4 = this.s;
                float f5 = this.t;
                float a7 = a(motionEvent, i2);
                float b = b(motionEvent, i2);
                float a8 = a(motionEvent, i);
                float b2 = b(motionEvent, i);
                boolean z2 = a7 < f3 || b < f3 || a7 > f4 || b > f5;
                boolean z3 = a8 < f3 || b2 < f3 || a8 > f4 || b2 > f5;
                if (z2 && z3) {
                    this.f = -1.0f;
                    this.g = -1.0f;
                    this.u = true;
                } else if (z2) {
                    this.f = motionEvent.getX(i);
                    this.g = motionEvent.getY(i);
                    this.u = true;
                } else if (z3) {
                    this.f = motionEvent.getX(i2);
                    this.g = motionEvent.getY(i2);
                    this.u = true;
                } else {
                    this.u = false;
                    this.c = this.b.b(this);
                }
            }
        } else if (this.u) {
            float f6 = this.r;
            float f7 = this.s;
            float f8 = this.t;
            int findPointerIndex4 = motionEvent.findPointerIndex(this.w);
            int findPointerIndex5 = motionEvent.findPointerIndex(this.x);
            float a9 = a(motionEvent, findPointerIndex4);
            float b3 = b(motionEvent, findPointerIndex4);
            float a10 = a(motionEvent, findPointerIndex5);
            float b4 = b(motionEvent, findPointerIndex5);
            boolean z4 = a9 < f6 || b3 < f6 || a9 > f7 || b3 > f8;
            boolean z5 = a10 < f6 || b4 < f6 || a10 > f7 || b4 > f8;
            if (z4 && (a2 = a(motionEvent, this.x, findPointerIndex4)) >= 0) {
                this.w = motionEvent.getPointerId(a2);
                a(motionEvent, a2);
                b(motionEvent, a2);
                findPointerIndex4 = a2;
                z4 = false;
            }
            if (z5 && (a = a(motionEvent, this.w, findPointerIndex5)) >= 0) {
                this.x = motionEvent.getPointerId(a);
                a(motionEvent, a);
                b(motionEvent, a);
                findPointerIndex5 = a;
                z5 = false;
            }
            if (z4 && z5) {
                this.f = -1.0f;
                this.g = -1.0f;
            } else if (z4) {
                this.f = motionEvent.getX(findPointerIndex5);
                this.g = motionEvent.getY(findPointerIndex5);
            } else if (z5) {
                this.f = motionEvent.getX(findPointerIndex4);
                this.g = motionEvent.getY(findPointerIndex4);
            } else {
                this.u = false;
                this.c = this.b.b(this);
            }
        }
        return true;
    }

    public float b() {
        return this.f;
    }

    private int a(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != findPointerIndex) {
                float f = this.r;
                float f2 = this.s;
                float f3 = this.t;
                float a = a(motionEvent, i3);
                float b = b(motionEvent, i3);
                if (a >= f && b >= f && a <= f2 && b <= f3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static float a(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }
}
