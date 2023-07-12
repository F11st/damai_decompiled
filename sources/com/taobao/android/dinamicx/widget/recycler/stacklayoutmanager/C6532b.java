package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.b */
/* loaded from: classes12.dex */
public class C6532b {
    protected StackLayoutManager.ScrollOrientation a;
    protected int b;
    protected float c;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.b$a */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C6533a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[StackLayoutManager.ScrollOrientation.values().length];
            a = iArr;
            try {
                iArr[StackLayoutManager.ScrollOrientation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[StackLayoutManager.ScrollOrientation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[StackLayoutManager.ScrollOrientation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[StackLayoutManager.ScrollOrientation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C6532b(StackLayoutManager.ScrollOrientation scrollOrientation, int i, float f) {
        this.a = scrollOrientation;
        this.b = i;
        this.c = f;
    }

    private int b(int i, float f) {
        int i2 = C6533a.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return this.e / 2;
            }
            return (int) (this.g - (this.c * (i - f)));
        }
        return (int) (this.g + (this.c * (i - f)));
    }

    private int c(int i, float f) {
        int i2 = C6533a.a[this.a.ordinal()];
        if (i2 != 3) {
            if (i2 != 4) {
                return this.f / 2;
            }
            return (int) (this.g - (this.c * (i - f)));
        }
        return (int) (this.g + (this.c * (i - f)));
    }

    private int d() {
        int i = C6533a.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return this.e / 2;
            }
            int i2 = this.j;
            int i3 = this.h;
            if (i2 % i3 == 0) {
                return this.g;
            }
            return this.g + (i3 - (i2 % i3));
        }
        return this.g - (this.j % this.h);
    }

    private int e() {
        int i = C6533a.a[this.a.ordinal()];
        if (i != 3) {
            if (i != 4) {
                return this.f / 2;
            }
            int i2 = this.j;
            int i3 = this.i;
            if (i2 % i3 == 0) {
                return this.g;
            }
            return this.g + (i3 - (i2 % i3));
        }
        return this.g - (this.j % this.i);
    }

    private int f() {
        float f;
        float f2;
        int max;
        float f3;
        float f4;
        float f5;
        int max2;
        int i = C6533a.a[this.a.ordinal()];
        if (i != 1) {
            if (i == 2) {
                f4 = this.e;
                f5 = this.c;
                max2 = Math.max(0, this.b - 1);
            } else if (i != 3) {
                f4 = this.f;
                f5 = this.c;
                max2 = Math.max(0, this.b - 1);
            } else {
                f = this.f;
                f2 = this.c;
                max = Math.max(0, this.b - 1);
            }
            f3 = f4 + (f5 * max2);
            return (int) (f3 / 2.0f);
        }
        f = this.e;
        f2 = this.c;
        max = Math.max(0, this.b - 1);
        f3 = f - (f2 * max);
        return (int) (f3 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(StackLayoutManager stackLayoutManager, int i, float f, View view, int i2, C6531a c6531a) {
        int b;
        int c;
        this.h = stackLayoutManager.getWidth();
        this.i = stackLayoutManager.getHeight();
        this.j = i;
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            childAt.setClickable(true);
            childAt.setFocusable(true);
        }
        int decoratedMeasuredWidth = childAt == null ? stackLayoutManager.getDecoratedMeasuredWidth(view) : childAt.getMeasuredWidth();
        int decoratedMeasuredHeight = childAt == null ? stackLayoutManager.getDecoratedMeasuredHeight(view) : childAt.getMeasuredHeight();
        if (!this.d) {
            this.e = this.h - decoratedMeasuredWidth;
            this.f = this.i - decoratedMeasuredHeight;
            this.g = f();
            this.d = true;
        }
        if (i2 == 0) {
            b = d();
            c = e();
        } else {
            b = b(i2, f);
            c = c(i2, f);
        }
        float b2 = c6531a.b(f, i2);
        int i3 = C6533a.a[this.a.ordinal()];
        if (i3 == 1) {
            b += (int) ((decoratedMeasuredWidth * (1.0f - b2)) / 2.0f);
        } else if (i3 == 2) {
            b -= (int) ((decoratedMeasuredWidth * (1.0f - b2)) / 2.0f);
        } else if (i3 == 3) {
            c += (int) ((decoratedMeasuredWidth * (1.0f - b2)) / 2.0f);
        } else if (i3 == 4) {
            c -= (int) ((decoratedMeasuredHeight * (1.0f - b2)) / 2.0f);
        }
        int i4 = c;
        stackLayoutManager.layoutDecorated(view, b, i4, b + decoratedMeasuredWidth, i4 + decoratedMeasuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.d = false;
    }
}
