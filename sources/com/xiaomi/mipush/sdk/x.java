package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class x {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f80a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return !TextUtils.isEmpty(xVar.f80a) && xVar.f80a.equals(this.f80a);
    }
}
