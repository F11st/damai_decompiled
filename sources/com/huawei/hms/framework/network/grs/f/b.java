package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final Map<String, b> b = new ConcurrentHashMap(16);
    private static final Object c = new Object();
    private a a;

    public b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        a(context, z);
        Map<String, b> map = b;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, b> map = b;
        return map.get(str + grsBaseInfo.uniqueCode());
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        b a = a(context.getPackageName(), grsBaseInfo);
        if (a != null) {
            Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (c) {
                a.a.a();
            }
        }
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.a.b();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        synchronized (c) {
            String a = this.a.a(context, aVar, grsBaseInfo, str, str2, z);
            if (TextUtils.isEmpty(a) && this.a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.a.a(context, aVar, grsBaseInfo, str, str2, z);
            }
            return a;
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        synchronized (c) {
            Map<String, String> a = this.a.a(context, aVar, grsBaseInfo, str, z);
            if ((a == null || a.isEmpty()) && this.a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.a.a(context, aVar, grsBaseInfo, str, z);
            }
            return a;
        }
    }

    public void a(Context context, boolean z) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is" + appConfigName);
        this.a = new d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.a = new d(context, appConfigName, z);
        }
        if (!this.a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.a = new c(context, z);
        }
        this.a.a(context, arrayList);
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.a.a(grsBaseInfo);
    }

    public Set<String> b() {
        return this.a.c();
    }
}
