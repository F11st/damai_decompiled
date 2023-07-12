package com.youku.arch.v3.util.log;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BaseLog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1091785294")) {
            ipChange.ipc$dispatch("1091785294", new Object[]{Integer.valueOf(i), str, str2});
            return;
        }
        int length = str2.length();
        int i3 = length / 4000;
        if (i3 > 0) {
            int i4 = 0;
            while (i2 < i3) {
                int i5 = i4 + 4000;
                printSub(i, str, str2.substring(i4, i5));
                i2++;
                i4 = i5;
            }
            printSub(i, str, str2.substring(i4, length));
            return;
        }
        printSub(i, str, str2);
    }

    private static void printSub(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48157491")) {
            ipChange.ipc$dispatch("-48157491", new Object[]{Integer.valueOf(i), str, str2});
            return;
        }
        switch (i) {
            case 1:
                Log.v(str, str2);
                return;
            case 2:
                Log.d(str, str2);
                return;
            case 3:
                Log.i(str, str2);
                return;
            case 4:
                Log.w(str, str2);
                return;
            case 5:
                Log.e(str, str2);
                return;
            case 6:
                Log.wtf(str, str2);
                return;
            default:
                return;
        }
    }
}
