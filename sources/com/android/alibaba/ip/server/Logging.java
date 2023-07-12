package com.android.alibaba.ip.server;

import com.android.alibaba.ip.common.Log;
import java.util.logging.Level;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Logging {
    public static final String LOG_TAG = "InstantPatcher";

    static {
        Log.logging = new Log.Logging() { // from class: com.android.alibaba.ip.server.Logging.1
            @Override // com.android.alibaba.ip.common.Log.Logging
            public boolean isLoggable(Level level) {
                if (level == Level.SEVERE) {
                    return android.util.Log.isLoggable(Logging.LOG_TAG, 6);
                }
                if (level == Level.FINE) {
                    return android.util.Log.isLoggable(Logging.LOG_TAG, 2);
                }
                return android.util.Log.isLoggable(Logging.LOG_TAG, 4);
            }

            @Override // com.android.alibaba.ip.common.Log.Logging
            public void log(Level level, String str) {
                log(level, str, null);
            }

            @Override // com.android.alibaba.ip.common.Log.Logging
            public void log(Level level, String str, Throwable th) {
                if (level == Level.SEVERE) {
                    if (th == null) {
                        android.util.Log.e(Logging.LOG_TAG, str);
                    } else {
                        android.util.Log.e(Logging.LOG_TAG, str, th);
                    }
                } else if (level == Level.FINE) {
                    if (android.util.Log.isLoggable(Logging.LOG_TAG, 2)) {
                        if (th == null) {
                            android.util.Log.v(Logging.LOG_TAG, str);
                        } else {
                            android.util.Log.v(Logging.LOG_TAG, str, th);
                        }
                    }
                } else if (android.util.Log.isLoggable(Logging.LOG_TAG, 4)) {
                    if (th == null) {
                        android.util.Log.i(Logging.LOG_TAG, str);
                    } else {
                        android.util.Log.i(Logging.LOG_TAG, str, th);
                    }
                }
            }
        };
    }
}
