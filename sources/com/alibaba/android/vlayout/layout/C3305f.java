package com.alibaba.android.vlayout.layout;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.C3299b;
import java.util.Map;
import tb.py1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.vlayout.layout.f */
/* loaded from: classes6.dex */
public class C3305f extends BaseLayoutHelper {
    private static boolean d;
    private static final int e = View.MeasureSpec.makeMeasureSpec(0, 0);
    private C3306a a;
    private int b;
    private boolean c;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.layout.f$a */
    /* loaded from: classes6.dex */
    public static class C3306a extends C3307g<C3306a> {
        private float[] A;
        private View[] B;
        private int[] C;
        private int[] D;
        private float t = Float.NaN;
        private int u = 4;
        private int v = 0;
        private boolean w = true;
        @NonNull
        private C3299b.AbstractC3301b x;
        private int y;
        private int z;

        public C3306a() {
            C3299b.C3300a c3300a = new C3299b.C3300a();
            this.x = c3300a;
            this.y = 0;
            this.z = 0;
            this.A = new float[0];
            c3300a.e(true);
        }

        public static int u0(C3306a c3306a, boolean z) {
            int i;
            int i2;
            int i3;
            int i4;
            if (z) {
                i = c3306a.n;
                i2 = c3306a.j;
            } else {
                i = c3306a.l;
                i2 = c3306a.h;
            }
            int i5 = i + i2;
            int intValue = c3306a.J().e().intValue();
            for (Map.Entry entry : c3306a.f.entrySet()) {
                C3306a c3306a2 = (C3306a) entry.getValue();
                if (!c3306a2.O()) {
                    i5 += u0(c3306a2, z);
                } else if (c3306a2.e.e().intValue() == intValue) {
                    if (z) {
                        i3 = c3306a2.n;
                        i4 = c3306a2.j;
                    } else {
                        i3 = c3306a2.l;
                        i4 = c3306a2.h;
                    }
                    return i5 + i3 + i4;
                }
            }
            return i5;
        }

        public static int v0(C3306a c3306a, boolean z) {
            int i;
            int i2;
            int i3;
            int i4;
            if (z) {
                i = -c3306a.m;
                i2 = c3306a.i;
            } else {
                i = -c3306a.k;
                i2 = c3306a.g;
            }
            int i5 = i - i2;
            int intValue = c3306a.J().d().intValue();
            for (Map.Entry entry : c3306a.f.entrySet()) {
                C3306a c3306a2 = (C3306a) entry.getValue();
                if (!c3306a2.O()) {
                    i5 += v0(c3306a2, z);
                } else if (c3306a2.e.d().intValue() == intValue) {
                    if (z) {
                        i3 = -c3306a2.m;
                        i4 = c3306a2.i;
                    } else {
                        i3 = -c3306a2.k;
                        i4 = c3306a2.g;
                    }
                    return i5 + (i3 - i4);
                }
            }
            return i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            View[] viewArr = this.B;
            if (viewArr == null || viewArr.length != this.u) {
                this.B = new View[this.u];
            }
            int[] iArr = this.C;
            if (iArr == null || iArr.length != this.u) {
                this.C = new int[this.u];
            }
            int[] iArr2 = this.D;
            if (iArr2 == null || iArr2.length != this.u) {
                this.D = new int[this.u];
            }
        }

        private C3306a x0(C3306a c3306a, int i) {
            for (Map.Entry entry : c3306a.f.entrySet()) {
                C3306a c3306a2 = (C3306a) entry.getValue();
                py1 py1Var = (py1) entry.getKey();
                if (!c3306a2.O()) {
                    return x0(c3306a2, i);
                }
                if (py1Var.a(Integer.valueOf(i))) {
                    return c3306a2;
                }
            }
            return c3306a;
        }

        public void A0() {
            this.x.d();
            for (Map.Entry entry : this.f.entrySet()) {
                ((C3306a) entry.getValue()).A0();
            }
        }

        public void B0(float f) {
            this.t = f;
        }

        @Override // com.alibaba.android.vlayout.layout.C3307g
        public void f0(int i, int i2) {
            super.f0(i, i2);
            this.x.f(i);
            this.x.d();
        }

        public C3306a y0(int i) {
            return x0(this, i);
        }

        public float z0() {
            return this.t;
        }
    }

