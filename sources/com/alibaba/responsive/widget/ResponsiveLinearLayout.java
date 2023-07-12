package com.alibaba.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.responsive.widget.size.OnResponsiveListener;
import tb.a32;
import tb.x22;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ResponsiveLinearLayout extends LinearLayout {
    a32 responsiveSizeManager;

    public ResponsiveLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        x22 e = this.responsiveSizeManager.e(i, i2);
        if (e.d() > 0) {
            i = View.MeasureSpec.makeMeasureSpec(e.d(), 1073741824);
        }
        if (e.c() > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(e.c(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setHGap(int i) {
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public void setLayoutRatio(int i) {
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public void setMargin(int i) {
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public void setOnResponsiveListener(OnResponsiveListener onResponsiveListener) {
        this.responsiveSizeManager.i(onResponsiveListener);
    }

    public void setRatio(String str) {
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public ResponsiveLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResponsiveLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a32 a32Var = new a32(this);
        this.responsiveSizeManager = a32Var;
        a32Var.d(context, attributeSet);
    }
}
