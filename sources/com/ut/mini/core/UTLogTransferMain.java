package com.ut.mini.core;

import com.alibaba.analytics.utils.Logger;
import java.util.Map;
import tb.ct2;
import tb.za1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTLogTransferMain {
    private static UTLogTransferMain mInstance;

    private UTLogTransferMain() {
    }

    public static UTLogTransferMain getInstance() {
        if (mInstance == null) {
            synchronized (UTLogTransferMain.class) {
                if (mInstance == null) {
                    mInstance = new UTLogTransferMain();
                }
            }
        }
        return mInstance;
    }

    public void transferLog(Map<String, String> map) {
        if (map != null) {
            try {
                if (ct2.d().g(map)) {
                    za1.a(map);
                } else {
                    Logger.r("log discard", "aLogMap", map);
                }
            } catch (Throwable th) {
                Logger.h(null, th, new Object[0]);
            }
        }
    }
}
