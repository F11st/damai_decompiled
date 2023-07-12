package com.uc.webview.export.internal.utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i {
    private static i c;
    public Map<String, Object> a;
    private final int b = 128;

    private i() {
        this.a = null;
        this.a = Collections.synchronizedMap(new HashMap());
    }

    public static i a() {
        if (c == null) {
            synchronized (i.class) {
                if (c == null) {
                    c = new i();
                }
            }
        }
        return c;
    }

    public final boolean b(String str) {
        Boolean bool = (Boolean) a(str);
        return bool != null && bool.booleanValue();
    }

    public final int c(String str) {
        Integer num = (Integer) a(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean a(String str, Object obj) {
        if (this.a.size() < 128) {
            this.a.put(str, obj);
            return true;
        }
        return false;
    }

    public final Object a(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        return null;
    }
}
