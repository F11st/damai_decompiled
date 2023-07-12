package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum hx {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f543a;

    hx(int i) {
        this.f543a = i;
    }

    public static hx a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Init;
            }
            return PackageUnregistered;
        }
        return RegIdExpired;
    }

    public int a() {
        return this.f543a;
    }
}
