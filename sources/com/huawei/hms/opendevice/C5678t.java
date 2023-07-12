package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.opendevice.t */
/* loaded from: classes10.dex */
public class C5678t {
    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
