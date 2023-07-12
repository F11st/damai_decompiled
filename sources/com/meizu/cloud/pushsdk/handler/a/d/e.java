package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.a.c.c> {
    public e(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 32768;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(com.meizu.cloud.pushsdk.handler.a.c.c cVar) {
        int c = cVar.c();
        if (c == -2) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_ACCESS_DENY");
            com.meizu.cloud.pushsdk.util.d.f(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        } else if (c == -1) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_INBOX");
            com.meizu.cloud.pushsdk.util.d.c(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        } else if (c == 0) {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_NORMAL");
            com.meizu.cloud.pushsdk.util.d.d(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        } else if (c != 1) {
        } else {
            DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_FLOAT");
            com.meizu.cloud.pushsdk.util.d.e(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.a.c.c cVar, com.meizu.cloud.pushsdk.notification.c cVar2) {
        DebugLogger.e("AbstractMessageHandler", "store notification id " + cVar.b());
        com.meizu.cloud.pushsdk.notification.c.b.b(d(), cVar.a().getUploadDataPackageName(), cVar.b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationStateMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "notification_state".equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public com.meizu.cloud.pushsdk.handler.a.c.c c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_TASK_ID);
        String stringExtra3 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_SEQ_ID);
        String stringExtra4 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_DEVICE_ID);
        String stringExtra5 = intent.getStringExtra(PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP);
        String stringExtra6 = intent.getStringExtra(PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE);
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.MZ_PUSH_WHITE_LIST, false);
        long longExtra = intent.getLongExtra(PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        DebugLogger.i("AbstractMessageHandler", "current taskId " + stringExtra2 + " seqId " + stringExtra3 + " deviceId " + stringExtra4 + " packageName " + stringExtra);
        com.meizu.cloud.pushsdk.handler.a.c.c cVar = new com.meizu.cloud.pushsdk.handler.a.c.c(MessageV3.parse(d().getPackageName(), stringExtra, stringExtra5, stringExtra4, stringExtra2, stringExtra3, stringExtra6, booleanExtra, longExtra));
        String stringExtra7 = intent.getStringExtra("flyme:notification_pkg");
        int intExtra = intent.getIntExtra("flyme:notification_id", 0);
        int intExtra2 = intent.getIntExtra("flyme:notification_state", 0);
        cVar.a(intExtra);
        cVar.a(stringExtra7);
        cVar.b(intExtra2);
        return cVar;
    }
}
