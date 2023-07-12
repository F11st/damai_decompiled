package com.huawei.hms.aaid.plugin;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ProxyCenter {
    public PushProxy proxy;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public static ProxyCenter a = new ProxyCenter();
    }

    public static ProxyCenter getInstance() {
        return a.a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
