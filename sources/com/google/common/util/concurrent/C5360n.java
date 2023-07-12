package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.util.concurrent.n */
/* loaded from: classes10.dex */
final class C5360n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NullableDecl Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }
}
