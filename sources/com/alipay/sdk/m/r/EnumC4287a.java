package com.alipay.sdk.m.r;

import android.text.TextUtils;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.r.a */
/* loaded from: classes12.dex */
public enum EnumC4287a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    
    public String a;

    EnumC4287a(String str) {
        this.a = str;
    }

    public static EnumC4287a a(String str) {
        EnumC4287a[] values;
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        EnumC4287a enumC4287a = None;
        for (EnumC4287a enumC4287a2 : values()) {
            if (str.startsWith(enumC4287a2.a)) {
                return enumC4287a2;
            }
        }
        return enumC4287a;
    }
}
