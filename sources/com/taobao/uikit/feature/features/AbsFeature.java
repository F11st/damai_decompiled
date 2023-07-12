package com.taobao.uikit.feature.features;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbsFeature<T extends View> {
    protected T mHost;

    public AbsFeature() {
        constructor(null, null, 0);
    }

    public abstract void constructor(Context context, AttributeSet attributeSet, int i);

    public T getHost() {
        return this.mHost;
    }

    public void setHost(T t) {
        this.mHost = t;
    }
}
