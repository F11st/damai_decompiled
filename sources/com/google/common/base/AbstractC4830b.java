package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.base.b */
/* loaded from: classes10.dex */
public abstract class AbstractC4830b {
    public static AbstractC4830b compile(String str) {
        return C4838f.a(str);
    }

    public static boolean isPcreLike() {
        return C4838f.d();
    }

    public abstract int flags();

    public abstract AbstractC4829a matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
