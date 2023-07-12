package com.alibaba.android.vlayout.layout;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class b extends BaseLayoutHelper {
    private static boolean m;
    private static final int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    private int a;
    private int b;
    private int c;
    private boolean d;
    @NonNull
    private AbstractC0135b e;
    private int f;
    private int g;
    private float[] h;
    private View[] i;
    private int[] j;
    private int[] k;
    private boolean l;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static final class a extends AbstractC0135b {
        @Override // com.alibaba.android.vlayout.layout.b.AbstractC0135b
        public int b(int i, int i2) {
            return (i - this.c) % i2;
        }

        @Override // com.alibaba.android.vlayout.layout.b.AbstractC0135b
        public int c(int i) {
            return 1;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.layout.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC0135b {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;
        int c = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (!this.b) {
                return b(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int b = b(i, i2);
            this.a.put(i, b);
            return b;
        }

        public abstract int b(int i, int i2);

        public abstract int c(int i);

        public void d() {
            this.a.clear();
        }

        public void e(boolean z) {
            this.b = z;
        }

        public void f(int i) {
            this.c = i;
        }
    }

    public b(int i) {
        this(i, -1, -1);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z, LayoutManagerHelper layoutManagerHelper) {
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
            int spanSize = getSpanSize(recycler, state, layoutManagerHelper.getPosition(this.i[i3]));
            if (i6 == -1 && spanSize > 1) {
                this.j[i3] = i7 - (spanSize - 1);
            } else {
                this.j[i3] = i7;
            }
            i7 += spanSize * i6;
            i3 += i5;
        }
    }

    private void ensureSpanCount() {
        View[] viewArr = this.i;
        if (viewArr == null || viewArr.length != this.a) {
            this.i = new View[this.a];
        }
        int[] iArr = this.j;
        if (iArr == null || iArr.length != this.a) {
            this.j = new int[this.a];
        }
        int[] iArr2 = this.k;
        if (iArr2 == null || iArr2.length != this.a) {
            this.k = new int[this.a];
        }
    }

    private int getMainDirSpec(int i, int i2, int i3, float f) {
        if (!Float.isNaN(f) && f > 0.0f && i3 > 0) {
            return View.MeasureSpec.makeMeasureSpec((int) ((i3 / f) + 0.5f), 1073741824);
        }
        if (!Float.isNaN(this.mAspectRatio)) {
            float f2 = this.mAspectRatio;
            if (f2 > 0.0f) {
                return View.MeasureSpec.makeMeasureSpec((int) ((i2 / f2) + 0.5f), 1073741824);
            }
        }
        if (i < 0) {
            return n;
        }
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.e.a(i, this.a);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.e.a(convertPreLayoutPositionToPostLayout, this.a);
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.e.c(i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.e.c(convertPreLayoutPositionToPostLayout);
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (state.getItemCount() <= 0 || state.isPreLayout()) {
            return;
        }
        int a2 = this.e.a(cVar.a, this.a);
        if (!cVar.c) {
            while (a2 > 0) {
                int i = cVar.a;
                if (i <= 0) {
                    break;
                }
                int i2 = i - 1;
                cVar.a = i2;
                a2 = this.e.a(i2, this.a);
            }
        } else {
            while (a2 < this.a - 1 && cVar.a < getRange().e().intValue()) {
                int i3 = cVar.a + 1;
                cVar.a = i3;
                a2 = this.e.a(i3, this.a);
            }
        }
        this.l = true;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i == getItemCount() - 1) {
                if (z3) {
                    i4 = this.mMarginBottom;
                    i5 = this.mPaddingBottom;
                } else {
                    i4 = this.mMarginRight;
                    i5 = this.mPaddingRight;
                }
                return i4 + i5;
            }
        } else if (i == 0) {
            if (z3) {
                i2 = -this.mMarginTop;
                i3 = this.mPaddingTop;
            } else {
                i2 = -this.mMarginLeft;
                i3 = this.mPaddingLeft;
            }
            return i2 - i3;
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x024e, code lost:
        if (r0 == getRange().d().intValue()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x025f, code lost:
        if (r0 == getRange().e().intValue()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0261, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0263, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011e, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014c, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x021b, code lost:
        if (r0 == getRange().e().intValue()) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x022e, code lost:
        if (r0 == getRange().d().intValue()) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0230, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0232, code lost:
        r1 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ed  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0266 -> B:66:0x01a2). Please submit an issue!!! */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutViews(androidx.recyclerview.widget.RecyclerView.Recycler r30, androidx.recyclerview.widget.RecyclerView.State r31, com.alibaba.android.vlayout.VirtualLayoutManager.d r32, tb.m81 r33, com.alibaba.android.vlayout.LayoutManagerHelper r34) {
        /*
            Method dump skipped, instructions count: 1638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.layout.b.layoutViews(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, com.alibaba.android.vlayout.VirtualLayoutManager$d, tb.m81, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        this.e.d();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        super.onItemsChanged(layoutManagerHelper);
        this.e.d();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        this.e.f(i);
        this.e.d();
    }

    public void setAutoExpand(boolean z) {
        this.d = z;
    }

    public void setHGap(int i) {
        if (i < 0) {
            i = 0;
        }
        this.g = i;
    }

    public void setSpanCount(int i) {
        if (i == this.a) {
            return;
        }
        if (i >= 1) {
            this.a = i;
            this.e.d();
            ensureSpanCount();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    public void setVGap(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f = i;
    }

    public b(int i, int i2, int i3) {
        this(i, i2, i3, i3);
    }

    public b(int i, int i2, int i3, int i4) {
        this.a = 4;
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.e = new a();
        this.f = 0;
        this.g = 0;
        this.h = new float[0];
        this.l = false;
        setSpanCount(i);
        this.e.e(true);
        setItemCount(i2);
        setVGap(i3);
        setHGap(i4);
    }
}
