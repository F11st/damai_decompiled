package com.taobao.zcache;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public enum Environment {
    Debug(0),
    Daily(1),
    Release(2);
    
    public final int value;

    Environment(int i) {
        this.value = i;
    }
}
