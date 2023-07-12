package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.C6070d;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.d.a */
/* loaded from: classes10.dex */
public class C6051a extends AbstractC6034a<MessageV3> {
    public C6051a(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 131072;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(MessageV3 messageV3, InterfaceC6080c interfaceC6080c) {
        if (c() == null || messageV3 == null) {
            return;
        }
        c().b(d(), MzPushMessage.fromMessageV3(messageV3));
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationArrivedHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED.equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        return !TextUtils.isEmpty(stringExtra) ? C6070d.a(stringExtra) : (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
    }
}
