package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.g */
/* loaded from: classes11.dex */
public class C7570g extends ba.AbstractRunnableC7734a {
    final /* synthetic */ C7569f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7570g(C7569f c7569f, int i, String str) {
        super(i, str);
        this.a = c7569f;
    }

    @Override // com.xiaomi.push.service.ba.AbstractRunnableC7734a
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
            C7572i.b(context2);
        }
    }
}
