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

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "23";
    }

    @Override // com.xiaomi.push.dt
    public String b() {
        return "ram:" + C7680j.m1091a() + ",rom:" + C7680j.m1094b() + "|ramOriginal:" + C7680j.m1096c() + ",romOriginal:" + C7680j.d();
    }
}
