package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class j {
    private static final j a = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a extends j {
        a() {
        }

        @Override // com.google.common.base.j
        public long a() {
            return f.f();
        }
    }

    public static j b() {
        return a;
    }

    public abstract long a();
}
