package com.xiaomi.push;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class du extends dt {
    public du(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.dt
    public hl a() {
        return hl.Storage;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "23";
    }

    @Override // com.xiaomi.push.dt
    public String b() {
        return "ram:" + j.m1091a() + ",rom:" + j.m1094b() + "|ramOriginal:" + j.m1096c() + ",romOriginal:" + j.d();
    }
}
