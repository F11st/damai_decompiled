package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class b {
    public static b compile(String str) {
        return f.a(str);
    }

    public static boolean isPcreLike() {
        return f.d();
    }

    public abstract int flags();

    public abstract a matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
