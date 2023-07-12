package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.handler.a.c.C6042c;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.notification.c.C6082b;
import com.meizu.cloud.pushsdk.util.C6104d;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.d.e */
/* loaded from: classes10.dex */
public class C6055e extends AbstractC6034a<C6042c> {
    public C6055e(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 32768;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: a */
    public void b(C6042c c6042c) {
        int c = c6042c.c();
        if (c == -2) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_ACCESS_DENY");
            C6104d.f(d(), c6042c.a().getUploadDataPackageName(), c6042c.a().getDeviceId(), c6042c.a().getTaskId(), c6042c.a().getSeqId(), c6042c.a().getPushTimestamp(), c6042c.a().getDelayedReportMillis());
        } else if (c == -1) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_INBOX");
            C6104d.c(d(), c6042c.a().getUploadDataPackageName(), c6042c.a().getDeviceId(), c6042c.a().getTaskId(), c6042c.a().getSeqId(), c6042c.a().getPushTimestamp(), c6042c.a().getDelayedReportMillis());
        } else if (c == 0) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_NORMAL");
            C6104d.d(d(), c6042c.a().getUploadDataPackageName(), c6042c.a().getDeviceId(), c6042c.a().getTaskId(), c6042c.a().getSeqId(), c6042c.a().getPushTimestamp(), c6042c.a().getDelayedReportMillis());
        } else if (c != 1) {
        } else {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_FLOAT");
            C6104d.e(d(), c6042c.a().getUploadDataPackageName(), c6042c.a().getDeviceId(), c6042c.a().getTaskId(), c6042c.a().getSeqId(), c6042c.a().getPushTimestamp(), c6042c.a().getDelayedReportMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(C6042c c6042c, InterfaceC6080c interfaceC6080c) {
        DebugLogger.e("AbstractMessageHandler", "store notification id " + c6042c.b());
        C6082b.b(d(), c6042c.a().getUploadDataPackageName(), c6042c.b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationStateMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "notification_state".equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public C6042c c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_TASK_ID);
        String stringExtra3 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_SEQ_ID);
        String stringExtra4 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID);
        String stringExtra5 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP);
        String stringExtra6 = intent.getStringExtra(PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE);
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        DebugLogger.i("AbstractMessageHandler", "current taskId " + stringExtra2 + " seqId " + stringExtra3 + " deviceId " + stringExtra4 + " packageName " + stringExtra);
        C6042c c6042c = new C6042c(MessageV3.parse(d().getPackageName(), stringExtra, stringExtra5, stringExtra4, stringExtra2, stringExtra3, stringExtra6, booleanExtra, longExtra));
        String stringExtra7 = intent.getStringExtra("flyme:notification_pkg");
        int intExtra = intent.getIntExtra("flyme:notification_id", 0);
        int intExtra2 = intent.getIntExtra("flyme:notification_state", 0);
        c6042c.a(intExtra);
        c6042c.a(stringExtra7);
        c6042c.b(intExtra2);
        return c6042c;
    }
}
