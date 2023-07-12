package com.alibaba.android.vlayout.layout;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.AbstractC3291c;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import tb.m81;
import tb.wj0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class StickyLayoutHelper extends FixAreaLayoutHelper {
    private int b;
    private boolean c;
    private int d;
    private View e;
    private boolean f;
    private boolean g;
    private StickyListener h;
    private Stackable i;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Stackable {
        boolean enable();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface StickyListener {
        void onSticky(int i, View view);

        void onUnSticky(int i, View view);
    }

    public StickyLayoutHelper() {
        this(true);
    }

    private void b(View view, LayoutManagerHelper layoutManagerHelper) {
        int childMeasureSpec;
        int childMeasureSpec2;
        VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
        boolean z = layoutManagerHelper.getOrientation() == 1;
        int contentWidth = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin();
        int contentHeight = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
        float f = layoutParams.a;
        if (z) {
            int childMeasureSpec3 = layoutManagerHelper.getChildMeasureSpec(contentWidth, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            if (!Float.isNaN(f) && f > 0.0f) {
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) ((contentWidth / f) + 0.5f), 1073741824);
            } else {
                if (!Float.isNaN(this.mAspectRatio)) {
                    float f2 = this.mAspectRatio;
                    if (f2 > 0.0f) {
                        childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) ((contentWidth / f2) + 0.5d), 1073741824);
                    }
                }
                childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(contentHeight, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
            }
            layoutManagerHelper.measureChildWithMargins(view, childMeasureSpec3, childMeasureSpec2);
            return;
        }
        int childMeasureSpec4 = layoutManagerHelper.getChildMeasureSpec(contentHeight, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
        if (!Float.isNaN(f) && f > 0.0f) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((contentHeight * f) + 0.5d), 1073741824);
        } else {
            if (!Float.isNaN(this.mAspectRatio)) {
                float f3 = this.mAspectRatio;
                if (f3 > 0.0f) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((contentHeight * f3) + 0.5d), 1073741824);
                }
            }
            childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(contentWidth, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
        }
        layoutManagerHelper.measureChildWithMargins(view, childMeasureSpec, childMeasureSpec4);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.alibaba.android.vlayout.AbstractC3291c r3, androidx.recyclerview.widget.RecyclerView.Recycler r4, int r5, int r6, com.alibaba.android.vlayout.LayoutManagerHelper r7) {
        /*
            r2 = this;
            boolean r4 = com.alibaba.android.vlayout.VirtualLayoutManager.sDebuggable
            if (r4 == 0) goto L2c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "abnormal pos: "
            r4.append(r0)
            int r0 = r2.b
            r4.append(r0)
            java.lang.String r0 = " start: "
            r4.append(r0)
            r4.append(r5)
            java.lang.String r5 = " end: "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "StickyStartLayoutHelper"
            android.util.Log.i(r5, r4)
        L2c:
            android.view.View r4 = r2.e
            if (r4 == 0) goto Lc1
            boolean r4 = r2.c
            r5 = 1
            if (r4 == 0) goto L7b
            int r4 = r7.getChildCount()
            int r4 = r4 - r5
        L3a:
            if (r4 < 0) goto Lc1
            android.view.View r6 = r7.getChildAt(r4)
            int r0 = r7.getPosition(r6)
            int r1 = r2.b
            if (r0 >= r1) goto L78
            int r3 = r3.d(r6)
            com.alibaba.android.vlayout.a r4 = r7.findLayoutHelperByPosition(r0)
            boolean r6 = r4 instanceof com.alibaba.android.vlayout.layout.C3305f
            if (r6 == 0) goto L5c
            com.alibaba.android.vlayout.layout.f r4 = (com.alibaba.android.vlayout.layout.C3305f) r4
            int r4 = r4.b(r7)
        L5a:
            int r3 = r3 + r4
            goto L6c
        L5c:
            boolean r6 = r4 instanceof com.alibaba.android.vlayout.layout.AbstractC3303d
            if (r6 == 0) goto L6c
            com.alibaba.android.vlayout.layout.d r4 = (com.alibaba.android.vlayout.layout.AbstractC3303d) r4
            int r6 = r4.getMarginBottom()
            int r3 = r3 + r6
            int r4 = r4.getPaddingBottom()
            goto L5a
        L6c:
            int r4 = r2.d
            tb.wj0 r6 = r2.a
            int r6 = r6.b
            int r4 = r4 + r6
            if (r3 < r4) goto Lc1
            r2.f = r5
            goto Lc1
        L78:
            int r4 = r4 + (-1)
            goto L3a
        L7b:
            r4 = 0
        L7c:
            int r6 = r7.getChildCount()
            if (r4 >= r6) goto Lc1
            android.view.View r6 = r7.getChildAt(r4)
            int r0 = r7.getPosition(r6)
            int r1 = r2.b
            if (r0 <= r1) goto Lbe
            int r3 = r3.g(r6)
            com.alibaba.android.vlayout.a r4 = r7.findLayoutHelperByPosition(r0)
            boolean r6 = r4 instanceof com.alibaba.android.vlayout.layout.C3305f
            if (r6 == 0) goto La2
            com.alibaba.android.vlayout.layout.f r4 = (com.alibaba.android.vlayout.layout.C3305f) r4
            int r4 = r4.c(r7)
        La0:
            int r3 = r3 - r4
            goto Lb2
        La2:
            boolean r6 = r4 instanceof com.alibaba.android.vlayout.layout.AbstractC3303d
            if (r6 == 0) goto Lb2
            com.alibaba.android.vlayout.layout.d r4 = (com.alibaba.android.vlayout.layout.AbstractC3303d) r4
            int r6 = r4.getMarginTop()
            int r3 = r3 - r6
            int r4 = r4.getPaddingTop()
            goto La0
        Lb2:
            int r4 = r2.d
            tb.wj0 r6 = r2.a
            int r6 = r6.d
            int r4 = r4 + r6
            if (r3 < r4) goto Lc1
            r2.f = r5
            goto Lc1
        Lbe:
            int r4 = r4 + 1
            goto L7c
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.layout.StickyLayoutHelper.c(com.alibaba.android.vlayout.c, androidx.recyclerview.widget.RecyclerView$Recycler, int, int, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    private void d(AbstractC3291c abstractC3291c, RecyclerView.Recycler recycler, int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int paddingLeft;
        int f;
        View view;
        int paddingTop;
        int i8;
        int i9;
        int i10;
        int paddingBottom;
        boolean z = this.c;
        if ((z && i2 >= this.b) || (!z && i <= this.b)) {
            int e = abstractC3291c.e(this.e);
            int i11 = 0;
            boolean z2 = layoutManagerHelper.getOrientation() == 1;
            int f2 = z2 ? this.a.b + f(layoutManagerHelper) : this.a.a;
            wj0 wj0Var = this.a;
            int i12 = z2 ? wj0Var.d : wj0Var.c;
            int i13 = -1;
            if (z2) {
                if (layoutManagerHelper.isDoLayoutRTL()) {
                    f = layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight();
                    paddingLeft = f - abstractC3291c.f(this.e);
                } else {
                    paddingLeft = layoutManagerHelper.getPaddingLeft();
                    f = abstractC3291c.f(this.e) + paddingLeft;
                }
                if (this.c) {
                    i10 = layoutManagerHelper.getChildCount() - 1;
                    view = null;
                    while (i10 >= 0) {
                        view = layoutManagerHelper.getChildAt(i10);
                        int position = layoutManagerHelper.getPosition(view);
                        if (position < this.b) {
                            i9 = abstractC3291c.d(view);
                            AbstractC3289a findLayoutHelperByPosition = layoutManagerHelper.findLayoutHelperByPosition(position);
                            if (findLayoutHelperByPosition instanceof C3305f) {
                                paddingBottom = ((C3305f) findLayoutHelperByPosition).b(layoutManagerHelper);
                            } else {
                                if (findLayoutHelperByPosition instanceof AbstractC3303d) {
                                    AbstractC3303d abstractC3303d = (AbstractC3303d) findLayoutHelperByPosition;
                                    i9 += abstractC3303d.getMarginBottom();
                                    paddingBottom = abstractC3303d.getPaddingBottom();
                                }
                                i8 = i9 + e;
                                this.f = true;
                                i4 = i9;
                                i13 = i10;
                            }
                            i9 += paddingBottom;
                            i8 = i9 + e;
                            this.f = true;
                            i4 = i9;
                            i13 = i10;
                        } else {
                            i10--;
                        }
                    }
                    i4 = 0;
                    i8 = 0;
                } else {
                    view = null;
                    for (int i14 = 0; i14 < layoutManagerHelper.getChildCount(); i14++) {
                        view = layoutManagerHelper.getChildAt(i14);
                        int position2 = layoutManagerHelper.getPosition(view);
                        if (position2 > this.b) {
                            int g = abstractC3291c.g(view);
                            AbstractC3289a findLayoutHelperByPosition2 = layoutManagerHelper.findLayoutHelperByPosition(position2);
                            if (findLayoutHelperByPosition2 instanceof C3305f) {
                                paddingTop = ((C3305f) findLayoutHelperByPosition2).c(layoutManagerHelper);
                            } else {
                                if (findLayoutHelperByPosition2 instanceof AbstractC3303d) {
                                    AbstractC3303d abstractC3303d2 = (AbstractC3303d) findLayoutHelperByPosition2;
                                    g -= abstractC3303d2.getMarginTop();
                                    paddingTop = abstractC3303d2.getPaddingTop();
                                }
                                i8 = g;
                                i9 = i8 - e;
                                i10 = i14 + 1;
                                this.f = true;
                                i4 = i9;
                                i13 = i10;
                            }
                            g -= paddingTop;
                            i8 = g;
                            i9 = i8 - e;
                            i10 = i14 + 1;
                            this.f = true;
                            i4 = i9;
                            i13 = i10;
                        }
                    }
                    i4 = 0;
                    i8 = 0;
                }
                if (view == null || i13 < 0) {
                    this.f = false;
                }
                if (!layoutManagerHelper.getReverseLayout() && this.c) {
                    if (i4 < abstractC3291c.k() + this.d + f2) {
                        this.f = false;
                    }
                } else if (i8 > (abstractC3291c.i() - this.d) - i12) {
                    this.f = false;
                }
                if (!this.f) {
                    if (!layoutManagerHelper.getReverseLayout() && this.c) {
                        i4 = abstractC3291c.k() + this.d + f2;
                        i8 = i4 + e;
                    } else {
                        i8 = (abstractC3291c.i() - this.d) - i12;
                        i4 = i8 - e;
                    }
                }
                i3 = f;
                i6 = paddingLeft;
                i5 = i8;
            } else {
                int paddingTop2 = layoutManagerHelper.getPaddingTop();
                int f3 = abstractC3291c.f(this.e) + paddingTop2;
                if (this.f) {
                    if (this.c) {
                        for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = layoutManagerHelper.getChildAt(childCount);
                            if (layoutManagerHelper.getPosition(childAt) < this.b) {
                                i11 = abstractC3291c.d(childAt);
                                i7 = i11 + e;
                                break;
                            }
                        }
                        i7 = 0;
                        i4 = paddingTop2;
                        i6 = i11;
                        i5 = f3;
                        i3 = i7;
                    } else {
                        for (int i15 = 0; i15 < layoutManagerHelper.getChildCount(); i15++) {
                            View childAt2 = layoutManagerHelper.getChildAt(i15);
                            if (layoutManagerHelper.getPosition(childAt2) > this.b) {
                                int g2 = abstractC3291c.g(childAt2);
                                i11 = g2 - e;
                                i7 = g2;
                                break;
                            }
                        }
                        i7 = 0;
                        i4 = paddingTop2;
                        i6 = i11;
                        i5 = f3;
                        i3 = i7;
                    }
                } else if (!layoutManagerHelper.getReverseLayout() && this.c) {
                    int k = abstractC3291c.k() + this.d + f2;
                    i3 = e + k;
                    i4 = paddingTop2;
                    i5 = f3;
                    i6 = k;
                } else {
                    int i16 = (abstractC3291c.i() - this.d) - i12;
                    i3 = i16;
                    i4 = paddingTop2;
                    i5 = f3;
                    i6 = i16 - e;
                }
            }
            layoutChildWithMargin(this.e, i6, i4, i3, i5, layoutManagerHelper);
            if (!this.f) {
                layoutManagerHelper.showView(this.e);
                layoutManagerHelper.addFixedView(this.e);
                return;
            } else if (i13 >= 0) {
                if (this.e.getParent() == null) {
                    layoutManagerHelper.addChildView(this.e, i13);
                }
                this.e = null;
                return;
            } else {
                return;
            }
        }
        layoutManagerHelper.removeChildView(this.e);
        layoutManagerHelper.recycleView(this.e);
        this.e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(com.alibaba.android.vlayout.AbstractC3291c r19, androidx.recyclerview.widget.RecyclerView.Recycler r20, int r21, int r22, com.alibaba.android.vlayout.LayoutManagerHelper r23) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.layout.StickyLayoutHelper.e(com.alibaba.android.vlayout.c, androidx.recyclerview.widget.RecyclerView$Recycler, int, int, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    private int f(LayoutManagerHelper layoutManagerHelper) {
        View fixedView;
        Stackable stackable = this.i;
        int i = 0;
        if (stackable != null && stackable.enable() && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            for (AbstractC3289a abstractC3289a : ((VirtualLayoutManager) layoutManagerHelper).getLayoutHelpers()) {
                if (abstractC3289a.isFixLayout() && abstractC3289a.getRange().e().intValue() < getRange().d().intValue() && (fixedView = abstractC3289a.getFixedView()) != null) {
                    i += fixedView.getHeight();
                }
            }
        }
        return i;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        int i4;
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        if (this.b < 0) {
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (!this.f && (i4 = this.b) >= i && i4 <= i2) {
            c(mainOrientationHelper, recycler, i, i2, layoutManagerHelper);
        }
        if (this.f || state.isPreLayout()) {
            state.isPreLayout();
            View view = this.e;
            if (view == null) {
                return;
            }
            layoutManagerHelper.removeChildView(view);
        }
        View view2 = this.e;
        if (!this.f && view2 != null) {
            if (view2.getParent() == null) {
                layoutManagerHelper.addFixedView(this.e);
            } else {
                d(mainOrientationHelper, recycler, i, i2, layoutManagerHelper);
            }
        } else {
            e(mainOrientationHelper, recycler, i, i2, layoutManagerHelper);
        }
        if (this.h != null) {
            if (this.g && !g()) {
                this.h.onUnSticky(this.b, view2);
                this.g = false;
            } else if (this.g || !g()) {
            } else {
                this.h.onSticky(this.b, this.e);
                this.g = true;
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        super.beforeLayout(recycler, state, layoutManagerHelper);
        View view = this.e;
        if (view != null && layoutManagerHelper.isViewHolderUpdated(view)) {
            layoutManagerHelper.removeChildView(this.e);
            recycler.recycleView(this.e);
            this.e = null;
        }
        this.f = false;
    }

    public boolean g() {
        return (this.f || this.e == null) ? false : true;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    @Nullable
    public View getFixedView() {
        return this.e;
    }

    public void h(int i) {
        this.d = i;
    }

    public void i(StickyListener stickyListener) {
        this.h = stickyListener;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.C3287d c3287d, m81 m81Var, LayoutManagerHelper layoutManagerHelper) {
        int paddingTop;
        int f;
        int g;
        int g2;
        int i;
        int paddingLeft;
        int f2;
        int i2;
        int i3;
        if (isOutOfRange(c3287d.c())) {
            return;
        }
        View view = this.e;
        if (view == null) {
            view = c3287d.l(recycler);
        } else {
            c3287d.n();
        }
        View view2 = view;
        if (view2 == null) {
            m81Var.b = true;
            return;
        }
        b(view2, layoutManagerHelper);
        boolean z = layoutManagerHelper.getOrientation() == 1;
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        m81Var.a = mainOrientationHelper.e(view2);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
        this.f = true;
        int b = (c3287d.b() - m81Var.a) + c3287d.d();
        if (layoutManagerHelper.getOrientation() == 1) {
            if (layoutManagerHelper.isDoLayoutRTL()) {
                f2 = (layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight;
                paddingLeft = f2 - mainOrientationHelper.f(view2);
            } else {
                paddingLeft = this.mMarginLeft + layoutManagerHelper.getPaddingLeft();
                f2 = mainOrientationHelper.f(view2) + paddingLeft;
            }
            if (c3287d.f() == -1) {
                i2 = c3287d.g() - this.mMarginBottom;
                i3 = c3287d.g() - m81Var.a;
            } else if (this.c) {
                i3 = this.mMarginTop + c3287d.g();
                i2 = c3287d.g() + m81Var.a;
            } else {
                i2 = ((mainOrientationHelper.i() - this.mMarginBottom) - this.d) - this.a.d;
                i3 = i2 - m81Var.a;
            }
            if (!layoutManagerHelper.getReverseLayout() && this.c) {
                if ((b < this.d + this.a.b && c3287d.e() == -1) || i3 < this.mMarginTop + this.d + this.a.b) {
                    this.f = false;
                    this.e = view2;
                    int k = mainOrientationHelper.k() + this.mMarginTop + this.d + this.a.b;
                    g2 = f2;
                    i = paddingLeft;
                    paddingTop = k;
                    f = m81Var.a + k;
                } else {
                    if (VirtualLayoutManager.sDebuggable) {
                        Log.i("Sticky", "remainingSpace: " + b + "    offset: " + this.d);
                    }
                    g2 = f2;
                    i = paddingLeft;
                    f = i2;
                    paddingTop = i3;
                }
            } else {
                if ((b < this.d + this.a.d && c3287d.e() == 1) || i2 > this.mMarginBottom + this.d + this.a.d) {
                    this.f = false;
                    this.e = view2;
                    int i4 = ((mainOrientationHelper.i() - this.mMarginBottom) - this.d) - this.a.d;
                    g2 = f2;
                    i = paddingLeft;
                    f = i4;
                    paddingTop = i4 - m81Var.a;
                }
                g2 = f2;
                i = paddingLeft;
                f = i2;
                paddingTop = i3;
            }
        } else {
            paddingTop = layoutManagerHelper.getPaddingTop();
            f = mainOrientationHelper.f(view2) + paddingTop + this.mMarginTop;
            if (c3287d.f() == -1) {
                g2 = c3287d.g() - this.mMarginRight;
                g = c3287d.g() - m81Var.a;
            } else {
                g = this.mMarginLeft + c3287d.g();
                g2 = c3287d.g() + m81Var.a;
            }
            if (!layoutManagerHelper.getReverseLayout() && this.c) {
                if (b < this.d + this.a.a) {
                    this.f = false;
                    this.e = view2;
                    i = mainOrientationHelper.k() + this.d + this.a.a;
                    g2 = m81Var.a;
                }
                i = g;
            } else {
                if (b < this.d + this.a.c) {
                    this.f = false;
                    this.e = view2;
                    int i5 = (mainOrientationHelper.i() - this.d) - this.a.c;
                    g2 = i5;
                    i = i5 - m81Var.a;
                }
                i = g;
            }
        }
        layoutChildWithMargin(view2, i, paddingTop, g2, f, layoutManagerHelper);
        m81Var.a += z ? getVerticalMargin() : getHorizontalMargin();
        if (state.isPreLayout()) {
            this.f = true;
        }
        if (this.f) {
            layoutManagerHelper.addChildView(c3287d, view2);
            handleStateOnResult(m81Var, view2);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        super.onClear(layoutManagerHelper);
        View view = this.e;
        if (view != null) {
            layoutManagerHelper.recycleView(view);
            layoutManagerHelper.removeChildView(this.e);
            this.e = null;
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRangeChange(int i, int i2) {
        this.b = i;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public boolean requireLayoutView() {
        return false;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void setItemCount(int i) {
        if (i > 0) {
            super.setItemCount(1);
        } else {
            super.setItemCount(0);
        }
    }

    public StickyLayoutHelper(boolean z) {
        this.b = -1;
        this.c = true;
        this.d = 0;
        this.e = null;
        this.f = false;
        this.g = false;
        this.c = z;
        setItemCount(1);
    }
}
