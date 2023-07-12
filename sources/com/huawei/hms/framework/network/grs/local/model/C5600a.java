package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.local.model.a */
/* loaded from: classes10.dex */
public class C5600a {
    private String a;
    private final Map<String, C5602c> b = new ConcurrentHashMap(16);

    public C5602c a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
            return null;
        }
        return this.b.get(str);
    }

    public void a() {
        Map<String, C5602c> map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public void a(long j) {
    }

    public void a(String str, C5602c c5602c) {
        if (TextUtils.isEmpty(str) || c5602c == null) {
            return;
        }
        this.b.put(str, c5602c);
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }
}
