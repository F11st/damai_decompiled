package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bh {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f130a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f131a = new HashMap();

    public String a() {
        return this.f130a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f131a.toString(), this.f130a);
    }
}
