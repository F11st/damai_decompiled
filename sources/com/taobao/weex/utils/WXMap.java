package com.taobao.weex.utils;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXMap extends HashMap<String, String> {
    public String put(String str, byte[] bArr) {
        return (String) super.put((WXMap) str, new String(bArr));
    }
}
