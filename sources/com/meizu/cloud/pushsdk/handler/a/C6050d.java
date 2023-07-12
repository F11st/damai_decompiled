package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.util.C6102b;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.d */
/* loaded from: classes10.dex */
public class C6050d extends AbstractC6034a<String> {
    public C6050d(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(String str, InterfaceC6080c interfaceC6080c) {
        if (c() != null) {
            c().a(d(), str);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public String c(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        C6102b.g(d(), stringExtra, d().getPackageName());
        C6102b.a(d(), 0, d().getPackageName());
        return stringExtra;
    }
}
