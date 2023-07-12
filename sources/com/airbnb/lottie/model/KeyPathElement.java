package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.List;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes17.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var);

    void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2);
}
