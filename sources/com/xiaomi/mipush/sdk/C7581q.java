package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.q */
/* loaded from: classes11.dex */
public final class C7581q extends ba.AbstractRunnableC7734a {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7581q(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ba.AbstractRunnableC7734a
    protected void onCallback() {
        ed.a(this.a).a(ba.a(this.a).a(ho.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
