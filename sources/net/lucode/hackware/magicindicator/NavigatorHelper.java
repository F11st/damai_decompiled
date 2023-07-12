package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NavigatorHelper {
    private SparseBooleanArray a = new SparseBooleanArray();
    private SparseArray<Float> b = new SparseArray<>();
    private int c;
    private int d;
    private int e;
    private float f;
    private int g;
    private boolean h;
    private OnNavigatorScrollListener i;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnNavigatorScrollListener {
        void onDeselected(int i, int i2);

        void onEnter(int i, int i2, float f, boolean z);

        void onLeave(int i, int i2, float f, boolean z);

        void onSelected(int i, int i2);
    }

    private void a(int i) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onDeselected(i, this.c);
        }
        this.a.put(i, true);
    }

    private void b(int i, float f, boolean z, boolean z2) {
        if (this.h || i == this.d || this.g == 1 || z2) {
            OnNavigatorScrollListener onNavigatorScrollListener = this.i;
            if (onNavigatorScrollListener != null) {
                onNavigatorScrollListener.onEnter(i, this.c, f, z);
            }
            this.b.put(i, Float.valueOf(1.0f - f));
        }
    }

    private void c(int i, float f, boolean z, boolean z2) {
        if (!this.h && i != this.e && this.g != 1) {
            int i2 = this.d;
            if (((i != i2 - 1 && i != i2 + 1) || this.b.get(i, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onLeave(i, this.c, f, z);
        }
        this.b.put(i, Float.valueOf(f));
    }

    private void d(int i) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.i;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onSelected(i, this.c);
        }
        this.a.put(i, false);
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.c;
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(int i, float f, int i2) {
        boolean z;
        float f2 = i + f;
        float f3 = this.f;
        boolean z2 = f3 <= f2;
        if (this.g == 0) {
            for (int i3 = 0; i3 < this.c; i3++) {
                if (i3 != this.d) {
                    if (!this.a.get(i3)) {
                        a(i3);
                    }
                    if (this.b.get(i3, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i3, 1.0f, false, true);
                    }
                }
            }
            b(this.d, 1.0f, false, true);
            d(this.d);
        } else if (f2 == f3) {
            return;
        } else {
            int i4 = i + 1;
            if (f == 0.0f && z2) {
                i4 = i - 1;
                z = false;
            } else {
                z = true;
            }
            for (int i5 = 0; i5 < this.c; i5++) {
                if (i5 != i && i5 != i4 && this.b.get(i5, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    c(i5, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f4 = 1.0f - f;
                c(i4, f4, true, false);
                b(i, f4, true, false);
            } else if (z2) {
                c(i, f, true, false);
                b(i4, f, true, false);
            } else {
                float f5 = 1.0f - f;
                c(i4, f5, false, false);
                b(i, f5, false, false);
            }
        }
        this.f = f2;
    }

    public void j(int i) {
        this.e = this.d;
        this.d = i;
        d(i);
        for (int i2 = 0; i2 < this.c; i2++) {
            if (i2 != this.d && !this.a.get(i2)) {
                a(i2);
            }
        }
    }

    public void k(OnNavigatorScrollListener onNavigatorScrollListener) {
        this.i = onNavigatorScrollListener;
    }

    public void l(boolean z) {
        this.h = z;
    }

    public void m(int i) {
        this.c = i;
        this.a.clear();
        this.b.clear();
    }
}
