package com.alibaba.wireless.security.aopsdk.e.g;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: UtdidHashUtils.java */
/* loaded from: classes.dex */
public class a {
    private static final boolean a = ConfigManager.DEBUG;
    private static final String b = "AOP-UtdidHashUtils";

    private static String a() {
        byte[] bArr = new byte[16];
        new Random().nextBytes(bArr);
        return new String(bArr);
    }

    public static boolean b(String str) {
        return a(str, a());
    }

    private static boolean a(String str, String str2) {
        boolean z;
        try {
            String[] split = str.split(JSMethod.NOT_SET);
            ArrayList arrayList = new ArrayList();
            for (String str3 : split) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            }
            if (arrayList.size() == 3 && ((Integer) arrayList.get(0)).intValue() > 0 && ((Integer) arrayList.get(2)).intValue() >= 0 && ((Integer) arrayList.get(1)).intValue() <= ((Integer) arrayList.get(2)).intValue()) {
                long a2 = a(str2) % ((Integer) arrayList.get(0)).intValue();
                if (a2 >= ((Integer) arrayList.get(1)).intValue()) {
                    if (a2 <= ((Integer) arrayList.get(2)).intValue()) {
                        z = true;
                        return z;
                    }
                }
                z = false;
                return z;
            }
            return false;
        } catch (Throwable th) {
            Log.e(b, "", th);
            return false;
        }
    }

    private static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        char[] charArray = str.toCharArray();
        long j = 0;
        for (int i = 0; i < length; i++) {
            j = charArray[i] + (31 * j);
        }
        return AbsPerformance.LONG_NIL & j;
    }
}
