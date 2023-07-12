package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.base.j */
/* loaded from: classes10.dex */
public abstract class AbstractC4845j {
    private static final AbstractC4845j a = new C4846a();

    /* compiled from: Taobao */
    /* renamed from: com.google.common.base.j$a */
    /* loaded from: classes10.dex */
    static class C4846a extends AbstractC4845j {
        C4846a() {
        }

        @Override // com.google.common.base.AbstractC4845j
        public long a() {
            return C4838f.f();
        }
    }

    public static AbstractC4845j b() {
        return a;
    }

    public abstract long a();
}
