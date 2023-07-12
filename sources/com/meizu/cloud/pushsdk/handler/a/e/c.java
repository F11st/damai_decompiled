package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c extends com.meizu.cloud.pushsdk.handler.a.a<RegisterStatus> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String mzPushServicePackageName = MzSystemUtils.getMzPushServicePackageName(d());
        if (com.meizu.cloud.pushsdk.util.b.l(d(), mzPushServicePackageName)) {
            com.meizu.cloud.pushsdk.util.b.c(d(), mzPushServicePackageName, false);
            if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.k(d(), mzPushServicePackageName))) {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                com.meizu.cloud.pushsdk.util.b.k(d(), mzPushServicePackageName, b);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 512;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void c(RegisterStatus registerStatus) {
        com.meizu.cloud.pushsdk.b.c.a.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(RegisterStatus registerStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || registerStatus == null) {
            return;
        }
        c().a(d(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS.equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public RegisterStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        RegisterStatus a = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.a(stringExtra) : (RegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS);
        if (!TextUtils.isEmpty(a.getPushId())) {
            com.meizu.cloud.pushsdk.util.b.g(d(), a.getPushId(), d().getPackageName());
            com.meizu.cloud.pushsdk.util.b.a(d(), (int) ((System.currentTimeMillis() / 1000) + a.getExpireTime()), d().getPackageName());
        }
        return a;
    }
}
