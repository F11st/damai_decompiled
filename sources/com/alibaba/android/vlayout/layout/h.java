package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import tb.m81;
import tb.vk;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class h extends vk {
    public h() {
        setItemCount(1);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, m81 m81Var, LayoutManagerHelper layoutManagerHelper) {
        int i;
        int i2;
        int i3;
        int i4;
        int g;
        int i5;
        if (isOutOfRange(dVar.c())) {
            return;
        }
        View l = dVar.l(recycler);
        boolean z = true;
        if (l == null) {
            m81Var.b = true;
            return;
        }
        layoutManagerHelper.addChildView(dVar, l);
        VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) l.getLayoutParams();
        boolean z2 = layoutManagerHelper.getOrientation() == 1;
        int contentWidth = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
        int contentHeight = (((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin()) - getVerticalPadding();
        if (!Float.isNaN(this.mAspectRatio)) {
            if (z2) {
                contentHeight = (int) ((contentWidth / this.mAspectRatio) + 0.5f);
            } else {
                contentWidth = (int) ((contentHeight * this.mAspectRatio) + 0.5f);
            }
        }
        if (z2) {
            layoutManagerHelper.measureChildWithMargins(l, layoutManagerHelper.getChildMeasureSpec(contentWidth, Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : contentWidth, !z2 && Float.isNaN(this.mAspectRatio)), layoutManagerHelper.getChildMeasureSpec(contentHeight, Float.isNaN(layoutParams.a) ? Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : contentHeight : (int) ((contentWidth / layoutParams.a) + 0.5f), (z2 && Float.isNaN(this.mAspectRatio)) ? false : false));
        } else {
            layoutManagerHelper.measureChildWithMargins(l, layoutManagerHelper.getChildMeasureSpec(contentWidth, Float.isNaN(layoutParams.a) ? Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : contentWidth : (int) ((contentHeight * layoutParams.a) + 0.5f), !z2 && Float.isNaN(this.mAspectRatio)), layoutManagerHelper.getChildMeasureSpec(contentHeight, Float.isNaN(this.mAspectRatio) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : contentHeight, (z2 && Float.isNaN(this.mAspectRatio)) ? false : false));
        }
        com.alibaba.android.vlayout.c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        m81Var.a = mainOrientationHelper.e(l);
        if (z2) {
            int f = contentWidth - mainOrientationHelper.f(l);
            int i6 = (f >= 0 ? f : 0) / 2;
            int paddingLeft = this.mMarginLeft + this.mPaddingLeft + layoutManagerHelper.getPaddingLeft() + i6;
            int contentWidth2 = (((layoutManagerHelper.getContentWidth() - this.mMarginRight) - this.mPaddingRight) - layoutManagerHelper.getPaddingRight()) - i6;
            if (dVar.f() == -1) {
                i5 = (dVar.g() - this.mMarginBottom) - this.mPaddingBottom;
                g = i5 - m81Var.a;
            } else {
                g = this.mPaddingTop + dVar.g() + this.mMarginTop;
                i5 = m81Var.a + g;
            }
            i = paddingLeft;
            i3 = i5;
            i2 = contentWidth2;
            i4 = g;
        } else {
            int f2 = contentHeight - mainOrientationHelper.f(l);
            int i7 = (f2 >= 0 ? f2 : 0) / 2;
            int paddingTop = layoutManagerHelper.getPaddingTop() + this.mMarginTop + this.mPaddingTop + i7;
            int contentHeight2 = (((layoutManagerHelper.getContentHeight() - (-this.mMarginBottom)) - this.mPaddingBottom) - layoutManagerHelper.getPaddingBottom()) - i7;
            if (dVar.f() == -1) {
                int g2 = (dVar.g() - this.mMarginRight) - this.mPaddingRight;
                i2 = g2;
                i = g2 - m81Var.a;
            } else {
                int g3 = dVar.g() + this.mMarginLeft + this.mPaddingLeft;
                i = g3;
                i2 = m81Var.a + g3;
            }
            i3 = contentHeight2;
            i4 = paddingTop;
        }
        if (z2) {
            m81Var.a += getVerticalMargin() + getVerticalPadding();
        } else {
            m81Var.a += getHorizontalMargin() + getHorizontalPadding();
        }
        layoutChildWithMargin(l, i, i4, i2, i3, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void setItemCount(int i) {
        if (i > 0) {
            super.setItemCount(1);
        } else {
            super.setItemCount(0);
        }
    }
}
