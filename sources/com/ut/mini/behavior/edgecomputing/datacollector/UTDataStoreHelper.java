package com.ut.mini.behavior.edgecomputing.datacollector;

import com.alibaba.analytics.utils.Logger;
import tb.pv2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UTDataStoreHelper {
    private static final String TAG = "UTDataStoreHelper";
    private static pv2 mHandler = new pv2();

    UTDataStoreHelper() {
    }

    public static void postRunnable(final Runnable runnable) {
        mHandler.b(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UTDataStoreHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Logger.h(UTDataStoreHelper.TAG, e, new Object[0]);
                }
            }
        });
    }
}
