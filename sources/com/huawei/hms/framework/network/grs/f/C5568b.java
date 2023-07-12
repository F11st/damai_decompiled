package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.local.model.C5600a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.f.b */
/* loaded from: classes10.dex */
public class C5568b {
    private static final Map<String, C5568b> b = new ConcurrentHashMap(16);
    private static final Object c = new Object();
    private AbstractC5567a a;

    public C5568b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        a(context, z);
        Map<String, C5568b> map = b;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static C5568b a(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, C5568b> map = b;
        return map.get(str + grsBaseInfo.uniqueCode());
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        C5568b a = a(context.getPackageName(), grsBaseInfo);
        if (a != null) {
            Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (c) {
                a.a.a();
            }
        }
    }

    public C5600a a() {
        return this.a.b();
    }

    public String a(Context context, C5564a c5564a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        synchronized (c) {
            String a = this.a.a(context, c5564a, grsBaseInfo, str, str2, z);
            if (TextUtils.isEmpty(a) && this.a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, C5568b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.a.a(context, c5564a, grsBaseInfo, str, str2, z);
            }
            return a;
        }
    }

    public Map<String, String> a(Context context, C5564a c5564a, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        synchronized (c) {
            Map<String, String> a = this.a.a(context, c5564a, grsBaseInfo, str, z);
            if ((a == null || a.isEmpty()) && this.a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, C5568b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.a.a(context, c5564a, grsBaseInfo, str, z);
            }
            return a;
        }
    }

    public void a(Context context, boolean z) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is" + appConfigName);
        this.a = new C5570d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.a = new C5570d(context, appConfigName, z);
        }
        if (!this.a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.a = new C5569c(context, z);
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
