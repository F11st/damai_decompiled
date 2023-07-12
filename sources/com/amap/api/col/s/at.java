package com.amap.api.col.s;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class at<T, V> extends AbstractC4379b<T, V> {
    public at(Context context, T t) {
        super(context, t);
    }

    public final T c_() {
        return ((AbstractC4370a) this).b;
    }

    @Override // com.amap.api.col.s.df
    public String h() {
        return C4434h.a() + "/weather/weatherInfo?";
    }
}
