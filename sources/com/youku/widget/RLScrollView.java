package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RLScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public RLScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setOnScrollListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public RLScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RLScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
