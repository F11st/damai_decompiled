package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class g extends ba.a {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, String str) {
        super(i, str);
        this.a = fVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    protected void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.a.f70a;
        boolean a = ba.a(context).a(ho.AggregatePushSwitch.a(), true);
        z = this.a.f73a;
        if (z != a) {
            this.a.f73a = a;
            context2 = this.a.f70a;
            i.b(context2);
        }
    }
}
