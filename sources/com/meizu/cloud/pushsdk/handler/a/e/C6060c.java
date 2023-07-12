package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.c.ExecutorC5928a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.platform.message.C6100a;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.C6102b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.e.c */
/* loaded from: classes10.dex */
public class C6060c extends AbstractC6034a<RegisterStatus> {
    public C6060c(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String mzPushServicePackageName = MzSystemUtils.getMzPushServicePackageName(d());
        if (C6102b.l(d(), mzPushServicePackageName)) {
            C6102b.c(d(), mzPushServicePackageName, false);
            if (TextUtils.isEmpty(C6102b.k(d(), mzPushServicePackageName))) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                C6102b.k(d(), mzPushServicePackageName, b);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 512;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: a */
    public void c(RegisterStatus registerStatus) {
        ExecutorC5928a.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                C6060c.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(RegisterStatus registerStatus, InterfaceC6080c interfaceC6080c) {
        if (c() == null || registerStatus == null) {
            return;
        }
        c().a(d(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS.equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public RegisterStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        RegisterStatus a = !TextUtils.isEmpty(stringExtra) ? C6100a.a(stringExtra) : (RegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS);
        if (!TextUtils.isEmpty(a.getPushId())) {
            C6102b.g(d(), a.getPushId(), d().getPackageName());
            C6102b.a(d(), (int) ((System.currentTimeMillis() / 1000) + a.getExpireTime()), d().getPackageName());
        }
        return a;
    }
}
