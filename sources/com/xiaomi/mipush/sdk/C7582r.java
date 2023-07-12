package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dm;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.r */
/* loaded from: classes11.dex */
public class C7582r implements dm {
    private Context a;

    public C7582r(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dm
    public String a() {
        return C7564b.m629a(this.a).d();
    }

    @Override // com.xiaomi.push.dm
    public void a(ii iiVar, hj hjVar, hw hwVar) {
        ao.a(this.a).a((ao) iiVar, hjVar, hwVar);
    }
}
