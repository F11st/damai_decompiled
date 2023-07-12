package com.alibaba.android.vlayout.layout;

import com.alibaba.android.vlayout.LayoutManagerHelper;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class d extends com.alibaba.android.vlayout.a {
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;

    @Override // com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.a
    public int computeMarginEnd(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (layoutManagerHelper.getOrientation() == 1) {
            return this.mMarginBottom;
        }
        return this.mMarginRight;
    }

    @Override // com.alibaba.android.vlayout.a
    public int computeMarginStart(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (layoutManagerHelper.getOrientation() == 1) {
            return this.mMarginTop;
        }
        return this.mMarginLeft;
    }

    @Override // com.alibaba.android.vlayout.a
    public int computePaddingEnd(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (layoutManagerHelper.getOrientation() == 1) {
            return this.mPaddingBottom;
        }
        return this.mPaddingRight;
    }

    @Override // com.alibaba.android.vlayout.a
    public int computePaddingStart(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (layoutManagerHelper.getOrientation() == 1) {
            return this.mPaddingTop;
        }
        return this.mPaddingLeft;
    }

    public int getHorizontalMargin() {
        return this.mMarginLeft + this.mMarginRight;
    }

    public int getHorizontalPadding() {
        return this.mPaddingLeft + this.mPaddingRight;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public int getVerticalMargin() {
        return this.mMarginTop + this.mMarginBottom;
    }

    public int getVerticalPadding() {
        return this.mPaddingTop + this.mPaddingBottom;
    }

    public void setMargin(int i, int i2, int i3, int i4) {
        this.mMarginLeft = i;
        this.mMarginTop = i2;
        this.mMarginRight = i3;
        this.mMarginBottom = i4;
    }

    public void setMarginBottom(int i) {
        this.mMarginBottom = i;
    }

    public void setMarginLeft(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    public void setMarginTop(int i) {
        this.mMarginTop = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingRight = i3;
        this.mPaddingTop = i2;
        this.mPaddingBottom = i4;
    }

    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }
}
