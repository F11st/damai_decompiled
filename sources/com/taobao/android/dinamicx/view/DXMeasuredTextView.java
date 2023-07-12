package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXMeasuredTextView extends TextView {
    private final long mInitThreadId;

    public DXMeasuredTextView(Context context) {
        super(context);
        this.mInitThreadId = Thread.currentThread().getId();
    }

    public long getInitThreadId() {
        return this.mInitThreadId;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
