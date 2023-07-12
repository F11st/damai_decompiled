package com.amap.api.col.s;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.ad */
/* loaded from: classes10.dex */
final class C4372ad {
    private static volatile boolean a;

    public static synchronized void a() {
        synchronized (C4372ad.class) {
            if (!a) {
                C4373ae.a().a("regeo", new ag("/geocode/regeo"));
                C4373ae.a().a("placeAround", new ag("/place/around"));
                C4373ae.a().a("placeText", new af("/place/text"));
                C4373ae.a().a("geo", new af("/geocode/geo"));
                a = true;
            }
        }
    }
}
