package com.taobao.orange.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeReceiver extends BroadcastReceiver {
    private static final String TAG = "OrangeReceiver";
    public static volatile boolean networkValid;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            if (AndroidUtil.isNetworkConnected(context)) {
                if (networkValid) {
                    return;
                }
                networkValid = true;
                OLog.i(TAG, "onReceive network valid", new Object[0]);
                OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.receiver.OrangeReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigCenter.getInstance().retryFailRequests();
                    }
                });
                return;
            }
            networkValid = false;
        }
    }
}
