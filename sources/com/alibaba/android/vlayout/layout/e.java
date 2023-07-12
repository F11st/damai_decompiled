package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import java.util.Arrays;
import tb.m81;
import tb.r1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class e extends r1 {
    private View[] e;
    private Rect d = new Rect();
    private float[] f = new float[0];
    private float g = Float.NaN;

    public e() {
        setItemCount(0);
    }

    private float f(int i) {
        float[] fArr = this.f;
        if (fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }

    private int g(VirtualLayoutManager.d dVar, m81 m81Var, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        com.alibaba.android.vlayout.c cVar;
        View view;
        int i5;
        VirtualLayoutManager.LayoutParams layoutParams;
        View view2;
        int i6;
        View view3;
        int i7;
        com.alibaba.android.vlayout.c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view4 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[6] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        View view6 = layoutManagerHelper.getReverseLayout() ? this.e[5] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        View view7 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view7.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view8 = reverseLayout ? viewArr[3] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view8.getLayoutParams();
        boolean reverseLayout2 = layoutManagerHelper.getReverseLayout();
        View[] viewArr2 = this.e;
        View view9 = reverseLayout2 ? viewArr2[2] : viewArr2[5];
        VirtualLayoutManager.LayoutParams layoutParams7 = (VirtualLayoutManager.LayoutParams) view9.getLayoutParams();
        if (layoutManagerHelper.getReverseLayout()) {
            cVar = mainOrientationHelper;
            view = this.e[1];
        } else {
            cVar = mainOrientationHelper;
            view = this.e[6];
        }
        VirtualLayoutManager.LayoutParams layoutParams8 = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
        View view10 = view;
        float f = f(0);
        float f2 = f(1);
        float f3 = f(2);
        float f4 = f(3);
        float f5 = f(4);
        View view11 = view9;
        float f6 = f(5);
        float f7 = f(6);
        if (z) {
            View view12 = view8;
            if (Float.isNaN(this.mAspectRatio)) {
                layoutParams = layoutParams6;
            } else {
                layoutParams = layoutParams6;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((i - i3) / this.mAspectRatio);
            }
            int i8 = ((((((i - i3) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i9 = (int) ((Float.isNaN(f) ? i8 / 3.0f : (i8 * f) / 100.0f) + 0.5f);
            if (Float.isNaN(f2)) {
                i6 = (i8 - i9) / 2;
                view2 = view7;
            } else {
                view2 = view7;
                i6 = (int) (((i8 * f2) / 100.0f) + 0.5f);
            }
            if (Float.isNaN(f3)) {
                view3 = view6;
                i7 = i6;
            } else {
                view3 = view6;
                i7 = (int) (((i8 * f3) / 100.0f) + 0.5d);
            }
            int i10 = Float.isNaN(f4) ? i6 : (int) (((i8 * f4) / 100.0f) + 0.5f);
            int i11 = Float.isNaN(f5) ? i6 : (int) (((i8 * f5) / 100.0f) + 0.5f);
            int i12 = Float.isNaN(f6) ? i6 : (int) (((i8 * f6) / 100.0f) + 0.5f);
            int i13 = Float.isNaN(f6) ? i6 : (int) (((i8 * f7) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view4, View.MeasureSpec.makeMeasureSpec(i9 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
            int measuredHeight = view4.getMeasuredHeight();
            int i14 = (int) ((Float.isNaN(this.g) ? ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) / 3.0f : (((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) * this.g) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i6 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, 1073741824));
            View view13 = view3;
            layoutManagerHelper.measureChildWithMargins(view13, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view2, View.MeasureSpec.makeMeasureSpec(i10 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, 1073741824));
            VirtualLayoutManager.LayoutParams layoutParams9 = layoutParams;
            layoutManagerHelper.measureChildWithMargins(view12, View.MeasureSpec.makeMeasureSpec(i11 + ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view11, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view10, View.MeasureSpec.makeMeasureSpec(i13 + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, Math.max(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, i14 + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            a((max - getVerticalMargin()) - getVerticalPadding(), this.d, dVar, layoutManagerHelper);
            com.alibaba.android.vlayout.c cVar2 = cVar;
            int f8 = this.d.left + cVar2.f(view4);
            Rect rect = this.d;
            layoutChildWithMargin(view4, rect.left, rect.top, f8, rect.bottom, layoutManagerHelper);
            int f9 = f8 + cVar2.f(view5);
            int i15 = this.d.top;
            layoutChildWithMargin(view5, f8, i15, f9, i15 + cVar2.e(view5), layoutManagerHelper);
            int f10 = f9 + cVar2.f(view13);
            int i16 = this.d.top;
            layoutChildWithMargin(view13, f9, i16, f10, i16 + cVar2.e(view13), layoutManagerHelper);
            View view14 = view2;
            int f11 = f8 + cVar2.f(view14);
            layoutChildWithMargin(view14, f8, this.d.top + cVar2.e(view5), f11, this.d.bottom - cVar2.e(view11), layoutManagerHelper);
            layoutChildWithMargin(view12, f11, this.d.top + cVar2.e(view5), f11 + cVar2.f(view12), this.d.bottom - cVar2.e(view10), layoutManagerHelper);
            int f12 = f8 + cVar2.f(view11);
            layoutChildWithMargin(view11, f8, this.d.bottom - cVar2.e(view11), f12, this.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view10, f12, this.d.bottom - cVar2.e(view10), f12 + cVar2.f(view10), this.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            i5 = 0;
        }
        handleStateOnResult(m81Var, this.e);
        return i5;
    }

    private int h(VirtualLayoutManager.d dVar, m81 m81Var, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        e eVar;
        int i5;
        View view;
        View view2;
        int i6;
        int i7;
        VirtualLayoutManager.LayoutParams layoutParams;
        int i8;
        VirtualLayoutManager.LayoutParams layoutParams2;
        float f;
        com.alibaba.android.vlayout.c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view3 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view3.getLayoutParams();
        View view4 = layoutManagerHelper.getReverseLayout() ? this.e[5] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        View view6 = layoutManagerHelper.getReverseLayout() ? this.e[3] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view7 = reverseLayout ? viewArr[2] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams7 = (VirtualLayoutManager.LayoutParams) view7.getLayoutParams();
        boolean reverseLayout2 = layoutManagerHelper.getReverseLayout();
        View[] viewArr2 = this.e;
        View view8 = reverseLayout2 ? viewArr2[1] : viewArr2[5];
        VirtualLayoutManager.LayoutParams layoutParams8 = (VirtualLayoutManager.LayoutParams) view8.getLayoutParams();
        float f2 = f(0);
        float f3 = f(1);
        float f4 = f(2);
        float f5 = f(3);
        float f6 = f(4);
        View view9 = view8;
        float f7 = f(5);
        if (z) {
            View view10 = view7;
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
            int i9 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = i9;
            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = i9;
            ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            if (Float.isNaN(this.mAspectRatio)) {
                view = view6;
            } else {
                view = view6;
                ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) ((i - i3) / this.mAspectRatio);
            }
            int i10 = i - i3;
            int i11 = (((i10 - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i12 = (int) ((Float.isNaN(f2) ? i11 / 2.0f : (i11 * f2) / 100.0f) + 0.5f);
            if (Float.isNaN(f3)) {
                view2 = view4;
                i6 = i11 - i12;
            } else {
                view2 = view4;
                i6 = (int) (((i11 * f3) / 100.0f) + 0.5f);
            }
            if (Float.isNaN(f4)) {
                layoutParams = layoutParams5;
                i7 = i6;
                i8 = i7;
            } else {
                i7 = i6;
                layoutParams = layoutParams5;
                i8 = (int) (((i11 * f4) / 100.0f) + 0.5d);
            }
            int i13 = (int) ((Float.isNaN(f5) ? ((((((i10 - ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin) / 3.0f : (i11 * f5) / 100.0f) + 0.5f);
            int i14 = Float.isNaN(f6) ? i13 : (int) (((i11 * f6) / 100.0f) + 0.5f);
            int i15 = Float.isNaN(f7) ? i13 : (int) (((i11 * f7) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view3, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams3).height, true));
            int measuredHeight = view3.getMeasuredHeight();
            if (Float.isNaN(this.g)) {
                layoutParams2 = layoutParams;
                f = ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) / 2.0f;
            } else {
                layoutParams2 = layoutParams;
                f = (((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) * this.g) / 100.0f;
            }
            int i16 = (int) (f + 0.5f);
            int i17 = ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - i16;
            View view11 = view2;
            layoutManagerHelper.measureChildWithMargins(view11, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i16 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i8 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, 1073741824));
            View view12 = view;
            layoutManagerHelper.measureChildWithMargins(view12, View.MeasureSpec.makeMeasureSpec(i13 + ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view10, View.MeasureSpec.makeMeasureSpec(i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view9, View.MeasureSpec.makeMeasureSpec(i15 + ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, (i16 + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) * 2) + Math.max(((ViewGroup.MarginLayoutParams) layoutParams6).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin, Math.max(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i17 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, i17 + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            eVar = this;
            eVar.a((max - getVerticalMargin()) - getVerticalPadding(), eVar.d, dVar, layoutManagerHelper);
            int f8 = eVar.d.left + mainOrientationHelper.f(view3);
            Rect rect = eVar.d;
            layoutChildWithMargin(view3, rect.left, rect.top, f8, rect.bottom - mainOrientationHelper.e(view12), layoutManagerHelper);
            int f9 = f8 + mainOrientationHelper.f(view11);
            int i18 = eVar.d.top;
            layoutChildWithMargin(view11, f8, i18, f9, i18 + mainOrientationHelper.e(view11), layoutManagerHelper);
            layoutChildWithMargin(view5, f8, eVar.d.top + mainOrientationHelper.e(view5), f8 + mainOrientationHelper.f(view5), eVar.d.bottom - mainOrientationHelper.e(view12), layoutManagerHelper);
            int f10 = eVar.d.left + mainOrientationHelper.f(view12);
            Rect rect2 = eVar.d;
            layoutChildWithMargin(view12, rect2.left, rect2.bottom - mainOrientationHelper.e(view12), f10, eVar.d.bottom, layoutManagerHelper);
            int f11 = f10 + mainOrientationHelper.f(view10);
            layoutChildWithMargin(view10, f10, eVar.d.bottom - mainOrientationHelper.e(view10), f11, eVar.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view9, f11, eVar.d.bottom - mainOrientationHelper.e(view9), f11 + mainOrientationHelper.f(view9), eVar.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            eVar = this;
            i5 = 0;
        }
        eVar.handleStateOnResult(m81Var, eVar.e);
        return i5;
    }

    private int i(VirtualLayoutManager.d dVar, m81 m81Var, LayoutManagerHelper layoutManagerHelper, boolean z, int i, int i2, int i3, int i4) {
        e eVar;
        int i5;
        com.alibaba.android.vlayout.c cVar;
        View view;
        int i6;
        VirtualLayoutManager.LayoutParams layoutParams;
        int i7;
        com.alibaba.android.vlayout.c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View view2 = this.e[0];
        VirtualLayoutManager.LayoutParams layoutParams2 = (VirtualLayoutManager.LayoutParams) view2.getLayoutParams();
        View view3 = layoutManagerHelper.getReverseLayout() ? this.e[4] : this.e[1];
        VirtualLayoutManager.LayoutParams layoutParams3 = (VirtualLayoutManager.LayoutParams) view3.getLayoutParams();
        View view4 = layoutManagerHelper.getReverseLayout() ? this.e[3] : this.e[2];
        VirtualLayoutManager.LayoutParams layoutParams4 = (VirtualLayoutManager.LayoutParams) view4.getLayoutParams();
        View view5 = layoutManagerHelper.getReverseLayout() ? this.e[2] : this.e[3];
        VirtualLayoutManager.LayoutParams layoutParams5 = (VirtualLayoutManager.LayoutParams) view5.getLayoutParams();
        boolean reverseLayout = layoutManagerHelper.getReverseLayout();
        View[] viewArr = this.e;
        View view6 = reverseLayout ? viewArr[1] : viewArr[4];
        VirtualLayoutManager.LayoutParams layoutParams6 = (VirtualLayoutManager.LayoutParams) view6.getLayoutParams();
        float f = f(0);
        float f2 = f(1);
        float f3 = f(2);
        float f4 = f(3);
        float f5 = f(4);
        if (z) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = i8;
            ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i8;
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            if (Float.isNaN(this.mAspectRatio)) {
                cVar = mainOrientationHelper;
            } else {
                cVar = mainOrientationHelper;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((i - i3) / this.mAspectRatio);
            }
            int i9 = ((((((i - i3) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            int i10 = (int) ((Float.isNaN(f) ? i9 / 3.0f : (i9 * f) / 100.0f) + 0.5f);
            if (Float.isNaN(f2)) {
                i6 = (i9 - i10) / 2;
                view = view6;
            } else {
                view = view6;
                i6 = (int) (((i9 * f2) / 100.0f) + 0.5f);
            }
            int i11 = Float.isNaN(f3) ? i6 : (int) (((i9 * f3) / 100.0f) + 0.5f);
            if (Float.isNaN(f4)) {
                layoutParams = layoutParams6;
                i7 = i6;
            } else {
                layoutParams = layoutParams6;
                i7 = (int) (((i9 * f4) / 100.0f) + 0.5f);
            }
            int i12 = Float.isNaN(f5) ? i6 : (int) (((i9 * f5) / 100.0f) + 0.5f);
            layoutManagerHelper.measureChildWithMargins(view2, View.MeasureSpec.makeMeasureSpec(i10 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, 1073741824), layoutManagerHelper.getChildMeasureSpec(layoutManagerHelper.getContentHeight(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
            int measuredHeight = view2.getMeasuredHeight();
            int i13 = (int) ((Float.isNaN(this.g) ? ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) / 2.0f : (((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) * this.g) / 100.0f) + 0.5f);
            int i14 = ((measuredHeight - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin) - ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin) - i13;
            layoutManagerHelper.measureChildWithMargins(view3, View.MeasureSpec.makeMeasureSpec(i6 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + i13 + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view4, View.MeasureSpec.makeMeasureSpec(i11 + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, 1073741824));
            layoutManagerHelper.measureChildWithMargins(view5, View.MeasureSpec.makeMeasureSpec(i7 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin, 1073741824));
            VirtualLayoutManager.LayoutParams layoutParams7 = layoutParams;
            View view7 = view;
            layoutManagerHelper.measureChildWithMargins(view7, View.MeasureSpec.makeMeasureSpec(i12 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin, 1073741824));
            int max = Math.max(measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, i13 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + Math.max(((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + i14 + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin, i14 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin)) + getVerticalMargin() + getVerticalPadding();
            eVar = this;
            eVar.a((max - getVerticalMargin()) - getVerticalPadding(), eVar.d, dVar, layoutManagerHelper);
            com.alibaba.android.vlayout.c cVar2 = cVar;
            int f6 = eVar.d.left + cVar2.f(view2);
            Rect rect = eVar.d;
            layoutChildWithMargin(view2, rect.left, rect.top, f6, rect.bottom, layoutManagerHelper);
            int f7 = f6 + cVar2.f(view3);
            int i15 = eVar.d.top;
            layoutChildWithMargin(view3, f6, i15, f7, i15 + cVar2.e(view3), layoutManagerHelper);
            int f8 = f7 + cVar2.f(view4);
            int i16 = eVar.d.top;
            layoutChildWithMargin(view4, f7, i16, f8, i16 + cVar2.e(view4), layoutManagerHelper);
            int f9 = f6 + cVar2.f(view5);
            layoutChildWithMargin(view5, f6, eVar.d.bottom - cVar2.e(view5), f9, eVar.d.bottom, layoutManagerHelper);
            layoutChildWithMargin(view7, f9, eVar.d.bottom - cVar2.e(view7), f9 + cVar2.f(view7), eVar.d.bottom, layoutManagerHelper);
            i5 = max;
        } else {
            eVar = this;
            i5 = 0;
        }
        eVar.handleStateOnResult(m81Var, eVar.e);
        return i5;
    }

    @Override // tb.r1, com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        if (getItemCount() == 3) {
            if (i == 1 && z) {
                Log.w("OnePlusNLayoutHelper", "Should not happen after adjust anchor");
                return 0;
            }
        } else if (getItemCount() == 4 && i == 1 && z) {
            return 0;
        }
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

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.d dVar, m81 m81Var, LayoutManagerHelper layoutManagerHelper) {
        if (isOutOfRange(dVar.c())) {
            return;
        }
        View[] viewArr = this.e;
        if (viewArr == null || viewArr.length != getItemCount()) {
            this.e = new View[getItemCount()];
        }
        int e = e(this.e, recycler, dVar, m81Var, layoutManagerHelper);
        if (e != getItemCount()) {
            Log.w("OnePlusNLayoutHelper", "The real number of children is not match with range of LayoutHelper");
        }
        int i = 0;
        boolean z = layoutManagerHelper.getOrientation() == 1;
        int contentWidth = layoutManagerHelper.getContentWidth();
        int contentHeight = layoutManagerHelper.getContentHeight();
        int paddingLeft = layoutManagerHelper.getPaddingLeft() + layoutManagerHelper.getPaddingRight() + getHorizontalMargin() + getHorizontalPadding();
        int paddingTop = layoutManagerHelper.getPaddingTop() + layoutManagerHelper.getPaddingBottom() + getVerticalMargin() + getVerticalPadding();
        if (e == 5) {
            i = i(dVar, m81Var, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
        } else if (e == 6) {
            i = h(dVar, m81Var, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
        } else if (e == 7) {
            i = g(dVar, m81Var, layoutManagerHelper, z, contentWidth, contentHeight, paddingLeft, paddingTop);
        }
        m81Var.a = i;
        Arrays.fill(this.e, (Object) null);
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 4) {
            throw new IllegalArgumentException("pls use OnePlusNLayoutHelper instead of OnePlusNLayoutHelperEx which childcount <= 5");
        }
        if (i3 > 6) {
            throw new IllegalArgumentException("OnePlusNLayoutHelper only supports maximum 7 children now");
        }
    }
}
