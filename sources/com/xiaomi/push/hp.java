package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum hp {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f483a;

    hp(int i) {
        this.f483a = i;
    }

    public static hp a(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return PLUGIN_CONFIG;
        }
        return MISC_CONFIG;
    }

    public int a() {
        return this.f483a;
    }
}
