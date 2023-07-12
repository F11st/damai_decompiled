package com.taobao.weex.utils;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXDataStructureUtil {
    private static int a(int i) {
        if (i < 3) {
            b(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private static int b(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(a(i));
    }
}
