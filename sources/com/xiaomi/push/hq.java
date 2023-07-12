package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum hq {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f485a;

    hq(int i) {
        this.f485a = i;
    }

    public static hq a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}
