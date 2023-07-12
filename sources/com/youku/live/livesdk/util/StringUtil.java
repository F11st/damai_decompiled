package com.youku.live.livesdk.util;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class StringUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean isNumString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166679066")) {
            return ((Boolean) ipChange.ipc$dispatch("-1166679066", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }
}
