package com.alibaba.android.vlayout.layout;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class c extends BaseLayoutHelper {
    private int a;
    private boolean b;

    public c() {
        this(0);
    }

    public void a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.a = i;
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        super.checkAnchorInfo(state, cVar, layoutManagerHelper);
        this.b = true;
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

    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d0  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutViews(androidx.recyclerview.widget.RecyclerView.Recycler r20, androidx.recyclerview.widget.RecyclerView.State r21, com.alibaba.android.vlayout.VirtualLayoutManager.d r22, tb.m81 r23, com.alibaba.android.vlayout.LayoutManagerHelper r24) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.layout.c.layoutViews(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, com.alibaba.android.vlayout.VirtualLayoutManager$d, tb.m81, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    public c(int i) {
        this(i, 0);
    }

    public c(int i, int i2) {
        this.a = 0;
        this.b = false;
        setItemCount(i2);
        a(i);
    }
}
