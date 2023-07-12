package tb;

import android.graphics.Rect;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class r1 extends BaseLayoutHelper {
    protected boolean a = false;
    protected boolean b = false;
    protected boolean c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, Rect rect, VirtualLayoutManager.C3287d c3287d, LayoutManagerHelper layoutManagerHelper) {
        int i2 = 0;
        if (layoutManagerHelper.getOrientation() == 1) {
            rect.left = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft + this.mPaddingLeft;
            rect.right = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight) - this.mPaddingRight;
            if (c3287d.f() == -1) {
                int g = c3287d.g();
                if (!this.c && !this.b) {
                    i2 = this.mMarginBottom + this.mPaddingBottom;
                }
                int i3 = g - i2;
                rect.bottom = i3;
                rect.top = i3 - i;
                return;
            }
            int g2 = c3287d.g();
            if (!this.c && !this.a) {
                i2 = this.mMarginTop + this.mPaddingTop;
            }
            int i4 = g2 + i2;
            rect.top = i4;
            rect.bottom = i4 + i;
            return;
        }
        rect.top = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop;
        rect.bottom = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - this.mMarginBottom) - this.mPaddingBottom;
        if (c3287d.f() == -1) {
            int g3 = c3287d.g();
            if (!this.c && !this.b) {
                i2 = this.mMarginRight + this.mPaddingRight;
            }
            int i5 = g3 - i2;
            rect.right = i5;
            rect.left = i5 - i;
            return;
        }
        int g4 = c3287d.g();
        if (!this.c && !this.a) {
            i2 = this.mMarginLeft + this.mPaddingLeft;
        }
        int i6 = g4 + i2;
        rect.left = i6;
        rect.right = i6 + i;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        this.c = false;
    }

    protected boolean b(ViewGroup.LayoutParams layoutParams) {
        return true;
    }

    protected ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        if (c3286c.c) {
            if (!this.b) {
                c3286c.a = getRange().e().intValue();
            }
        } else if (!this.a) {
            c3286c.a = getRange().d().intValue();
        }
        this.c = true;
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d, com.alibaba.android.vlayout.AbstractC3289a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (layoutManagerHelper.getOrientation() == 1) {
            if (z) {
                return this.mMarginBottom + this.mPaddingBottom;
            }
            return (-this.mMarginTop) - this.mPaddingTop;
        } else if (z) {
            return this.mMarginRight + this.mPaddingRight;
        } else {
            return (-this.mMarginLeft) - this.mPaddingLeft;
        }
    }

    protected ViewGroup.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
        if (r2 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        r8 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        if (r1 >= r8) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
        r9 = r7[r1];
        r7[r1] = r7[r8];
        r7[r8] = r9;
        r1 = r1 + 1;
        r8 = r8 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e(android.view.View[] r7, androidx.recyclerview.widget.RecyclerView.Recycler r8, com.alibaba.android.vlayout.VirtualLayoutManager.C3287d r9, tb.m81 r10, com.alibaba.android.vlayout.LayoutManagerHelper r11) {
        /*
            r6 = this;
            int r0 = r9.e()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L9
            goto La
        L9:
            r2 = 0
        La:
            tb.py1 r0 = r6.getRange()
            if (r2 == 0) goto L15
            java.lang.Comparable r0 = r0.d()
            goto L19
        L15:
            java.lang.Comparable r0 = r0.e()
        L19:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r3 = r9.c()
            if (r2 == 0) goto L28
            if (r3 <= r0) goto L31
            goto L2a
        L28:
            if (r3 <= r0) goto L31
        L2a:
            java.lang.String r0 = "FullFillLayoutHelper"
            java.lang.String r3 = "Please handle strange order views carefully"
            android.util.Log.w(r0, r3)
        L31:
            r0 = 0
        L32:
            int r3 = r7.length
            if (r0 >= r3) goto L67
            int r3 = r9.c()
            boolean r3 = r6.isOutOfRange(r3)
            if (r3 == 0) goto L40
            goto L67
        L40:
            android.view.View r3 = r6.nextView(r8, r9, r11, r10)
            if (r3 != 0) goto L47
            goto L67
        L47:
            r7[r0] = r3
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            if (r4 != 0) goto L57
            android.view.ViewGroup$LayoutParams r4 = r6.c()
            r3.setLayoutParams(r4)
            goto L64
        L57:
            boolean r5 = r6.b(r4)
            if (r5 != 0) goto L64
            android.view.ViewGroup$LayoutParams r4 = r6.d(r4)
            r3.setLayoutParams(r4)
        L64:
            int r0 = r0 + 1
            goto L32
        L67:
            if (r0 <= 0) goto L7c
            if (r2 != 0) goto L7c
            int r8 = r0 + (-1)
        L6d:
            if (r1 >= r8) goto L7c
            r9 = r7[r1]
            r10 = r7[r8]
            r7[r1] = r10
            r7[r8] = r9
            int r1 = r1 + 1
            int r8 = r8 + (-1)
            goto L6d
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.r1.e(android.view.View[], androidx.recyclerview.widget.RecyclerView$Recycler, com.alibaba.android.vlayout.VirtualLayoutManager$d, tb.m81, com.alibaba.android.vlayout.LayoutManagerHelper):int");
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public boolean isRecyclable(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper, boolean z) {
        py1<Integer> range = getRange();
        if (range.a(Integer.valueOf(i))) {
            if (this.a && i == getRange().d().intValue()) {
                return true;
            }
            if (this.b && i == getRange().e().intValue()) {
                return true;
            }
            return py1.c(Integer.valueOf(i2), Integer.valueOf(i3)).b(py1.c(Integer.valueOf(range.d().intValue() + (this.a ? 1 : 0)), Integer.valueOf(range.e().intValue() - (this.b ? 1 : 0))));
        }
        Log.w("FullFillLayoutHelper", "Child item not match");
        return true;
    }
}
