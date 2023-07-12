package com.meizu.cloud.pushsdk.handler.a.f;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a.C6039c;
import com.meizu.cloud.pushsdk.util.C6104d;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.f.b */
/* loaded from: classes10.dex */
public class C6066b extends C6039c {
    public C6066b(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 524288;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start BrightNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_BRIGHT_NOTIFICATION_MESSAGE.equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public void b(MessageV3 messageV3) {
        DebugLogger.e("AbstractMessageHandler", "BrightNotificationHandler don't repeat upload receiver push event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: e */
    public void c(MessageV3 messageV3) {
        C6104d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: h */
    public int d(MessageV3 messageV3) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.C6039c, com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE);
    }
}
