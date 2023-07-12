package com.alipay.camera.util;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.util.HashSet;
import java.util.Iterator;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FpsWhiteList {
    public static final String TAG = "FpsWhiteList";
    private static HashSet<String> a;

    public static boolean inWhiteList(String str, String str2) {
        boolean z;
        if (a == null) {
            return false;
        }
        String str3 = str + "/" + str2;
        if (str3 != null) {
            String lowerCase = str3.toLowerCase();
            HashSet<String> hashSet = a;
            if (hashSet != null && !hashSet.isEmpty()) {
                Iterator<String> it = a.iterator();
                while (it.hasNext()) {
                    if (lowerCase.startsWith(it.next())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            MPaasLogger.d(TAG, new Object[]{"FpsWhiteList Contained(", Boolean.valueOf(z), jn1.BRACKET_END_STR});
            return z;
        }
        return false;
    }

    public static void refreshCurrentDeviceInList(String str) {
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(str)) {
            String str2 = Build.getBRAND() + "/" + Build.getMODEL();
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                if (a == null) {
                    a = new HashSet<>();
                }
                a.add(lowerCase);
            }
        }
    }
}