    private void a(C3306a c3306a, RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z) {
            i4 = i;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
            i5 = -1;
        }
        if (layoutManagerHelper.getOrientation() == 1 && layoutManagerHelper.isDoLayoutRTL()) {
            i7 = i2 - 1;
            i6 = -1;
        } else {
            i6 = 1;
        }
        while (i3 != i4) {
            int f = f(c3306a.x, recycler, state, layoutManagerHelper.getPosition(c3306a.B[i3]));
            if (i6 != -1 || f <= 1) {
                c3306a.C[i3] = i7;
            } else {
                c3306a.C[i3] = i7 - (f - 1);
            }
            i7 += f * i6;
            i3 += i5;
        }
    }

    private int d(C3306a c3306a, int i, int i2, int i3, float f) {
        if (Float.isNaN(f) || f <= 0.0f || i3 <= 0) {
            if (Float.isNaN(c3306a.t) || c3306a.t <= 0.0f) {
                if (i < 0) {
                    return e;
                }
                return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
            }
            return View.MeasureSpec.makeMeasureSpec((int) ((i2 / c3306a.t) + 0.5f), 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec((int) ((i3 / f) + 0.5f), 1073741824);
    }

    private int e(C3299b.AbstractC3301b abstractC3301b, int i, RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.isPreLayout()) {
            return abstractC3301b.a(i2, i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i2);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return abstractC3301b.a(convertPreLayoutPositionToPostLayout, i);
    }

    private int f(C3299b.AbstractC3301b abstractC3301b, RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return abstractC3301b.c(i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return abstractC3301b.c(convertPreLayoutPositionToPostLayout);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void adjustLayout(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        this.a.a(i, i2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        this.a.b(recycler, state, i, i2, i3, layoutManagerHelper);
    }

    public int b(LayoutManagerHelper layoutManagerHelper) {
        int o;
        int s;
        C3306a y0 = this.a.y0(getRange().e().intValue());
        if (layoutManagerHelper.getOrientation() == 1) {
            o = y0.m();
            s = y0.q();
        } else {
            o = y0.o();
            s = y0.s();
        }
        return o + s;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        this.a.c(recycler, state, layoutManagerHelper);
    }

    public int c(LayoutManagerHelper layoutManagerHelper) {
        int n;
        int r;
        C3306a y0 = this.a.y0(getRange().d().intValue());
        if (layoutManagerHelper.getOrientation() == 1) {
            n = y0.p();
            r = y0.t();
        } else {
            n = y0.n();
            r = y0.r();
        }
        return n + r;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        if (state.getItemCount() > 0) {
            C3306a y0 = this.a.y0(c3286c.a);
            int a = y0.x.a(c3286c.a, y0.u);
            if (!c3286c.c) {
                while (a > 0) {
                    int i = c3286c.a;
                    if (i <= 0) {
                        break;
                    }
                    c3286c.a = i - 1;
                    a = y0.x.a(c3286c.a, y0.u);
                }
            } else {
                while (a < y0.u - 1 && c3286c.a < getRange().e().intValue()) {
                    c3286c.a++;
                    a = y0.x.a(c3286c.a, y0.u);
                }
            }
            this.c = true;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d, com.alibaba.android.vlayout.AbstractC3289a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i == getItemCount() - 1) {
                return C3306a.u0(this.a, z3);
            }
        } else if (i == 0) {
            return C3306a.v0(this.a, z3);
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public float getAspectRatio() {
        return this.a.z0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02c3, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02f3, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0329, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03c5, code lost:
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0151, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x028f, code lost:
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0380 A[LOOP:2: B:70:0x0208->B:137:0x0380, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x091a  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x093a  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x095a  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x022c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x03c7 A[EDGE_INSN: B:411:0x03c7->B:142:0x03c7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x024d  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutViews(androidx.recyclerview.widget.RecyclerView.Recycler r33, androidx.recyclerview.widget.RecyclerView.State r34, com.alibaba.android.vlayout.VirtualLayoutManager.C3287d r35, tb.m81 r36, com.alibaba.android.vlayout.LayoutManagerHelper r37) {
        /*
            Method dump skipped, instructions count: 2801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.layout.C3305f.layoutViews(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, com.alibaba.android.vlayout.VirtualLayoutManager$d, tb.m81, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        this.a.V(layoutManagerHelper);
        this.a.A0();
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        super.onItemsChanged(layoutManagerHelper);
        this.a.A0();
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRangeChange(int i, int i2) {
        this.a.f0(i, i2);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public boolean requireLayoutView() {
        return this.a.Y();
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setAspectRatio(float f) {
        this.a.B0(f);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setBgColor(int i) {
        this.a.Z(i);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewBindListener(BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener) {
        this.a.a0(layoutViewBindListener);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewHelper(BaseLayoutHelper.C3297a c3297a) {
        this.a.b0(c3297a);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewUnBindListener(BaseLayoutHelper.LayoutViewUnBindListener layoutViewUnBindListener) {
        this.a.c0(layoutViewUnBindListener);
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d
    public void setMargin(int i, int i2, int i3, int i4) {
        super.setMargin(i, i2, i3, i4);
        this.a.d0(i, i2, i3, i4);
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.a.e0(i, i2, i3, i4);
    }
}
