package com.baseproject.basecard.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CardRecyclerView extends RecyclerView {
    public CardRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (Exception unused) {
        }
    }

    public CardRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
