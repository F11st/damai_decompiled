package com.ali.user.open.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionSyncReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (TextUtils.equals(intent.getAction(), "aliuser_sync_session")) {
                intent.getStringExtra("from");
            }
        } catch (Throwable unused) {
        }
    }
}
