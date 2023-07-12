package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuRecyclerView extends RecyclerView {
    public YoukuRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public YoukuRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public YoukuRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
