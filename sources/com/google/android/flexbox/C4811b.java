package com.google.android.flexbox;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.google.android.flexbox.b */
/* loaded from: classes10.dex */
public class C4811b {
    private final FlexContainer a;
    private boolean[] b;
    @Nullable
    int[] c;
    @Nullable
    long[] d;
    @Nullable
    private long[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.android.flexbox.b$b */
    /* loaded from: classes10.dex */
    public static class C4813b {
        List<C4810a> a;
        int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.android.flexbox.b$c */
    /* loaded from: classes10.dex */
    public static class C4814c implements Comparable<C4814c> {
        int a;
        int b;

        private C4814c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull C4814c c4814c) {
            int i = this.b;
            int i2 = c4814c.b;
            return i != i2 ? i - i2 : this.a - c4814c.a;
        }

        public String toString() {
            return "Order{order=" + this.b + ", index=" + this.a + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4811b(FlexContainer flexContainer) {
        this.a = flexContainer;
    }

    private int A(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int B(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int C(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int D(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int E(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int F(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int G(boolean z) {
        if (z) {
            return this.a.getPaddingBottom();
        }
        return this.a.getPaddingEnd();
    }

    private int H(boolean z) {
        if (z) {
            return this.a.getPaddingEnd();
        }
        return this.a.getPaddingBottom();
    }

    private int I(boolean z) {
        if (z) {
            return this.a.getPaddingTop();
        }
        return this.a.getPaddingStart();
    }

    private int J(boolean z) {
        if (z) {
            return this.a.getPaddingStart();
        }
        return this.a.getPaddingTop();
    }

    private int K(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int L(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean M(int i, int i2, C4810a c4810a) {
        return i == i2 - 1 && c4810a.c() != 0;
    }

    private boolean O(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.a.getMaxLine();
        if (maxLine == -1 || maxLine > i7 + 1) {
            int decorationLengthMainAxis = this.a.getDecorationLengthMainAxis(view, i5, i6);
            if (decorationLengthMainAxis > 0) {
                i4 += decorationLengthMainAxis;
            }
            return i2 < i3 + i4;
        }
        return false;
    }

    private void S(int i, int i2, C4810a c4810a, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8 = c4810a.e;
        float f = c4810a.k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i8) {
            return;
        }
        float f3 = (i8 - i3) / f;
        c4810a.e = i4 + c4810a.f;
        if (!z) {
            c4810a.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < c4810a.h) {
            int i11 = c4810a.o + i9;
            View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i5 = i8;
                i6 = i9;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredHeight = w(jArr[i11]);
                    }
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredWidth = x(jArr2[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexShrink() <= f2) {
                        i5 = i8;
                        i6 = i9;
                    } else {
                        float flexShrink = measuredHeight - (flexItem.getFlexShrink() * f3);
                        if (i9 == c4810a.h - 1) {
                            flexShrink += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(flexShrink);
                        if (round < flexItem.getMinHeight()) {
                            round = flexItem.getMinHeight();
                            this.b[i11] = true;
                            c4810a.k -= flexItem.getFlexShrink();
                            i5 = i8;
                            i6 = i9;
                            z2 = true;
                        } else {
                            f4 += flexShrink - round;
                            i5 = i8;
                            i6 = i9;
                            double d = f4;
                            if (d > 1.0d) {
                                round++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                round--;
                                f4 += 1.0f;
                            }
                        }
                        int z3 = z(i, flexItem, c4810a.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(z3, makeMeasureSpec);
                        measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Y(i11, z3, makeMeasureSpec, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight = measuredHeight2;
                    }
                    i7 = Math.max(i10, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    c4810a.e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                } else {
                    i5 = i8;
                    int i12 = i9;
                    int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredWidth2 = x(jArr3[i11]);
                    }
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredHeight3 = w(jArr4[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexShrink() <= 0.0f) {
                        i6 = i12;
                    } else {
                        float flexShrink2 = measuredWidth2 - (flexItem.getFlexShrink() * f3);
                        i6 = i12;
                        if (i6 == c4810a.h - 1) {
                            flexShrink2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(flexShrink2);
                        if (round2 < flexItem.getMinWidth()) {
                            round2 = flexItem.getMinWidth();
                            this.b[i11] = true;
                            c4810a.k -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            f4 += flexShrink2 - round2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                round2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round2--;
                                f4 += 1.0f;
                            }
                        }
                        int y = y(i2, flexItem, c4810a.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec2, y);
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Y(i11, makeMeasureSpec2, y, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i10, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    c4810a.e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i7 = max;
                }
                c4810a.g = Math.max(c4810a.g, i7);
                i10 = i7;
            }
            i9 = i6 + 1;
            i8 = i5;
            f2 = 0.0f;
        }
        int i13 = i8;
        if (!z2 || i13 == c4810a.e) {
            return;
        }
        S(i, i2, c4810a, i3, i4, true);
    }

    private int[] T(int i, List<C4814c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (C4814c c4814c : list) {
            int i3 = c4814c.a;
            iArr[i2] = i3;
            sparseIntArray.append(i3, c4814c.b);
            i2++;
        }
        return iArr;
    }

    private void U(View view, int i, int i2) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.e;
        if (jArr != null) {
            measuredHeight = w(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Y(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.updateViewCache(i2, view);
    }

    private void V(View view, int i, int i2) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.e;
        if (jArr != null) {
            measuredWidth = x(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Y(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.updateViewCache(i2, view);
    }

    private void Y(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = R(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = R(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<C4810a> list, C4810a c4810a, int i, int i2) {
        c4810a.m = i2;
        this.a.onNewFlexLineAdded(c4810a);
        c4810a.p = i;
        list.add(c4810a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Y(r8, r1, r0, r7)
            com.google.android.flexbox.FlexContainer r0 = r6.a
            r0.updateViewCache(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.C4811b.i(android.view.View, int):void");
    }

    private List<C4810a> k(List<C4810a> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        C4810a c4810a = new C4810a();
        c4810a.g = (i - i2) / 2;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                arrayList.add(c4810a);
            }
            arrayList.add(list.get(i3));
            if (i3 == list.size() - 1) {
                arrayList.add(c4810a);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<C4814c> l(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            C4814c c4814c = new C4814c();
            c4814c.b = ((FlexItem) this.a.getFlexItemAt(i2).getLayoutParams()).getOrder();
            c4814c.a = i2;
            arrayList.add(c4814c);
        }
        return arrayList;
    }

    private void r(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.b = new boolean[i];
        } else if (zArr.length < i) {
            int length = zArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.b = new boolean[i];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(int i, int i2, C4810a c4810a, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        double d;
        int i8;
        double d2;
        float f = c4810a.j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = c4810a.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        c4810a.e = i4 + c4810a.f;
        if (!z) {
            c4810a.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f4 = 0.0f;
        while (i9 < c4810a.h) {
            int i11 = c4810a.o + i9;
            View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i6 = i5;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredHeight = w(jArr[i11]);
                    }
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredWidth = x(jArr2[i11]);
                    }
                    if (this.b[i11] || flexItem.getFlexGrow() <= f2) {
                        i8 = i5;
                    } else {
                        float flexGrow = measuredHeight + (flexItem.getFlexGrow() * f3);
                        if (i9 == c4810a.h - 1) {
                            flexGrow += f4;
                            f4 = 0.0f;
                        }
                        int round = Math.round(flexGrow);
                        if (round > flexItem.getMaxHeight()) {
                            round = flexItem.getMaxHeight();
                            this.b[i11] = true;
                            c4810a.j -= flexItem.getFlexGrow();
                            i8 = i5;
                            z2 = true;
                        } else {
                            f4 += flexGrow - round;
                            i8 = i5;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                round++;
                                d2 = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                round--;
                                d2 = d3 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int z3 = z(i, flexItem, c4810a.m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(z3, makeMeasureSpec);
                        measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Y(i11, z3, makeMeasureSpec, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight = measuredHeight2;
                    }
                    i7 = Math.max(i10, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    c4810a.e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i6 = i8;
                } else {
                    int i12 = i5;
                    int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredWidth2 = x(jArr3[i11]);
                    }
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr4 = this.e;
                    i6 = i12;
                    if (jArr4 != null) {
                        measuredHeight3 = w(jArr4[i11]);
                    }
                    if (!this.b[i11] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow2 = measuredWidth2 + (flexItem.getFlexGrow() * f3);
                        if (i9 == c4810a.h - 1) {
                            flexGrow2 += f4;
                            f4 = 0.0f;
                        }
                        int round2 = Math.round(flexGrow2);
                        if (round2 > flexItem.getMaxWidth()) {
                            round2 = flexItem.getMaxWidth();
                            this.b[i11] = true;
                            c4810a.j -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            f4 += flexGrow2 - round2;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                round2++;
                                d = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round2--;
                                d = d4 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int y = y(i2, flexItem, c4810a.m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec2, y);
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Y(i11, makeMeasureSpec2, y, reorderedFlexItemAt);
                        this.a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i10, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    c4810a.e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i7 = max;
                }
                c4810a.g = Math.max(c4810a.g, i7);
                i10 = i7;
            }
            i9++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i13 = i5;
        if (!z2 || i13 == c4810a.e) {
            return;
        }
        v(i, i2, c4810a, i3, i4, true);
    }

    private int y(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i, flexContainer.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    private int z(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.a;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i, flexContainer.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.a.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(View view, C4810a c4810a, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = c4810a.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i3, i6 - flexItem.getMarginBottom());
                    return;
                }
                view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop(), i3, (i4 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            } else if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                }
                int i8 = i2 - measuredHeight;
                view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                return;
            } else if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int max = Math.max(c4810a.l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                }
                int max2 = Math.max((c4810a.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                view.layout(i, i2 - max2, i3, i4 - max2);
                return;
            } else if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i, i2 + flexItem.getMarginTop(), i3, i4 + flexItem.getMarginTop());
        } else {
            view.layout(i, i2 - flexItem.getMarginBottom(), i3, i4 - flexItem.getMarginBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(View view, C4810a c4810a, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = c4810a.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i2, (i3 - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i4);
                    return;
                }
            } else if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            } else if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + flexItem.getMarginLeft(), i2, i3 + flexItem.getMarginLeft(), i4);
        } else {
            view.layout(i - flexItem.getMarginRight(), i2, i3 - flexItem.getMarginRight(), i4);
        }
    }

    @VisibleForTesting
    long R(int i, int i2) {
        return (i & 4294967295L) | (i2 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        X(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(int i) {
        View reorderedFlexItemAt;
        if (i >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() == 4) {
            int[] iArr = this.c;
            List<C4810a> flexLinesInternal = this.a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                C4810a c4810a = flexLinesInternal.get(i2);
                int i3 = c4810a.h;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = c4810a.o + i4;
                    if (i4 < this.a.getFlexItemCount() && (reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i5)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                V(reorderedFlexItemAt, c4810a.g, i5);
                            } else if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            } else {
                                U(reorderedFlexItemAt, c4810a.g, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (C4810a c4810a2 : this.a.getFlexLinesInternal()) {
            for (Integer num : c4810a2.n) {
                View reorderedFlexItemAt2 = this.a.getReorderedFlexItemAt(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    V(reorderedFlexItemAt2, c4810a2.g, num.intValue());
                } else if (flexDirection != 2 && flexDirection != 3) {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                } else {
                    U(reorderedFlexItemAt2, c4810a2.g, num.intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(C4813b c4813b, int i, int i2, int i3, int i4, int i5, @Nullable List<C4810a> list) {
        int i6;
        C4813b c4813b2;
        int i7;
        int i8;
        int i9;
        List<C4810a> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        C4810a c4810a;
        int i17;
        int i18 = i;
        int i19 = i2;
        int i20 = i5;
        boolean isMainAxisDirectionHorizontal = this.a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        c4813b.a = arrayList;
        boolean z = i20 == -1;
        int J = J(isMainAxisDirectionHorizontal);
        int H = H(isMainAxisDirectionHorizontal);
        int I = I(isMainAxisDirectionHorizontal);
        int G = G(isMainAxisDirectionHorizontal);
        C4810a c4810a2 = new C4810a();
        int i21 = i4;
        c4810a2.o = i21;
        int i22 = H + J;
        c4810a2.e = i22;
        int flexItemCount = this.a.getFlexItemCount();
        boolean z2 = z;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i21 >= flexItemCount) {
                i6 = i24;
                c4813b2 = c4813b;
                break;
            }
            View reorderedFlexItemAt = this.a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null) {
                if (M(i21, flexItemCount, c4810a2)) {
                    a(arrayList, c4810a2, i21, i23);
                }
            } else if (reorderedFlexItemAt.getVisibility() == 8) {
                c4810a2.i++;
                c4810a2.h++;
                if (M(i21, flexItemCount, c4810a2)) {
                    a(arrayList, c4810a2, i21, i23);
                }
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int i27 = flexItemCount;
                if (flexItem.getAlignSelf() == 4) {
                    c4810a2.n.add(Integer.valueOf(i21));
                }
                int F = F(flexItem, isMainAxisDirectionHorizontal);
                if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                    F = Math.round(size * flexItem.getFlexBasisPercent());
                }
                if (isMainAxisDirectionHorizontal) {
                    int childWidthMeasureSpec = this.a.getChildWidthMeasureSpec(i18, i22 + D(flexItem, true) + B(flexItem, true), F);
                    i7 = size;
                    i8 = mode;
                    int childHeightMeasureSpec = this.a.getChildHeightMeasureSpec(i19, I + G + C(flexItem, true) + A(flexItem, true) + i23, E(flexItem, true));
                    reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    Y(i21, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                    i9 = childWidthMeasureSpec;
                } else {
                    i7 = size;
                    i8 = mode;
                    int childWidthMeasureSpec2 = this.a.getChildWidthMeasureSpec(i19, I + G + C(flexItem, false) + A(flexItem, false) + i23, E(flexItem, false));
                    int childHeightMeasureSpec2 = this.a.getChildHeightMeasureSpec(i18, D(flexItem, false) + i22 + B(flexItem, false), F);
                    reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                    Y(i21, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                    i9 = childHeightMeasureSpec2;
                }
                this.a.updateViewCache(i21, reorderedFlexItemAt);
                i(reorderedFlexItemAt, i21);
                i24 = View.combineMeasuredStates(i24, reorderedFlexItemAt.getMeasuredState());
                int i28 = i23;
                int i29 = i22;
                C4810a c4810a3 = c4810a2;
                int i30 = i21;
                list2 = arrayList;
                int i31 = i9;
                if (O(reorderedFlexItemAt, i8, i7, c4810a2.e, B(flexItem, isMainAxisDirectionHorizontal) + L(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal), flexItem, i30, i25, arrayList.size())) {
                    if (c4810a3.c() > 0) {
                        if (i30 > 0) {
                            i17 = i30 - 1;
                            c4810a = c4810a3;
                        } else {
                            c4810a = c4810a3;
                            i17 = 0;
                        }
                        a(list2, c4810a, i17, i28);
                        i23 = c4810a.g + i28;
                    } else {
                        i23 = i28;
                    }
                    if (isMainAxisDirectionHorizontal) {
                        if (flexItem.getHeight() == -1) {
                            FlexContainer flexContainer = this.a;
                            i10 = i2;
                            i21 = i30;
                            view = reorderedFlexItemAt;
                            view.measure(i31, flexContainer.getChildHeightMeasureSpec(i10, flexContainer.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i23, flexItem.getHeight()));
                            i(view, i21);
                        } else {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i21 = i30;
                        }
                    } else {
                        i10 = i2;
                        view = reorderedFlexItemAt;
                        i21 = i30;
                        if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer2 = this.a;
                            view.measure(flexContainer2.getChildWidthMeasureSpec(i10, flexContainer2.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i23, flexItem.getWidth()), i31);
                            i(view, i21);
                        }
                    }
                    c4810a2 = new C4810a();
                    c4810a2.h = 1;
                    i11 = i29;
                    c4810a2.e = i11;
                    c4810a2.o = i21;
                    i12 = 0;
                    i13 = Integer.MIN_VALUE;
                } else {
                    i10 = i2;
                    view = reorderedFlexItemAt;
                    i21 = i30;
                    c4810a2 = c4810a3;
                    i11 = i29;
                    c4810a2.h++;
                    i12 = i25 + 1;
                    i23 = i28;
                    i13 = i26;
                }
                int[] iArr = this.c;
                if (iArr != null) {
                    iArr[i21] = list2.size();
                }
                c4810a2.e += L(view, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal) + B(flexItem, isMainAxisDirectionHorizontal);
                c4810a2.j += flexItem.getFlexGrow();
                c4810a2.k += flexItem.getFlexShrink();
                this.a.onNewFlexItemAdded(view, i21, i12, c4810a2);
                int max = Math.max(i13, K(view, isMainAxisDirectionHorizontal) + C(flexItem, isMainAxisDirectionHorizontal) + A(flexItem, isMainAxisDirectionHorizontal) + this.a.getDecorationLengthCrossAxis(view));
                c4810a2.g = Math.max(c4810a2.g, max);
                if (isMainAxisDirectionHorizontal) {
                    if (this.a.getFlexWrap() != 2) {
                        c4810a2.l = Math.max(c4810a2.l, view.getBaseline() + flexItem.getMarginTop());
                    } else {
                        c4810a2.l = Math.max(c4810a2.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                    }
                }
                i14 = i27;
                if (M(i21, i14, c4810a2)) {
                    a(list2, c4810a2, i21, i23);
                    i23 += c4810a2.g;
                }
                i15 = i5;
                if (i15 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i15 && i21 >= i15 && !z2) {
                        i23 = -c4810a2.a();
                        i16 = i3;
                        z2 = true;
                        if (i23 <= i16 && z2) {
                            c4813b2 = c4813b;
                            i6 = i24;
                            break;
                        }
                        i25 = i12;
                        i26 = max;
                        i21++;
                        i18 = i;
                        flexItemCount = i14;
                        i19 = i10;
                        i22 = i11;
                        arrayList = list2;
                        mode = i8;
                        i20 = i15;
                        size = i7;
                    }
                }
                i16 = i3;
                if (i23 <= i16) {
                }
                i25 = i12;
                i26 = max;
                i21++;
                i18 = i;
                flexItemCount = i14;
                i19 = i10;
                i22 = i11;
                arrayList = list2;
                mode = i8;
                i20 = i15;
                size = i7;
            }
            i7 = size;
            i8 = mode;
            i10 = i19;
            i15 = i20;
            list2 = arrayList;
            i11 = i22;
            i14 = flexItemCount;
            i21++;
            i18 = i;
            flexItemCount = i14;
            i19 = i10;
            i22 = i11;
            arrayList = list2;
            mode = i8;
            i20 = i15;
            size = i7;
        }
        c4813b2.b = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(C4813b c4813b, int i, int i2) {
        b(c4813b, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(C4813b c4813b, int i, int i2, int i3, int i4, @Nullable List<C4810a> list) {
        b(c4813b, i, i2, i3, i4, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(C4813b c4813b, int i, int i2, int i3, int i4, List<C4810a> list) {
        b(c4813b, i, i2, i3, 0, i4, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(C4813b c4813b, int i, int i2) {
        b(c4813b, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(C4813b c4813b, int i, int i2, int i3, int i4, @Nullable List<C4810a> list) {
        b(c4813b, i2, i, i3, i4, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(C4813b c4813b, int i, int i2, int i3, int i4, List<C4810a> list) {
        b(c4813b, i2, i, i3, 0, i4, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List<C4810a> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        return T(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] n(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        List<C4814c> l = l(flexItemCount);
        C4814c c4814c = new C4814c();
        if (view != null && (layoutParams instanceof FlexItem)) {
            c4814c.b = ((FlexItem) layoutParams).getOrder();
        } else {
            c4814c.b = 1;
        }
        if (i != -1 && i != flexItemCount) {
            if (i < this.a.getFlexItemCount()) {
                c4814c.a = i;
                while (i < flexItemCount) {
                    l.get(i).a++;
                    i++;
                }
            } else {
                c4814c.a = flexItemCount;
            }
        } else {
            c4814c.a = flexItemCount;
        }
        l.add(c4814c);
        return T(flexItemCount + 1, l, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        } else if (flexDirection != 2 && flexDirection != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            i4 = View.MeasureSpec.getMode(i);
            i5 = View.MeasureSpec.getSize(i);
        }
        List<C4810a> flexLinesInternal = this.a.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = i5 - i3;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    C4810a c4810a = new C4810a();
                    c4810a.g = i7;
                    flexLinesInternal.add(0, c4810a);
                } else if (alignContent == 2) {
                    this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                } else if (alignContent == 3) {
                    if (sumOfCrossSize >= i5) {
                        return;
                    }
                    float size2 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i6 < size3) {
                        arrayList.add(flexLinesInternal.get(i6));
                        if (i6 != flexLinesInternal.size() - 1) {
                            C4810a c4810a2 = new C4810a();
                            if (i6 == flexLinesInternal.size() - 2) {
                                c4810a2.g = Math.round(f + size2);
                                f = 0.0f;
                            } else {
                                c4810a2.g = Math.round(size2);
                            }
                            int i8 = c4810a2.g;
                            f += size2 - i8;
                            if (f > 1.0f) {
                                c4810a2.g = i8 + 1;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                c4810a2.g = i8 - 1;
                                f += 1.0f;
                            }
                            arrayList.add(c4810a2);
                        }
                        i6++;
                    }
                    this.a.setFlexLines(arrayList);
                } else if (alignContent == 4) {
                    if (sumOfCrossSize >= i5) {
                        this.a.setFlexLines(k(flexLinesInternal, i5, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    C4810a c4810a3 = new C4810a();
                    c4810a3.g = size4;
                    for (C4810a c4810a4 : flexLinesInternal) {
                        arrayList2.add(c4810a3);
                        arrayList2.add(c4810a4);
                        arrayList2.add(c4810a3);
                    }
                    this.a.setFlexLines(arrayList2);
                } else if (alignContent == 5 && sumOfCrossSize < i5) {
                    float size5 = (i5 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i6 < size6) {
                        C4810a c4810a5 = flexLinesInternal.get(i6);
                        float f3 = c4810a5.g + size5;
                        if (i6 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = Math.round(f3);
                        f2 += f3 - round;
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        c4810a5.g = round;
                        i6++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i, int i2) {
        q(i, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.a.getFlexItemCount());
        if (i3 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            if (mode != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else if (flexDirection2 != 2 && flexDirection2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.c;
        int i5 = iArr != null ? iArr[i3] : 0;
        List<C4810a> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i6 = i5; i6 < size2; i6++) {
            C4810a c4810a = flexLinesInternal.get(i6);
            if (c4810a.e < size) {
                v(i, i2, c4810a, size, i4, false);
            } else {
                S(i, i2, c4810a, size, i4, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.c = Arrays.copyOf(iArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.d = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.e = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(long j) {
        return (int) j;
    }
}
