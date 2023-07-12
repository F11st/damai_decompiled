package com.vivo.push.e;

import java.util.ArrayList;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.e.a */
/* loaded from: classes11.dex */
public final class C7483a {
    private static String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};
    private ArrayList<String> b;

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.e.a$a */
    /* loaded from: classes11.dex */
    private static class C7484a {
        private static C7483a a = new C7483a((byte) 0);
    }

    /* synthetic */ C7483a(byte b) {
        this();
    }

    public static C7483a a() {
        return C7484a.a;
    }

    public final ArrayList<String> b() {
        return new ArrayList<>(this.b);
    }

    public final boolean c() {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private C7483a() {
        this.b = null;
        this.b = new ArrayList<>();
    }
}
