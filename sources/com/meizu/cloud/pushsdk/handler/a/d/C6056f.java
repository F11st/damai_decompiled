package com.meizu.cloud.pushsdk.handler.a.d;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.C5915b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.handler.a.a.C6035a;
import com.meizu.cloud.pushsdk.handler.a.c.C6041b;
import com.meizu.cloud.pushsdk.handler.a.c.C6049h;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.util.C6104d;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.d.f */
/* loaded from: classes10.dex */
public class C6056f extends AbstractC6034a<C6049h> {
    public C6056f(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 262144;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: a */
    public void b(C6049h c6049h) {
        C6104d.b(d(), c6049h.c(), c6049h.a().b().d(), c6049h.a().b().a(), c6049h.a().b().e(), c6049h.a().b().b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(C6049h c6049h, InterfaceC6080c interfaceC6080c) {
        NotificationManager notificationManager = (NotificationManager) d().getSystemService("notification");
        if (notificationManager != null) {
            DebugLogger.e("AbstractMessageHandler", "start cancel notification id " + c6049h.b());
            notificationManager.cancel(c6049h.b());
            C6035a b = C5915b.a(d()).b();
            if (b != null) {
                b.a(c6049h.b());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        int i;
        DebugLogger.i("AbstractMessageHandler", "start WithDrawMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            C6041b a = C6041b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "4".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public C6049h c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new C6049h(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), g(intent), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
