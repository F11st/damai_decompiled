package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.AbstractC3291c;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.C3307g;
import java.util.HashMap;
import java.util.Map;
import tb.py1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.vlayout.layout.g */
/* loaded from: classes15.dex */
public class C3307g<T extends C3307g> {
    protected BaseLayoutHelper a;
    protected T b;
    protected py1<Integer> e;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    private View p;
    private int q;
    private BaseLayoutHelper.LayoutViewUnBindListener r;
    private BaseLayoutHelper.LayoutViewBindListener s;
    private int c = 0;
    private int d = 0;
    protected HashMap<py1<Integer>, T> f = new HashMap<>();
    protected Rect o = new Rect();

    private void M(LayoutManagerHelper layoutManagerHelper, C3307g<T> c3307g) {
        for (Map.Entry<py1<Integer>, T> entry : c3307g.f.entrySet()) {
            T value = entry.getValue();
            if (!value.O()) {
                M(layoutManagerHelper, value);
            }
            View view = value.p;
            if (view != null) {
                layoutManagerHelper.hideView(view);
            }
        }
    }

    private void N(LayoutManagerHelper layoutManagerHelper) {
        if (S()) {
            M(layoutManagerHelper, this);
            View view = this.p;
            if (view != null) {
                layoutManagerHelper.hideView(view);
            }
        }
    }

    private boolean T(int i) {
        return (i == Integer.MAX_VALUE || i == Integer.MIN_VALUE) ? false : true;
    }

