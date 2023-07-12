package com.ali.user.open.core.util;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class Validate {
    public static void notNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + str + "' cannot be null");
    }
}
