package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.al;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class p extends al.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ii f76a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ii iiVar, Context context) {
        this.f76a = iiVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        ii iiVar = this.f76a;
        if (iiVar != null) {
            iiVar.a(bd.a());
            ao.a(this.a.getApplicationContext()).a((ao) this.f76a, hj.Notification, true, (hw) null, true);
        }
    }
}
