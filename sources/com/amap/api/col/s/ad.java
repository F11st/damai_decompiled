package com.amap.api.col.s;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class ad {
    private static volatile boolean a;

    public static synchronized void a() {
        synchronized (ad.class) {
            if (!a) {
                ae.a().a("regeo", new ag("/geocode/regeo"));
                ae.a().a("placeAround", new ag("/place/around"));
                ae.a().a("placeText", new af("/place/text"));
                ae.a().a("geo", new af("/geocode/geo"));
                a = true;
            }
        }
    }
}
