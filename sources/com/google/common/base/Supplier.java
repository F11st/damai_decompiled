package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public interface Supplier<T> {
    @CanIgnoreReturnValue
    T get();
}
