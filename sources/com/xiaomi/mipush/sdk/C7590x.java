package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.x */
/* loaded from: classes11.dex */
class C7590x {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f80a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C7590x)) {
            return false;
        }
        C7590x c7590x = (C7590x) obj;
        return !TextUtils.isEmpty(c7590x.f80a) && c7590x.f80a.equals(this.f80a);
    }
}
