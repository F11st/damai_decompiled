package com.ali.user.open.ucc.util;

import android.content.Context;
import com.ali.user.open.core.trace.SDKLogger;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccStatus {
    public static final String TAG = "login.LoginStatus";
    private static HashMap<String, AtomicBoolean> isUccLogining = new HashMap<>();
    private static HashMap<String, AtomicLong> lastUccLoginTime = new HashMap<>();
    private static Context mContext;

    public static synchronized boolean compareAndSetLogining(String str, boolean z, boolean z2) {
        boolean z3;
        synchronized (UccStatus.class) {
            SDKLogger.e("login.LoginStatus", "compareAndSetLogining  expect=" + z + ",update=" + z2);
            AtomicBoolean atomicBoolean = isUccLogining.get(str);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
            }
            atomicBoolean.compareAndSet(z, z2);
            isUccLogining.put(str, atomicBoolean);
            if (atomicBoolean.get()) {
                AtomicLong atomicLong = lastUccLoginTime.get(str);
                if (atomicLong == null) {
                    atomicLong = new AtomicLong(0L);
                }
                atomicLong.set(System.currentTimeMillis());
                lastUccLoginTime.put(str, atomicLong);
            }
            z3 = atomicBoolean.get();
        }
        return z3;
    }

    public static long getLastLoginTime(String str) {
        AtomicLong atomicLong = lastUccLoginTime.get(str);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    public static void init(Context context) {
        SDKLogger.e("login.LoginStatus", "init Login Status");
    }

    public static boolean isLogining(String str) {
        AtomicBoolean atomicBoolean = isUccLogining.get(str);
        return atomicBoolean != null && atomicBoolean.get();
    }

    public static void resetLoginFlag(String str) {
        SDKLogger.e("login.LoginStatus", "reset login status");
        AtomicBoolean atomicBoolean = isUccLogining.get(str);
        if (atomicBoolean == null) {
            atomicBoolean = new AtomicBoolean(false);
        }
        atomicBoolean.compareAndSet(true, false);
        isUccLogining.put(str, atomicBoolean);
    }

    public static void setLogining(String str, boolean z) {
        SDKLogger.e("login.LoginStatus", "set isLogining=" + z);
        AtomicBoolean atomicBoolean = isUccLogining.get(str);
        if (atomicBoolean == null) {
            atomicBoolean = new AtomicBoolean(false);
        }
        atomicBoolean.compareAndSet(!z, z);
        isUccLogining.put(str, atomicBoolean);
    }
}
