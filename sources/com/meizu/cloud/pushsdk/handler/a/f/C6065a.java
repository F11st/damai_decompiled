package com.meizu.cloud.pushsdk.handler.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.c.ExecutorC5932c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.f.a */
/* loaded from: classes10.dex */
public class C6065a {
    private Context a;
    private List<Intent> b;
    private BroadcastReceiver c;

    public C6065a(Context context) {
        this.a = context.getApplicationContext();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<Intent> list = this.b;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = this.b.size();
        int i = 0;
        Iterator<Intent> it = this.b.iterator();
        while (it.hasNext()) {
            Intent next = it.next();
            if (i != size - 1) {
                b(next);
            }
            a(next);
            it.remove();
            i++;
        }
    }

    private void a(final Intent intent) {
        ExecutorC5932c.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.f.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                    DebugLogger.d("BrightNotification", "start bright notification service " + intent);
                    C6065a.this.a.startService(intent);
                } catch (Exception e) {
                    DebugLogger.e("BrightNotification", "send bright notification error " + e.getMessage());
                }
            }
        });
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (this.c == null) {
            this.c = new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.handler.a.f.a.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if ("android.intent.action.USER_PRESENT".equalsIgnoreCase(intent.getAction())) {
                        C6065a.this.a();
                    }
                }
            };
        }
        this.a.registerReceiver(this.c, intentFilter);
    }

    private void b(Intent intent) {
        MessageV3 messageV3 = (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE);
        if (messageV3 == null) {
            return;
        }
        AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSetting == null || advanceSettingEx == null) {
            return;
        }
        advanceSettingEx.setSoundTitle(null);
        advanceSetting.getNotifyType().setSound(false);
        advanceSetting.getNotifyType().setLights(false);
        advanceSetting.getNotifyType().setVibrate(false);
    }

    public void a(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str)) {
            return;
        }
        List<Intent> list = this.b;
        if (list != null) {
            Iterator<Intent> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Intent next = it.next();
                MessageV3 messageV3 = (MessageV3) next.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE);
                if (messageV3 != null && messageV3.getUploadDataPackageName() != null && str.equalsIgnoreCase(messageV3.getUploadDataPackageName())) {
                    this.b.remove(next);
                    break;
                }
            }
        } else {
            this.b = new ArrayList();
        }
        this.b.add(intent);
        DebugLogger.d("BrightNotification", "add bright notification intent, intent list: " + this.b);
    }
}
