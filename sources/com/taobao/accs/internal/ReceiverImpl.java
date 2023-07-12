package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.base.IBaseReceiver;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ReceiverImpl implements IBaseReceiver {
    private static final String TAG = "ReceiverImpl";

    @Override // com.taobao.accs.base.IBaseReceiver
    public void onReceive(Context context, Intent intent) {
        ALog.d(TAG, "ReceiverImpl onReceive begin......", new Object[0]);
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = new Intent();
        }
        try {
            if (UtilityImpl.getServiceEnabled(context)) {
                intent.setClassName(context.getPackageName(), AdapterUtilityImpl.channelService);
                IntentDispatch.dispatchIntent(context.getApplicationContext(), intent);
            } else {
                Process.killProcess(Process.myPid());
            }
            if (UtilityImpl.getAgooServiceEnabled(context)) {
                intent.setClassName(context, AdapterGlobalClientInfo.getAgooCustomServiceName(context.getPackageName()));
                IntentDispatch.dispatchIntent(context.getApplicationContext(), intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "ReceiverImpl onReceive,exception,e=" + th.getMessage(), new Object[0]);
        }
    }
}
