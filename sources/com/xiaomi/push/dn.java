package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dn {
    private static volatile dn a;

    /* renamed from: a  reason: collision with other field name */
    private dm f220a;

    public static dn a() {
        if (a == null) {
            synchronized (dn.class) {
                if (a == null) {
                    a = new dn();
                }
            }
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dm m769a() {
        return this.f220a;
    }

    public void a(dm dmVar) {
        this.f220a = dmVar;
    }
}
