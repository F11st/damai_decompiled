package com.alibaba.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.responsive.widget.size.OnResponsiveListener;
import tb.d32;
import tb.x22;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ResponsiveRecyclerView extends RecyclerView {
    private OnResponsiveListener mOnResponsiveListener;
    private x22 responsiveSize;

    public ResponsiveRecyclerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = ViewGroup.getDefaultSize(0, i);
        int defaultSize2 = ViewGroup.getDefaultSize(0, i2);
        if (defaultSize != getMeasuredWidth() && this.mOnResponsiveListener != null) {
            if (this.responsiveSize == null) {
                this.responsiveSize = new x22();
            }
            this.responsiveSize.h(defaultSize);
            this.responsiveSize.g(defaultSize2);
            this.responsiveSize.f(d32.d(getContext()));
            this.responsiveSize.e(d32.c(getContext()));
            this.mOnResponsiveListener.onResponsive(this.responsiveSize);
        }
        super.onMeasure(i, i2);
    }

    public void setOnResponsiveListener(OnResponsiveListener onResponsiveListener) {
        this.mOnResponsiveListener = onResponsiveListener;
    }

    public ResponsiveRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResponsiveRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