    private void W(LayoutManagerHelper layoutManagerHelper, C3307g<T> c3307g) {
        if (!c3307g.O()) {
            for (Map.Entry<py1<Integer>, T> entry : c3307g.f.entrySet()) {
                W(layoutManagerHelper, entry.getValue());
            }
        }
        View view = c3307g.p;
        if (view != null) {
            BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = c3307g.r;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, y());
            }
            layoutManagerHelper.removeChildView(c3307g.p);
            c3307g.p = null;
        }
    }

    private boolean X(C3307g<T> c3307g) {
        boolean z = (c3307g.q == 0 && c3307g.s == null) ? false : true;
        for (Map.Entry<py1<Integer>, T> entry : c3307g.f.entrySet()) {
            T value = entry.getValue();
            if (!value.O()) {
                z |= X(value);
            } else {
                return value.Y();
            }
        }
        return z;
    }

    private void e(LayoutManagerHelper layoutManagerHelper, C3307g<T> c3307g) {
        View view = c3307g.p;
        if (view != null) {
            BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = c3307g.r;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, y());
            }
            layoutManagerHelper.removeChildView(c3307g.p);
            c3307g.p = null;
        }
        if (c3307g.f.isEmpty()) {
            return;
        }
        for (Map.Entry<py1<Integer>, T> entry : c3307g.f.entrySet()) {
            e(layoutManagerHelper, entry.getValue());
        }
    }

    private void g0(C3307g<T> c3307g) {
        if (c3307g.O()) {
            return;
        }
        for (Map.Entry<py1<Integer>, T> entry : c3307g.f.entrySet()) {
            T value = entry.getValue();
            g0(value);
            View view = value.p;
            if (view != null) {
                c3307g.o.union(view.getLeft(), value.p.getTop(), value.p.getRight(), value.p.getBottom());
            }
        }
    }

    public int A() {
        return this.k;
    }

    public int B() {
        return this.l;
    }

    public int C() {
        return this.m;
    }

    public int D() {
        return this.d;
    }

    public int E() {
        return this.c;
    }

    public int F() {
        return this.j;
    }

    public int G() {
        return this.g;
    }

    public int H() {
        return this.h;
    }

    public int I() {
        return this.i;
    }

    public py1<Integer> J() {
        return this.e;
    }

    protected int K() {
        return this.m + this.n;
    }

    protected int L() {
        return this.i + this.j;
    }

    public boolean O() {
        return this.f.isEmpty();
    }

    public boolean P(int i) {
        py1<Integer> py1Var = this.e;
        return py1Var != null && py1Var.d().intValue() == i;
    }

    public boolean Q(int i) {
        py1<Integer> py1Var = this.e;
        return py1Var != null && py1Var.e().intValue() == i;
    }

    public boolean R(int i) {
        py1<Integer> py1Var = this.e;
        return py1Var == null || !py1Var.a(Integer.valueOf(i));
    }

    public boolean S() {
        return this.b == null;
    }

    public void U(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChildWithMargins(view, i, i2, i3, i4);
        f(i, i2, i3, i4, z);
    }

    public void V(LayoutManagerHelper layoutManagerHelper) {
        e(layoutManagerHelper, this);
    }

    public boolean Y() {
        boolean z = (this.q == 0 && this.s == null) ? false : true;
        return !O() ? z | X(this) : z;
    }

    public void Z(int i) {
        this.q = i;
    }

    public void a(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        if (!O()) {
            for (Map.Entry<py1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().a(i, i2, layoutManagerHelper);
            }
        }
        if (Y()) {
            Rect rect = new Rect();
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            for (int i3 = 0; i3 < layoutManagerHelper.getChildCount(); i3++) {
                View childAt = layoutManagerHelper.getChildAt(i3);
                if (J().a(Integer.valueOf(layoutManagerHelper.getPosition(childAt)))) {
                    if (childAt.getVisibility() == 8) {
                        rect.setEmpty();
                    } else {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                        if (layoutManagerHelper.getOrientation() == 1) {
                            rect.union(layoutManagerHelper.getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, mainOrientationHelper.d(childAt));
                        } else {
                            rect.union(mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, mainOrientationHelper.d(childAt), layoutManagerHelper.getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    }
                }
            }
            if (!rect.isEmpty()) {
                this.o.set(rect.left - this.g, rect.top - this.i, rect.right + this.h, rect.bottom + this.j);
            } else {
                this.o.setEmpty();
            }
            View view = this.p;
            if (view != null) {
                Rect rect2 = this.o;
                view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    public void a0(BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener) {
        this.s = layoutViewBindListener;
    }

    public void b(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (!O()) {
            for (Map.Entry<py1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().b(recycler, state, i, i2, i3, layoutManagerHelper);
            }
        }
        if (Y()) {
            if (T(i3) && (view = this.p) != null) {
                this.o.union(view.getLeft(), this.p.getTop(), this.p.getRight(), this.p.getBottom());
            }
            if (!this.o.isEmpty()) {
                if (T(i3)) {
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.o.offset(0, -i3);
                    } else {
                        this.o.offset(-i3, 0);
                    }
                }
                g0(this);
                int contentWidth = layoutManagerHelper.getContentWidth();
                int contentHeight = layoutManagerHelper.getContentHeight();
                if (layoutManagerHelper.getOrientation() != 1 ? this.o.intersects((-contentWidth) / 4, 0, contentWidth + (contentWidth / 4), contentHeight) : this.o.intersects(0, (-contentHeight) / 4, contentWidth, contentHeight + (contentHeight / 4))) {
                    if (this.p == null) {
                        View generateLayoutView = layoutManagerHelper.generateLayoutView();
                        this.p = generateLayoutView;
                        layoutManagerHelper.addBackgroundView(generateLayoutView, true);
                    }
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.o.left = layoutManagerHelper.getPaddingLeft() + n() + h();
                        this.o.right = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - o()) - i();
                    } else {
                        this.o.top = layoutManagerHelper.getPaddingTop() + p() + j();
                        this.o.bottom = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingBottom()) - m()) - g();
                    }
                    d(this.p);
                    N(layoutManagerHelper);
                    return;
                }
                this.o.set(0, 0, 0, 0);
                View view2 = this.p;
                if (view2 != null) {
                    view2.layout(0, 0, 0, 0);
                }
                N(layoutManagerHelper);
            }
        }
        N(layoutManagerHelper);
        if (S()) {
            W(layoutManagerHelper, this);
        }
    }

    public void b0(BaseLayoutHelper.C3297a c3297a) {
        this.s = c3297a;
        this.r = c3297a;
    }

    public void c(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (!O()) {
            for (Map.Entry<py1<Integer>, T> entry : this.f.entrySet()) {
                entry.getValue().c(recycler, state, layoutManagerHelper);
            }
        }
        if (Y() || (view = this.p) == null) {
            return;
        }
        BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener = this.r;
        if (layoutViewUnBindListener != null) {
            layoutViewUnBindListener.onUnbind(view, y());
        }
        layoutManagerHelper.removeChildView(this.p);
        this.p = null;
    }

    public void c0(BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener) {
        this.r = layoutViewUnBindListener;
    }

    public void d(@NonNull View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.o), 1073741824), View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.o), 1073741824));
        Rect rect = this.o;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setBackgroundColor(this.q);
        BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener = this.s;
        if (layoutViewBindListener != null) {
            layoutViewBindListener.onBind(view, y());
        }
        this.o.set(0, 0, 0, 0);
    }

    public void d0(int i, int i2, int i3, int i4) {
        this.k = i;
        this.m = i2;
        this.l = i3;
        this.n = i4;
    }

    public void e0(int i, int i2, int i3, int i4) {
        this.g = i;
        this.h = i3;
        this.i = i2;
        this.j = i4;
    }

    protected void f(int i, int i2, int i3, int i4, boolean z) {
        if (z) {
            this.o.union((i - this.g) - this.k, (i2 - this.i) - this.m, this.h + i3 + this.l, this.j + i4 + this.n);
        } else {
            this.o.union(i - this.g, i2 - this.i, this.h + i3, this.j + i4);
        }
        T t = this.b;
        if (t != null) {
            int i5 = this.k;
            t.f((i - this.g) - i5, (i2 - this.i) - i5, this.h + i3 + this.l, this.j + i4 + this.n, z);
        }
    }

    public void f0(int i, int i2) {
        this.e = py1.c(Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<py1<Integer>, T> entry : this.f.entrySet()) {
            T value = entry.getValue();
            int E = value.E() + i;
            int D = value.D() + i;
            hashMap.put(py1.c(Integer.valueOf(E), Integer.valueOf(D)), value);
            value.f0(E, D);
        }
        this.f.clear();
        this.f.putAll(hashMap);
    }

    public int g() {
        T t = this.b;
        if (t != null) {
            return t.g() + this.b.F();
        }
        return 0;
    }

    public int h() {
        T t = this.b;
        if (t != null) {
            return t.h() + this.b.G();
        }
        return 0;
    }

    public int i() {
        T t = this.b;
        if (t != null) {
            return t.i() + this.b.H();
        }
        return 0;
    }

    public int j() {
        T t = this.b;
        if (t != null) {
            return t.j() + this.b.I();
        }
        return 0;
    }

    public int k() {
        T t = this.b;
        return (t != null ? t.k() : 0) + w();
    }

    public int l() {
        T t = this.b;
        return (t != null ? t.l() : 0) + x();
    }

    public int m() {
        T t = this.b;
        return (t != null ? t.m() : 0) + this.n;
    }

    public int n() {
        T t = this.b;
        return (t != null ? t.n() : 0) + this.k;
    }

    public int o() {
        T t = this.b;
        return (t != null ? t.o() : 0) + this.l;
    }

    public int p() {
        T t = this.b;
        return (t != null ? t.p() : 0) + this.m;
    }

    public int q() {
        T t = this.b;
        return (t != null ? t.q() : 0) + this.j;
    }

    public int r() {
        T t = this.b;
        return (t != null ? t.r() : 0) + this.g;
    }

    public int s() {
        T t = this.b;
        return (t != null ? t.s() : 0) + this.h;
    }

    public int t() {
        T t = this.b;
        return (t != null ? t.t() : 0) + this.i;
    }

    public int u() {
        T t = this.b;
        return (t != null ? t.u() : 0) + K();
    }

    public int v() {
        T t = this.b;
        return (t != null ? t.v() : 0) + L();
    }

    protected int w() {
        return this.k + this.l;
    }

    protected int x() {
        return this.g + this.h;
    }

    public BaseLayoutHelper y() {
        BaseLayoutHelper baseLayoutHelper = this.a;
        if (baseLayoutHelper != null) {
            return baseLayoutHelper;
        }
        T t = this.b;
        if (t != null) {
            return t.y();
        }
        return null;
    }

    public int z() {
        return this.n;
    }
}
