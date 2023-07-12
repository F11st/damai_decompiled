package com.taobao.accs.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.internal.ReceiverImpl;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BaseReceiver extends BroadcastReceiver {
    private static final String TAG = BaseReceiver.class.getSimpleName();
    private IBaseReceiver baseReceiver;

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        try {
            if (this.baseReceiver == null) {
                this.baseReceiver = new ReceiverImpl();
            }
            ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.base.BaseReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BaseReceiver.this.baseReceiver.onReceive(context, intent);
                    } catch (Exception e) {
                        ALog.e(BaseReceiver.TAG, "onReceive error", e, new Object[0]);
                    }
                }
            });
        } catch (Exception e) {
            ALog.e(TAG, "build ReceiverImpl error", e, new Object[0]);
        }
    }
}
