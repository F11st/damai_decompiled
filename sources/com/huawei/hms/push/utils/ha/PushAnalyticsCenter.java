package com.huawei.hms.push.utils.ha;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PushAnalyticsCenter {
    public PushBaseAnalytics a;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a */
    /* loaded from: classes10.dex */
    private static class C5702a {
        public static PushAnalyticsCenter a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return C5702a.a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.a = pushBaseAnalytics;
    }
}
